package com.general.spring.beans;

public class BeanWithMultipleConstructor {

    private PrototypeBean prototypeBean;

    public BeanWithMultipleConstructor() {
    }

    public BeanWithMultipleConstructor(PrototypeBean prototypeBean) {
        this.prototypeBean = prototypeBean;
    }
}
