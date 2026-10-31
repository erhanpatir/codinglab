package binarysearch;

import java.util.*;

public class Q0540_SingleElementInASortedArray {
    // Öncelik   : 🔵 Trend  ·  🌍 Ortak soru
    // Şirketler : Google ✅, Amazon ✅, Bloomberg ✅
    //
    // 540. Single Element in a Sorted Array - Medium
    // https://leetcode.com/problems/single-element-in-a-sorted-array/

    /* ------------------------------------------------------------
       | PATTERN: Binary Search (çift / tek indeks eşleşmesi)
       ------------------------------------------------------------
       Tekil elemandan önce çiftler (çift, tek) indekslerde, sonra (tek, çift) indekslerde durur.
       mid ^ 1, mid'in eşi olması gereken indekstir. nums[mid] == nums[mid ^ 1] ise tekil eleman sağdadır,
       değilse mid ya da soldadır.
    */
    /*  Complexity
        Time  : O(log n)
        Space : O(1)
    */

    public static int singleNonDuplicate(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[mid] != nums[mid ^ 1]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums[l];
    }
}
