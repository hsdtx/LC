package com.company.algorithms;

import com.company.base.ListNode;

import java.util.HashSet;

public class HasCycle {

    /*
     * 哈希表，时间复杂度O(n)
     */
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        for (; head != null; head = head.next){
            if (set.contains(head)){
                return true;
            }else {
                set.add(head);
            }
        }

        return false;
    }

    /*
     * 龟兔赛跑
     * 一个快指针（每次走两步），一个慢指针（每次走一步），如果有环的话，两指针一定会在环内相遇
     * 无环的话，快指针会先走到null（到达终点）
     */
    public boolean hasCycle1(ListNode head){
        if (head == null){
            return false;
        }

        ListNode quick = head;
        ListNode slow = head;

        do {
            quick = quick.next;
            slow = slow.next;
            if (quick != null){
                quick = quick.next;
            }

            if (quick == slow && quick != null){
                return true;
            }
        }while (quick != null && slow != null);

        return false;
    }

    /*
     * 找到环的入口
     * 假设链表起点到环的入口距离为a，环的入口到快慢指针相遇的地方距离为b，相遇点到环的入口距离为c
     * 则两指针相遇时，慢指针走过的距离为a+b，快指针走过的距离为2(a+b)，
     * 快指针此时套了慢指针k圈，则2a+2b = a+b+k(b+c)
     * 则 a = -b+kb+kc
     * 则 a = (k-1)b+(k-1)c+c，把c拆出来
     * 则 a = (k-1)(b+c)+c
     * 这时候用一个finder指针从链表的起点走a步会到达环的入口，同步让慢指针走a步，慢指针走过的距离为a+b+c+(k-1)(b+c) = a+k(b+c)
     * 此时finder指针和慢指针会同时到达环的入口
     */
    public ListNode cycleEntrance(ListNode head){
        if (head == null){
            return null;
        }

        ListNode quick = head;
        ListNode slow = head;
        do {
            quick = quick.next;
            slow = slow.next;
            if (quick != null){
                quick = quick.next;
            }

            if (quick == slow && quick != null){
                break;
            }
        }while (quick != null && slow != null);

        //有一个指针已经到链表尽头了
        if (quick == null || slow == null){
            return null;
        }

        ListNode finder = head;
        while (finder != null && slow != null){
            if (finder == slow){
                break;
            }

            finder = finder.next;
            slow = slow.next;
        }

        return finder;
    }
}