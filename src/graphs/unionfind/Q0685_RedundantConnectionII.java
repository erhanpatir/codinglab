package graphs.unionfind;

import java.util.*;

public class Q0685_RedundantConnectionII {
    // 685. Redundant Connection II - Hard
    // https://leetcode.com/problems/redundant-connection-ii/description/

    /* ------------------------------------------------------------
       | PATTERN: Union Find + giriş derecesi (yönlü)
       ------------------------------------------------------------
       İki durum: bir düğümün iki ebeveyni var (indegree 2) ya da döngü var.
       İki ebeveyn varsa o iki kenardan sonrakini çıkar, kalanında döngü yoksa cevap budur, varsa önceki kenar.
       İki ebeveyn yoksa döngüyü oluşturan kenarı Union Find ile bul.
    */
    /*  Complexity
        Time  : O(n * α(n))
        Space : O(n)
    */

    private int[] p;

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] ind = new int[n];
        for (var e : edges) {
            ++ind[e[1] - 1];
        }
        List<Integer> dup = new ArrayList<>();
        p = new int[n];
        for (int i = 0; i < n; ++i) {
            if (ind[edges[i][1] - 1] == 2) {
                dup.add(i);
            }
            p[i] = i;
        }
        if (!dup.isEmpty()) {
            for (int i = 0; i < n; ++i) {
                if (i == dup.get(1)) {
                    continue;
                }
                int pu = find(edges[i][0] - 1);
                int pv = find(edges[i][1] - 1);
                if (pu == pv) {
                    return edges[dup.get(0)];
                }
                p[pu] = pv;
            }
            return edges[dup.get(1)];
        }
        for (int i = 0;; ++i) {
            int pu = find(edges[i][0] - 1);
            int pv = find(edges[i][1] - 1);
            if (pu == pv) {
                return edges[i];
            }
            p[pu] = pv;
        }
    }

    private int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }
}
