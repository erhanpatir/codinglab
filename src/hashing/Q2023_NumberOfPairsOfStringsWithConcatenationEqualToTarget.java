package hashing;

import java.util.*;

public class Q2023_NumberOfPairsOfStringsWithConcatenationEqualToTarget {
    // 2023. Number of Pairs of Strings With Concatenation Equal to Target - Medium
    // https://leetcode.com/problems/number-of-pairs-of-strings-with-concatenation-equal-to-target/

    /* ------------------------------------------------------------
       | PATTERN: Hash / Enumeration
       ------------------------------------------------------------
       Tüm (i, j), i != j çiftleri için nums[i] + nums[j] == target mı diye kontrol et.
       Takip: kelime frekanslarını sayıp target'ın her ön ek / son ek ayrımına bakarak O(n + m^2).
    */
    /*  Complexity
        Time  : O(n^2 * m)
        Space : O(m)
    */

    public static int numOfPairs(String[] nums, String target) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i != j && target.equals(nums[i] + nums[j])) {
                    ++ans;
                }
            }
        }
        return ans;
    }
}
