package dp.state;

import java.util.*;

public class Q0714_BestTimeToBuyAndSellStockWithTransactionFee {
    // 714. Best Time to Buy and Sell Stock with Transaction Fee - Medium
    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/

    /* ------------------------------------------------------------
       | PATTERN: State Machine DP (cash / hold)
       ------------------------------------------------------------
       İki durum: cash = elde hisse yokken en iyi kâr, hold = elde hisse varken en iyi kâr.
       cash = max(cash, hold + fiyat - fee) (sat), hold = max(hold, cash - fiyat) (al).
       Sadece önceki gün gerektiği için iki değişken yeterli.
    */
    /*  Complexity
        Time  : O(n)
        Space : O(1)
    */

    public static int maxProfit(int[] prices, int fee) {
        int cash = 0;            // elimde hisse yokken en iyi kâr
        int hold = -prices[0];   // elimde hisse varken en iyi kâr
        for (int i = 1; i < prices.length; i++) {
            int newCash = Math.max(cash, hold + prices[i] - fee); // sat
            int newHold = Math.max(hold, cash - prices[i]);       // al
            cash = newCash;
            hold = newHold;
        }
        return cash;
    }
}
