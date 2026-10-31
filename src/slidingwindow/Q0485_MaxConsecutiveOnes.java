package slidingwindow;

import java.util.*;

public class Q0485_MaxConsecutiveOnes {
    // 485. Max Consecutive Ones - Easy
    // https://leetcode.com/problems/max-consecutive-ones/

    /* ------------------------------------------------------------
       | PATTERN: Sliding Window (sayaç ile)
       ------------------------------------------------------------
       Ardışık 1'leri say; 0 görünce sayacı sıfırla. Her adımda en büyük sayaç değerini tut.
    */
    /*  Complexity
        Time  : O(n)
        Space : O(1)
    */

    public static int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0, cnt = 0;
        for (int x : nums) {
            if (x == 1) {
                ans = Math.max(ans, ++cnt);
            } else {
                cnt = 0;
            }
        }
        return ans;
    }
}
