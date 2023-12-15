package com.coursera.algorithms.week4;

import edu.princeton.cs.algs4.Queue;

import java.util.HashSet;
import java.util.Set;

public class BST <Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        private Key key;
        private Value val;
        private Node left;
        private Node right;
        private int count;
        public Node(Key key, Value val) {
            this.key = key;
            this.val = val;
            count = 1;
        }
    }
    public Value get(Key k) {
        Node n = root;
        while (n != null) {
            int cmp = k.compareTo(n.key);
            if (cmp == 0)
                return n.val;
            else if (cmp < 0)
                n = n.left;
            else
                n = n.right;
        }
        return null;
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null)
            return 0;
        return x.count;
    }
    public void put(Key k, Value v) {
        root = put(root, k, v);
    }

    private Node put(Node x, Key k, Value v) {
        if (x == null)
            return new Node(k,v);
        int cmp = k.compareTo(x.key);
        if (cmp < 0)
            x.left = put(x.left, k , v);
        else if (cmp > 0)
            x.right = put(x.right, k , v);
        else
            x.val = v;
        x.count = 1 + size(x.left) + size(x.right);
        return x;
    }

    public Key min() {
        return min(root).key;
    }

    public Key max() {
        Node n = root;
        while (n.right != null)
            n = n.right;
        return n.key;
    }

    public Key floor(Key k) {
        Node x = floor(root, k);
        if (x == null)
            return null;
        return x.key;
    }

    private Node floor(Node x, Key k) {
        if (x == null)
            return null;
        int cmp = k.compareTo(x.key);
        if (cmp == 0)
            return x;
        if (cmp < 0)
            return floor(x.left,k);
        Node t = floor(x.right, k);
        if (t != null)
            return t;
        return x;
    }

    public Key ceiling(Key k) {
        Node x = ceiling(root, k);
        if (x == null)
            return null;
        return x.key;
    }

    private Node ceiling(Node x, Key k) {
        if (x == null)
            return null;
        int cmp = k.compareTo(x.key);
        if (cmp == 0)
            return x;
        if (cmp > 0)
            return ceiling(x.right, k);
        Node t = ceiling(x.left, k);
        if (t != null)
            return t;
        return x;
    }

    public void invert() {
        root = invert(root);
    }

    private Node invert(Node x) {
        if (x == null)
            return null;
        Node tmp = x.left;
        x.left = invert(x.right);
        x.right = invert(tmp);
        return x;
    }

    public int rank(Key key) {
        return rank(root, key);
    }

    private int rank(Node x, Key key) {
        if (x == null)
            return 0;
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            return rank(x.left, key);
        else if (cmp > 0)
            return 1 + size(x.left) + rank(x.right, key);
        else
            return size(x.left);
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<>();
        inorder(root, queue);
        return queue;
    }

    private void inorder(Node x, Queue<Key> queue) {
        if (x == null)
            return;
        inorder(x.left, queue);
        queue.enqueue(x.key);
        inorder(x.right, queue);
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if (x.left == null)
            return x.right;
        x.left = deleteMin(x.left);
        x.count = 1 + size(x.left) + size(x.right);
        return x;
    }

    public void delete(Key k) {
        root = delete(root, k);
    }

    private Node delete(Node x, Key k) {
        if (x == null)
            return null;
        int cmp = k.compareTo(x.key);
        if (cmp < 0)
            return delete(x.left, k);
        else if (cmp > 0)
            return delete(x.right, k);
        if (x.right == null) // no right child
            return x.left;
        if (x.left == null) // no left child
            return x.right;
        //both children present
        Node t = x;
        x = min(t.right); // find the minimum from right as that min element can take its parent's place
        x.right = deleteMin(t.right); // deleteMin and create link
        x.left = t.left; // assign left tree of t to x
        x.count = 1 + size(x.left) + size(x.right);
        return x;
    }

    private Node min(Node x) {
        Node n = x;
        while (n.left != null)
            n = n.left;
        return n;
    }

    public boolean contains(Key k) {
        return contains(root, k);
    }

    private boolean contains(Node h, Key k) {
        if (h == null)
            return false;
        int cmp = k.compareTo(h.key);
        if (cmp == 0)
            return true;
        if (cmp < 0)
            contains(h.left, k);
        else
            contains(h.right, k);
        return false;
    }

    public Set<Key> rangeSearch(Key k1, Key k2) {
        Set<Key> keySet = new HashSet<>();
        rangeSearch(root, k1, k2, keySet);
        return keySet;
    }

    private void rangeSearch(Node h, Key k1, Key k2, Set<Key> keySet) {
        if (h == null )
            return;
        rangeSearch(h.left, k1, k2, keySet);
        int cmp = h.key.compareTo(k1);
        int cmp1 = h.key.compareTo(k2);
        if (cmp >= 0 && cmp1 <= 0)
            keySet.add(h.key);
        rangeSearch(h.right, k1, k2, keySet);
    }

    public int rangeCount(Key lo, Key hi) {
        return rangeCount(root, lo, hi);
    }

    private int rangeCount(Node h, Key lo, Key hi) {
        if (h == null)
            return 0;
        if (contains(hi))
            return rank(hi) - rank(lo) + 1;
        return rank(hi) - rank(lo);
    }
}
