package com.ooad.ticketbookingsystem.service;

import com.ooad.ticketbookingsystem.model.Booking;
import com.ooad.ticketbookingsystem.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserService {
    private final Map<String, User> users;
    private final IdGenerator idGenerator;

    public UserService(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
        this.users = new HashMap<>();
    }

    public User addUser(String name) {
        String id = idGenerator.generate();
        User user = new User(id, name);
        users.put(id, user);
        return user;
    }

    public User getUser(String userId) {
        return users.get(userId);
    }
}
