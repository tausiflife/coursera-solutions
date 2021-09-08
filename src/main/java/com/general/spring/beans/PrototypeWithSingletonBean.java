package com.general.spring.beans;

import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class PrototypeWithSingletonBean {

    @Autowired
    private SingletonBean singletonBean;
    private LocalDateTime dateTime = LocalDateTime.now();

    public LocalDateTime getLocalDateTime() {
        System.out.println("Prototype datetime : "+dateTime.toString());
        System.out.println("Singleton datetime : "+singletonBean.getSingletonDatetime().toString());
        return singletonBean.getSingletonDatetime();
    }
}
