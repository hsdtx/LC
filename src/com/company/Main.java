package com.company;


import com.company.algorithms.FindLengthOfLCIS;

public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,4,3,7};
        System.out.println((new FindLengthOfLCIS()).findLengthOfLCIS(nums));
    }
}
