package greedy;

import java.util.*;

public class Q3914_MinimumOperationsToMakeArrayNonDecreasing {
    // Öncelik   : 🔵 Trend
    // Şirketler : Amazon ✅ (#241)
    //
    // 3914. Minimum Operations to Make Array Non Decreasing - Medium
    // https://leetcode.com/problems/minimum-operations-to-make-array-non-decreasing/

    /* ------------------------------------------------------------
       | PATTERN: Greedy (düşüşleri toplama)
       ------------------------------------------------------------
       Her düşüş (nums[i-1] > nums[i]) en az fark kadar işlem gerektirir; artışlar ücretsizdir.
       Tüm pozitif farkları topla.
    */
    /*  Complexity
        Time  : O(n)
        Space : O(1)
    */

    public static long minOperations(int[] nums) {
        long ans = 0;
        for (int i = 1; i < nums.length; ++i) {
            ans += Math.max(nums[i - 1] - nums[i], 0);
        }
        return ans;
    }
}
