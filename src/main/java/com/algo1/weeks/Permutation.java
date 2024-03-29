package com.algo1.weeks;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Permutation {
    public static void main(String[] args) {
        if (args.length == 1) {
            RandomizedQueue<String> q = new RandomizedQueue<>();
            int k = Integer.parseInt(args[0]);
            while (!StdIn.isEmpty())
                q.enqueue(StdIn.readString());
            for (int i = 0; i < k; i++)
                StdOut.println(q.dequeue());
        }
    }
}
