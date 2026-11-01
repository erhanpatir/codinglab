package graphs.bfs;

import java.util.*;

public class Q0994_RottingOranges {
    // Öncelik   : 🟡 Orta  ·  🌍 Ortak soru
    // Şirketler : Google ✅ (#85), Amazon ✅ (#21), Bloomberg ✅ (#99)
    //
    // 994. Rotting Oranges - Medium
    // https://leetcode.com/problems/rotting-oranges/

    /* ------------------------------------------------------------
       | PATTERN: Graph BFS - Multi-source
       ------------------------------------------------------------
       Tüm çürük portakalları aynı anda kuyruğa koy (çok kaynaklı BFS) ve taze portakalları say.
       Her BFS seviyesi bir dakikadır; komşu tazeler çürür ve sayaç azalır.
       Sonunda taze kalırsa -1, kalmazsa geçen dakika sayısı.
    */
    /*  Complexity
        Time  : O(m * n)
        Space : O(m * n)
    */

    public static int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Deque<int[]> q = new ArrayDeque<>();
        int cnt = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    ++cnt;
                } else if (grid[i][j] == 2) {
                    q.offer(new int[] {i, j});
                }
            }
        }
        final int[] dirs = {-1, 0, 1, 0, -1};
        for (int ans = 1; !q.isEmpty() && cnt > 0; ++ans) {
            for (int k = q.size(); k > 0; --k) {
                var p = q.poll();
                for (int d = 0; d < 4; ++d) {
                    int x = p[0] + dirs[d], y = p[1] + dirs[d + 1];
                    if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        q.offer(new int[] {x, y});
                        if (--cnt == 0) {
                            return ans;
                        }
                    }
                }
            }
        }
        return cnt > 0 ? -1 : 0;
    }
}
