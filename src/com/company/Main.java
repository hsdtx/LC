package com.company;

import com.company.algorithms.MedianTwoSortedArray;
import com.company.algorithms.MergeIntervals;

public class Main {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,3};
        int[] nums2 = new int[]{2};
        System.out.println((new MedianTwoSortedArray()).findMedianSortedArrays(nums1, nums2));
    }
}
