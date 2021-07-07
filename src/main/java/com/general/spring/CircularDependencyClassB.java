package com.general.spring;


public class CircularDependencyClassB {

    private CircularDependencyClassA dependencyClassA;

    public CircularDependencyClassB(CircularDependencyClassA a) {
        this.dependencyClassA = a;
    }
}
