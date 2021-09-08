package com.general.spring.config;

import com.general.spring.beans.BeanA;
import com.general.spring.beans.BeanB;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfigurationInternalGetBeanCall {

    @Bean
    public BeanA getBeanA() {
        return new BeanA();
    }

    @Bean
    public BeanB getBeanB() {
        return new BeanB(getBeanA());
    }

}
