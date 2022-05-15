package com.company.swordoffer;
import com.company.base.ListNode;

public class DeleteListNode {

    public ListNode deleteNode(ListNode head, int val){
        ListNode mark = new ListNode();
        ListNode res = mark;
        mark.next = head;

        while (head != null){
            if (head.val == val){
                //删除节点
                mark.next = head.next;
                head.next = null;
                head = mark.next;

                continue;
            }

            head = head.next;
            mark = mark.next;
        }

        return res.next;
    }
}
