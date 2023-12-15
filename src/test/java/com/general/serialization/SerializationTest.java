package com.general.serialization;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;

public class SerializationTest {

    @Test
    void testSerializationFails() throws Exception {
        String name = "emp 1";
        int age = 30;
        Exception exception = Assertions.assertThrows(Exception.class, () -> {
            Employee employee = new Employee(name, age);
            FileOutputStream fileOut =
                    new FileOutputStream("employee.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(employee);
            out.close();
            fileOut.close();

            FileInputStream fileIn =
                    new FileInputStream("employee.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Employee man = (Employee)in.readObject();
            Assert.assertEquals(name, man.getName());
            Assert.assertEquals(age, man.getAge());
            in.close();
            fileIn.close();
        });
        Assert.assertEquals(NotSerializableException.class, exception.getClass());
    }

    @Test
    void testSerialization() throws Exception {
        String name = "manager";
        int age = 40;
        Manager employee = new Manager(name, age);
        FileOutputStream fileOut =
                new FileOutputStream("Manager.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(employee);
        out.close();
        fileOut.close();

        FileInputStream fileIn =
                new FileInputStream("Manager.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        Manager man = (Manager)in.readObject();
        Assert.assertEquals(name, man.getName());
        Assert.assertEquals(age, man.getAge());
        out.close();
        fileOut.close();
    }

    @Test
    void testSerializationWthTransient() throws Exception {
        String name = "manager";
        int age = 40;
        ManagerWithTransientName managerWithTransientName = new ManagerWithTransientName(name, age);
        FileOutputStream fileOut =
                new FileOutputStream("ManagerWithTransientName.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(managerWithTransientName);
        out.writeObject(managerWithTransientName.getName());
        out.close();
        fileOut.close();

        FileInputStream fileIn =
                new FileInputStream("ManagerWithTransientName.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        ManagerWithTransientName man = (ManagerWithTransientName)in.readObject();
        String readName = (String) in.readObject();
        Assert.assertEquals(name, readName);
        Assert.assertEquals(age, man.getAge());
        out.close();
        fileOut.close();
    }
}

class Employee {
    private final String name;
    private final int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

class Manager implements Serializable {

    private final String name;
    private final int age;

    public Manager(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

class ManagerWithTransientName implements Serializable {

    private transient final String name;
    private final int age;

    public ManagerWithTransientName(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
