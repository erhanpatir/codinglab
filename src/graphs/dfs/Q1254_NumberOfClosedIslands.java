package graphs.dfs;

import java.util.*;

public class Q1254_NumberOfClosedIslands {
    // 1254. Number of Closed Islands - Medium
    // https://leetcode.com/problems/number-of-closed-islands/

    /* ------------------------------------------------------------
       | PATTERN: Graph DFS (sınıra değmeyen adalar)
       ------------------------------------------------------------
       Her 0 (kara) hücresinden DFS başlat ve adayı işaretle. DFS sırasında grid sınırına ulaşılırsa ada kapalı değildir.
       Tüm komşular gezilmeye devam edilir (erken çıkış yok, aksi halde ada yarım işaretlenir).
       Kapalı adaları say. Alternatif: önce sınıra değen adaları silmek.
    */
    /*  Complexity
        Time  : O(m * n)
        Space : O(m * n)
    */

    private int m;
    private int n;
    private int[][] grid;

    public int closedIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        int ans = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 0) {
                    ans += dfs(i, j);
                }
            }
        }
        return ans;
    }

    private int dfs(int i, int j) {
        int res = i > 0 && i < m - 1 && j > 0 && j < n - 1 ? 1 : 0;
        grid[i][j] = 1;
        int[] dirs = {-1, 0, 1, 0, -1};
        for (int k = 0; k < 4; ++k) {
            int x = i + dirs[k], y = j + dirs[k + 1];
            if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 0) {
                res &= dfs(x, y);
            }
        }
        return res;
    }
}
