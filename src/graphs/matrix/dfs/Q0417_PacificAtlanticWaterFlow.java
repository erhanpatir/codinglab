package graphs.matrix.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Q0417_PacificAtlanticWaterFlow {
    // 417. Pacific Atlantic Water Flow - Medium
    // https://leetcode.com/problems/pacific-atlantic-water-flow/

    /*
     * Instead of checking from every cell whether water can reach an ocean,
     * we reverse the flow and start from the oceans.
     * Then we find cells reachable from Pacific and Atlantic separately,
     * and take their intersection.
     */

    // Time: O(m * n)
    // Space: O(m * n)

    private static final int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for (int c = 0; c < n; c++) {
            dfs(heights, 0, c, pacific); // up
            dfs(heights, m - 1, c, atlantic); // down
        }

        for (int r = 0; r < m; r++) {
            dfs(heights, r, 0, pacific); // left
            dfs(heights, r, n - 1, atlantic); // right
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    result.add(List.of(r, c));
                }
            }
        }

        return result;
    }

    private static void dfs(int[][] heights, int r, int c, boolean[][] visited) {
        int m = heights.length;
        int n = heights[0].length;

        if(visited[r][c]) return;

        visited[r][c] = true;

        for (int[] dir : DIRS) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            if (nr < 0 || nc < 0 || nr >= m || nc >= n) continue;

            if (visited[nr][nc]) continue;

            if (heights[nr][nc] < heights[r][c]) continue;

            dfs(heights, nr, nc, visited);
        }
    }

    private static void bfs(int[][] heights, boolean[][] visited, Queue<int[]> queue) {
        int m = heights.length;
        int n = heights[0].length;

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0];
            int c = cell[1];

            for (int[] dir : DIRS) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr < 0 || nc < 0 || nr >= m || nc >= n) {
                    continue;
                }

                if (visited[nr][nc]) {
                    continue;
                }

                if (heights[nr][nc] < heights[r][c]) {
                    continue;
                }

                visited[nr][nc] = true;
                queue.offer(new int[]{nr, nc});
            }
        }
    }

    private static void add(int r, int c, boolean[][] visited, Queue<int[]> queue) {
        if (!visited[r][c]) {
            visited[r][c] = true;
            queue.offer(new int[]{r, c});
        }
    }
}
