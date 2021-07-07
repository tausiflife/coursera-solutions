package com.general.spring;

import org.springframework.stereotype.Component;

@Component
public class CircularDependencyResolvedClassA {

    private CircularDependencyResolvedClassB dependencyResolvedClassB;

    public CircularDependencyResolvedClassA(CircularDependencyResolvedClassB dependencyResolvedClassB) {
        this.dependencyResolvedClassB = dependencyResolvedClassB;
    }

    public void serve() {
        System.out.println("Serving from CircularDependencyResolvedClassA ...");
    }
}
