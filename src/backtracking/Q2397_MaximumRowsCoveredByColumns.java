package backtracking;

import java.util.*;

public class Q2397_MaximumRowsCoveredByColumns {
    // 2397. Maximum Rows Covered by Columns - Medium
    // https://leetcode.com/problems/maximum-rows-covered-by-columns/

    /* ------------------------------------------------------------
       | PATTERN: Backtracking / Bitmask enumeration
       ------------------------------------------------------------
       Her satırı bir bitmask'e çevir. numSelect bit içeren tüm sütun seçimlerini (mask) dene;
       bir satır, (satır & mask) == satır ise kapsanmıştır. Kapsanan satır sayısı en büyük olan seçim cevap.
    */
    /*  Complexity
        Time  : O(2^n * m)
        Space : O(m)
    */

    public static int maximumRows(int[][] matrix, int numSelect) {
        int m = matrix.length, n = matrix[0].length;
        int[] rows = new int[m];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == 1) {
                    rows[i] |= 1 << j;
                }
            }
        }
        int ans = 0;
        for (int mask = 1; mask < 1 << n; ++mask) {
            if (Integer.bitCount(mask) != numSelect) {
                continue;
            }
            int t = 0;
            for (int x : rows) {
                if ((x & mask) == x) {
                    ++t;
                }
            }
            ans = Math.max(ans, t);
        }
        return ans;
    }
}
