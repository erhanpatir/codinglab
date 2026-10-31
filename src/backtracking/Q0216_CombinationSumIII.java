package backtracking;

import java.util.*;

public class Q0216_CombinationSumIII {
    // 216. Combination Sum III - Medium
    // https://leetcode.com/problems/combination-sum-iii/description/

    /* ------------------------------------------------------------
       | PATTERN: Backtracking (combination + budama)
       ------------------------------------------------------------
       1'den 9'a kadar artan sırada sayı seç (her sayı en fazla bir kez).
       Toplam 0'a indiğinde ve k sayı seçildiğinde sonucu ekle. Sayı kalan toplamdan büyükse
       ya da k sayıya ulaşıldıysa dalı kes.
    */
    /*  Complexity
        Time  : O(C(9, k) * k)
        Space : O(k)
    */

    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> t = new ArrayList<>();
    private int k;

    public List<List<Integer>> combinationSum3(int k, int n) {
        this.k = k;
        dfs(1, n);
        return ans;
    }

    private void dfs(int i, int s) {
        if (s == 0) {
            if (t.size() == k) {
                ans.add(new ArrayList<>(t));
            }
            return;
        }
        if (i > 9 || i > s || t.size() >= k) {
            return;
        }
        t.add(i);
        dfs(i + 1, s - i);
        t.remove(t.size() - 1);
        dfs(i + 1, s);
    }
}
