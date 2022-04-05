package com.company.algorithms;

import java.util.LinkedList;

public class Reverse {


    public int reverse(int x) {
        int downLimit = Integer.MIN_VALUE/10;
        System.out.println(downLimit);
        int upLimit = Integer.MAX_VALUE/10;

        int ans = 0;
        while (x != 0){
            if (ans < downLimit || ans > upLimit){
                System.out.println(ans);
                return 0;
            }

            int tmp = x%10;
            ans = ans * 10 + tmp;
            x /= 10;
        }

        return ans;
    }
}
