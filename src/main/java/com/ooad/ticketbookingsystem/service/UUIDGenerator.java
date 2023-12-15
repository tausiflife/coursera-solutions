package com.ooad.ticketbookingsystem.service;

import java.util.UUID;

public class UUIDGenerator implements IdGenerator {
    @Override
    public String generate() {
        return UUID.randomUUID().toString();
    }
}
