package graphs.dfs;

import java.util.*;

public class Q0323_NumberOfConnectedComponentsInAnUndirectedGraph {
    // 323. Number of Connected Components in an Undirected Graph - Medium
    // https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/

    /* ------------------------------------------------------------
       | PATTERN: Graph DFS - bileşen sayma
       ------------------------------------------------------------
       Kenarlardan adjacency list oluştur. Ziyaret edilmemiş her düğümden DFS başlat;
       her yeni başlangıç yeni bir bağlı bileşen demektir. Union Find ile de çözülebilir.
    */
    /*  Complexity
        Time  : O(n + m)
        Space : O(n + m)
    */

    private List<Integer>[] g;
    private boolean[] vis;

    public int countComponents(int n, int[][] edges) {
        g = new List[n];
        vis = new boolean[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (var e : edges) {
            int a = e[0], b = e[1];
            g[a].add(b);
            g[b].add(a);
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans += dfs(i);
        }
        return ans;
    }

    private int dfs(int i) {
        if (vis[i]) {
            return 0;
        }
        vis[i] = true;
        for (int j : g[i]) {
            dfs(j);
        }
        return 1;
    }
}
