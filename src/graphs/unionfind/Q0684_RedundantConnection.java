package graphs.unionfind;

import java.util.*;

public class Q0684_RedundantConnection {
    // 684. Redundant Connection - Medium
    // https://leetcode.com/problems/redundant-connection/description/

    /* ------------------------------------------------------------
       | PATTERN: Union Find (döngü oluşturan kenar)
       ------------------------------------------------------------
       Kenarları sırayla ekle; bir kenarın iki ucu zaten aynı bileşendeyse bu kenar döngü oluşturur.
       İlk böyle kenar cevaptır (girişte son gelen döngü kenarı).
    */
    /*  Complexity
        Time  : O(n * α(n))
        Space : O(n)
    */

    private int[] p;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        p = new int[n];
        for (int i = 0; i < n; ++i) {
            p[i] = i;
        }
        for (int i = 0;; ++i) {
            int pa = find(edges[i][0] - 1);
            int pb = find(edges[i][1] - 1);
            if (pa == pb) {
                return edges[i];
            }
            p[pa] = pb;
        }
    }

    private int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }
}
