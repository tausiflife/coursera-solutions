package com.ooad.splitwise.service;

import com.ooad.splitwise.exceptions.UserNotFoundException;
import com.ooad.splitwise.models.Expense;
import com.ooad.splitwise.models.ExpenseFactory;
import com.ooad.splitwise.models.Split;
import com.ooad.splitwise.models.User;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenseManager {
    private List<Expense> expenses;
    private Map<String, User> users;

    private Map<String, Map<String, BigDecimal>> balances;

    public ExpenseManager() {
        this.expenses = new ArrayList<>();
        this.users = new HashMap<>();
        this.balances = new HashMap<>();
    }

    public boolean addUser(User user) {
        this.users.putIfAbsent(user.getId(), user);
        this.balances.putIfAbsent(user.getId(), new HashMap<>());
        return false;
    }

    public void addExpense(String expenseType, String paidBy, BigDecimal amount, List<Split> splits) {
        Expense expense = ExpenseFactory.createExpense(expenseType, paidBy, amount, splits);
        expense.validate();
        this.expenses.add(expense);
        for (Split split : splits) {
            String paidTo = split.getUser().getId();
            Map<String, BigDecimal> balanceOfEachUserToPaidBy = balances.get(paidBy);
            if (!balanceOfEachUserToPaidBy.containsKey(paidTo))
                balanceOfEachUserToPaidBy.put(paidTo, new BigDecimal(0.0));
            balanceOfEachUserToPaidBy.put(paidTo, balanceOfEachUserToPaidBy.get(paidTo).add(split.getAmount()));
        }
    }

    public void showBalance(String userId) {
        //TODO show balance for that user
    }

    public void showBalances() {
        //TODO show balances for all users
    }

    public User getUser(String id){
        if(users.containsKey(id))
            return users.get(id);
        throw new UserNotFoundException("E001", "User is not found.");
    }
}
