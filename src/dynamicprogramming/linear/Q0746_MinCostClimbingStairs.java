package dynamicprogramming.linear;

public class Q0746_MinCostClimbingStairs {
    // 746. Min Cost Climbing Stairs - Easy
    // https://leetcode.com/problems/min-cost-climbing-stairs/

    /*
        Pattern 1 — Fibonacci-style 1D DP / linear forward DP
        - lineer mi? ✅
        - sadece önceki state’lere mi bakıyorum? ✅
    */

    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        int[] dp = new int[n];
        // base case
        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < n; i++) {
            // 🎯 5. State transfer
            // dp[i] = i. basamağa ulaşmanın minimum cost’u
            dp[i] = Math.min(dp[i - 1] + cost[i], dp[i - 2] + cost[i]);
        }

        /* 🎯 6. Cevap nerede?
           Top’a çıkmak için:
               ya n-1'den gelirsin
               ya n-2'den gelirsin

           👉 Çünkü top’ın cost’u yok!
        */
        return Math.min(dp[n - 1], dp[n - 2]);
    }

    public static int minCostClimbingStairs_optimized(int[] cost) {
        int prev2 = cost[0];
        int prev1 = cost[1];

        for (int i = 2; i < cost.length; i++) {
            int current = Math.min(prev1 + cost[i], prev2 + cost[i]);
            prev2 = prev1;
            prev1 = current;
        }
        return Math.min(prev1, prev2);
    }
}
