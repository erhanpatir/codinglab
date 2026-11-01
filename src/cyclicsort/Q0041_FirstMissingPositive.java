package cyclicsort;

import java.util.*;

public class Q0041_FirstMissingPositive {
    // Öncelik   : 🔴 Yüksek  ·  🌍 Ortak soru
    // Şirketler : Google ✅ (#109), Amazon ✅ (#61)
    //
    // 41. First Missing Positive - Hard
    // https://leetcode.com/problems/first-missing-positive/

    /* ------------------------------------------------------------
       | PATTERN: Cyclic Sort (in-place swap)
       ------------------------------------------------------------
       Cevap mutlaka 1..n+1 aralığında. Her x değerini, 1 <= x <= n ise, olması gereken x-1 indeksine swap ile taşı;
       yerine gelen değer için aynı işlemi tekrarla.
       Sonra baştan gez: nums[i] != i + 1 olan ilk i için cevap i + 1, hepsi yerindeyse n + 1.
    */
    /*  Complexity
        Time  : O(n)
        Space : O(1)
    */

    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }

    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
