package cyclicsort;

import java.util.*;

public class Q0565_ArrayNesting {
    // 565. Array Nesting - Medium
    // https://leetcode.com/problems/array-nesting/

    /* ------------------------------------------------------------
       | PATTERN: Cyclic Sort / Döngü takibi
       ------------------------------------------------------------
       Dizi 0..n-1 permütasyonu; i -> nums[i] kenarları ayrık döngüler oluşturur.
       Her ziyaret edilmemiş indeksten döngüyü takip et, uzunluğunu say, elemanları işaretle.
       En uzun döngünün uzunluğu cevap.
    */
    /*  Complexity
        Time  : O(n)
        Space : O(n)
    */

    public static int arrayNesting(int[] nums) {
        int n = nums.length;
        boolean[] vis = new boolean[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (vis[i]) {
                continue;
            }
            int cur = nums[i], m = 1;
            vis[cur] = true;
            while (nums[cur] != nums[i]) {
                cur = nums[cur];
                m++;
                vis[cur] = true;
            }
            res = Math.max(res, m);
        }
        return res;
    }
}
