package dp.subsequence;

import java.util.*;

public class Q1216_ValidPalindromeIII {
    // 1216. Valid Palindrome III - Hard
    // https://leetcode.com/problems/valid-palindrome-iii/

    /* ------------------------------------------------------------
       | PATTERN: Subsequence DP (en uzun palindromik alt dizi)
       ------------------------------------------------------------
       f[i][j]: s[i..j] içindeki en uzun palindromik alt dizinin uzunluğu.
       Uçlar eşitse f[i+1][j-1] + 2, değilse max(f[i+1][j], f[i][j-1]).
       En fazla k silme ile palindrom yapılabilir <=> n - f[0][n-1] <= k.
    */
    /*  Complexity
        Time  : O(n^2)
        Space : O(n^2)
    */

    public static boolean isValidPalindrome(String s, int k) {
        int n = s.length();
        int[][] f = new int[n][n];
        for (int i = 0; i < n; ++i) {
            f[i][i] = 1;
        }
        for (int i = n - 2; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                if (s.charAt(i) == s.charAt(j)) {
                    f[i][j] = f[i + 1][j - 1] + 2;
                } else {
                    f[i][j] = Math.max(f[i + 1][j], f[i][j - 1]);
                }
                if (f[i][j] + k >= n) {
                    return true;
                }
            }
        }
        return false;
    }
}
