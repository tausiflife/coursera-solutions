package com.algo1.weeks;

public class MaxMinStack implements StackInterface<Integer>{
    private Stack<Integer> data;
    private Stack<Integer> max;
    private Stack<Integer> min;

    public MaxMinStack() {
        this.data = new Stack<Integer>();
        this.max = new Stack<Integer>();
        this.min = new Stack<Integer>();
    }

    public boolean isEmpty() {
        return this.data.isEmpty();
    }

    public int size() {
        return data.size();
    }

    public void push(Integer item) {
        this.data.push(item);
        if (this.data.size() == 1) {
            this.max.push(item);
            this.min.push(item);
            return;
        }
        Integer maxE = this.max.peek();
        this.max.push(maxE > item ? maxE : item);
        Integer minE = this.min.peek();
        this.min.push(minE < item ? minE : item);

    }

    public Integer pop() {
        Integer d = this.data.pop();
        this.max.pop();
        this.min.pop();
        return d;
    }

    public Integer peek() {
        return this.data.peek();
    }

    public Integer getMaximumElement() {
        return this.max.peek();
    }

    public Integer getMinimumElement() {
        return this.min.peek();
    }

    public static void main(String[] args) {
        MaxMinStack maxMinStack = new MaxMinStack();
        maxMinStack.push(4);
        print(maxMinStack);
        maxMinStack.push(2);
        print(maxMinStack);
        maxMinStack.push(14);
        print(maxMinStack);
        maxMinStack.push(1);
        print(maxMinStack);
        maxMinStack.pop();
        print(maxMinStack);
        maxMinStack.push(18);
        print(maxMinStack);
        maxMinStack.pop();
        print(maxMinStack);
    }
    private static void print(MaxMinStack maxMinStack) {
        System.out.println("Current Max : "+maxMinStack.getMaximumElement());
        System.out.println("Current Min : "+maxMinStack.getMinimumElement());
        System.out.println("Current size : "+maxMinStack.size());
        System.out.println("\n");
    }
}
