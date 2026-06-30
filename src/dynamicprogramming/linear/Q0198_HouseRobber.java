package dynamicprogramming.linear;

public class Q0198_HouseRobber {
    // 198. House Robber - Medium
    // https://leetcode.com/problems/house-robber/

    /* 🧠 1. Pattern tanıma

        Kendine sor:
            lineer mi? ✅
            önceki state’lere mi bakıyorum? ✅
            “seç / seçme” var mı? ✅

        👉 Cevap: 1D DP + decision (choose / skip)
    */

    public static int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) return nums[0];

        // dp max. kazanci tutar
        int[] dp = new int[n];
        // base case
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            // dp[i] = i’ye kadar max/min sonuç
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]); // 👉 Bu = “choose vs skip” pattern
        }

        return dp[n - 1];
    }

    public static int rob_optimized(int[] nums) {
        int prev2 = 0;
        int prev1 = 0;

        for (int num : nums) {
            int current = Math.max(prev1, prev2 + num);
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }
}
