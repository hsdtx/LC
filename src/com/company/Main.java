package com.company;

import com.company.algorithms.MedianTwoSortedArray;
import com.company.algorithms.MergeIntervals;
import com.company.algorithms.SearchRange;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{5,8,8,8,8,10};
        int target = 6;
        int[] res = (new SearchRange()).searchRange(nums, target);
        System.out.println(Arrays.toString(res));
    }
}
