package com.company;

import com.company.algorithms.*;
import com.company.review.LRUCache;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{2,2,2,2,2};
        int res = (new FindLengthOfLIS()).findNumberOfLIS(nums);
        System.out.println(res);
    }
}
