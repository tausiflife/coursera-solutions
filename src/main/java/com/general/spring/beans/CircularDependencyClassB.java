package com.general.spring.beans;


public class CircularDependencyClassB {

    private CircularDependencyClassA dependencyClassA;

    public CircularDependencyClassB(CircularDependencyClassA a) {
        this.dependencyClassA = a;
    }
}
