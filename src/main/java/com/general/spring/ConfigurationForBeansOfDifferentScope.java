package com.general.spring;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Configuration
public class ConfigurationForBeansOfDifferentScope {

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public PrototypeBean getPrototypeBean() {
        return new PrototypeBean();
    }

    @Bean
    public SingletonBean getSingletonBean() {
        return new SingletonBean();
    }
}
