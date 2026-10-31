package dp.linear;

import java.util.*;

public class Q1387_SortIntegersByThePowerValue {
    // 1387. Sort Integers by The Power Value - Medium
    // https://leetcode.com/problems/sort-integers-by-the-power-value/

    /* ------------------------------------------------------------
       | PATTERN: 1-D DP / Memo + Sıralama
       ------------------------------------------------------------
       Her sayının "power" değerini (Collatz adım sayısı) hesapla, (power, sayı) çiftine göre sırala, k. elemanı döndür.
       Aynı ara değerler tekrar hesaplanmasın diye memo kullanılabilir.
    */
    /*  Complexity
        Time  : O(n log n * M)
        Space : O(n)
    */

    public static int getKth(int lo, int hi, int k) {
        Integer[] nums = new Integer[hi - lo + 1];
        for (int i = lo; i <= hi; ++i) {
            nums[i - lo] = i;
        }
        Arrays.sort(nums, (a, b) -> {
            int fa = f(a), fb = f(b);
            return fa == fb ? a - b : fa - fb;
        });
        return nums[k - 1];
    }

    private static int f(int x) {
        int ans = 0;
        for (; x != 1; ++ans) {
            if (x % 2 == 0) {
                x /= 2;
            } else {
                x = x * 3 + 1;
            }
        }
        return ans;
    }
}
