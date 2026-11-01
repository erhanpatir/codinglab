package binarysearch;

import java.util.*;

public class Q0004_MedianOfTwoSortedArrays {
    // Öncelik   : 🔵 Trend  ·  🌍 Ortak soru
    // Şirketler : Meta ✅ (#48), Google ✅ (#3), Amazon ✅ (#12), Apple (#35), Bloomberg ✅ (#12)
    //
    // 4. Median of Two Sorted Arrays - Hard
    // https://leetcode.com/problems/median-of-two-sorted-arrays/

    /* ------------------------------------------------------------
       | PATTERN: Binary Search / k-th Element (Divide & Conquer)
       ------------------------------------------------------------
       Medyan = birleşik dizinin (m+n+1)/2. ve (m+n+2)/2. elemanlarının ortalaması.
       f(i, j, k): nums1[i..] ve nums2[j..] içindeki k. en küçük eleman.
       Her adımda iki dizinin k/2. elemanlarını karşılaştır; küçük olan tarafın ilk k/2 elemanı
       k. eleman olamaz, onları at ve k'yi k/2 azalt. k her adımda yarıya indiği için logaritmik.
    */
    /*  Complexity
        Time  : O(log(m + n))
        Space : O(log(m + n)) (recursion)
    */

    private int m;
    private int n;
    private int[] nums1;
    private int[] nums2;

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        m = nums1.length;
        n = nums2.length;
        this.nums1 = nums1;
        this.nums2 = nums2;
        int a = f(0, 0, (m + n + 1) / 2);
        int b = f(0, 0, (m + n + 2) / 2);
        return (a + b) / 2.0;
    }

    private int f(int i, int j, int k) {
        if (i >= m) {
            return nums2[j + k - 1];
        }
        if (j >= n) {
            return nums1[i + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[i], nums2[j]);
        }
        int p = k / 2;
        int x = i + p - 1 < m ? nums1[i + p - 1] : 1 << 30;
        int y = j + p - 1 < n ? nums2[j + p - 1] : 1 << 30;
        return x < y ? f(i + p, j, k - p) : f(i, j + p, k - p);
    }
}
