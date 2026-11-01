package greedy;

import java.util.*;

public class Q0122_BestTimeToBuyAndSellStockII {
    // Öncelik   : 🔴 Yüksek  ·  🌍 Ortak soru
    // Şirketler : Amazon ✅ (#83), Apple ✅ (#22), Bloomberg ✅ (#98)
    //
    // 122. Best Time to Buy and Sell Stock II - Medium
    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/

    /* ------------------------------------------------------------
       | PATTERN: Greedy (her artışı topla)
       ------------------------------------------------------------
       Sınırsız işlem yapılabildiği için her yükselişi kâra çevirmek yeterli:
       prices[i] > prices[i-1] ise farkı ekle. Bu, tüm yükselen dönemlerin toplamına eşittir.
    */
    /*  Complexity
        Time  : O(n)
        Space : O(1)
    */

    public static int maxProfit(int[] prices) {
        int ans = 0;
        for (int i = 1; i < prices.length; ++i) {
            ans += Math.max(0, prices[i] - prices[i - 1]);
        }
        return ans;
    }
}
