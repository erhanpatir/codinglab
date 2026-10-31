package twopointers;

import java.util.*;

public class Q2970_CountTheNumberOfIncremovableSubarraysI {
    // Öncelik   : 🟡 Orta
    // Şirketler : Apple (#85)
    //
    // 2970. Count the Number of Incremovable Subarrays I - Easy
    // https://leetcode.com/problems/count-the-number-of-incremovable-subarrays-i/

    /* ------------------------------------------------------------
       | PATTERN: Two Pointers (artan önek ve sonek)
       ------------------------------------------------------------
       En uzun kesin artan öneki bul (i). Tüm dizi artansa her alt dizi geçerli: n(n+1)/2.
       Değilse sondan j ile kesin artan sonek boyunca ilerle; her j için nums[i] < nums[j] olacak şekilde i'yi geri çek,
       sayılabilen silme sayısı i + 2. Sonek artanlığı bozulunca dur.
    */
    /*  Complexity
        Time  : O(n)
        Space : O(1)
    */

    public static int incremovableSubarrayCount(int[] nums) {
        int i = 0, n = nums.length;
        while (i + 1 < n && nums[i] < nums[i + 1]) {
            ++i;
        }
        if (i == n - 1) {
            return n * (n + 1) / 2;
        }
        int ans = i + 2;
        for (int j = n - 1; j > 0; --j) {
            while (i >= 0 && nums[i] >= nums[j]) {
                --i;
            }
            ans += i + 2;
            if (nums[j - 1] >= nums[j]) {
                break;
            }
        }
        return ans;
    }
}
