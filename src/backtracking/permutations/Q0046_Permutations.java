package backtracking.permutations;

import java.util.ArrayList;
import java.util.List;

public class Q0046_Permutations {
    // 46. Permutations - Medium
    // https://leetcode.com/problems/permutations/
    // Backtracking

    // Time:  O(n * n!)
    // Space: O(n)

    /* Neden start işe yaramıyor?
        Subsets / combinations’ta:
            bir elemanı aldıktan sonra sadece sağa gidiyordun
            böylece duplicate order oluşmuyordu

        Ama permutation’da:
            ilk eleman olarak 1 de olabilir, 2 de olabilir, 3 de olabilir
            sonra kalanlardan biri ikinci olur

        Yani “soldan sağa index ilerletme” değil,
        “kullanılmamış eleman seçme” mantığı var.
    */

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, used, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] nums,
                                  boolean[] used,
                                  List<Integer> path,
                                  List<List<Integer>> result) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue; // Çünkü aynı elemanı aynı permutation içinde iki kez kullanamayız.

            used[i] = true;
            path.add(nums[i]);

            backtrack(nums, used, path, result);

            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}
