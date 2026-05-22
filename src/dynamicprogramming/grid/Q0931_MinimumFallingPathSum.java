package dynamicprogramming.grid;

public class Q0931_MinimumFallingPathSum {
    // 931. Minimum Falling Path Sum - Medium
    // https://leetcode.com/problems/minimum-falling-path-sum/
    // Pattern: 2D Grid DP + Min Path Sum

    /*
       Time: O(n²)
        Her hücreyi bir kere hesaplıyoruz.
       Space: O(n²)
        DP tablosu tutuyoruz.
    */
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        int[][] dp = new int[n][n];

        for (int col = 0; col < n; col++) {
            dp[0][col] = matrix[0][col]; // base case
        }

        for (int row = 1; row < n; row++) {
            for (int col = 0; col < n; col++) {
                int bestPrevious = dp[row - 1][col];

                if (col > 0) { // ilk column degilse, bir oncesi vardir.
                    bestPrevious = Math.min(bestPrevious, dp[row - 1][col - 1]);
                }

                if (col < n - 1) { // son column degilse bir sonrasi vardir.
                    bestPrevious = Math.min(bestPrevious, dp[row - 1][col + 1]);
                }

                dp[row][col] = matrix[row][col] + bestPrevious;
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int col = 0; col < n; col++) {
            answer = Math.min(answer, dp[n - 1][col]);
        }

        return answer;
    }

    /* Dry run
        matrix =
            [
              [2, 1, 3],
              [6, 5, 4],
              [7, 8, 9]
            ]

        Base:

        dp first row:
            [2, 1, 3]

        Row 1:
            dp[1][0] = 6 + min(2, 1) = 7
            dp[1][1] = 5 + min(2, 1, 3) = 6
            dp[1][2] = 4 + min(1, 3) = 5

        Row 2:
            dp[2][0] = 7 + min(7, 6) = 13
            dp[2][1] = 8 + min(7, 6, 5) = 13
            dp[2][2] = 9 + min(6, 5) = 14

        Final DP:
            [
              [2, 1, 3],
              [7, 6, 5],
              [13, 13, 14]
            ]

        Cevap: 13
    */
}
