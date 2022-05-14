package com.company.swordoffer;

import java.util.Arrays;
import java.util.Comparator;

public class MinNumber {

    public String v1(int[] nums){
        String[] numStrs = new String[nums.length];
        for (int i=0; i<nums.length; i++){
            numStrs[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(numStrs, new Comparator<String>() {
            public int compare(String o1, String o2) {
                String t1 = o1 + o2;
                String t2 = o2 + o1;
                return t1.compareTo(t2);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (String s: numStrs){
            sb.append(s);
        }
        return sb.toString();
    }
}
