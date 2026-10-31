package graphs.unionfind;

import java.util.*;

public class Q0765_CouplesHoldingHands {
    // 765. Couples Holding Hands - Hard
    // https://leetcode.com/problems/couples-holding-hands/description/

    /* ------------------------------------------------------------
       | PATTERN: Union Find (çift grupları)
       ------------------------------------------------------------
       Her çift (2k, 2k+1) bir düğüm (id = kişi / 2). Yan yana oturan her iki kişinin çiftlerini birleştir.
       k büyüklüğünde bir bileşeni düzeltmek k - 1 swap ister. Cevap = çift sayısı - bileşen sayısı.
    */
    /*  Complexity
        Time  : O(n * α(n))
        Space : O(n)
    */

    private int[] p;

    public int minSwapsCouples(int[] row) {
        int n = row.length >> 1;
        p = new int[n];
        for (int i = 0; i < n; ++i) {
            p[i] = i;
        }
        for (int i = 0; i < n << 1; i += 2) {
            int a = row[i] >> 1, b = row[i + 1] >> 1;
            p[find(a)] = find(b);
        }
        int ans = n;
        for (int i = 0; i < n; ++i) {
            if (i == find(i)) {
                --ans;
            }
        }
        return ans;
    }

    private int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }
}
