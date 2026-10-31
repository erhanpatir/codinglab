package twopointers;

import java.util.*;

public class Q2972_CountTheNumberOfIncremovableSubarraysII {
    // Öncelik   : 🟡 Orta
    // Şirketler : Apple (#84)
    //
    // 2972. Count the Number of Incremovable Subarrays II - Hard
    // https://leetcode.com/problems/count-the-number-of-incremovable-subarrays-ii/

    /* ------------------------------------------------------------
       | PATTERN: Two Pointers (artan önek ve sonek)
       ------------------------------------------------------------
       2970'in büyük kısıtlı versiyonu, aynı O(n) yaklaşım. Sonuç int'i aşabileceği için long kullanılır.
    */
    /*  Complexity
        Time  : O(n)
        Space : O(1)
    */

    public static long incremovableSubarrayCount(int[] nums) {
        int i = 0, n = nums.length;
        while (i + 1 < n && nums[i] < nums[i + 1]) {
            ++i;
        }
        if (i == n - 1) {
            return n * (n + 1L) / 2;
        }
        long ans = i + 2;
        for (int j = n - 1; j > 0; --j) {
            while (i >= 0 && nums[i] >= nums[j]) {
                --i;
            }
            ans += i + 2;
            if (nums[j - 1] >= nums[j]) {
                break;
            }
        }
        return ans;
    }
}
