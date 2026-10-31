package greedy;

import java.util.*;

public class Q0045_JumpGame2 {
    // Öncelik   : 🔴 Yüksek
    // Şirketler : Amazon ✅ (#77)
    //
    // 45. Jump Game II - Medium
    // https://leetcode.com/problems/jump-game-ii/

    /* ------------------------------------------------------------
       | PATTERN: Greedy (BFS seviyeleri gibi)
       ------------------------------------------------------------
       Her sıçrama bir "seviye". mx = şu ana kadar ulaşılabilen en uzak nokta,
       last = mevcut sıçramanın sınırı. i == last olduğunda sıçrama sayısını artır ve last = mx yap.
       Son elemana kadar (n-2) gezmek yeterli.
    */
    /*  Complexity
        Time  : O(n)
        Space : O(1)
    */

    public static int jump(int[] nums) {
        int ans = 0, mx = 0, last = 0;
        for (int i = 0; i < nums.length - 1; ++i) {
            mx = Math.max(mx, i + nums[i]);
            if (last == i) {
                ++ans;
                last = mx;
            }
        }
        return ans;
    }
}
