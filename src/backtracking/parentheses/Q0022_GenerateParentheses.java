package backtracking.parentheses;

import java.util.ArrayList;
import java.util.List;

public class Q0022_GenerateParentheses {
    // 22. Generate Parentheses - Medium
    // https://leetcode.com/problems/generate-parentheses/

    // Backtrack - constraint ile backtracking
    //           - build only valid prefixes

    // Time:  O(4^n / sqrt(n))
    // Space: O(n)

    /* Altın özet -------------------------------------------------
    |                                                              |
    |    Bu soru için aklında şunlar kalsın:                       |
    |    ------------------------------------------------          |
    |    |    if (current.length() == 2 * n) -> answer  |          |
    |    |    if (open < n) -> '(' koyabilirim          |          |
    |    |    if (close < open) -> ')' koyabilirim      |          |
    |    ------------------------------------------------          |
    |    ve en önemli cümle:                                       |
    |                                                              |
    |     ')' ancak daha önce açılmış bir '(' varsa eklenebilir.   |
    --------------------------------------------------------------- */

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(n, 0, 0, new StringBuilder(), result);
        return result;
    }

    private static void backtrack(int n,
                                  int open,
                                  int close,
                                  StringBuilder current,
                                  List<String> result) {

        if (current.length() == 2 * n) { // base case
            result.add(current.toString());
            return;
        }

        if (open < n) {
            current.append('(');
            backtrack(n, open + 1, close, current, result);
            current.deleteCharAt(current.length() - 1);
        }

        // Bu olmazsa invalid string’ler de üretilir.
        // Hic bir zaman close sayisi open sayisinin onune gecemez.
        if (close < open) {
            current.append(')');
            backtrack(n, open, close + 1, current, result);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
