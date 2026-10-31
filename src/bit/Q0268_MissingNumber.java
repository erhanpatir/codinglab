package bit;

import java.util.*;

public class Q0268_MissingNumber {
    // Öncelik   : 🔴 Yüksek
    // Şirketler : Amazon ✅ (#118)
    //
    // 268. Missing Number - Easy
    // https://leetcode.com/problems/missing-number/description/

    /* ------------------------------------------------------------
       | PATTERN: Bit Manipulation - XOR
       ------------------------------------------------------------
       0..n arasındaki tüm sayılar ile dizideki tüm sayıları XOR'la; olanlar birbirini götürür,
       eksik sayı kalır. Alternatif: n(n+1)/2 - toplam.
    */
    /*  Complexity
        Time  : O(n)
        Space : O(1)
    */

    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int ans = n;
        for (int i = 0; i < n; ++i) {
            ans ^= (i ^ nums[i]);
        }
        return ans;
    }
}
