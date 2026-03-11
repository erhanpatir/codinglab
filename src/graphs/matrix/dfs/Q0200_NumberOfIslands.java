package graphs.matrix.dfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Q0200_NumberOfIslands {
    // 200. Number of Islands - Medium
    // https://leetcode.com/problems/number-of-islands/

    // PATTERN — DFS Flood Fill / Connected Components

    /*  Flood fill
        visit cell
        mark visited (infinite loop olur unutursan)
        explore 4 neighbors
     */

    // Time:  O(m * n)
    // Space: O(m*n) worst case recursion
    public static int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int islands = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                if (grid[r][c] == '1') {
                    islands++;       // 1'i gorunce bir ada buldum diyoruz.
                    dfs_recursive(grid, r, c); // 4 bir yanini ziyaret ederek 0 olarak isaretliyoruz.
                }
            }
        }
        return islands;
    }

    private static void dfs_recursive(char[][] grid, int r, int c) {

        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length)
            return;

        if (grid[r][c] == '0')
            return;

        grid[r][c] = '0';  // We mutate the grid to mark visited nodes.

        dfs_recursive(grid, r + 1, c);
        dfs_recursive(grid, r - 1, c);
        dfs_recursive(grid, r, c + 1);
        dfs_recursive(grid, r, c - 1);
    }

    private static void dfs_iteraive(char[][] grid, int r, int c) {
        int m = grid.length;
        int n = grid[0].length;

        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{r, c});

        while (!stack.isEmpty()) {

            int[] cell = stack.pop();
            int row = cell[0];
            int col = cell[1];

            if (row < 0 || col < 0 || row >= m || col >= n || grid[row][col] == '0')
                continue;

            grid[row][col] = '0';

            stack.push(new int[]{row + 1, col});
            stack.push(new int[]{row - 1, col});
            stack.push(new int[]{row, col + 1});
            stack.push(new int[]{row, col - 1});
        }
    }

    //Time: O(m*n)
    //Space: O(m*n)
    private static void bfs_iterative(char[][] grid, int r, int c) {

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c});

        grid[r][c] = '0';

        int[][] dirs = {
                {1, 0}, {-1, 0}, {0, 1}, {0, -1} // dort yone
        };

        while (!q.isEmpty()) {

            int[] cell = q.poll();

            for (int[] d : dirs) {

                int nr = cell[0] + d[0]; // uzerine ekle
                int nc = cell[1] + d[1]; // uzerine ekle

                if (nr < 0 || nc < 0 ||
                        nr >= grid.length ||
                        nc >= grid[0].length)
                    continue;

                if (grid[nr][nc] == '1') {

                    grid[nr][nc] = '0';
                    q.add(new int[]{nr, nc});

                }
            }
        }
    }
}
