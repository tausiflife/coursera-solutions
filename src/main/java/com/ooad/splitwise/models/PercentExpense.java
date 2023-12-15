package com.ooad.splitwise.models;

import com.ooad.splitwise.exceptions.SplitPercentageNot100;

import java.math.BigDecimal;
import java.util.List;

public class PercentExpense extends Expense {
    public PercentExpense(BigDecimal amount, String createdBy, List<Split> splits, String desc) {
        super(amount, createdBy, splits, desc);
    }

    @Override
    public boolean validate() {
        double totalPercent = getSplits().stream().map(split -> split.getPercent())
                .reduce(0.0, (a,b) -> a+ b);
        if(totalPercent != 100)
            throw new SplitPercentageNot100("Split percentage is not equal to 100", "E005");
        return true;
    }
}
