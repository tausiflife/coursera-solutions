package com.general.spring.beans;

public class SpringService {

    public SpringService() {
        System.out.println("Spring service constructor called...");
    }
    public static SpringService constructMe() {
        System.out.println("Constructing spring service from factory...");
        return new SpringService();
    }
    public void serve() {
        System.out.println("Spring service is serving...");
    }
}
