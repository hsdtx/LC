package com.company.algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public int majorityElement(int[] nums){
        return mooreVote(nums);
    }

    /**
     * 摩尔投票法，有点难理解，在众数超过半数的前提下，遍历数组，如果元素等于can，则计数器count加一，否则减一，
     * count等于0时，更换can，最终can一定是众数
     */
    public int mooreVote(int[] nums){
        int can = nums[0], count = 0;
        for (int num: nums){
            if (count == 0){
                can = num;
            }

            if (can == num){
                count++;
            }else{
                count--;
            }
        }

        return can;
    }

    /**
     * 思路比较简单的方案，直接遍历一遍数组，将每个元素的出现基数记录下来，就知道哪个元素是出现次数最多的了
     * 时间复杂度O(n)，空间复杂度O(n)，感觉已经是比较高效的方法了，如果题目不满足最多的数的个数大于数组个数的一半，
     * 感觉只能用这个办法快一点？
     */
    public int hashMap(int[] nums){
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0, can = nums[0];
        for (int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);

            if (map.get(num) > max){
                can = num;
                max = map.get(num);
            }
        }

        return can;
    }

    /**
     * 排序也是比较直接的方案，排序后取中位数
     * 时间复杂度平均为O(nlogn)，空间复杂度O(1)
     */
    public int sort(int[] nums){
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    /**
     * 分治，感觉有点脱裤子放屁，当被分隔开的两部分的众数不同时，还是要遍历整个数组确定谁出现次数更多
     * 时间复杂度O(logN)
     */
    public int dividedAndConquer(int[] nums){
        return dividedAndConquerRecursive(nums, 0, nums.length-1);
    }

    private int dividedAndConquerRecursive(int[] nums, int left, int right){
        if (left >= right){
            return nums[left];
        }

        int middle = (left+right)/2;
        int leftNum = dividedAndConquerRecursive(nums, left, middle);
        int rightNum = dividedAndConquerRecursive(nums, middle+1, right);

        //左右两部分众数一样，直接返回
        if (leftNum == rightNum){
            return leftNum;
        }

        return countInNums(nums, leftNum, left, right) > countInNums(nums, rightNum, left, right)?
                leftNum: rightNum;
    }

    private int countInNums(int[] nums, int num, int begin, int end){
        int res = 0;
        for (int i=begin; i<=end; i++){
            if (nums[i] == num){
                res++;
            }
        }

        return res;
    }
}
