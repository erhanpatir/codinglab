package backtracking;

import java.util.*;

public class Q0282_ExpressionAddOperators {
    // Öncelik   : 🟡 Orta
    // Şirketler : Meta (#82)
    //
    // 282. Expression Add Operators - Hard
    // https://leetcode.com/problems/expression-add-operators/

    /* ------------------------------------------------------------
       | PATTERN: Backtracking (ifade kurma)
       ------------------------------------------------------------
       Her pozisyonda bir sonraki sayıyı farklı uzunluklarda kes ve önüne +, -, * koy.
       Çarpma önceliği için son terimi (prev) taşı: '*' gelince curr = curr - prev + prev * x.
       Başında 0 olan çok basamaklı sayılar geçersizdir. Sonuç target olunca ifadeyi ekle.
    */
    /*  Complexity
        Time  : O(4^n * n)
        Space : O(n)
    */

    private List<String> ans;
    private String num;
    private int target;

    public List<String> addOperators(String num, int target) {
        ans = new ArrayList<>();
        this.num = num;
        this.target = target;
        dfs(0, 0, 0, "");
        return ans;
    }

    private void dfs(int u, long prev, long curr, String path) {
        if (u == num.length()) {
            if (curr == target) ans.add(path);
            return;
        }
        for (int i = u; i < num.length(); i++) {
            if (i != u && num.charAt(u) == '0') {
                break;
            }
            long next = Long.parseLong(num.substring(u, i + 1));
            if (u == 0) {
                dfs(i + 1, next, next, path + next);
            } else {
                dfs(i + 1, next, curr + next, path + "+" + next);
                dfs(i + 1, -next, curr - next, path + "-" + next);
                dfs(i + 1, prev * next, curr - prev + prev * next, path + "*" + next);
            }
        }
    }
}
