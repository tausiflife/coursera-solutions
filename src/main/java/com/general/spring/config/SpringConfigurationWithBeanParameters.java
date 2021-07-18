package com.general.spring.config;

import com.general.spring.beans.SpringService;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class SpringConfigurationWithBeanParameters {


    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public SpringService getAnotherSpringServiceClass(){
        return SpringService.constructMe();
    }
}
