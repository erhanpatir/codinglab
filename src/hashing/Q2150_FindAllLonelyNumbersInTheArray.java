package hashing;

import java.util.*;

public class Q2150_FindAllLonelyNumbersInTheArray {
    // Öncelik   : 🔵 Trend
    // Şirketler : Apple ✅ (#109)
    //
    // 2150. Find All Lonely Numbers in the Array - Medium
    // https://leetcode.com/problems/find-all-lonely-numbers-in-the-array/

    /* ------------------------------------------------------------
       | PATTERN: Hash / Counting
       ------------------------------------------------------------
       Frekansları say. Frekansı 1 olan ve x - 1 ile x + 1'i map'te olmayan x yalnızdır.
    */
    /*  Complexity
        Time  : O(n)
        Space : O(n)
    */

    public static List<Integer> findLonely(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int x : nums) {
            cnt.merge(x, 1, Integer::sum);
        }
        List<Integer> ans = new ArrayList<>();
        for (var e : cnt.entrySet()) {
            int x = e.getKey(), v = e.getValue();
            if (v == 1 && !cnt.containsKey(x - 1) && !cnt.containsKey(x + 1)) {
                ans.add(x);
            }
        }
        return ans;
    }
}
