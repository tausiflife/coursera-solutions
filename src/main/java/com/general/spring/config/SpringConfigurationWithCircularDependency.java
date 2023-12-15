package com.general.spring.config;

import com.general.spring.beans.CircularDependencyClassA;
import com.general.spring.beans.CircularDependencyClassB;
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
