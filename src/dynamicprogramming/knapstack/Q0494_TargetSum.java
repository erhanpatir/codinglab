package dynamicprogramming.knapstack;

public class Q0494_TargetSum {
    // 494. Target Sum - Medium
    // https://leetcode.com/problems/target-sum/

    /*  --------------------------------------------------------
        | PATTERN: 0/1 Knapsack + Count Combinations           |
        --------------------------------------------------------
        State:
            dp[s] = s kaç farklı şekilde yapılabilir?

        Transition
        Her num için:
            dp[s] += dp[s - num]

        Anlamı:
            s toplamını yapmak için num’u kullanırsam, daha önce s - num yapılmış olmalı.
    */

    // Time: O(N * S)
    // Space: O(S)
    public static int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        if (Math.abs(target) > totalSum) return 0;

        int transformed = target + totalSum;

        if (transformed % 2 != 0) return 0;

        int targetSum = transformed / 2;

        int[] dp = new int[targetSum + 1];
        dp[0] = 1; // base case

        for (int num : nums) {
            for (int s = targetSum; s>= num; s--) {
                // s toplamını yapmak için num’u kullanırsam, daha önce s - num yapılmış olmalı.
                dp[s] += dp[s - num];
            }
        }
        return dp[targetSum]; // s kaç farklı şekilde yapılabilir?
    }

    /* Dry run
        nums = [1,1,1,1,1]
        target = 3
        subsetTarget = 4

       Başlangıç:

        dp = [1,0,0,0,0]

        Her 1 geldiğinde subset sayıları artar:

        1 sonrası:
        [1,1,0,0,0]
        1 sonrası:
        [1,2,1,0,0]
        1 sonrası:
        [1,3,3,1,0]
        1 sonrası:
        [1,4,6,4,1]
        1 sonrası:
        [1,5,10,10,5]

        Cevap:

        dp[4] = 5
    */
}
