package com.benkeil.demo;

import java.util.function.Function;
import org.apache.commons.lang3.StringUtils;
import org.apache.kafka.common.utils.Bytes;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.ValueMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StringStream {

    @Bean
    public Function<KStream<Bytes, String>, KStream<Bytes, String>> reverse() {
        return strings -> strings.mapValues(StringUtils::reverse)
                .peek((key, value) -> System.out.println("reverse: " + value));
    }

    @Bean
    public Function<KStream<Bytes, String>, KStream<Bytes, String>> uppercase() {
        return strings -> strings.mapValues((ValueMapper<String, String>) String::toUpperCase)
                .peek((key, value) -> System.out.println("uppercase: " + value));
    }

}
