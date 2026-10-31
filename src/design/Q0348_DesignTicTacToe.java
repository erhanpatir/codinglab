package design;

import java.util.*;

public class Q0348_DesignTicTacToe {
    // 348. Design Tic-Tac-Toe - Medium
    // https://leetcode.com/problems/design-tic-tac-toe/

    /* ------------------------------------------------------------
       | PATTERN: Design - Counting (satır/sütun/çapraz sayaçları)
       ------------------------------------------------------------
       Her oyuncu için her satır, her sütun ve iki çapraz için sayaç tut.
       Hamle yapıldığında ilgili sayaçları artır; herhangi biri n'ye ulaşırsa o oyuncu kazanır.
       Tahtayı taramaya gerek kalmaz. Wise'ın NxN ve "wincount" varyasyonunda ise
       son hamleden dört yönde ardışık işaret sayılır.
    */
    /*  Complexity
        Time  : O(1) her hamle
        Space : O(n)
    */

    public class TicTacToe {
        private int n;
        private int[][] cnt;

        public TicTacToe(int n) {
            this.n = n;
            cnt = new int[2][(n << 1) + 2];
        }

        public int move(int row, int col, int player) {
            int[] cur = cnt[player - 1];
            ++cur[row];
            ++cur[n + col];
            if (row == col) {
                ++cur[n << 1];
            }
            if (row + col == n - 1) {
                ++cur[n << 1 | 1];
            }
            if (cur[row] == n || cur[n + col] == n || cur[n << 1] == n || cur[n << 1 | 1] == n) {
                return player;
            }
            return 0;
        }
    }
}
