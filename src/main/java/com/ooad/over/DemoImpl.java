package com.ooad.over;

import java.util.List;

public class DemoImpl {
    public static void main(String[] args)
    {
        SuperClass obj1 = new SuperClass();
        obj1.method();

        SubClass obj2 = new SubClass();
        obj2.method();
    }
}
class SuperClass {
    protected List<SuperClass> method()
    {
        System.out.println(
                "This is the method in SuperClass");
        return null;
    }
}

class SubClass extends SuperClass {
    public List<SuperClass> method()
    {
        System.out.println(
                "This is the method in SubClass");
        return null;
    }
}
