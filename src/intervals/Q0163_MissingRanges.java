package intervals;

import java.util.*;

public class Q0163_MissingRanges {
    // 163. Missing Ranges - Easy
    // https://leetcode.com/problems/missing-ranges/

    /* ------------------------------------------------------------
       | PATTERN: Intervals - boşlukları tarama
       ------------------------------------------------------------
       Dizi sıralı. Üç yer kontrol edilir: lower ile ilk eleman arası, ardışık iki eleman arası
       (fark > 1 ise [a+1, b-1] eksik aralıktır), son eleman ile upper arası. Boş dizide cevap [lower, upper].
    */
    /*  Complexity
        Time  : O(n)
        Space : O(1) (çıktı hariç)
    */

    public static List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        int n = nums.length;
        if (n == 0) {
            return List.of(List.of(lower, upper));
        }
        List<List<Integer>> ans = new ArrayList<>();
        if (nums[0] > lower) {
            ans.add(List.of(lower, nums[0] - 1));
        }
        for (int i = 1; i < n; ++i) {
            if (nums[i] - nums[i - 1] > 1) {
                ans.add(List.of(nums[i - 1] + 1, nums[i] - 1));
            }
        }
        if (nums[n - 1] < upper) {
            ans.add(List.of(nums[n - 1] + 1, upper));
        }
        return ans;
    }
}
