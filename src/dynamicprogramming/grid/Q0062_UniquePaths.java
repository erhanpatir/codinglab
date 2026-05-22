package dynamicprogramming.grid;

import java.util.Arrays;

public class Q0062_UniquePaths {
    // 62. Unique Paths - Medium
    // https://leetcode.com/problems/unique-paths/
    // Pattern: 2D Grid DP + Count Paths

    // Time Complexity:  O(m * n)
    // Space Complexity: O(m * n)
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        // base case
        for (int row = 0; row < m; row++) {
            dp[row][0] = 1;    // rows
        }

        for (int col = 0; col < n; col++) {
            dp[0][col] = 1;    // columns
        }

        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                // transition
                dp[row][col] = dp[row - 1][col] + dp[row][col - 1];
            }
        }

        // answer
        return dp[m - 1][n - 1];
    }

    // Time Complexity:  O(m * n)
    // Space Complexity: O(n)
    public int uniquePaths_optimized(int m, int n) {
        int[] dp = new int[n];

        Arrays.fill(dp, 1);

        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                dp[col] = dp[col] + dp[col - 1];
            }
        }

        return dp[n - 1];
    }
}

/* 7. Dry run

        m = 3, n = 3

        Başlangıç:

        1 1 1
        1 ? ?
        1 ? ?

        Hesaplama:

            dp[1][1] = dp[0][1] + dp[1][0] = 1 + 1 = 2
            dp[1][2] = dp[0][2] + dp[1][1] = 1 + 2 = 3
            dp[2][1] = dp[1][1] + dp[2][0] = 2 + 1 = 3
            dp[2][2] = dp[1][2] + dp[2][1] = 3 + 3 = 6

        Final tablo:

            1 1 1
            1 2 3
            1 3 6
*/