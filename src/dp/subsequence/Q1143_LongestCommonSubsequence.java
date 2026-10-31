package dp.subsequence;

public class Q1143_LongestCommonSubsequence {
    // Öncelik   : ⭐ Gerçek deneyim
    // Şirketler : Apple ✅ (#98)
    // Raporlar  : 1
    //             https://www.vervecopilot.com/blog/apple-leetcode-interview-questions
    //
    // 1143. Longest Common Subsequence - Medium
    // https://leetcode.com/problems/longest-common-subsequence/description/

    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;

                } else {
                    dp[i][j] = Math.max(
                            dp[i - 1][j],
                            dp[i][j - 1]
                    );
                }
            }
        }

        return dp[m][n];
    }
}
