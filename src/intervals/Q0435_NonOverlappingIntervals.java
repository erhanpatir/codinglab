package intervals;

import java.util.*;

public class Q0435_NonOverlappingIntervals {
    // 435. Non-overlapping Intervals - Medium
    // https://leetcode.com/problems/non-overlapping-intervals/

    /* ------------------------------------------------------------
       | PATTERN: Intervals - Greedy (bitişe göre sırala)
       ------------------------------------------------------------
       Aralıkları bitiş zamanına göre sırala. Bitişi en erken olanı tutmak, sonrakiler için
       en fazla yer bırakır. Önceki seçilenin bitişinden önce başlayan aralığı sil (say).
       Cevap = toplam - tutulabilen aralık sayısı.
    */
    /*  Complexity
        Time  : O(n log n)
        Space : O(log n)
    */

    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int ans = intervals.length;
        int pre = Integer.MIN_VALUE;
        for (var e : intervals) {
            int l = e[0], r = e[1];
            if (pre <= l) {
                --ans;
                pre = r;
            }
        }
        return ans;
    }
}
