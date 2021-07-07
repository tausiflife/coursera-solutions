package com.general.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfiguration {

    @Bean
    public SpringService getSpringServiceClass(){
        return new SpringService();
    }

}
