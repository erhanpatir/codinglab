package twopointers;

import java.util.*;

public class Q3649_NumberOfPerfectPairs {
    // 3649. Number of Perfect Pairs - Medium
    // https://leetcode.com/problems/number-of-perfect-pairs/

    /* ------------------------------------------------------------
       | PATTERN: Two Pointers (mutlak değerler)
       ------------------------------------------------------------
       x = |a|, y = |b| için koşul max(x, y) <= 2 * min(x, y) koşuluna indirgenir.
       Mutlak değerleri sırala; her i için a[i] > 2 * a[j] olduğu sürece j'yi ilerlet.
       j..i-1 arasındaki her eleman a[i] ile geçerli çift oluşturur: count += i - j.
    */
    /*  Complexity
        Time  : O(n log n)
        Space : O(n)
    */

    public static long perfectPairs(int[] nums) {
        int n = nums.length;
        long[] a = new long[n];
        for (int i = 0; i < n; i++) a[i] = Math.abs((long) nums[i]);
        Arrays.sort(a);
        long count = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {
            while (a[i] > 2 * a[j]) j++;
            count += i - j;
        }
        return count;
    }
}
