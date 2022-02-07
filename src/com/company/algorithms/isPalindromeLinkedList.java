package com.company.algorithms;

import com.company.base.ListNode;
import java.util.LinkedList;
import java.util.List;

public class isPalindromeLinkedList {

    public boolean isPalindrome(ListNode head){
        int length = 0;
        ListNode index = head;
        while (index != null){
            length++;
            index = index.next;
        }

        int reverseEnd = (length+1)/2; //反转链表到第几个节点结束
        ListNode pre = null;
        index = head;
        for (int i=0; i<reverseEnd; i++){
            ListNode temp = index.next;
            index.next = pre;
            pre = index;
            index = temp;
        }

        if (length % 2 != 0 && pre != null){
            pre = pre.next;
        }

        while (pre != null && index != null){
            if ((pre == null || index == null) || pre.val != index.val){
                return false;
            }

            pre = pre.next;
            index = index.next;
        }

        return true;
    }
}
