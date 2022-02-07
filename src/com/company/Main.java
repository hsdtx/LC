package com.company;

import com.company.algorithms.*;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 3};
        int ret = (new RemoveElement()).removeElement(nums, 3);
        System.out.println(Arrays.toString(nums));
        System.out.println(ret);
    }
}
