package com.general.spring.config;

import com.general.spring.beans.PrototypeWithSingletonBean;
import com.general.spring.beans.SingletonBean;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

public class SpringPrototypeWithSingletonBean {

    @Bean
    public SingletonBean getSingletonBean() {
        return new SingletonBean();
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public PrototypeWithSingletonBean getPrototypeWithSingletonBean() {
        return new PrototypeWithSingletonBean();
    }
}
