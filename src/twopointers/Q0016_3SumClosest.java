package twopointers;

import java.util.*;

public class Q0016_3SumClosest {
    // 16. 3Sum Closest - Medium
    // https://leetcode.com/problems/3sum-closest/

    /* ------------------------------------------------------------
       | PATTERN: Two Pointers (Sorting + 3Sum kalıbı)
       ------------------------------------------------------------
       Diziyi sırala. Her i için kalan aralıkta j = i+1, k = n-1 pointer'larını kullan.
       Toplam target'tan küçükse j++, büyükse k--, eşitse doğrudan target döndür.
       Her adımda |toplam - target| en küçük olan toplamı sakla.
    */
    /*  Complexity
        Time  : O(n^2)
        Space : O(log n) (sıralama)
    */

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = 1 << 30;
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            int j = i + 1, k = n - 1;
            while (j < k) {
                int t = nums[i] + nums[j] + nums[k];
                if (t == target) {
                    return t;
                }
                if (Math.abs(t - target) < Math.abs(ans - target)) {
                    ans = t;
                }
                if (t > target) {
                    --k;
                } else {
                    ++j;
                }
            }
        }
        return ans;
    }
}
