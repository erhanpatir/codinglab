package twopointers;

import java.util.*;

public class Q0018_4Sum {
    // 18. 4Sum - Medium
    // https://leetcode.com/problems/4sum/

    /* ------------------------------------------------------------
       | PATTERN: Two Pointers (Sorting + kSum)
       ------------------------------------------------------------
       Sırala; iki dış döngü (i, j) ile ilk iki elemanı sabitle, kalan ikisini iki pointer ile ara.
       Tekrar eden sonuçları önlemek için her seviyede aynı değeri atla.
       Toplam int'i taşabileceği için long kullan.
    */
    /*  Complexity
        Time  : O(n^3)
        Space : O(log n) (sıralama)
    */

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        if (n < 4) {
            return ans;
        }
        Arrays.sort(nums);
        for (int i = 0; i < n - 3; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < n - 2; ++j) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int k = j + 1, l = n - 1;
                while (k < l) {
                    long x = (long) nums[i] + nums[j] + nums[k] + nums[l];
                    if (x < target) {
                        ++k;
                    } else if (x > target) {
                        --l;
                    } else {
                        ans.add(List.of(nums[i], nums[j], nums[k++], nums[l--]));
                        while (k < l && nums[k] == nums[k - 1]) {
                            ++k;
                        }
                        while (k < l && nums[l] == nums[l + 1]) {
                            --l;
                        }
                    }
                }
            }
        }
        return ans;
    }
}
