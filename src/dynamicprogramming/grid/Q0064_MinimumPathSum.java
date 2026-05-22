package dynamicprogramming.grid;

public class Q0064_MinimumPathSum {
    // 64. Minimum Path Sum - Medium
    // https://leetcode.com/problems/minimum-path-sum/
    // Pattern: 2D Grid DP + Min Path Sum

    //  Time Complexity: O(m * n)
    //  Space Complexity: O(m * n)
    public static int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] dp = new int[rows][cols];

        dp[0][0] = grid[0][0];

        for (int col = 1; col < cols; col++) {
            // cumulative sum from left
            dp[0][col] = dp[0][col - 1] + grid[0][col]; // left 👉 right
        }

        for (int row = 1; row < rows; row++) {
            // cumulative sum from top
            dp[row][0] = dp[row - 1][0] + grid[row][0]; // top 👉 down
        }

        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                dp[row][col] = grid[row][col] + Math.min(dp[row - 1][col], dp[row][col - 1]);
            }
        }
        return dp[rows - 1][ cols - 1];
    }

    // Time: O(m * n)
    // Space: O(n)
    public int minPathSum_optimized(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[] dp = new int[cols];

        dp[0] = grid[0][0];

        for (int col = 1; col < cols; col++) {
            dp[col] = dp[col - 1] + grid[0][col];
        }

        for (int row = 1; row < rows; row++) {
            dp[0] = dp[0] + grid[row][0];

            for (int col = 1; col < cols; col++) {
                dp[col] = grid[row][col] + Math.min(
                        dp[col],      // üstten gelen
                        dp[col - 1]   // soldan gelen
                );
            }
        }
        return dp[cols - 1];
    }

    /*
        Dry run
        grid =
            [
              [1, 3, 1],
              [1, 5, 1],
              [4, 2, 1]
            ]

        Başlangıç:
            dp[0][0] = 1

        İlk satır:
            1 4 5

        İlk sütun:
            1
            2
            6

        Ara hücreler:
            dp[1][1] = 5 + min(4, 2) = 7
            dp[1][2] = 1 + min(5, 7) = 6
            dp[2][1] = 2 + min(7, 6) = 8
            dp[2][2] = 1 + min(6, 8) = 7

        Final DP:
            [
              [1, 4, 5],
              [2, 7, 6],
              [6, 8, 7]
            ]

        Cevap: 7
     */
}
