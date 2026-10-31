package greedy;

import java.util.*;

public class Q1029_TwoCityScheduling {
    // Öncelik   : 🔴 Yüksek
    // Şirketler : Bloomberg ✅ (#82)
    //
    // 1029. Two City Scheduling - Medium
    // https://leetcode.com/problems/two-city-scheduling/

    /* ------------------------------------------------------------
       | PATTERN: Greedy (fark sıralaması)
       ------------------------------------------------------------
       Herkesi önce B şehrine gönderdiğini düşün; birini A'ya almak costA - costB kadar maliyet değiştirir.
       Kişileri (costA - costB) değerine göre sırala: ilk n kişi A'ya, kalan n kişi B'ye.
    */
    /*  Complexity
        Time  : O(n log n)
        Space : O(log n)
    */

    public static int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a, b) -> { return a[0] - a[1] - (b[0] - b[1]); });
        int ans = 0;
        int n = costs.length >> 1;
        for (int i = 0; i < n; ++i) {
            ans += costs[i][0] + costs[i + n][1];
        }
        return ans;
    }
}
