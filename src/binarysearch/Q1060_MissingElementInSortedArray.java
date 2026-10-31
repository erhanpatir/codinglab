package binarysearch;

import java.util.*;

public class Q1060_MissingElementInSortedArray {
    // Öncelik   : ⭐ Gerçek deneyim
    // Şirketler : Meta (#176)
    // Seviye    : Senior
    // Raporlar  : 1 (1 📍London)
    //             https://leetcode.com/discuss/interview-experience/5351906/Meta-or-E5-or-London-or-Passed/
    //
    // 1060. Missing Element in Sorted Array - Medium
    // https://leetcode.com/problems/missing-element-in-sorted-array/

    /* ------------------------------------------------------------
       | PATTERN: Binary Search (eksik sayısı)
       ------------------------------------------------------------
       missing(i) = nums[i] - nums[0] - i: i. indekse kadar eksik sayı adedi.
       k, son indeksteki eksik sayısından büyükse cevap dizinin sağında.
       Değilse missing(i) >= k olan ilk i'yi binary search ile bul; cevap nums[i-1] + k - missing(i-1).
    */
    /*  Complexity
        Time  : O(log n)
        Space : O(1)
    */

    public static int missingElement(int[] nums, int k) {
        int n = nums.length;
        if (k > missing(nums, n - 1)) {
            return nums[n - 1] + k - missing(nums, n - 1);
        }
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (missing(nums, mid) >= k) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums[l - 1] + k - missing(nums, l - 1);
    }

    private static int missing(int[] nums, int i) {
        return nums[i] - nums[0] - i;
    }
}
