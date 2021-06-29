package com.coursera.algorithms.week2;

public class Queue<T> {
    private T[] data;
    private int head;
    private int tail;
    private int size;
    public Queue() {
        data = (T[]) new Object[8];
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }
    public void enqueue(T item) {
        if (size == data.length)
            resize(size * 2);
        data[tail++] = item;
        size++;
    }

    public T dequeue() {
        T item = data[head++];
        size--;
        if (size>0 && size < data.length/4)
            resize(size/2);
        return item;
    }

    private void resize(int newSize) {
        T[] newData = (T[]) new Object[newSize];
        for (int i = 0; i < size; i++) {
            newData[i] = data[head + i];
        }
        head = 0;
        tail = size;
        data = newData;
    }
}


