package com.company.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums); //排序

        //掐头去尾
        for (int i=0; i<nums.length-2; i++){
            //排序后i之后的数绝对大于0，三数之和不可能为0了
            if (nums[i] > 0){
                continue;
            }

            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }

            int l = i+1;
            int r = nums.length-1;
            int de = -nums[i];
            while (l<r){
                //跳过重复元素
                if (l-1>i && nums[l] == nums[l-1]){
                    l++;
                    continue;
                }

                if (r+1 < nums.length && nums[r] == nums[r+1]){
                    r--;
                    continue;
                }

                if (nums[l] + nums[r] > de){
                    r--;
                }else if(nums[l] + nums[r] < de){
                    l++;
                }else{
                    List<Integer> tempRes = new ArrayList<Integer>();
                    tempRes.add(nums[l]);
                    tempRes.add(nums[r]);
                    tempRes.add(nums[i]);
                    res.add(tempRes);
                    l++;
                    r--;
                }
            }
        }

        return res;
    }
}
