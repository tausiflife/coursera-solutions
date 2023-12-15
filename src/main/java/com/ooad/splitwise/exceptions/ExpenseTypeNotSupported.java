package com.ooad.splitwise.exceptions;

import com.ooad.splitwise.models.ExactExpense;

public class ExpenseTypeNotSupported extends ApplicationException {
    public ExpenseTypeNotSupported(String message, String code) {
        super(message, code);
    }
}
