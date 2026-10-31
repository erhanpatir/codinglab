package graphs.bfs;

import java.util.*;

public class Q0785_IsGraphBipartite {
    // Öncelik   : 🔵 Trend
    // Şirketler : Apple ✅ (#198)
    //
    // 785. Is Graph Bipartite - Medium
    // https://leetcode.com/problems/is-graph-bipartite/

    /* ------------------------------------------------------------
       | PATTERN: Graph - iki renge boyama (DFS)
       ------------------------------------------------------------
       Her boyanmamış düğümden başlayarak komşuları zıt renge boya.
       Bir komşu zaten aynı renkteyse graf bipartite değildir. Graf bağlı olmayabilir, tüm düğümlerden denenir.
       BFS ile de aynı mantık uygulanır.
    */
    /*  Complexity
        Time  : O(V + E)
        Space : O(V)
    */

    private int[] color;
    private int[][] g;

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        color = new int[n];
        g = graph;
        for (int i = 0; i < n; ++i) {
            if (color[i] == 0 && !dfs(i, 1)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int a, int c) {
        color[a] = c;
        for (int b : g[a]) {
            if (color[b] == c || (color[b] == 0 && !dfs(b, -c))) {
                return false;
            }
        }
        return true;
    }
}
