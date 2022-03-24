package com.company.algorithms;

import java.util.LinkedList;

public class LongestValidParentheses {

    private final static char leftParenthesis = '(';
    private final static char rightParenthesis = ')';

    class Node{
        public int index; //下标
        public char ch; //字符

        public Node(int index, char ch){
            this.index = index;
            this.ch = ch;
        }
    }

    public int longestValidParentheses(String s) {
        LinkedList<Node> stack = new LinkedList<>();
        for (int i=0; i<s.length(); i++){
            if (!stack.isEmpty() && stack.peekLast().ch == leftParenthesis && s.charAt(i) == rightParenthesis){
                stack.removeLast();
            }else {
                stack.offer(new Node(i, s.charAt(i)));
            }
        }

        int max = 0;
        int previousIndex = 0;
        stack.offer(new Node(s.length(), leftParenthesis)); //整个下界
        for (Node n: stack){
            max = Math.max((n.index - previousIndex)/2*2, max);
            previousIndex = n.index;
        }

        return max;
    }

    public int dp(String s){
        int len = s.length();
        int[] dp = new int[len];
        char[] chs = s.toCharArray();

        int max = 0;
        for (int i=1; i<len; i++){
            if (chs[i] == rightParenthesis){
                if (chs[i-1]==leftParenthesis){
                    dp[i] = i-2<0? 2: dp[i-2]+2;
                }else if (i-dp[i-1]-1 >= 0 && chs[i-dp[i-1]-1]==leftParenthesis){
                    dp[i] = i-dp[i-1]-2<0? dp[i-1]+2: dp[i-1]+dp[i-dp[i-1]-2]+2;
                }

                max = Math.max(max, dp[i]);
            }
        }

        return max;
    }
}
