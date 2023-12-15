package com.ooad.splitwise.models;

import com.ooad.splitwise.exceptions.ExpenseTypeNotSupported;

import java.math.BigDecimal;
import java.util.List;

public class ExpenseFactory {

    public static Expense createExpense(String expenseType, String userId,
                                        BigDecimal amount, List<Split> splits) {
        Expense expense = null;
        switch (expenseType) {
            case "EXACT":
                expense = new ExactExpense(amount, userId, splits, null);
                break;
            case "EQUAL":
                expense = new EqualExpense(amount, userId, splits, null);
                break;
            case "PERCENT":
                expense = new PercentExpense(amount, userId, splits, null);
                break;
            default:
                throw new ExpenseTypeNotSupported("Expense type not supported.", "E0010");
        }
        return expense;
    }
}
