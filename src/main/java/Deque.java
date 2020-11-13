import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private class Node {
        Node previous;
        Node next;
        Item value;
    }
    private Node head;
    private Node tail;
    private int size;
    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
    }

    public void addFirst(Item item) {
        if (item == null)
            throw new IllegalArgumentException("Null element can't be added");
        Node newHead = new Node();
        newHead.value = item;
        newHead.next = this.head;
        if (this.size == 0)
            this.tail = newHead;
        else
            this.head.previous = newHead;
        this.head = newHead;
        ++this.size;
    }

    public void addLast(Item item) {
        if (item == null)
            throw new IllegalArgumentException("Null element can't be added");
        Node newHead = new Node();
        newHead.value = item;
        newHead.previous = this.tail;
        if (this.size == 0)
            this.head = newHead;
        else
            this.tail.next = newHead;
        this.tail = newHead;
        ++this.size;
    }

    public Item removeFirst() {
        if (this.size == 0)
            throw new NoSuchElementException();
        Node newHead =  this.head.next;
        Item v = this.head.value;
        this.head.next = null;
        if (newHead != null)
            newHead.previous = null;
        if (this.size == 1)
            this.tail = null;
        this.head = newHead;
        --this.size;
        return v;
    }

    public Item removeLast() {
        if (this.size == 0)
            throw new NoSuchElementException();
        Node newTail =  this.tail.previous;
        Item v = this.tail.value;
        this.tail.previous = null;
        if (newTail != null)
            newTail.next = null;
        if (this.size == 1)
            this.head = null;
        this.tail = newTail;
        --this.size;
        return v;
    }

    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {
        Node current = head;

        public boolean hasNext() {
            return this.current != null;
        }

        public Item next() {
            if (this.current == null)
                throw new NoSuchElementException();
            Item v = this.current.value;
            this.current = this.current.next;
            return v;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
    public static void main(String[] args) {
        Deque<String> randomizedQueue = new Deque<>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("-"))
                StdOut.println(randomizedQueue.removeFirst());
            else if (s.equals("--"))
                StdOut.println(randomizedQueue.removeLast());
            else
                randomizedQueue.addFirst(s);
            randomizedQueue.addLast(s);
        }
        Iterator<String> itr = randomizedQueue.iterator();
        while (itr.hasNext())
            StdOut.print(itr.next() + ",");

    }
}
