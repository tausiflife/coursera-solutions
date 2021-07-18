package com.general.spring.config;

import com.general.spring.beans.IntegerStore;
import com.general.spring.beans.StringStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GenericsAutowiringConfig {

    @Bean
    public StringStore getStringStore() {
        return new StringStore();
    }

    @Bean
    public IntegerStore getIntegerStore() {
        return new IntegerStore();
    }
}
