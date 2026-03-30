package backtracking.combinations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q0040_CombinationSumII {
    // 40. Combination Sum II - Medium
    // https://leetcode.com/problems/combination-sum-ii/
    // Backtracking: no reuse + duplicate skip

    /*  Mini walkthrough
            candidates = [1,1,2,5]
            target = 3
            Sorted zaten aynı.

            İlk level:
                i=0 → 1 seç
                    ikinci level:
                        i=1 → 1 seç
                        i=2 → 2 seç → [1,2]
                i=1 → skip, çünkü aynı level duplicate
                i=2 → 2 seç
                i=3 → 5 büyükse break

        Sonuç:
            [1,2]
     */

    // Time:  O(2^n * n)
    // Space: O(n)
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        /* Bu soruda sorting neredeyse mecbur:
            Neden?
                Çünkü duplicate’ları yan yana getirir.
                Böylece Duplicate skip edebiliriz.
        */
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] candidates, int remaining, int start,
                                  List<Integer> path, List<List<Integer>> result) {
        if (remaining == 0) { // base case
            result.add(new ArrayList<>(path));
            return;
        }

        if (remaining < 0) return;

        for (int i = start; i < candidates.length; i++) {
            /* 2. aynı seviyede duplicate seçemezsin
                Anlamı:
                    Aynı recursion level’ında, aynı değeri ikinci kez branch başlangıcı yapma.
                Bu çok önemli.
                    i > start kısmı olmazsa bazı doğru durumları da yanlışlıkla silersin.
             */
            if (i > start && candidates[i] == candidates[i - 1]) continue;

            // Array sorted olduğu için bundan sonrası da büyük olacak.
            // pruning
            if (candidates[i] > remaining) break;

            path.add(candidates[i]);
            backtrack(candidates, remaining - candidates[i], i + 1, path, result);
            path.remove(path.size() - 1);
        }
    }
}
