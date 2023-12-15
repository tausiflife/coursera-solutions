package com.general.spring.config;

import com.general.spring.beans.BeanNameAwareClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfigurationForBeanFactoryPostProcessor {

    @Bean
    public BeanNameAwareClass getBeanNameAwareClass() {
        return new BeanNameAwareClass();
    }
}
