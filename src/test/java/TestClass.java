import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.Stack;

public class TestClass {
    public static void main(String[] args) {
//      GenericTest<Integer>[] genericTest = new GenericTest<Integer>[10];
        Object[] arr = new String[10];
        System.out.println(arr.getClass());
        GenericTest<Integer> genericTest = new GenericTest<>();
        System.out.println(genericTest.getClass());
        GenericTest<Number> genericTest1 = new GenericTest<>();
        System.out.println(genericTest1.getClass());
        MyNode mn = new MyNode(5);
        Node n = mn;
        n.setData("hello");
        Integer x = mn.data;
//        Object[] arr1 = new String[2];
//        arr1[0] = "hi";
//        arr1[1] = 100; //an arraystore exception is thrown
//        Object[] arr2 = new ArrayList<String>[10];
//        arr2[0] = new ArrayList<String>(); //at runtime this is converted to ArrayList<Object>
//        arr2[1] = new ArrayList<Integer>(); // this also converts to ArrayList<Object>

    }

}
class NaturalNumber {
    public NaturalNumber(int i) {

    }
}
class EvenNumber extends NaturalNumber {
    public EvenNumber(int i) {
        super(i);
    }
}
class GenericTest<T extends Number> {

}
class Node<T> {
    public T data;
    public Node(T data) {
        this.data = data;
    }
    public void setData(T data) {
        System.out.println("Node.setData");
        this.data = data;
    }
}

class MyNode extends Node<Integer> {
    public MyNode(Integer data) {
        super(data);
    }
    public void setData(Integer data) {
        System.out.println("MyNode setData");
        super.setData(data);
    }
}
