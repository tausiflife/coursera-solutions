package com.ooad.splitwise;

import com.ooad.splitwise.models.*;
import com.ooad.splitwise.service.ExpenseManager;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        ExpenseManager expenseManager = new ExpenseManager();
        expenseManager.addUser(new User("u1", "User1", "user1@xyz.tech", "9876543210"));
        expenseManager.addUser(new User("u2", "User2", "user2@xyz.tech", "9876543210"));
        expenseManager.addUser(new User("u3", "User3", "user3@xyz.tech", "9876543210"));
        expenseManager.addUser(new User("u4", "User4", "user4@xyz.tech", "9876543210"));

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String command = scanner.nextLine();
            String[] commands = command.split(" ");
            String commandType = commands[0];

            switch (commandType) {
            case "SHOW":
                if (commands.length == 1) {
                    expenseManager.showBalances();
                } else {
                    expenseManager.showBalance(commands[1]);
                }
                break;
            case "EXPENSE":
                String paidBy = commands[1];
                BigDecimal amount = new BigDecimal(commands[2]);
                int noOfUsers = Integer.parseInt(commands[3]);
                String expenseType = commands[3 + noOfUsers + 1];
                List<Split> splits = new ArrayList<>();
                switch (expenseType) {
                case "EQUAL":
                    for (int i = 1; i <= noOfUsers; i++) {
                        splits.add(new EqualSplit(expenseManager.getUser(commands[3 + i])));
                    }
                    expenseManager.addExpense(expenseType, paidBy, amount, splits);
                    break;
                case "EXACT":
                    for (int i = 1; i <= noOfUsers; i++) {
                        splits.add(new ExactSplit(expenseManager.getUser(commands[3 + i]),
                                new BigDecimal(commands[4 + noOfUsers + i])));
                    }

                    expenseManager.addExpense(expenseType, paidBy, amount, splits);
                    break;
                case "PERCENT":
                    for (int i = 1; i <= noOfUsers; i++) {
                        splits.add(new PercentSplit(expenseManager.getUser(commands[3 + i]),
                                Double.parseDouble(commands[4 + noOfUsers + i])));
                    }
                    expenseManager.addExpense(expenseType, paidBy, amount, splits);
                    break;

                }
                break;
            }
        }
    }
}
