package graphs.matrix.dfs;

public class Q0130_SurroundedRegions {
    // 130. Surrounded Regions - Medium
    // https://leetcode.com/problems/surrounded-regions/

    /*Core Insight (en önemli fikir)
        Naive düşünce:
            her O'dan DFS
            border'a ulaşıyor mu kontrol et

            Bu çok pahalı.

        Doğru düşünce:
            border'daki O'lar güvenlidir

        Yani:
            border'dan DFS/BFS yap
            ulaşılabilen tüm O'ları işaretle

        Sonra:
            geri kalan O'lar çevrilir
            Bu Pacific Atlantic ile aynı düşünce.
     */

    // Time: O(m * n)
    // Space: O(m * n). //Her hücre en fazla bir kere ziyaret edilir.
    public static void solve(char[][] board) {

        int m = board.length;
        int n = board[0].length;

        // border traversal
        for (int r = 0; r < m; r++) {
            dfs(board, r, 0); // top to down (left edge)
            dfs(board, r, n - 1); // top to down (right edge)
        }

        for (int c = 0; c < n; c++) {
            dfs(board, 0, c); // left to right (top edge)
            dfs(board, m - 1, c); // left to right (bottom edge)
        }

        // flip cells
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {

                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                }

                if (board[r][c] == 'T') {
                    board[r][c] = 'O';
                }
            }
        }
    }

    private static void dfs(char[][] board, int r, int c) {

        int m = board.length;
        int n = board[0].length;

        if (r < 0 || c < 0 || r >= m || c >= n || board[r][c] != 'O') {
            return;
        }

        board[r][c] = 'T';

        dfs(board, r + 1, c);
        dfs(board, r - 1, c);
        dfs(board, r, c + 1);
        dfs(board, r, c - 1);
    }
}
