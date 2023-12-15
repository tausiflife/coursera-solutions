package com.ooad.splitwise.models;

import java.util.*;

public class Group {
    private String id;
    private String name;
    private String description;
    private Map<String, User> users;
    private List<Expense> expenses;

    public Group(String name) {
        this.name = name;
        this.id = UUID.randomUUID().toString();
        this.users = new HashMap<>();
        this.expenses = new ArrayList<>();
    }

    public Group(String name, String description) {
        this(name);
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, User> getUsers() {
        return Collections.unmodifiableMap(users);
    }

    public List<Expense> getExpenses() {
        return Collections.unmodifiableList(expenses);
    }

    public void addUser(User user) {
        if(!this.users.containsKey(user.getId()))
            this.users.put(user.getId(), user);
    }

    public void addExpense(Expense expense) {
        this.expenses.add(expense);
    }
}
