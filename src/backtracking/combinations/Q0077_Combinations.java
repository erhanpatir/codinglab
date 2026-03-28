package backtracking.combinations;

import java.util.ArrayList;
import java.util.List;

public class Q0077_Combinations {
    // 77. Combinations - Medium
    // https://leetcode.com/problems/combinations/
    // Backtracking

    // Time:  O(C(n, k))
    // Space: O(C(n, k))

    // Input: n = 4, k = 2
    // Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(n, k, new ArrayList<>(), 1, result);
        return result;
    }

    private static void backtrack(int n,
                           int k,
                           List<Integer> current,
                           int start,
                           List<List<Integer>> result) {
        if (current.size() == k) { // base case
            result.add(new ArrayList<>(current));
            return;
        }

        if (current.size() > k) return;

        for (int i = start; i <= n; i++) {
            current.add(i);
            backtrack(n, k, current, i + 1, result);
            current.remove(current.size() - 1);
        }
    }
}
