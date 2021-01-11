package com.benkeil.demo;

import java.util.function.Function;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StringStreamSimple {

    @Bean
    public Function<String, String> reverse() {
        return StringUtils::reverse;
    }

    @Bean
    public Function<String, String> uppercase() {
        return String::toUpperCase;
    }

}
