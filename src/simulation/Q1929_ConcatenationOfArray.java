package simulation;

import java.util.*;

public class Q1929_ConcatenationOfArray {
    // Öncelik   : 🔴 Yüksek
    // Şirketler : Google ✅ (#29)
    //
    // 1929. Concatenation of Array - Easy
    // https://leetcode.com/problems/concatenation-of-array/

    /* ------------------------------------------------------------
       | PATTERN: Array Simülasyon
       ------------------------------------------------------------
       2n uzunlukta dizi oluştur; ans[i] = ans[i + n] = nums[i].
    */
    /*  Complexity
        Time  : O(n)
        Space : O(1) (çıktı hariç)
    */

    public static int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n << 1];
        for (int i = 0; i < n << 1; ++i) {
            ans[i] = nums[i % n];
        }
        return ans;
    }
}
