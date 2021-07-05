package com.general.spring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

public class CGLIBTest {

    @Test
    public void testCgLib() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Cat.class);
        Assertions.assertEquals("meoow", new Cat().getName());
        Assertions.assertEquals(5, new Cat().getAge());

        enhancer.setCallback((MethodInterceptor) (obj, method, args, proxy) -> {
            if (method.getDeclaringClass().equals(Cat.class) && method.getName().equals("getName"))
                return "from cglib";
            else if (method.getDeclaringClass().equals(Cat.class) && method.getName().equals("getAge"))
                return 15;
            else
                return proxy.invokeSuper(obj, args);
        });
        Cat cat = (Cat) enhancer.create();
        Assertions.assertEquals("from cglib", cat.getName());
        Assertions.assertEquals(15, cat.getAge());
    }

    public static class Cat {

        public String getName() {
            return "meoow";
        }

        public int getAge() {
            return 5;
        }
    }

    public class MyException extends RuntimeException {

        public MyException() {
            super();
        }
    }
}
