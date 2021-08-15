package com.company;

import com.company.algorithms.*;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int ret = (new FindPathsOut()).findPaths(1, 3, 3, 0, 1);
        System.out.println(ret);
    }
}
