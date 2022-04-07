package com.company;

import com.company.algorithms.*;
import com.company.review.LRUCache;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String s = "abab";
        String p = "ab";
        List<Integer> l = (new FindAnagrams()).findAnagrams(s, p);
        System.out.println(l);
    }
}
