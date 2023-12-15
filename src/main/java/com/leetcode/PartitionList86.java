package com.leetcode;

public class PartitionList86 {
    public ListNode partition(ListNode head, int x) {

        ListNode minHead = null;
        ListNode minPrevious = null;
        ListNode maxHead = null;
        ListNode maxPrevious = null;
        ListNode node = head;
        while(node != null){
            if(node.val < x) {
                if(minHead == null){
                    minHead = new ListNode(node.val);
                    minPrevious = minHead;
                } else {
                    ListNode curr = new ListNode(node.val);
                    minPrevious.next = curr;
                    minPrevious = curr;
                }
            }
            else {
                if(maxHead == null){
                    maxHead = new ListNode(node.val);
                    maxPrevious = maxHead;
                } else {
                    ListNode curr = new ListNode(node.val);
                    maxPrevious.next = curr;
                    maxPrevious = curr;
                }
            }
            node = node.next;
        }
        if(minHead == null) {
            return maxHead;
        } else {
            minPrevious.next = maxHead;
        }
        return minHead;
    }
}
