package backtracking.subsets;

import java.util.ArrayList;
import java.util.List;

public class Q0078_Subsets {
    // 78. Subsets - Medium
    // https://leetcode.com/problems/subsets/
    // Backtracking : backtrack + loop continuatio

    // Time: Toplam subset sayısı: 2^N Her subset kopyalanıyor: O(N * 2^N)
    // Space: O(N)

    // Input:  [1,2,3]
    // Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int start,
                           int[] nums,
                           List<Integer> path,
                           List<List<Integer>> result) {

        result.add(new ArrayList<>(path));  // 🔥 fark burada

        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            backtrack(i + 1, nums, path, result);
            path.remove(path.size() - 1);
        }
    }
}
