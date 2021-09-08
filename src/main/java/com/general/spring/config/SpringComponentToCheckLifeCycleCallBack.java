package com.general.spring.config;

import com.general.spring.beans.BeanForComponent;
import com.general.spring.beans.PrototypeBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class SpringComponentToCheckLifeCycleCallBack {

    @Bean
    public BeanForComponent getBeanForComponent() {
        return new BeanForComponent(getPrototypeBean());
    }

    @Bean
    public PrototypeBean getPrototypeBean() {
        return new PrototypeBean();
    }
}
