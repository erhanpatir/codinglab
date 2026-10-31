package dp.knapsack;

import java.util.*;

public class Q1049_LastStoneWeightII {
    // Öncelik   : 🔵 Trend
    // Şirketler : Apple ✅ (#111)
    //
    // 1049. Last Stone Weight II - Medium
    // https://leetcode.com/problems/last-stone-weight-ii/

    /* ------------------------------------------------------------
       | PATTERN: 0/1 Knapsack (toplamın yarısına en yakın alt küme)
       ------------------------------------------------------------
       Taşları iki gruba ayırma problemine dönüşür: kalan ağırlık = |S1 - S2|.
       S1'i toplam / 2'ye mümkün olduğunca yaklaştır (0/1 knapsack, kapasite toplam / 2).
       Cevap = toplam - 2 * dp[toplam / 2].
    */
    /*  Complexity
        Time  : O(n * toplam)
        Space : O(n * toplam)
    */

    public static int lastStoneWeightII(int[] stones) {
        int s = 0;
        for (int v : stones) {
            s += v;
        }
        int m = stones.length;
        int n = s >> 1;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; ++i) {
            for (int j = 0; j <= n; ++j) {
                dp[i][j] = dp[i - 1][j];
                if (stones[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - stones[i - 1]] + stones[i - 1]);
                }
            }
        }
        return s - dp[m][n] * 2;
    }
}
