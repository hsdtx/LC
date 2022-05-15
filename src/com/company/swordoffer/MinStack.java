package com.company.swordoffer;

import java.util.Stack;

public class MinStack {

    private Stack<Integer> mainStack;
    private Stack<Integer> helpStack;

    public MinStack() {
        this.mainStack = new Stack<>();
        this.helpStack = new Stack<>();
        this.helpStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        this.mainStack.push(x);
        this.helpStack.push(this.helpStack.peek() < x? this.helpStack.peek(): x);
    }

    public void pop() {
        this.mainStack.pop();
        this.helpStack.pop();
    }

    public int top() {
        return this.mainStack.peek();
    }

    public int min() {
        return this.helpStack.peek();
    }
}
