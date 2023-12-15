package com.ooad.splitwise.models;

import lombok.AllArgsConstructor;
import lombok.Data;

public class User {
    private String id;
    private String name;
    private String emailId;
    private String phoneNumber;

    public User(String id, String name, String emailId, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.emailId = emailId;
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}

