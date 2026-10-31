package graphs.dfs;

import java.util.*;

public class Q0733_FloodFill {
    // 733. Flood Fill - Easy
    // https://leetcode.com/problems/flood-fill/

    /* ------------------------------------------------------------
       | PATTERN: Graph DFS (Flood Fill)
       ------------------------------------------------------------
       Başlangıç rengi zaten yeni renkse hiçbir şey yapma (sonsuz döngüyü de önler).
       Değilse başlangıçtan DFS ile aynı orijinal renkteki 4 komşulara yay ve rengi değiştir.
    */
    /*  Complexity
        Time  : O(m * n)
        Space : O(m * n)
    */

    private int[][] image;
    private int oc;
    private int color;
    private final int[] dirs = {-1, 0, 1, 0, -1};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        oc = image[sr][sc];
        if (oc == color) {
            return image;
        }
        this.image = image;
        this.color = color;
        dfs(sr, sc);
        return image;
    }

    private void dfs(int i, int j) {
        image[i][j] = color;
        for (int k = 0; k < 4; ++k) {
            int x = i + dirs[k], y = j + dirs[k + 1];
            if (x >= 0 && x < image.length && y >= 0 && y < image[0].length && image[x][y] == oc) {
                dfs(x, y);
            }
        }
    }
}
