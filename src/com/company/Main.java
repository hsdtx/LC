package com.company;

import com.company.algorithms.*;
import com.company.review.LRUCache;
import com.company.swordoffer.*;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{4,6,7,5};
        boolean ret = (new VerifyPostorder()).v1(nums);
        System.out.println(ret);
    }
}
