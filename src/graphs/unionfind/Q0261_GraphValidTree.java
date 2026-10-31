package graphs.unionfind;

import java.util.*;

public class Q0261_GraphValidTree {
    // 261. Graph Valid Tree - Medium
    // https://leetcode.com/problems/graph-valid-tree/

    /* ------------------------------------------------------------
       | PATTERN: Union Find
       ------------------------------------------------------------
       Ağaç olmak için döngü olmamalı ve tüm düğümler bağlı olmalı.
       Her kenarda iki ucun root'unu bul; aynıysa bu kenar döngü oluşturur, false.
       Farklıysa birleştir ve bileşen sayısını azalt. Sonunda tek bileşen kalmalı.
    */
    /*  Complexity
        Time  : O(n * α(n))
        Space : O(n)
    */

    private int[] p;

    public boolean validTree(int n, int[][] edges) {
        p = new int[n];
        for (int i = 0; i < n; ++i) {
            p[i] = i;
        }
        for (var e : edges) {
            int pa = find(e[0]), pb = find(e[1]);
            if (pa == pb) {
                return false;
            }
            p[pa] = pb;
            --n;
        }
        return n == 1;
    }

    private int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }
}
