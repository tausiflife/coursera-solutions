package com.general.spring.beans;

public class CircularDependencyClassA {

    private CircularDependencyClassB dependencyClassB;

    public CircularDependencyClassA(CircularDependencyClassB dependencyClassB) {
        this.dependencyClassB = dependencyClassB;
    }
}
