package com.general.spring;

public class CircularDependencyClassA {

    private CircularDependencyClassB dependencyClassB;

    public CircularDependencyClassA(CircularDependencyClassB dependencyClassB) {
        this.dependencyClassB = dependencyClassB;
    }
}
