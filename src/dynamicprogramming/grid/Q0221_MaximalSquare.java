package dynamicprogramming.grid;

public class Q0221_MaximalSquare {
    // 221. Maximal Square - Medium
    // https://leetcode.com/problems/maximal-square/
    // Pattern: Grid 2D DP + Shape DP

    /*
        Time: O(m * n)
            Her hücreyi bir kere geziyoruz.
        Space: O(m * n)
            DP tablosu tutuyoruz.
    */
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] dp = new int[rows + 1][cols + 1]; // boylece boundary check yapmayiz.
        // dp[i][j] = sağ-alt köşesi (i,j) olan en büyük karenin kenar uzunluğu

        int maxSide = 0;

        for (int row = 1; row <= rows; row++) {
            for (int col = 1; col <= cols; col++) {

                if (matrix[row - 1][col - 1] == '1') {
                    dp[row][col] = 1 + Math.min(
                            dp[row - 1][col],             // ust
                            Math.min(
                                    dp[row][col - 1],     // sol
                                    dp[row - 1][col - 1]  // sol ust
                            )
                    );

                    maxSide = Math.max(maxSide, dp[row][col]);
                }
            }
        }

        return maxSide * maxSide;
    }
}
