package com.company.algorithms;

import com.company.base.ListNode;

public class LinkedListTwoNumberSum {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //头节点
        ListNode head = new ListNode();
        ListNode l3 = head;
        int extra = 0;
        while(l1 != null || l2 != null || extra != 0){
            ListNode next = new ListNode();
            if (l1 != null && l2 != null){
                int sum = l1.val + l2.val + extra;
                extra = sum / 10;
                next.val = sum % 10;

                l1 = l1.next;
                l2 = l2.next;
            }else if(l1 != null){
                int sum = l1.val + extra;
                extra = sum / 10;
                next.val = sum % 10;

                l1 = l1.next;
            }else if(l2 != null){
                int sum = l2.val + extra;
                extra = sum / 10;
                next.val = sum % 10;

                l2 = l2.next;
            }else if(extra != 0){
                int sum = extra;
                extra = sum / 10;
                next.val = sum % 10;
            }

            l3.next = next;
            l3 = l3.next;
        }

        return head.next;
    }
}
