package com.company.algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LetterCombinations {

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()){
            return new LinkedList<>();
        }

        LinkedList<String> queue = new LinkedList<>();
        queue.offer("");
        for (int i=0; i<digits.length(); i++){
            char[] chs = getLetters(digits.charAt(i));
            int n = queue.size();
            for (int j=0; j<n; j++){
                String lastString = queue.poll();
                for (char c: chs){
                    queue.offer(lastString + c);
                }
            }
        }

        return queue;
    }

    private char[] getLetters(char c){
        if (c == '2'){
            return new char[]{'a', 'b', 'c'};
        }else if(c == '3'){
            return new char[]{'d', 'e', 'f'};
        }else if(c == '4'){
            return new char[]{'g', 'h', 'i'};
        }else if(c == '5'){
            return new char[]{'j', 'k', 'l'};
        }else if(c == '6'){
            return new char[]{'m', 'n', 'o'};
        }else if(c == '7'){
            return new char[]{'p', 'q', 'r', 's'};
        }else if(c == '8'){
            return new char[]{'t', 'u', 'v'};
        }else{
            return new char[]{'w', 'x', 'y', 'z'};
        }
    }
}
