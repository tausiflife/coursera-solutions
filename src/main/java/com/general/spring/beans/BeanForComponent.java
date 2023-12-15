package com.general.spring.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class BeanForComponent {

    private  PrototypeBean prototypeBean;

    public BeanForComponent(PrototypeBean prototypeBean) {
        this.prototypeBean = prototypeBean;
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
