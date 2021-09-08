package com.coursera.algorithms.week5;

/**
 * This is left leaning RedBlackBST
 *
 * @param <Key>
 * @param <Value>
 */
public class RedBlackBST<Key extends Comparable<Key>, Value> {
    private Node root;
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node {
        private Key key;
        private Value value;
        private int count;
        private Node left;
        private Node right;
        boolean color; //to store if the link in red/blue

        public Node(Key key, Value val, boolean color) {
            this.key = key;
            this.value = val;
            this.color = color;
            count = 1;
        }
    }

    public Value get(Key k) {
        Node n = root;
        while (n == null) {
            int cmp = k.compareTo(n.key);
            if (cmp == 0)
                return n.value;
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

    public Key max() {
        Node max = max(root);
        if (max == null)
            return null;
        return max.key;
    }

    private Node max(Node x) {
        if (x == null)
            return null;
        Node n = x;
        while (n.right != null)
            n = n.right;
        return n;
    }

    public Key min() {
        Node min = min(root);
        if (min == null)
            return null;
        return min.key;
    }

    private Node min(Node x) {
        if (x == null)
            return null;
        Node n = x;
        while (n.left != null)
            n = n.left;
        return n;
    }

    public Key floor(Key k) {
        Node floor = floor(root, k);
        if (floor == null)
            return null;
        return floor.key;
    }

    private Node floor(Node x, Key k) {
        if (x == null)
            return null;
        int cmp = k.compareTo(x.key);
        if (cmp == 0)
            return x;
        else if (cmp < 0)
            return floor(x.left, k);
        Node t = floor(x.right, k);
        if (t != null)
            return t;
        return x;
    }

    public Key ceiling(Key k) {
        Node ceiling = ceiling(root, k);
        if (ceiling == null)
            return null;
        return ceiling.key;
    }

    private Node ceiling(Node x, Key k) {
        if (x == null)
            return null;
        int cmp = k.compareTo(x.key);
        if (cmp == 0)
            return x;
        else if (cmp > 0)
            return ceiling(x.right, k);
        Node t = ceiling(x.left, k);
        if (t != null)
            return t;
        return x;
    }

    public int rank(Key k) {
        return rank(root, k);
    }

    private int rank(Node x, Key k) {
        if (x == null)
            return 0;
        int cmp = k.compareTo(x.key);
        if (cmp == 0)
            return size(x.left);
        else if (cmp < 0)
            return rank(x.left, k);
        else
            return 1 + size(x.left) + rank(x.right, k);
    }

    public boolean isRed(Node x) {
        if (x == null)
            return false;
        return x.color == RED;
    }

    //Right leaning red link to lean left
    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    //Rotate left leaning red link to lean right, temporary
    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    //When node has 2 red links
    private void flipColor(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    /**
     * Insert 1 node (b) --put(a)--> (b)
     *                              /(red)
     *                             (a)
     *                  --put(b)--> (a)          --rotateLeft(a)--> (b)
     *                                \(red)                       /
     *                                (b)                        (a)
     * Right child RED and leftChild BLACK : rotateLeft
     * Left child RED and left grandchild RED : rotateRight
     * Both children RED : flipColor
     * @param k
     * @param v
     * @return
     */
    public void put(Key k, Value v) {
        root = put(root, k, v);
    }

    private Node put(Node h, Key k, Value v) {
        if (h == null)
            return new Node(k, v, RED);
        int cmp = k.compareTo(h.key);
        if (cmp < 0)
            h.left = put(h.left, k, v);
        else if(cmp > 0)
            h.right = put(h.right, k, v);
        else
            h.value = v;
        if (isRed(h.right) && !isRed(h.left))
            h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left))
            h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right))
            flipColor(h);
        return h;
    }

}
