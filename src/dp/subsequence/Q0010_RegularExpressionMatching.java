package dp.subsequence;

import java.util.*;

public class Q0010_RegularExpressionMatching {
    // Öncelik   : 🔴 Yüksek
    // Şirketler : Google ✅ (#83), Amazon ✅ (#108), Apple (#88), Bloomberg ✅ (#116)
    //
    // 10. Regular Expression Matching - Hard
    // https://leetcode.com/problems/regular-expression-matching/

    /* ------------------------------------------------------------
       | PATTERN: 2D DP - Memoization (string matching)
       ------------------------------------------------------------
       dfs(i, j): s[i..] ile p[j..] eşleşiyor mu?
       p[j+1] == '*' ise iki seçenek: '*'ı sıfır kez kullan (j+2'ye atla) ya da
       s[i] p[j] ile eşleşiyorsa bir karakter tüket (i+1, j aynı kalır).
       Değilse s[i] ile p[j] eşleşmeli ('.' her karakterle eşleşir). Sonuçlar memo tablosunda saklanır.
    */
    /*  Complexity
        Time  : O(m * n)
        Space : O(m * n)
    */

    private Boolean[][] f;
    private String s;
    private String p;
    private int m;
    private int n;

    public boolean isMatch(String s, String p) {
        m = s.length();
        n = p.length();
        f = new Boolean[m + 1][n + 1];
        this.s = s;
        this.p = p;
        return dfs(0, 0);
    }

    private boolean dfs(int i, int j) {
        if (j >= n) {
            return i == m;
        }
        if (f[i][j] != null) {
            return f[i][j];
        }
        boolean res = false;
        if (j + 1 < n && p.charAt(j + 1) == '*') {
            res = dfs(i, j + 2)
                || (i < m && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') && dfs(i + 1, j));
        } else {
            res = i < m && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') && dfs(i + 1, j + 1);
        }
        return f[i][j] = res;
    }
}
