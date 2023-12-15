package com.ooad.splitwise.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public abstract class Expense {
    private String id;
    private BigDecimal amount;
    private String createdBy;
    private LocalDateTime createdAt;
    private String desc;
    private List<Split> splits;
    private Group group;
    public Expense(BigDecimal amount, String createdBy, List<Split> splits, String desc) {
        this.id = UUID.randomUUID().toString();
        this.amount = amount;
        this.createdBy = createdBy;
        this.createdAt = LocalDateTime.now();
        this.desc = desc;
        this.splits = splits;
    }

    public Expense(BigDecimal amount, String createdBy, List<Split> splits, String desc, Group group) {
        this(amount, createdBy, splits, desc);
        this.group = group;
    }
    public abstract boolean validate();

    public BigDecimal getAmount() {
        return amount;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getDesc() {
        return desc;
    }

    public List<Split> getSplits() {
        return Collections.unmodifiableList(splits);
    }

    public String getId() {
        return id;
    }

    public Group getGroup() {
        return group;
    }
}
