package com.company.algorithms;
import java.util.ArrayList;
import java.util.List;

public class FindDisappearNumbers {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for (int i=0; i<nums.length; i++){
            int mod = nums[i]%n == 0? n: nums[i]%n;
            nums[mod-1] += n;
        }

        List<Integer> list = new ArrayList<>();
        for (int i=0; i< nums.length; i++){
            if (nums[i] <=n){
                list.add(i+1);
            }
        }

        return list;
    }

}
