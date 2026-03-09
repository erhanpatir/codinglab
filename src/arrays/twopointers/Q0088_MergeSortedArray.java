package arrays.twopointers;

import java.util.Arrays;

// 88. Merge Sorted Array - Easy
// https://leetcode.com/problems/merge-sorted-array/
public class Q0088_MergeSortedArray {
    /*
        Cozum: ✅
             Baştan değil, sondan merge et.
        Neden?
            Baştan yazarsan, nums1’deki değerleri ezersin
            Sondan yazarsan kimseyi ezmezsin.
    *
    * Complexity Analysis
        Time Complexity:  O(m + n), as we process each element exactly once.
        Space Complexity: O(1),     in-place without extra space.
    */

    // 1. In-place Two-Pointer
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;      // nums1'in dolu kısmının sonu
        int j = n - 1;      // nums2'nin sonu
        int k = m + n - 1;  // nums1'in en son index'i

        // 1. ve 2. array'i bastan sona merge et.
        // Buyuk mu kucuk mu bakarak iki pointer ile takip et.
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
        // nums2'de kalanlar varsa kopyala
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }

    // 2. Merge Then Sort
    public static void merge_2(int[] nums1, int m, int[] nums2, int n) {
        // nums1 array ine nums2 array inin elementlerini ekle
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        // sonra da sirala
        Arrays.sort(nums1);
    }

    // 3. Two-Pointer
    // Time Complexity: O(m + n),  as we iterate through both arrays once.
    // Space Complexity: O(m + n), due to the use of an additional array.
    public static void merge_3(int[] nums1, int m, int[] nums2, int n) {

        // New array to store merged result
        int[] sorted = new int[m + n];
        // Pointers for nums1, nums2, and sorted array
        int p1 = 0, p2 = 0, p = 0;

        // Compare and merge
        while (p1 < m && p2 < n) {
            if (nums1[p1] <= nums2[p2]) {
                sorted[p++] = nums1[p1++];
            } else {
                sorted[p++] = nums2[p2++];
            }
        }

        // Append remaining elements
        while (p1 < m) {
            sorted[p++] = nums1[p1++];
        }
        while (p2 < n) {
            sorted[p++] = nums2[p2++];
        }

        // Copy sorted array back to nums1
        System.arraycopy(sorted, 0, nums1, 0, m + n);
    }
}
