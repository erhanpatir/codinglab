package dp.subsequence;

import java.util.*;

public class Q0583_DeleteOperationForTwoStrings {
    // 583. Delete Operation for Two Strings - Medium
    // https://leetcode.com/problems/delete-operation-for-two-strings/description/

    /* ------------------------------------------------------------
       | PATTERN: Subsequence DP (edit distance benzeri)
       ------------------------------------------------------------
       f[i][j]: word1'in ilk i ve word2'nin ilk j karakterini eşit yapmak için gereken silme sayısı.
       Karakterler eşitse f[i-1][j-1], değilse 1 + min(f[i-1][j], f[i][j-1]).
       Alternatif: m + n - 2 * LCS.
    */
    /*  Complexity
        Time  : O(m * n)
        Space : O(m * n)
    */

    public static int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] f = new int[m + 1][n + 1];
        for (int i = 0; i <= m; ++i) {
            f[i][0] = i;
        }
        for (int j = 0; j <= n; ++j) {
            f[0][j] = j;
        }
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                char a = word1.charAt(i - 1);
                char b = word2.charAt(j - 1);
                if (a == b) {
                    f[i][j] = f[i - 1][j - 1];
                } else {
                    f[i][j] = Math.min(f[i - 1][j], f[i][j - 1]) + 1;
                }
            }
        }
        return f[m][n];
    }
}
