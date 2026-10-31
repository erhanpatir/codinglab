package hashing;

import java.util.*;

public class Q3371_IdentifyTheLargestOutlierInAnArray {
    // 3371. Identify the Largest Outlier in an Array - Medium
    // https://leetcode.com/problems/identify-the-largest-outlier-in-an-array/

    /* ------------------------------------------------------------
       | PATTERN: Hash / Counting (toplam üzerinden)
       ------------------------------------------------------------
       Outlier x ise kalan toplam t = S - x, ve t'nin yarısı (özel toplam) dizide başka bir eleman olarak bulunmalı.
       Her aday x için t çift mi ve t / 2 map'te var mı (x == t / 2 ise frekans > 1 olmalı) kontrol et; en büyük x'i tut.
    */
    /*  Complexity
        Time  : O(n)
        Space : O(n)
    */

    public static int getLargestOutlier(int[] nums) {
        int s = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int x : nums) {
            s += x;
            cnt.merge(x, 1, Integer::sum);
        }
        int ans = Integer.MIN_VALUE;
        for (var e : cnt.entrySet()) {
            int x = e.getKey(), v = e.getValue();
            int t = s - x;
            if (t % 2 != 0 || !cnt.containsKey(t / 2)) {
                continue;
            }
            if (x != t / 2 || v > 1) {
                ans = Math.max(ans, x);
            }
        }
        return ans;
    }
}
