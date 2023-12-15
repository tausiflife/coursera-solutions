package com.algo1.weeks;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private static final int CAPACITY = 8;
    private Item[] s;
    private int size;

    public RandomizedQueue() {
        this.s = (Item[]) new Object[CAPACITY];
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
    }

    public void enqueue(Item item) {
        if (item == null)
            throw new IllegalArgumentException();
        if (this.size == this.s.length)
            resize(this.s.length * 2);
        this.s[size++] = item;
        swapRandom();
    }

    /**
     * This will always make sure that a random element is at the end and the position is swapped with the random index.
     * Since we are doing a random swap at insert, we don't have to to random check again at dequeue and also while
     * iterating.
     */
    private void swapRandom() {
        int rand = StdRandom.uniform(size);
        Item tmp = this.s[rand];
        this.s[rand] = this.s[size - 1];
        this.s[size - 1] = tmp;

    }

    private void resize(int newSize) {
        Item[] tmp = (Item[]) new Object[newSize];
        for (int i = 0; i < this.size; i++)
            tmp[i] = this.s[i];
        this.s = tmp;
    }

    public Item sample() {
        if (this.size == 0)
            throw new NoSuchElementException();
        int rand = StdRandom.uniform(this.size);
        return this.s[rand];
    }

    public Item dequeue() {
        if (this.size == 0)
            throw new NoSuchElementException();
        Item item = this.s[--size];
        if (size > 0 && size == this.s.length/4)
            resize(this.s.length/2);
        this.s[size] = null;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new RandomQueueIterator();
    }

    private class RandomQueueIterator implements Iterator<Item> {
        private int index;
        private int[] randomIndices;

        public RandomQueueIterator() {
            randomIndices = new int[size];
            for (int i = 0; i< size; i++)
                randomIndices[i] = i;
            StdRandom.shuffle(randomIndices);
        }
        @Override
        public boolean hasNext() {
            return this.index < size;
        }

        @Override
        public Item next() {
            if (index == size)
                throw new NoSuchElementException();
            return s[randomIndices[this.index++]];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        RandomizedQueue<String> randomizedQueue = new RandomizedQueue<>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("-")) {
                StdOut.println(randomizedQueue.sample());
                StdOut.println(randomizedQueue.dequeue());
                StdOut.println(randomizedQueue.size());
            } else
                randomizedQueue.enqueue(s);
        }
        Iterator<String> itr = randomizedQueue.iterator();
        while (itr.hasNext())
            StdOut.print(itr.next() + ",");

    }
}
