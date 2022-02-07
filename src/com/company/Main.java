package com.company;

import com.company.algorithms.*;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{7,6,5,4,3,2,1};
        int res = (new TopK()).findKthLargest(nums, 5);
        System.out.println(Arrays.toString(nums));

        System.out.println(res);
    }
}
