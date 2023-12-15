package com.algo1.weeks;

public class Stack<T> implements StackInterface<T> {
    private static int INITIAL_SIZE = 8;
    private Object[] data;
    private int n;
    public Stack() {
        this.data = new Object[INITIAL_SIZE];
    }

    public boolean isEmpty() {
        return this.n == 0;
    }

    public int size() {
        return this.n;
    }

    public void push(T item) {
        if (this.n == this.data.length) {
            resize(2 * this.data.length);
        }
        data[n++] = item;
    }

    private void resize(int newSize) {
        Object[] tmp = new Object[newSize];
        for (int i = 0; i < this.n; i++)
            tmp[i] = this.data[i];
        this.data = tmp;
    }

    public T pop() {
        T item = (T) data[--n];
        data[n] = null;
        if (this.n > 0 && this.n < this.data.length/4) {
            resize(this.data.length / 2);
        }
        return item;
    }

    public T peek() {
        int top = n - 1;
        return (T)this.data[top];
    }
}
