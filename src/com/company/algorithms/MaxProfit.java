package com.company.algorithms;

public class MaxProfit {

    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int p: prices){
            minPrice = Math.min(minPrice, p);
            maxProfit = Math.max(maxProfit, p-minPrice);
        }

        return maxProfit;
    }
}
