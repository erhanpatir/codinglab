package dynamicprogramming.subsequence;

public class Q0072_EditDistance {
    // 72. Edit Distance - Medium
    // https://leetcode.com/problems/edit-distance/

    /*  ------------------------------------------------------
        | PATTERN: 2D String DP.                             |
        ------------------------------------------------------
           STATE
           dp[i][j] =
            word1'in ilk i karakterini
            word2'nin ilk j karakterine çevirmek için minimum operation sayısı

           TRANSITION
            Equal chars
                if word1[i-1] == word2[j-1]:
                    dp[i][j] = dp[i-1][j-1]
            Different chars
                else:
                    dp[i][j] = 1 + min(
                        dp[i-1][j-1], // replace
                        dp[i-1][j],   // delete
                        dp[i][j-1]    // insert
                    )
    */
    /* Complexity
        Time  : O(m * n)
        Space : O(m * n)
    */

    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = i; // word1 bos ise
        }

        for (int j = 0; j <= n; j++) {
            dp[0][j] = j; // word2 bos ise
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {

                    dp[i][j] = dp[i - 1][j - 1];

                } else {

                    dp[i][j] = 1 + Math.min(
                            dp[i - 1][j - 1], // replace
                            Math.min(
                                    dp[i - 1][j], // delete
                                    dp[i][j - 1]  // insert
                            )
                    );
                }
            }
        }
        return dp[m][n];
    }
}
