package com.company.algorithms;

import java.util.LinkedList;

public class DecodeString {

    public String decodeString(String s){
        char[] chs = s.toCharArray();
        LinkedList<Character> stack = new LinkedList<>();

        for (char ch: chs){
            if (ch == ']'){
                StringBuilder sb = new StringBuilder();
                while (!stack.isEmpty() && stack.getFirst() != '['){
                    sb.insert(0, stack.removeFirst());
                }
                stack.removeFirst(); // [

                int duplicate = 0;
                int numIndex = 1;
                while (!stack.isEmpty() && stack.getFirst() >= '0' && stack.getFirst() <= '9'){
                    duplicate += Math.pow(10, numIndex-1)*(stack.removeFirst()-'0');
                    numIndex++;
                }
                String temp = sb.toString();
                for (int i=0; i<duplicate-1; i++){
                    sb.append(temp);
                }
                for (int i=0; i<sb.length(); i++){
                    stack.addFirst(sb.charAt(i));
                }
            }else{
                stack.addFirst(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char ch: stack){
            sb.append(ch);
        }

        return sb.reverse().toString();
    }
}
