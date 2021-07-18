package com.general.spring.config;

import com.general.spring.beans.PrototypeBean;
import com.general.spring.beans.SingletonBean;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

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
