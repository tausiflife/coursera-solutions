package com.general.problems;

public class Fibonacci {

    public int printFiboncacciUsingRecursion(int n) {
        if (n <= 1)
            return 1;
        return printFiboncacciUsingRecursion(n-1) + printFiboncacciUsingRecursion(n - 2);
    }
}
