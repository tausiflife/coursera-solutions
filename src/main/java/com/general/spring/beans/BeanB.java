package com.general.spring.beans;

public class BeanB {
    private BeanA beanA;

    public BeanB(BeanA beanA) {
        this.beanA = beanA;
        System.out.println("In bean B");
    }
}
