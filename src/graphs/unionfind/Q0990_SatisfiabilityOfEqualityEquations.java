package graphs.unionfind;

import java.util.*;

public class Q0990_SatisfiabilityOfEqualityEquations {
    // 990. Satisfiability of Equality Equations - Medium
    // https://leetcode.com/problems/satisfiability-of-equality-equations/description/

    /* ------------------------------------------------------------
       | PATTERN: Union Find (eşitlik / eşitsizlik)
       ------------------------------------------------------------
       Önce tüm "==" denklemlerinde iki değişkeni birleştir.
       Sonra her "!=" denkleminde iki değişkenin root'u aynıysa çelişki var: false.
    */
    /*  Complexity
        Time  : O(n * α(26))
        Space : O(1) (26 değişken)
    */

    private int[] p;

    public boolean equationsPossible(String[] equations) {
        p = new int[26];
        for (int i = 0; i < 26; ++i) {
            p[i] = i;
        }
        for (String e : equations) {
            int a = e.charAt(0) - 'a', b = e.charAt(3) - 'a';
            if (e.charAt(1) == '=') {
                p[find(a)] = find(b);
            }
        }
        for (String e : equations) {
            int a = e.charAt(0) - 'a', b = e.charAt(3) - 'a';
            if (e.charAt(1) == '!' && find(a) == find(b)) {
                return false;
            }
        }
        return true;
    }

    private int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }
}
