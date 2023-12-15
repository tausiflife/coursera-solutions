package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class CoinSum {
    public static void main(String[] args) {

        System.out.println(countWays(2));
    }

    private static int countWays(float coin) {
        float[] possibleCoins = new float[] {0.01F, 0.02f, 0.05f, 0.1f,0.2f, 0.5f, 1f, 2f};
        Queue<Float> queue = new LinkedList<>();
        queue.add(coin);
        int count =0;
        double epsilon = 0.000001d;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i< size; i++) {
                float remaining = queue.poll();
                for (float possibleCoin : possibleCoins) {
                    float finalSum = remaining - possibleCoin;
                    finalSum = Float.parseFloat(String.format("%.2f", finalSum));
                    if(finalSum == 0)
                        count++;
                    else if (finalSum > 0)
                        queue.add(finalSum);
                }
            }
        }
        return count;
    }
}
