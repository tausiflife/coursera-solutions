package com.general.spring.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class CircularDependencyResolvedClassB {

    private CircularDependencyResolvedClassA dependencyResolvedClassA;

    @Autowired
    @Lazy
    public void setDependencyResolvedClassA(CircularDependencyResolvedClassA dependencyResolvedClassA) {
        this.dependencyResolvedClassA = dependencyResolvedClassA;
    }

    public CircularDependencyResolvedClassA getDependencyResolvedClassA() {
        return dependencyResolvedClassA;
    }
}
