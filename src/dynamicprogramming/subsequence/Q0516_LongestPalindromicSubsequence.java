package dynamicprogramming.subsequence;

public class Q0516_LongestPalindromicSubsequence {
    // 516. Longest Palindromic Subsequence - Medium
    // https://leetcode.com/problems/longest-palindromic-subsequence/

    /*  ------------------------------------------------------
        | PATTERN: Interval DP.                              |
        ------------------------------------------------------
        STATE
         dp[l][r] = s[l...r] aralığındaki en uzun palindromic subsequence uzunluğu
        ------------------------
        Base case
         Tek karakter her zaman palindrome’dur:
         dp[i][i] = 1
        ------------------------
        dp[l][r] represents the longest palindromic subsequence inside substring s[l...r].
        If both ends match, I can use both and add 2 to the inner answer.
        If they don't match, I skip one end and take the better result.
    */
    /* Complexity
        Time  : O(n²)
        Space : O(n²)
    */
    public static int longestPalindromeSubseq(String s) {
        int n = s.length();

        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        for (int length = 2; length <= n; length++) {
            for (int left = 0; left + length - 1 < n; left++) {
                int right = left + length - 1;

                if (s.charAt(left) == s.charAt(right)) {
                    dp[left][right] = dp[left + 1][right - 1] + 2; // b + innerPalindrome + b
                } else {
                    // Hangisi daha iyiyse onu alırız.
                    dp[left][right] = Math.max(
                            dp[left + 1][right], // Solu bırak
                            dp[left][right - 1]  // Sağı bırak
                    );
                }
            }
        }

        return dp[0][n - 1];
        /* Final matrix:
                0 1 2 3 4
                b b b a b
          0 b   1 2 3 3 4
          1 b   . 1 2 2 3
          2 b   . . 1 1 3
          3 a   . . . 1 1
          4 b   . . . . 1
        */

    }
}
