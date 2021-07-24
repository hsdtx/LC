package com.company.algorithms;

import com.company.base.ListNode;

public class ReverseList {

    /**
     * 递归
     * @param head
     * @return
     */
    public ListNode recursive(ListNode head){
        //head=null的情况只有一种，头节点是null
        if (head == null || head.next == null){
            return head;
        }

        //个人理解这个返回值只是把最后一个节点反给递归的最外层
        ListNode newHead = recursive(head.next);
        //真正做逆序操作的是如下两步
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    /**
     * 迭代
     * @param head
     * @return
     */
    public ListNode reverse(ListNode head){
        ListNode prev = null, cur = head;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }


    /**
     * 链表k个一组逆序
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode pre = new ListNode(0); //实例化一个头节点
        ListNode newTail = pre;
        pre.next = head;

        while (head != null) {
            ListNode tail = head;
            boolean notEnoughFlag = false;
            for (int i = 0; i<k-1; i++){
                //剩下的节点数不够k个了
                if (tail.next == null){
                    notEnoughFlag = true;
                    break;
                }
                tail = tail.next;
            }

            if (notEnoughFlag){
                while (head != null){
                    newTail.next = head;
                    head = head.next;
                    newTail = newTail.next;
                }
            }

            ListNode prev = null, cur = head, temp = head;
            while (cur != null && prev != tail){
                ListNode next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }

            newTail.next = prev; //prev指向这一组新的头节点
            newTail = temp;
            head = cur; //head指向下一组的头节点
        }

        return pre.next;
    }
}
