package com.company.algorithms;

import com.company.base.ListNode;

public class DetectCycle {

    public ListNode detectCycle(ListNode head){
        if(head == null){
            return null;
        }

        ListNode quick = head, slow = head;
     
        do{
            slow = slow.next;
            quick = quick.next;
            if(quick!=null){
                quick=quick.next;
            }
        }while(quick!=null && slow!=null && quick!=slow);

        //has no cycle
        if(quick == null || slow == null){
            return null;
        }

        quick = head; //quick reset to head
        while(quick!=slow){
            slow = slow.next;
            quick = quick.next;
        }

        return quick;
    }

}