package slidingwindow;

import java.util.*;

public class Q0713_SubarrayProductLessThanK {
    // Öncelik   : ⭐ Gerçek deneyim
    // Şirketler : Apple ✅ (#20)
    // Raporlar  : 1
    //             https://www.vervecopilot.com/blog/apple-leetcode-interview-questions
    //
    // 713. Subarray Product Less Than K - Medium
    // https://leetcode.com/problems/subarray-product-less-than-k/

    /* ------------------------------------------------------------
       | PATTERN: Sliding Window (çarpım)
       ------------------------------------------------------------
       Sağ ucu genişlet, çarpımı güncelle; çarpım >= k olduğu sürece soldan daralt.
       Sağ ucu r'de biten geçerli alt dizi sayısı r - l + 1; hepsini topla. k <= 1 için cevap 0.
    */
    /*  Complexity
        Time  : O(n)
        Space : O(1)
    */

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int ans = 0, l = 0;
        int p = 1;
        for (int r = 0; r < nums.length; ++r) {
            p *= nums[r];
            while (l <= r && p >= k) {
                p /= nums[l++];
            }
            ans += r - l + 1;
        }
        return ans;
    }
}
