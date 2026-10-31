package graphs.shortestpath;

import java.util.*;

public class Q0778_SwimInRisingWater {
    // Öncelik   : ⭐ Gerçek deneyim
    // Şirketler : Amazon (#508)
    // Seviye    : Mid
    // Raporlar  : 1
    //             https://leetcode.com/discuss/post/7646418/
    //
    // 778. Swim in Rising Water - Hard
    // https://leetcode.com/problems/swim-in-rising-water/description/

    /* ------------------------------------------------------------
       | PATTERN: Shortest Path - Dijkstra (minimax yol)
       ------------------------------------------------------------
       Yolun maliyeti, üzerindeki en yüksek seviye. Min-heap'te (o ana kadarki en yüksek seviye, hücre) tut.
       Heap'ten en düşük maliyetli hücreyi çek; komşuya geçiş maliyeti max(mevcut, komşu yüksekliği).
       Hedef ilk kez çekildiğinde cevap kesinleşmiştir.
    */
    /*  Complexity
        Time  : O(n^2 log n)
        Space : O(n^2)
    */

    public static int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] seen = new boolean[n][n];
        // {o ana kadar yolda görülen en yüksek seviye, satır, sütun}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[]{grid[0][0], 0, 0});
        seen[0][0] = true;
        int[] dirs = {-1, 0, 1, 0, -1};
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int t = cur[0], r = cur[1], c = cur[2];
            if (r == n - 1 && c == n - 1) return t;
            for (int d = 0; d < 4; d++) {
                int nr = r + dirs[d], nc = c + dirs[d + 1];
                if (nr < 0 || nc < 0 || nr >= n || nc >= n || seen[nr][nc]) continue;
                seen[nr][nc] = true;
                pq.offer(new int[]{Math.max(t, grid[nr][nc]), nr, nc});
            }
        }
        return -1;
    }
}
