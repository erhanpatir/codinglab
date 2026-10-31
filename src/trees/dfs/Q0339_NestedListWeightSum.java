package trees.dfs;

import common.model.NestedInteger;
import java.util.*;

public class Q0339_NestedListWeightSum {
    // Öncelik   : 🔴 Yüksek
    // Şirketler : Meta ✅ (#13)
    //
    // 339. Nested List Weight Sum - Medium
    // https://leetcode.com/problems/nested-list-weight-sum/

    /* ------------------------------------------------------------
       | PATTERN: DFS (iç içe yapı üzerinde)
       ------------------------------------------------------------
       dfs(liste, derinlik): tam sayıysa değer * derinlik ekle, liste ise derinlik + 1 ile recursive çağır.
    */
    /*  Complexity
        Time  : O(N) (toplam eleman)
        Space : O(D) (en derin seviye)
    */

    public static int depthSum(List<NestedInteger> nestedList) {
        return dfs(nestedList, 1);
    }

    private static int dfs(List<NestedInteger> nestedList, int depth) {
        int depthSum = 0;
        for (NestedInteger item : nestedList) {
            if (item.isInteger()) {
                depthSum += item.getInteger() * depth;
            } else {
                depthSum += dfs(item.getList(), depth + 1);
            }
        }
        return depthSum;
    }
}
