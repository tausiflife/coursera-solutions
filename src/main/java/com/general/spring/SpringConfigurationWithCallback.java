package com.general.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfigurationWithCallback {
    @Bean
    public SpringBeanCallbacks getSpringBeanCallbacks() {
        return new SpringBeanCallbacks();
    }
}
