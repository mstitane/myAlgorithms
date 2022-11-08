package com.stitane.dp;

public class DynamicProgrammingSolution {
    public int climbStairs(int n) {
        int[] sums = new int[n + 1];
        return climb(0, n, sums);
    }

    public int maxProfit(int[] prices) {
        int min = prices[0];
        int maxProfit = 0;

        for (int i = 1, pricesLength = prices.length; i < pricesLength; i++) {
            if (min > prices[i]) {
                min = prices[i];
            } else if (prices[i] - min > maxProfit)
                maxProfit = prices[i] - min;
        }
        return maxProfit;
    }

    public int maxSubArray(int[] nums) {
        int maxSoFar = Integer.MIN_VALUE;
        int maxEndingHere = 0;

        for (int n : nums) {
            maxEndingHere = maxEndingHere + n;
            if (maxSoFar < maxEndingHere)
                maxSoFar = maxEndingHere;
            if (maxEndingHere < 0)
                maxEndingHere = 0;
        }
        return maxSoFar;
    }

    public int rob(int[] nums) {
        int r1 = 0;
        int r2 = 0;

        for (int n : nums) {
            int temp = Math.max(n + r1, r2);
            r1 = r2;
            r2 = temp;
        }
        return r2;
    }

    private int climb(int i, int n, int[] sums) {
        if (i > n)
            return 0;
        else if (i == n)
            return 1;
        else if (sums[i] != 0)
            return sums[i];
        else
            sums[i] = climb(i + 1, n, sums) + climb(i + 2, n, sums);

        return sums[i];
    }
}