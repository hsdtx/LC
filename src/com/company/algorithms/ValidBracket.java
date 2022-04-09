package com.company.algorithms;

import java.util.LinkedList;
import java.util.Stack;

public class ValidBracket {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chs = s.toCharArray();
        for (char ch: chs){
            if (!stack.empty() && (
                    ch == ')' && stack.peek() == '('
                    || ch == '}' && stack.peek() == '{'
                    || ch == ']' && stack.peek() == '['
                )
            ){
                stack.pop();
            }else{
                stack.push(ch);
            }
        }

        return stack.empty();
    }
}
