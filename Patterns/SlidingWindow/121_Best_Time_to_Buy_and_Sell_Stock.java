/*
Problem: Best Time to Buy and Sell Stock
Platform: LeetCode #121
Pattern: One Pass / Greedy / Prefix Minimum
Difficulty: Easy

Approach:
- Initialize minPrice as the first day's price
- Iterate through prices:
  - Update minPrice if a lower price is found
  - Compute profit if sold today
  - Track the maximum profit seen so far

Time Complexity: O(n) — single pass through the array
Space Complexity: O(1) — constant extra space
*/

public class 121_Best_Time_to_Buy_and_Sell_Stock {
    

    public int maxProfit(int[] prices) {

        int minPrice=prices[0];
        int maxProfit=0;
        for(int i=0;i<prices.length;i++){
            minPrice=Math.min(minPrice,prices[i]);
            maxProfit=Math.max(maxProfit,prices[i]-minPrice);
        }
        return maxProfit;
    }
}
