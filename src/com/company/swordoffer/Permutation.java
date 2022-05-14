package com.company.swordoffer;

import java.util.*;

public class Permutation {

    public String[] v1(String s){
        HashSet<String> list = new HashSet<>();
        List<Character> set = new LinkedList<>();
        for (int i=0; i<s.length(); i++){
            set.add(s.charAt(i));
        }
        v1Rec(list, set, new StringBuilder());

        return list.toArray(new String[]{});
    }

    public void v1Rec(HashSet<String> res, List<Character> set, StringBuilder sb){
        if (set.isEmpty()){
            res.add(sb.toString());
            return ;
        }

        for (Character c: set.toArray(new Character[]{})){
            set.remove(c);
            sb.append(c);
            v1Rec(res, set, sb);
            //回溯
            sb.deleteCharAt(sb.length()-1);
            set.add(c);
        }
    }
}
