package backtracking.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q0090_SubsetsII {
    // 90. Subsets II - Medium
    // https://leetcode.com/problems/subsets-ii/
    // Backtracking: 78 + sorting + same-level duplicate skip

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] nums,
                           int start,
                           List<Integer> subset,
                           List<List<Integer>> result) {
        result.add(new ArrayList<>(subset));

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;

            subset.add(nums[i]);
            backtrack(nums, i + 1, subset, result);
            subset.remove(subset.size() - 1);
        }
    }
}
