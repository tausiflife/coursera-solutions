package com.leetcode;

public class SortList148 {
    public static void main(String[] args) {
        SortList148 sortList148 = new SortList148();
        // [4,2,1,3]
        ListNode head = new ListNode(4);
        ListNode next = new ListNode(2);
        head.next = next;
        next = new ListNode(1);
        head.next.next = next;
        next = new ListNode(3);
        head.next.next.next = next;
        System.out.println(sortList148.sortList(head));
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null )
            return head;
        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);
    }


    private ListNode getMid(ListNode node) {
        ListNode slow = node, fast = node, prev = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev= slow;
            slow = slow.next;
        }
        prev.next = null;
        return slow;
    }

    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummy_head = new ListNode(0);
        ListNode curr = dummy_head;
        while(list1 != null || list2 != null) {
            if(list1 == null) {
                curr.next = list2;
                break;
            }
            if(list2 == null) {
                curr.next = list1;
                break;
            }
            int val1 = list1.val;
            int val2 = list2.val;
            if(val1 < val2) {
                curr.next = list1;
                curr = curr.next;
                list1 = list1.next;
            } else {
                curr.next = list2;
                curr = curr.next;
                list2 = list2.next;
            }
        }
        return dummy_head.next;
    }
}
