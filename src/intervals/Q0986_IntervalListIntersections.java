package intervals;

import java.util.*;

public class Q0986_IntervalListIntersections {
    // 986. Interval List Intersections - Medium
    // https://leetcode.com/problems/interval-list-intersections/

    /* ------------------------------------------------------------
       | PATTERN: Intervals - Two Pointers
       ------------------------------------------------------------
       İki listeyi aynı anda gez. Kesişim = [max(başlangıçlar), min(bitişler)], başlangıç <= bitiş ise geçerli.
       Bitişi daha erken olan aralığın pointer'ını ilerlet; o aralık başka hiçbir aralıkla kesişemez.
    */
    /*  Complexity
        Time  : O(m + n)
        Space : O(1) (çıktı hariç)
    */

    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> ans = new ArrayList<>();
        int m = firstList.length, n = secondList.length;
        for (int i = 0, j = 0; i < m && j < n;) {
            int l = Math.max(firstList[i][0], secondList[j][0]);
            int r = Math.min(firstList[i][1], secondList[j][1]);
            if (l <= r) {
                ans.add(new int[] {l, r});
            }
            if (firstList[i][1] < secondList[j][1]) {
                ++i;
            } else {
                ++j;
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
