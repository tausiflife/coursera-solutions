package com.general.spring.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import javax.annotation.PostConstruct;

public class BeanPostProcessorClass implements BeanPostProcessor {

    public BeanPostProcessorClass() {
        System.out.println("constructor called");
    }

    @PostConstruct
    public void init() {
        System.out.println("post construct");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("post process before initialization");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("post process after initialization");
        return bean;
    }
}
