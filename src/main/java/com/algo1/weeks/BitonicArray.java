package com.algo1.weeks;

import java.util.Iterator;

public class BitonicArray<Item> implements Iterator<Item> {
    public static int bitonicSearch(int[] arr, int k) {
        if (arr.length == 0 )
            return -1;
        return find(arr, 0, arr.length - 1, k);
    }
    public static int find(int[] arr, int start, int end, int k) {
        if (k == arr[start])
            return start;
        if (k == arr[end])
            return end;
        if (start >= end)
            return -1;
        int mid = start + (end - start)/2;
        if (k == arr[mid])
            return mid;
        if (arr[mid - 1] < arr[mid]) {
            if (arr[mid] < arr[mid + 1]) { //peak is to the right
                if (k > arr[mid])
                    return find(arr, mid + 1, end, k);
                else {
                    int idx = binarySearch(arr, start, mid - 1, k, true);
                    return idx != -1 ? idx : find(arr, mid + 1, end, k);
                }
            } else { //this is peak
                if (k > arr[mid])
                    return -1;
                int idx = binarySearch(arr, start, mid - 1, k, true);
                return idx != -1 ? idx : binarySearch(arr, mid + 1, end, k, false);
            }
        } else { //peak is to the left
            if (k > arr[mid])
                return find(arr, start, mid -1, k);
            else {
                int idx = binarySearch(arr, mid + 1, end, k, false);
                return idx != -1 ? idx : find(arr, start, mid - 1, k);
            }
        }
    }

    private static int binarySearch(int[] arr, int start, int end, int k, boolean asc) {
        if (k == arr[start])
            return start;
        if (k == arr[end])
            return end;
        if (start >= end)
            return -1;
        int mid = start + (end - start)/2;
        if (k == arr[mid])
            return mid;
        if ((asc && k > arr[mid]) || (!asc && k < arr[mid]))
            return binarySearch(arr, mid + 1, end, k, asc);
        else
            return binarySearch(arr, start, mid - 1, k , asc);
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,2,11,9,8,7,6,5,4,3};
        System.out.println(find(arr,0, arr.length - 1, 2));
    }

    public boolean hasNext() {
        return false;
    }

    public Item next() {
        return null;
    }

    public void remove() {

    }
}
