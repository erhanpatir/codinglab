package dynamicprogramming.knapsack;

public class Q0474_OnesAndZeroes {
    // 474. Ones and Zeroes - Medium
    // https://leetcode.com/problems/ones-and-zeroes/

    /*  ------------------------------------------------------
        | PATTERN: Multi-dimensional 0/1 Knapsack            |
        ------------------------------------------------------
        State:
            dp[z][o] = z zero ve o one kullanarak seçebileceğim maksimum string sayısı

        Transition
        Eğer current string’i alırsam:
        dp[z][o] = max(
            dp[z][o],
            dp[z - zeros][o - ones] + 1
        )

        Anlamı:
            “Bu string’i almazsam mevcut sonuç dp[z][o].
             Bu string’i alırsam, bu string’in harcadığı zero/one kapasitesini düşerim,
             kalan kapasitedeki en iyi sonuca +1 eklerim. Hangisi büyükse onu tutarım.”
    */
    /* Complexity
        Diyelim:
            S = strs.length
            M = m
            N = n

        Time: O(S * M * N)
            Her string için tüm capacity grid’ini geziyoruz.

        Space: O(M * N)
            2D DP array tutuyoruz.
    */

    public static int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for (String str : strs) {
            int zeros = 0;
            int ones = 0;

            for (char c : str.toCharArray()) {
                if (c == '0') {
                    zeros++;
                } else {
                    ones++;
                }
            }

            /* Neden reverse loop şart?
                Çünkü her string sadece 1 kez kullanılabilir.
                Mesela "0" işlerken forward loop yapsaydın, aynı "0"ı aynı turda tekrar kullanma riski olurdu.

                0/1 knapsack’ta kural:
                    Her item bir kez kullanılacaksa capacity reverse dönülür.

                Unbounded knapsack’ta:
                    Item tekrar tekrar kullanılabiliyorsa forward dönülür.
            */
            for (int z = m; z >= zeros; z--) {
                for (int o = n; o >= ones; o--) {
                    dp[z][o] = Math.max(dp[z][o], dp[z - zeros][o - ones] + 1); // transition
                }
            }
        }
        return dp[m][n]; // the size of the largest subset
    }
}
