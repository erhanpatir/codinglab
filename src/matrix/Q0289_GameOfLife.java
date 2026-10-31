package matrix;

import java.util.*;

public class Q0289_GameOfLife {
    // 289. Game of Life - Medium
    // https://leetcode.com/problems/game-of-life/

    /* ------------------------------------------------------------
       | PATTERN: Matrix - in-place durum kodlama
       ------------------------------------------------------------
       Aynı anda güncelleme için ara durumlar kullan: 2 = canlıydı ölecek, -1 = ölüydü canlanacak.
       Komşu sayarken > 0 olanlar orijinalde canlıdır. İkinci geçişte 2 -> 0, -1 -> 1 yap.
    */
    /*  Complexity
        Time  : O(m * n)
        Space : O(1)
    */

    public static void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int live = -board[i][j];
                for (int x = i - 1; x <= i + 1; ++x) {
                    for (int y = j - 1; y <= j + 1; ++y) {
                        if (x >= 0 && x < m && y >= 0 && y < n && board[x][y] > 0) {
                            ++live;
                        }
                    }
                }
                if (board[i][j] == 1 && (live < 2 || live > 3)) {
                    board[i][j] = 2;
                }
                if (board[i][j] == 0 && live == 3) {
                    board[i][j] = -1;
                }
            }
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] == 2) {
                    board[i][j] = 0;
                } else if (board[i][j] == -1) {
                    board[i][j] = 1;
                }
            }
        }
    }
}
