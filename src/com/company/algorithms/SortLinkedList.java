package com.company.algorithms;

import com.company.base.ListNode;
import com.sun.org.apache.xerces.internal.util.ShadowedSymbolTable;

import java.util.List;

public class SortLinkedList {

    public ListNode sortList(ListNode head) {
        if (head == null) return null;

        //链表长度
        int length = 0;
        ListNode index = head;
        while (index != null){
            length ++;
            index = index.next;
        }

        ListNode ans = new ListNode(0, head);
        for (int subLength = 1; subLength < length; subLength <<= 2){
            System.out.println(subLength);
            ListNode curr = ans.next;
            ListNode p = ans;
            while (curr != null){
                ListNode l1 = curr;
                for (int i=1; i<subLength && curr.next != null; i++){
                    curr = curr.next;
                }

                ListNode l2 = curr.next;
                curr.next = null; //分割链表
                curr = l2;
                for (int i=1; i<subLength && curr != null && curr.next != null; i++){
                    curr = curr.next;
                }
                if (curr != null){
                    ListNode temp = curr.next;
                    curr.next = null; //分割链表
                    curr = temp; //移位
                }

                p.next = mergeList(l1, l2);
                while (p.next != null) {
                    p = p.next; //p移动到最后一个节点
                }
            }
        }

        return ans.next;
    }

    private ListNode mergeList(ListNode l1, ListNode l2){
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

        return p.next;
    }
}
