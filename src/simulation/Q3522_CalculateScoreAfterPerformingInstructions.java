package simulation;

import java.util.*;

public class Q3522_CalculateScoreAfterPerformingInstructions {
    // 3522. Calculate Score After Performing Instructions - Medium
    // https://leetcode.com/problems/calculate-score-after-performing-instructions/

    /* ------------------------------------------------------------
       | PATTERN: Simülasyon (ziyaret işaretleme)
       ------------------------------------------------------------
       i'den başla; "add" ise puanı ekle ve bir ilerle, "jump" ise values[i] kadar zıpla.
       Dizi dışına çıkınca ya da aynı talimata ikinci kez gelince dur.
    */
    /*  Complexity
        Time  : O(n)
        Space : O(n)
    */

    public static long calculateScore(String[] instructions, int[] values) {
        int n = values.length;
        boolean[] vis = new boolean[n];
        long ans = 0;
        int i = 0;

        while (i >= 0 && i < n && !vis[i]) {
            vis[i] = true;
            if (instructions[i].charAt(0) == 'a') {
                ans += values[i];
                i += 1;
            } else {
                i = i + values[i];
            }
        }

        return ans;
    }
}
