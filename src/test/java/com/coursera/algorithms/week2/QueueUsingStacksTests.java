package com.coursera.algorithms.week2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QueueUsingStacksTests {
    @Test
    public void testEncodeConsonants() {
        QueueUsingStacks<String> queueUsingStacks = new QueueUsingStacks<>();
        queueUsingStacks.enqueue("hello");
        queueUsingStacks.enqueue("world");
        queueUsingStacks.enqueue("to");
        queueUsingStacks.enqueue("the");
        queueUsingStacks.enqueue("new");
        queueUsingStacks.enqueue("world");
        queueUsingStacks.enqueue("order");
        assertEquals(7, queueUsingStacks.size());
        assertEquals("hello", queueUsingStacks.dequeue());
    }
}
