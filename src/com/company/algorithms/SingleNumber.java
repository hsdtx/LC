package com.company.algorithms;

import org.omg.CORBA.PUBLIC_MEMBER;

public class SingleNumber {

    /**
     * 数组里一个数只出现一次，其他数均出现偶数次，找出这个数
     * 利用逻辑运算异或的性质
     * 0 ^ N = N
     * N ^ N = 0
     * M ^ N = N * M 交换律
     * 出现偶数次的数必和相同的数异或为0，0异或出现一次的数，则最终结果为出现一次的数
     */
    public int singleNumber1(int[] nums) {
        int ans = 0;
        for (int i : nums) {
            ans ^= i;
        }
        return ans;
    }

    /**
     * 数组里一个数只出现一次，其他数均出现3次，找出这个数
     * 因为其他数字出现次数为奇数次，所以不能用异或的方式将其他数字抵消
     */
    public int singleNumber2(int [] nums){
        int ans = 0;
        for (int i=0; i<32; i++){
            int total = 0; //记录每一位的总和
            for (int n: nums){
                total += (n>>i) & 1; //与1是只保留最后一位
            }

            ans += (total%3) << i;
        }

        return ans;
    }

    /**
     * 数组里有两个仅出现一次的数，其他数字均出现偶数次，找出两个出现一次的数
     */
    public int[] singleNumber3(int[] nums){
        int[] ans = new int[2];

        //先异或所有数
        //因为其他数字均出现偶数次，所以最终的结果一定是这两个数的异或结果
        //又因为这两个数一定不同，所以异或的结果一定不为0
        int temp = 0;
        for (int i: nums) {
            temp ^= i;
        }

        //找出最终结果最靠右哪一位是1
        //这一步有点骚操作，设计原码补码的知识，反正数和自己的相反数相与就能找到最右哪一位为1
        int rightOne = temp & -temp;

        //找到为1的那一位是为了把所有数分成两组，一组是对应为0的，一组是对应位为1的
        //其中一个出现一次的数这一位必为1，另一个必为0
        for (int i: nums){
            if ((i & rightOne) == 0){
                //为0的为一组
                ans[0] ^= i;
            }else{
                //不为0的为一组
                ans[1] ^= i;
            }
        }

        return ans;
    }
}