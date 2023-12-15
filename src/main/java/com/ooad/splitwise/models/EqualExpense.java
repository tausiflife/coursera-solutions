package com.ooad.splitwise.models;

import java.math.BigDecimal;
import java.util.List;

public class EqualExpense extends Expense {
    public EqualExpense(BigDecimal amount, String createdBy, List<Split> splits, String desc) {
        super(amount, createdBy, splits, desc);
    }

    @Override
    public boolean validate() {
        return true;
    }
}
