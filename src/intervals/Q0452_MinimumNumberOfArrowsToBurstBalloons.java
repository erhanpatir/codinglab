package intervals;

import java.util.*;

public class Q0452_MinimumNumberOfArrowsToBurstBalloons {
    // 452. Minimum Number of Arrows to Burst Balloons - Medium
    // https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/description/

    /* ------------------------------------------------------------
       | PATTERN: Intervals - Greedy (bitişe göre sırala)
       ------------------------------------------------------------
       Balonları bitiş noktasına göre sırala. Oku son balonun bitişine at; başlangıcı bu noktadan sonra olan
       ilk balon için yeni ok gerekir. Taşma olmaması için Integer.compare ile karşılaştır.
    */
    /*  Complexity
        Time  : O(n log n)
        Space : O(log n)
    */

    public static int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        int ans = 0;
        long last = -(1L << 60);
        for (var p : points) {
            int a = p[0], b = p[1];
            if (a > last) {
                ++ans;
                last = b;
            }
        }
        return ans;
    }
}
