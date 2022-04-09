package com.company.algorithms;

import com.company.base.ListNode;

public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p = new ListNode(0);
        ListNode index = p;

        while (l1 != null && l2 != null){
            if (l1.val <= l2.val){
                index.next = l1;
                l1 = l1.next;
            }else{
                index.next = l2;
                l2 = l2.next;
            }
            index = index.next;
        }

        while (l1 != null){
            index.next = l1;
            l1 = l1.next;
            index = index.next;
        }

        while (l2 != null){
            index.next = l2;
            l2 = l2.next;
            index = index.next;
        }

        return p;
    }
}
