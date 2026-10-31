package graphs.shortestpath;

import java.util.*;

public class Q1631_PathWithMinimumEffort {
    // 1631. Path With Minimum Effort - Medium
    // https://leetcode.com/problems/path-with-minimum-effort/description/

    /* ------------------------------------------------------------
       | PATTERN: Shortest Path - Dijkstra (minimax)
       ------------------------------------------------------------
       Yolun eforu, ardışık hücreler arasındaki en büyük fark. Min-heap'te (efor, hücre) tut.
       Komşuya geçiş eforu = max(mevcut efor, |yükseklik farkı|); daha iyi değer bulunursa güncelle ve heap'e ekle.
       Hedef hücre heap'ten ilk çekildiğinde cevap kesinleşir. Alternatif: binary search + BFS.
    */
    /*  Complexity
        Time  : O(m * n * log(m * n))
        Space : O(m * n)
    */

    public static int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        int[][] effort = new int[m][n];
        for (int[] row : effort) Arrays.fill(row, Integer.MAX_VALUE);
        effort[0][0] = 0;
        // {şu ana kadarki efor, satır, sütun}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[]{0, 0, 0});
        int[] dirs = {-1, 0, 1, 0, -1};
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int e = cur[0], r = cur[1], c = cur[2];
            if (e > effort[r][c]) continue; // eskimiş kayıt
            if (r == m - 1 && c == n - 1) return e;
            for (int d = 0; d < 4; d++) {
                int nr = r + dirs[d], nc = c + dirs[d + 1];
                if (nr < 0 || nc < 0 || nr >= m || nc >= n) continue;
                int next = Math.max(e, Math.abs(heights[nr][nc] - heights[r][c]));
                if (next < effort[nr][nc]) {
                    effort[nr][nc] = next;
                    pq.offer(new int[]{next, nr, nc});
                }
            }
        }
        return 0;
    }
}
