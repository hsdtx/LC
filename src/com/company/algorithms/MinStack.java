package com.company.algorithms;

import java.util.LinkedList;
import java.util.Objects;

class MinStack {
    private LinkedList<Integer> stack;
    private LinkedList<Integer> minStack; //保存到目前栈顶的最小值

    public MinStack() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
        minStack.offer(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack.offer(val);
        int top = Objects.isNull(minStack.peekLast())? Integer.MAX_VALUE: minStack.peekLast();
        minStack.offer(Math.min(val, top));
    }

    public void pop() {
        stack.removeLast();
        minStack.removeLast();
    }

    public int top() {
        return Objects.isNull(stack.peekLast())? Integer.MAX_VALUE: stack.peekLast();
    }

    public int getMin() {
        return Objects.isNull(minStack.peekLast())? Integer.MAX_VALUE: minStack.peekLast();
    }
}