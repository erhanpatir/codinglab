package prefixsum;

import java.util.*;

public class Q1480_RunningSumOf1dArray {
    // Öncelik   : 🔴 Yüksek
    // Şirketler : Google ✅ (#105)
    //
    // 1480. Running Sum of 1d Array - Easy
    // https://leetcode.com/problems/running-sum-of-1d-array/

    /* ------------------------------------------------------------
       | PATTERN: Prefix Sum
       ------------------------------------------------------------
       nums[i] += nums[i-1] ile diziyi yerinde koşan toplama çevir.
    */
    /*  Complexity
        Time  : O(n)
        Space : O(1)
    */

    public static int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; ++i) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}
