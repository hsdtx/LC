package com.company.swordoffer;

import java.util.Stack;

public class ValidateStackSequences {

    public boolean v1(int[] pushed, int[] popped){
        int pushedIndex = 0, poppedIndex = 0;
        Stack<Integer> stack = new Stack<>();

        for (; pushedIndex<pushed.length; pushedIndex++){
            stack.push(pushed[pushedIndex]);

            while (!stack.isEmpty() && stack.peek() == popped[poppedIndex]){
                stack.pop();
                poppedIndex++;
            }
        }

        int len = pushed.length;
        return pushedIndex == len && poppedIndex == len;
    }
}
