package com.company;

import com.company.algorithms.*;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int ret = (new UniquePaths()).uniquePaths(3, 7);
        System.out.println(ret);
    }
}
