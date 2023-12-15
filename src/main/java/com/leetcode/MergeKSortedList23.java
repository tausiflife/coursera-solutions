package com.leetcode;

public class MergeKSortedList23 {
    public static void main(String[] args) {
        MergeKSortedList23 mergeKSortedList23 = new MergeKSortedList23();

    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)
            return null;
        return divide(lists, 0, lists.length - 1);
    }

    public ListNode divide(ListNode[] list, int start, int end) {
        if(start >= end)
            return list[start];
        int mid = start + (end - start)/2;
        ListNode left = divide(list, start, mid);
        ListNode right = divide(list, mid + 1, end);
        return mergeList(left, right);
    }

    public ListNode mergeList(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        while(list1 != null || list2 != null) {
            if(list1 == null) {
                curr.next = list2;
                break;
            }
            if(list2 == null) {
                curr.next = list1;
                break;
            }
            if(list1.val < list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
        }
        return dummy.next;
    }
}
