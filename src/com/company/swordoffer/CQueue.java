package com.company.swordoffer;

import java.util.Stack;

class CQueue {

    private Stack<Integer> mainStack;
    private Stack<Integer> additionalStack;

    public CQueue() {
        this.mainStack = new Stack<>();
        this.additionalStack = new Stack<>();
    }

    public void appendTail(int value) {
        mainStack.push(value);
    }

    public int deleteHead() {
        if (this.additionalStack.isEmpty()){
            if (this.mainStack.isEmpty()){
                return -1;
            }

            while (!this.mainStack.isEmpty()){
                this.additionalStack.push(this.mainStack.pop());
            }
        }

        return this.additionalStack.pop();
    }
}
