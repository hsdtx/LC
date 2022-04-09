package com.company.algorithms;

import java.util.ArrayList;
import java.util.List;

public class Palindrome {

    public boolean isPalindrome(int x) {
        if (x < 0){
            return false;
        }

        List<Integer> nums = new ArrayList<>();

        while (x!=0){
            int lastNum = x % 10;
            x /= 10;
            nums.add(lastNum);
        }
        System.out.println(nums.toString());

        int left = 0, right = nums.size() - 1;

        while (left < right){
            if ((int)nums.get(left) == nums.get(right)){
                left ++;
                right --;
            }else{
                return false;
            }
        }

        return true;
    }
}
