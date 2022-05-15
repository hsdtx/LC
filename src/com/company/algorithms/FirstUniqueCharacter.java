package com.company.algorithms;

import java.util.HashMap;
import java.util.LinkedList;

public class FirstUniqueCharacter{

    public char v1(String s){
        int len = s.length();
        if(len == 0){
            return ' ';
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<len; i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }

        for(int i=0; i<len; i++){
            if(map.get(s.charAt(i)) == 1){
                return s.charAt(i);
            }
        }

        return ' ';
    }

}