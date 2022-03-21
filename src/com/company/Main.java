package com.company;

import com.company.algorithms.*;
import com.company.review.LRUCache;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,4,7};
        System.out.println((new FindLengthOfLCIS()).findLengthOfLCIS(nums));
    }
}
