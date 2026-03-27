package graphs.matrix.bfs;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Q1091_ShortestPathInBinaryMatrix {
    // 1091. Shortest Path in Binary Matrix - Medium
    // https://leetcode.com/problems/shortest-path-in-binary-matrix/

    private static final int[][] DIRS = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1},
            {1, 1}, {1, -1}, {-1, 1}, {-1, -1}
    };

    // Time: O(m * n)
    // Space: O(m * n) - bfs icin standart maliyet
    // unweighted shortest path → BFS
    public static int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0, 1});
        grid[0][0] = 1; // visited

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];
            int dist = current[2];

            if (r == n - 1 && c == n - 1) return dist;

            for (int[] dir : DIRS) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr < 0 || nc < 0 || nr >= n || nc >= n) continue;
                if (grid[nr][nc] != 0) continue;

                grid[nr][nc] = 1; // mark visited when enqueuing
                queue.offer(new int[]{nr, nc, dist + 1});
            }
        }

        return -1;
    }
}