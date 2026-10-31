package twopointers;

import java.util.*;

public class Q0031_NextPermutation {
    // 31. Next Permutation - Medium
    // https://leetcode.com/problems/next-permutation/

    /* ------------------------------------------------------------
       | PATTERN: Two Pointers - Next Permutation
       ------------------------------------------------------------
       Sağdan sola ilk düşüşü bul: nums[i] < nums[i+1]. Yoksa dizi son permütasyon; tümünü ters çevir.
       Varsa yine sağdan, nums[i]'den büyük ilk nums[j]'yi bul ve ikisini swap et.
       Son olarak i+1'den sona kadar olan kısmı ters çevir (bu kısım azalan sıradaydı, artana döner).
    */
    /*  Complexity
        Time  : O(n)
        Space : O(1)
    */

    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;
        for (; i >= 0; --i) {
            if (nums[i] < nums[i + 1]) {
                break;
            }
        }
        if (i >= 0) {
            for (int j = n - 1; j > i; --j) {
                if (nums[j] > nums[i]) {
                    swap(nums, i, j);
                    break;
                }
            }
        }

        for (int j = i + 1, k = n - 1; j < k; ++j, --k) {
            swap(nums, j, k);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int t = nums[j];
        nums[j] = nums[i];
        nums[i] = t;
    }
}
