package com.ooad.splitwise.models;

import com.ooad.splitwise.exceptions.SplitAmountMisMatch;

import java.math.BigDecimal;
import java.util.List;

public class ExactExpense extends Expense {
    public ExactExpense(BigDecimal amount, String createdBy, List<Split> splits, String desc) {
        super(amount, createdBy, splits, desc);
    }

    @Override
    public boolean validate() {
        BigDecimal total = getSplits().stream().map(split -> split.getAmount())
                .reduce(BigDecimal.valueOf(0.0), (bd, am) -> bd = bd.add(am));
        if(!total.equals(getAmount()))
            throw new SplitAmountMisMatch("Split amount is not equal to total amount", "E004");
        return true;
    }
}
