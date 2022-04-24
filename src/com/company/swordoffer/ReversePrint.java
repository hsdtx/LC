package com.company.swordoffer;
import com.company.base.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class ReversePrint {

    /**
     * 感觉和反转链表没啥区别
     * 先递归试试
     */
    public int[] v1(ListNode head){
        ArrayList<Integer> list = new ArrayList<>();
        recursive(head, list);
        int[] res = new int[list.size()];

        for (int i=0; i<list.size(); i++){
            res[i] = list.get(i);
        }

        return res;
    }

    private void recursive(ListNode head, ArrayList<Integer> res){
        if (head == null){
            return;
        }

        recursive(head.next, res);
        res.add(head.val);
    }

    /**
     * 直接用栈就不用递归了
     */
    public int[] v2(ListNode head){
        LinkedList<Integer> stack = new LinkedList<>();

        while (head != null){
            stack.addFirst(head.val);
            head = head.next;
        }

        int[] res = new int[stack.size()];
        int index = 0;
        while (!stack.isEmpty()){
            res[index] = stack.removeFirst();
            index++;
        }

        return res;
    }
}