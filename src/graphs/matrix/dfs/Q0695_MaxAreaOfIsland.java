package graphs.matrix.dfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Q0695_MaxAreaOfIsland {
    // 695. Max Area of Island - Medium
    // https://leetcode.com/problems/max-area-of-island/

    // Time: O(m * n)
    // Space: O(m * n)
    public static int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxArea = 0;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, r, c));
                }
            }
        }

        return maxArea;
    }

    private static int dfs(int[][] grid, int r, int c) {
        int m = grid.length;
        int n = grid[0].length;

        if (r < 0 || c < 0 || r >= m || c >= n || grid[r][c] == 0) {
            return 0;
        }

        grid[r][c] = 0;

        return 1
                + dfs(grid, r + 1, c)
                + dfs(grid, r - 1, c)
                + dfs(grid, r, c + 1)
                + dfs(grid, r, c - 1);
    }

    private int dfs_iterative(int[][] grid, int r, int c) {
        int area = 0;

        Stack<int[]> stack = new Stack<>();
        stack.push(new int[] {r, c});

        while (!stack.isEmpty()) {
            int[] cell = stack.pop();

            int row = cell[0];
            int col = cell[1];

            if (row < 0 || col < 0
                    || row >= grid.length || col >= grid[0].length
                    || grid[row][col] == 0) continue;

            grid[row][col] = 0;
            area++;

            stack.push(new int[] {row, col + 1});
            stack.push(new int[] {row, col - 1});
            stack.push(new int[] {row + 1, col});
            stack.push(new int[] {row - 1, col});
        }
        return area;
    }

    private int bfs_iterative(int[][] grid, int r, int c) {
        int m = grid.length;
        int n = grid[0].length;
        int area = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c});
        grid[r][c] = 0;

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            area++;

            for (int[] dir : dirs) {
                int nr = cell[0] + dir[0];
                int nc = cell[1] + dir[1];

                if (nr >= 0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] == 1) {
                    grid[nr][nc] = 0;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
        return area;
    }
}
