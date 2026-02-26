package DataStructures.Arrays;

public class BestTimeToBuyAndSellStock {
    // 121 - Best Time to Buy and Sell Stock - Easy
    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

    /*
        Complexity Analysis
            Time Complexity: O(n)
            Space Complexity: O(1)
    */
    public static int maxProfit(int[] prices) {
        int minPrice  = Integer.MAX_VALUE;
        int maxProfit = 0;

        // [7,1,5,3,6,4]
        for(int price : prices) {
            // minPrice = Math.min(minPrice, price);
            // maxProfit = Math.max(maxProfit, price - minPrice);

            // update min price so far
            if (price < minPrice) {
                minPrice = price;
            }
            // Calculate the potential profit
            int profit =  price - minPrice;

            // Update the max profit found so far
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }
        return maxProfit;
    }
}
