package twopointers;

import java.util.*;

public class Q0189_RotateArray {
    // Öncelik   : 🔴 Yüksek  ·  🌍 Ortak soru
    // Şirketler : Google ✅ (#54), Amazon ✅ (#85), Apple ✅ (#7), Bloomberg ✅ (#50)
    //
    // 189. Rotate Array - Medium
    // https://leetcode.com/problems/rotate-array/

    /* ------------------------------------------------------------
       | PATTERN: Two Pointers - üç kez ters çevirme
       ------------------------------------------------------------
       k %= n. Tüm diziyi ters çevir, sonra ilk k elemanı, sonra kalan n-k elemanı ters çevir.
       Örnek: [1,2,3,4,5], k=2 -> [5,4,3,2,1] -> [4,5,3,2,1] -> [4,5,1,2,3].
    */
    /*  Complexity
        Time  : O(n)
        Space : O(1)
    */

    private int[] nums;

    public void rotate(int[] nums, int k) {
        this.nums = nums;
        int n = nums.length;
        k %= n;
        reverse(0, n - 1);
        reverse(0, k - 1);
        reverse(k, n - 1);
    }

    private void reverse(int i, int j) {
        for (; i < j; ++i, --j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
    }
}
