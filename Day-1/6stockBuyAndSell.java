/*
Solution
We need to find out the maximum difference (which will be the maximum profit) between two numbers in the given array. 
Also, the second number (selling price) must be larger than the first one (buying price).

In formal terms, we need to find max(prices[j] - prices[i]), 
for every i and j such that j > i.
 */

public class Solution {
    public int maxProfit(int prices[]) {
        int maxprofit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxprofit)
                    maxprofit = profit;
            }
        }
        return maxprofit;
    }
}
/*
Complexity Analysis

Time complexity : O(n^2)
 */


 // Optimal Solution

 /*
 The points of interest are the peaks and valleys in the given graph. We need to find the largest peak following 
 the smallest valley. We can maintain two variables - minprice and maxprofit corresponding to the smallest valley and 
 maximum profit (maximum difference between selling price and minprice) obtained so far respectively.
  */

public class Solution {
    public int maxProfit(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }
}

// TC - O(n), only a single pass needed.