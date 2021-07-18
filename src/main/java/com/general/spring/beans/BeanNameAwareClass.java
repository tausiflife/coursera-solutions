package com.general.spring.beans;

import org.springframework.beans.factory.BeanNameAware;

public class BeanNameAwareClass implements BeanNameAware {
    @Override
    public void setBeanName(String s) {
        System.out.println(s);
    }
}
