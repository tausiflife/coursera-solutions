package com.general.spring.beans;

import java.time.LocalDateTime;
import java.util.Properties;

public class PrototypeBean {

    public PrototypeBean() {
        System.out.println("prototype bean created");
    }

    private LocalDateTime dateTimeNow = LocalDateTime.now();

    public LocalDateTime getDateTime() {
        return dateTimeNow;
    }
}
