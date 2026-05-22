package dynamicprogramming.linear;

public class Q0070_ClimbingStairs {
    // 70. Climbing Stairs - Easy
    // https://leetcode.com/problems/climbing-stairs/

    /*
        Pattern 1 — Fibonacci-style 1D DP / linear forward DP
        Ne zaman tanırım?
            Current state, önceki 1-2 state’ten geliyor
            Linear progression var
    */

    // Time : O(n)
    // Space: O(n)
    public static int climbStairs(int n) {
        if (n <= 2) return n;

        int[] dp = new int[n + 1];
        // base case
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            // dp[i] = i. basamağa çıkmanın farklı yolu
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static int climbStairs_optimized(int n) {
        if (n <= 2) return n;

        int prev2 = 1;
        int prev1 = 2;

        for (int i = 3; i <= n; i++) {
            int current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }

        return prev1; // Optimization: only previous two states are needed, so O(1) space
    }
}
