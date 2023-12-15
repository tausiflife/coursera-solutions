package com.ooad.splitwise.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
@AllArgsConstructor
@Data
public abstract class Split {
    private User user;
    private BigDecimal amount;
    private double percent;

    public Split(User user, BigDecimal amount) {
        this.user = user;
        this.amount = amount;
    }

    public Split(User user) {
        this.user = user;
    }

    public Split(User user, double percent) {
        this.user = user;
        this.percent = percent;
    }

    public User getUser() {
        return user;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public double getPercent() {
        return percent;
    }

}
