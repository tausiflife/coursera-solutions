package com.leetcode;

public class RotateList61 {
    public static void main(String[] args) {
        RotateList61 rotateList61 = new RotateList61();
        ListNode head = new ListNode(1);
        ListNode next = new ListNode(2);
        head.next = next;
        next = new ListNode(3);
        head.next.next = next;
        next = new ListNode(4);
        head.next.next.next = next;
        next = new ListNode(5);
        head.next.next.next.next = next;
        System.out.println(rotateList61.rotateList(head, 6));
    }

    public ListNode rotateList(ListNode head, int k) {
        if (k == 0 || head == null)
            return head;
        ListNode node = head;;
        int n = 1;
        while (node.next != null) {
            n++;
            node = node.next;
        }
        k = k % n;
        if (k == 0)
            return head;
        ListNode slow = head, fast = head;
        for (int i = 0; i < k; i++)
            fast = fast.next;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        ListNode tail = fast;
        ListNode newhead = slow.next;
        slow.next = null;
        tail.next = head;
        return newhead;
    }
}
