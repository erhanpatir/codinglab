package dp.state;

import java.util.*;

public class Q0403_FrogJump {
    // 403. Frog Jump - Hard
    // https://leetcode.com/problems/frog-jump/

    /* ------------------------------------------------------------
       | PATTERN: State DP - Memoization (konum, son zıplama)
       ------------------------------------------------------------
       dfs(i, k): i. taşa son zıplama k ile gelindi, sona ulaşılabilir mi?
       Bir sonraki zıplama k-1, k ya da k+1 olabilir; hedef konumda taş varsa (map ile kontrol) recursive devam et.
       Sonuçlar f[i][k] tablosunda saklanır.
    */
    /*  Complexity
        Time  : O(n^2)
        Space : O(n^2)
    */

    private Boolean[][] f;
    private Map<Integer, Integer> pos = new HashMap<>();
    private int[] stones;
    private int n;

    public boolean canCross(int[] stones) {
        n = stones.length;
        f = new Boolean[n][n];
        this.stones = stones;
        for (int i = 0; i < n; ++i) {
            pos.put(stones[i], i);
        }
        return dfs(0, 0);
    }

    private boolean dfs(int i, int k) {
        if (i == n - 1) {
            return true;
        }
        if (f[i][k] != null) {
            return f[i][k];
        }
        for (int j = k - 1; j <= k + 1; ++j) {
            if (j > 0) {
                int h = stones[i] + j;
                if (pos.containsKey(h) && dfs(pos.get(h), j)) {
                    return f[i][k] = true;
                }
            }
        }
        return f[i][k] = false;
    }
}
