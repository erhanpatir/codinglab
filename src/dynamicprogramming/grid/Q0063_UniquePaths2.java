package dynamicprogramming.grid;

public class Q0063_UniquePaths2 {
    // 63. Unique Paths II - Medium
    // https://leetcode.com/problems/unique-paths-ii/
    // PATTERN: Grid DP + Count Paths + Obstacles

    // Time: O(m * n)
    // Space: O(m * n)
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;

        if (obstacleGrid[0][0] == 1) {
            return 0; // Başlangıç hücresi obstacle ise
        }

        int[][] dp = new int[rows][cols];
        dp[0][0] = 1;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (obstacleGrid[row][col] == 1) {
                    dp[row][col] = 0; // obstacle ise oraya ulasamazsin.
                    continue;
                }

                if (row == 0 && col == 0) {
                    continue;
                }

                int fromTop = row > 0 ? dp[row - 1][col] : 0;
                int fromLeft = col > 0 ? dp[row][col - 1] : 0;

                dp[row][col] = fromTop + fromLeft;
            }
        }

        return dp[rows - 1][cols - 1];
    }

    // Time: O(m * n)
    // Space: O(n)
    public int uniquePathsWithObstacles_1D(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;

        int[] dp = new int[cols];
        dp[0] = obstacleGrid[0][0] == 1 ? 0 : 1;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (obstacleGrid[row][col] == 1) {
                    dp[col] = 0;
                } else if (col > 0) {
                    dp[col] = dp[col] + dp[col - 1];
                }
            }
        }

        return dp[cols - 1];
    }

    /*
        Dry run
            grid =
            [
              [0, 0, 0],
              [0, 1, 0],
              [0, 0, 0]
            ]

        Başlangıç:
            dp[0][0] = 1

        Hesaplama:
            [1, 1, 1]
            [1, 0, 1]
            [1, 1, 2]

        Cevap: 2
            Obstacle olan orta hücre 0 olur, çünkü oradan yol geçemez.
    */
}
