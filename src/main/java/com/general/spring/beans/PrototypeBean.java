package com.general.spring.beans;

import java.time.LocalDateTime;

public class PrototypeBean {

    private LocalDateTime dateTimeNow = LocalDateTime.now();

    public LocalDateTime getDateTime() {
        return dateTimeNow;
    }
}
