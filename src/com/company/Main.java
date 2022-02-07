package com.company;

import com.company.algorithms.*;

public class Main {

    public static void main(String[] args) {
        String[] strs = new String[]{"a","b","a","b","a","c"};
        String s = (new TopKString()).sol(strs, 3);
        System.out.println(s);
    }
}
