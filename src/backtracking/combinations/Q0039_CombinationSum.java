package backtracking.combinations;

import java.util.ArrayList;
import java.util.List;

public class Q0039_CombinationSum {
    // 39. Combination Sum - Medium
    // https://leetcode.com/problems/combination-sum/

    /* 🌳 Recursion Tree Mantığı
            Örnek:

            []
             ├── 2 → [2]
             │    ├── 2 → [2,2]
             │    │    ├── 2 → [2,2,2] ❌ (overflow)
             │    │    ├── 3 → [2,2,3] ✅
             │
             ├── 3 → [3]
             │    ├── 3 → [3,3]
             │
             ├── 6 → [6]
             ├── 7 → [7] ✅
     */
    /* 🔑 Kritik Noktalar
            index önemli → tekrar kullanım için aynı index ile devam
            target < 0 → stop
            target == 0 → solution
     */

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private static void backtrack(List<List<Integer>> result,
                           List<Integer> current,
                           int[] candidates,
                           int target,
                           int start) {

        if (target == 0) {
            result.add(new ArrayList<>(current)); // copy state
            return;
        }

        if (target < 0) return;

        for (int i = start; i < candidates.length; i++) {
            current.add(candidates[i]); // make choice

            // aynı i → reuse allowed
            backtrack(result, current, candidates, target - candidates[i], i);

            current.remove(current.size() - 1); // undo choice
        }
    }
}
