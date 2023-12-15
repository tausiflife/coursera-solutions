package com.general.spring.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class SpringBeanCallbacks {

    public SpringBeanCallbacks() {
        System.out.println("constructor called");
    }

    @PostConstruct
    public void init() {
        System.out.println("post construct");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("pre destroy");
    }
}
