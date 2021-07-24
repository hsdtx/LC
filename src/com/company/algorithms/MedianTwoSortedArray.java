package com.company.algorithms;

public class MedianTwoSortedArray {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //恒任务长度长的数组为nums2，减少不必要的分类讨论
        if (nums1.length > nums2.length){
            int[] temp = nums2;
            nums2 = nums1;
            nums1 = temp;
        }

        int m = nums1.length;
        int n = nums2.length;

        //不管m+n为奇数还是偶数，左侧数字个数恒为(m+n+1)/2
        int leftTotal = (m+n+1)/2;
        /*
         * 针对nums1数组，需要在[0, m]的范围内找到两数组左侧数字个数为leftTotal且满足交叉比较条件的坐标
         * 包括m的原因是分割线可能在nums1的最右侧
         * 交叉比较条件：
         * 1. nums1[i-1] <= nums2[j]
         * 2. nums2[j-1] <= nums1[i]
         * 写代码时对条件取反
         */
        int left = 0;
        int right = m;
        while(left < right){
            int i = (left + right + 1) / 2; //对一个数组取中位数
            int j = leftTotal - i; //i和j的对应关系
            if (nums1[i-1] > nums2[j]){
                right = i - 1;
            } else{
                left = i;
            }
        }

        int nums1Right = left == 0? Integer.MIN_VALUE: nums1[left-1]; //分界线取到第一个数组的最左侧需要特殊处理
        int nums1Left = left == m? Integer.MAX_VALUE: nums1[left]; //特殊情况
        int nums2Right = leftTotal-left == 0? Integer.MIN_VALUE: nums2[leftTotal - left - 1];
        int nums2Left = leftTotal-left == n? Integer.MAX_VALUE: nums2[leftTotal - left];

        if ((m+n) % 2 == 0){
            return ((double) Math.max(nums1Right, nums2Right) + (double) Math.min(nums1Left, nums2Left))/2;
        }

        return (double) Math.max(nums1Right, nums2Right);
    }
}
