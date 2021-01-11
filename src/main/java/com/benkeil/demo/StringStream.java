package com.benkeil.demo;

import java.util.function.Function;
import org.apache.commons.lang3.StringUtils;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.ValueMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StringStream {

    @Bean
    public Function<KStream<String, String>, KStream<String, String>> reverse() {
        return strings -> strings.mapValues(StringUtils::reverse);
    }

    @Bean
    public Function<KStream<String, String>, KStream<String, String>> uppercase() {
        return strings -> strings.mapValues((ValueMapper<String, String>) String::toUpperCase);
    }

}
