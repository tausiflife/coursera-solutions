package com.coursera.algorithms.week2;


import edu.princeton.cs.algs4.Stack;

public class QueueUsingStacks<T> {
    private Stack<T> enqueue;
    private Stack<T> dequeue;
    private int size;

    public QueueUsingStacks() {
        enqueue = new Stack<>();
        dequeue = new Stack<>();
    }
    public boolean empty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void enqueue(T item) {
        enqueue.push(item);
        size++;
    }

    public T dequeue() {
        if (dequeue.isEmpty())
            moveFromEnqueueToDequeue();
        --size;
        return dequeue.pop();
    }

    private void moveFromEnqueueToDequeue() {
        while (!enqueue.isEmpty())
            dequeue.push(enqueue.pop());
    }
}
