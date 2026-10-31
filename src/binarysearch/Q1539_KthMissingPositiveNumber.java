package binarysearch;

import java.util.*;

public class Q1539_KthMissingPositiveNumber {
    // 1539. Kth Missing Positive Number - Easy
    // https://leetcode.com/problems/kth-missing-positive-number/

    /* ------------------------------------------------------------
       | PATTERN: Binary Search (eksik sayısı)
       ------------------------------------------------------------
       arr[i] - i - 1, arr[i]'den önce eksik olan pozitif sayı adedidir ve artandır.
       Bu değerin k'ya ulaştığı ilk indeksi binary search ile bul; cevap = k + (bulunan indeks).
    */
    /*  Complexity
        Time  : O(log n)
        Space : O(1)
    */

    public static int findKthPositive(int[] arr, int k) {
        if (arr[0] > k) {
            return k;
        }
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (arr[mid] - mid - 1 >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return arr[left - 1] + k - (arr[left - 1] - (left - 1) - 1);
    }
}
