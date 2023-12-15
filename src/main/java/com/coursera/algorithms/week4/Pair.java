package com.coursera.algorithms.week4;

public class Pair<Key extends Comparable<Key>, Value> implements Comparable {
    private Key key;
    private Value value;

    public Pair(Key key, Value value) {
        this.key = key;
        this.value = value;
    }

    public Key getKey() {
        return key;
    }

    public Value getValue() {
        return value;
    }

    @Override
    public int compareTo(Object o) {
        Pair<Key, Value> that = (Pair<Key, Value>) o;
        return this.getKey().compareTo(that.getKey());
    }
}
