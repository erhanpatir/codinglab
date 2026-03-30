package backtracking.permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q0047_PermutationsII {
    // 47. Permutations II - Medium
    // https://leetcode.com/problems/permutations-ii/
    // Backtracking

    // Time:  O(n * n!)
    // Space: O(n)

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
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
            if (used[i]) continue;

            // Bu sorunun kalbi bu
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

            /* Bu satır ne demek?
                Şunu diyor:
                    Eğer şu anki eleman, bir öncekiyle aynıysa
                    ve bir önceki daha bu path’te kullanılmadıysa,
                    bu elemanı seçme.

                Daha sezgisel hali:
                    Duplicate’lar arasında soldakini kullanmadan sağdakinden başlama.

                Ama neden !used[i - 1]?

                Çünkü bazı durumlarda ikinci 1’i kullanmak gereklidir.

                Örnek:
                    path = [1]
                    İlk 1 zaten kullanıldıysa, ikinci 1 artık seçilebilmeli ki:
                    [1,1,2] oluşabilsin.

                Yani:
                    önceki duplicate henüz kullanılmadıysa → skip
                    önceki duplicate zaten path’teyse → allowed
            */

            used[i] = true;
            path.add(nums[i]);

            backtrack(nums, used, path, result);

            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}
