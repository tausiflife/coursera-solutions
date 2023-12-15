package com.general.spring.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.ApplicationContext;

import java.time.LocalDateTime;

public class SingletonBean {

    private LocalDateTime dateTime = LocalDateTime.now();

    @Autowired
    private ApplicationContext applicationContext;

    @Lookup
    public LocalDateTime getDateTime() {
        PrototypeBean prototypeBean = applicationContext.getBean(PrototypeBean.class);
        System.out.println("The time is .. " + prototypeBean.getDateTime().toString());
        return prototypeBean.getDateTime();
    }

    public LocalDateTime getSingletonDatetime() {
        return dateTime;
    }
}
