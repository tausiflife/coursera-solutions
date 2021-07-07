package com.general.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfigurationWithCircularDependency {

    @Bean
    public CircularDependencyClassA getCircularDependencyClassA(CircularDependencyClassB dependencyClassB) {
        return new CircularDependencyClassA(dependencyClassB);
    }

    @Bean
    public CircularDependencyClassB getCircularDependencyClassB(CircularDependencyClassA dependencyClassA) {
        return new CircularDependencyClassB(dependencyClassA);
    }
}
