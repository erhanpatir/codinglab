package dynamicprogramming.lis;

import java.util.Arrays;

public class Q0300_LongestIncreasingSubsequence {
    // 300. Longest Increasing Subsequence - Medium
    // https://leetcode.com/problems/longest-increasing-subsequence/

    /*  ------------------------------------------------------
        | PATTERN: Sequence DP                               |
        ------------------------------------------------------
        Her index için şu soruyu sor:
            “Bu index’te biten en uzun increasing subsequence kaç?”

        State:
            dp[i] = i index’inde biten LIS uzunluğu
            Örnek:
                dp[5] demek, nums[5] elemanı ile biten en uzun increasing subsequence

        Transition
            if nums[j] < nums[i]:
                dp[i] = max(dp[i], dp[j] + 1)
    */
    /* Complexity
        Time
        İki loop var:
            O(n²)
        Space
            O(n)
    */

    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int answer = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) { // extend ediliyor 0'dan i'ye
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1); // i index’inde biten LIS uzunluğu
                }
            }
            answer = Math.max(answer, dp[i]);
        }

        return answer;
    }
}
