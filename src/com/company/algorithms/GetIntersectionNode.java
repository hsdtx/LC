package com.company.algorithms;

import com.company.base.ListNode;

import java.util.HashSet;

public class GetIntersectionNode {

    /**
     * 哈希集合方法空间复杂度O(n)，双指针可以降低空间复杂度，两方法时间复杂度都是O(n)。
     * 令A指针指向第一个链表，B指向第二个链表，
     * 设A链表不相交部分长度为a，B链表不相交部分长度为b，两链表相交部分长度为c。
     * 如果两指针同时指向null或同一节点，则返回null或节点；如果只有一个指针指向null，则令另一指针指向另一个链表
     * 数学证明：
     * 必有一时刻两链表走过的距离同为a+b+c (可c=0)，此时A指针一定会指向第二个链表长度为b的地方，B指向第一个长度为a的地方(可能是null，此时不相交)
     * 代码里实际上多走了一步
     */
    public ListNode getIntersectionNodeV2(ListNode headA, ListNode headB){
        ListNode p1 = headA, p2 = headB;
        while (headA != headB){
            if (headA != null){
                headA = headA.next;
            }else {
                headA = p2;
            }

            if (headB != null){
                headB = headB.next;
            }else{
                headB = p1;
            }
        }

        return headA;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();

        while (headA != null){
            set.add(headA);
            headA = headA.next;
        }

        while (headB != null){
            if (set.contains(headB)){
                return headB;
            }
            headB = headB.next;
        }

        return null;
    }
}
