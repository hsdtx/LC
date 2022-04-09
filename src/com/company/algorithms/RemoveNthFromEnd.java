package com.company.algorithms;

import com.company.base.ListNode;

import java.util.List;

public class RemoveNthFromEnd {

    /**
     * 双指针
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;

        ListNode p = new ListNode(0);
        p.next = head;
        ListNode firstIndex = p;
        ListNode secondIndex = head;
        //令firstIndex和secondIndex保持n个节点差距
        int i = 0;
        for (; i < n; i++){
            if (secondIndex != null){
                secondIndex = secondIndex.next;
            }else {
                break;
            }
        }

        if (i < n-1){
            return head;
        }

        /*
         * 当secondIndex.next = null时，secondIndex指向最后一个节点，firstIndex指向倒数第N个节点
         */
        while (secondIndex != null){
            firstIndex = firstIndex.next;
            secondIndex = secondIndex.next;
        }

        /*
         * 第一个指针没有移动
         */
        firstIndex.next = firstIndex.next.next;
        if (firstIndex == p){
            return p.next;
        }

        return head;
    }
}
