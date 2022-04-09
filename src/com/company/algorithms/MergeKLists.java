package com.company.algorithms;

import com.company.base.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;

        ListNode p = new ListNode(0);
        ListNode move = p;
        while (true){
            int minValue = Integer.MAX_VALUE;
            int index = 0;
            for (int i=0; i<lists.length; i++){
                if (lists[i] != null){
                    if (lists[i].val < minValue){
                        index = i;
                        minValue = lists[i].val;
                    }
                }
            }

            if (lists[index] == null){
                break;
            }

            move.next = lists[index];
            move = move.next;
            lists[index] = lists[index].next;
        }

        return p.next;
    }
}
