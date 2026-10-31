package math;

import java.util.*;

public class Q0398_RandomPickIndex {
    // Öncelik   : 🟡 Orta
    // Şirketler : Meta (#88)
    //
    // 398. Random Pick Index - Medium
    // https://leetcode.com/problems/random-pick-index/

    /* ------------------------------------------------------------
       | PATTERN: Reservoir Sampling
       ------------------------------------------------------------
       target'a eşit elemanları gezerken n. eşleşmeyi 1/n olasılıkla cevap olarak seç.
       Sonunda her eşleşmenin seçilme olasılığı eşittir. Ekstra indeks listesi gerekmez.
    */
    /*  Complexity
        Time  : O(n) her pick
        Space : O(1)
    */

    public class Solution {
        private int[] nums;
        private Random random = new Random();

        public Solution(int[] nums) {
            this.nums = nums;
        }

        public int pick(int target) {
            int n = 0, ans = 0;
            for (int i = 0; i < nums.length; ++i) {
                if (nums[i] == target) {
                    ++n;
                    int x = 1 + random.nextInt(n);
                    if (x == n) {
                        ans = i;
                    }
                }
            }
            return ans;
        }
    }
}
