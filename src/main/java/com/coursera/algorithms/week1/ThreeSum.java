package com.coursera.algorithms.week1;

import java.util.Arrays;

public class ThreeSum {

    public int getThreeSumInQuadraticTime(int[] a, int[] b, int[] c, int sum) {
        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);
        int count = 0;
        // x + y + z = sum
        //=> x + y = sum - z
        // if x + y < sum - z i.e either we want higher value than x or higher value that y
        // as b, c are sorted and we are iterating b from start and c from end
        // higher b, should be present in next index
        //lower c is on the previous index
        for (int i = 0; i < a.length; i++) {
            int j = 0, k = c.length - 1;
            while (j < b.length && k > 0) {
                if (b[j] + c[k] == sum - a[i])
                    count++;
                else if (b[j] + c[k] < sum - a[i])
                    j++;
                else
                    k--;
            }
        }
        return count;
    }
}
