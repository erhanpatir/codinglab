package sorting;

import java.util.*;

public class Q0912_SortAnArray {
    // Öncelik   : 🔴 Yüksek
    // Şirketler : Google ✅ (#110)
    //
    // 912. Sort an Array - Medium
    // https://leetcode.com/problems/sort-an-array/

    /* ------------------------------------------------------------
       | PATTERN: Sorting - Merge Sort
       ------------------------------------------------------------
       Diziyi ikiye böl, iki yarıyı recursive sırala, sonra iki sıralı yarıyı geçici dizi ile birleştir.
       Her durumda O(n log n) garantisi verir ve stabildir. Quick sort ortalamada hızlıdır
       ama kötü pivot seçiminde O(n^2) olur.
    */
    /*  Complexity
        Time  : O(n log n)
        Space : O(n)
    */

    public static int[] sortArray(int[] nums) {
        int[] temp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1, temp);
        return nums;
    }

    private static void mergeSort(int[] nums, int lo, int hi, int[] temp) {
        if (lo >= hi) return;
        int mid = lo + (hi - lo) / 2;
        mergeSort(nums, lo, mid, temp);
        mergeSort(nums, mid + 1, hi, temp);
        int i = lo, j = mid + 1, k = lo;
        while (i <= mid && j <= hi) temp[k++] = nums[i] <= nums[j] ? nums[i++] : nums[j++];
        while (i <= mid) temp[k++] = nums[i++];
        while (j <= hi) temp[k++] = nums[j++];
        for (k = lo; k <= hi; k++) nums[k] = temp[k];
    }
}
