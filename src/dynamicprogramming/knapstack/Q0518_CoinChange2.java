package dynamicprogramming.knapstack;

public class Q0518_CoinChange2 {
    // 518. Coin Change 2 - Medium
    // https://leetcode.com/problems/coin-change-2/

     /* ----------------------------------------------------
        | PATTERN: Unbounded Knapsack + Count Combinations |
        ----------------------------------------------------
        State: dp[a] = a amount’unu yapmanın kombinasyon sayısı

        Transition
            Her coin için amount’ları dolaşırız:

            for coin in coins:
                for a from coin to amount:
                    dp[a] += dp[a - coin]

        Anlamı:
            a amount’unu coin kullanarak yapmak istiyorsam,
            önce a - coin amount’unu yapmış olmalıyım.
    */

    /* Complexity
        Diyelim:
            A = amount
            C = coins.length

        Time: O(A * C)
            Her coin için amount’ları dolaşıyoruz.
        Space: O(A)
            Tek DP array tutuyoruz.
    */
    public static int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1; // base case

        // Coin’i dış loop yapınca, coin’leri belirli bir sırayla işlersin
        // ve aynı kombinasyonu farklı sırayla tekrar saymazsın.
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }

        return dp[amount];
    }

    /* Dry run
        amount = 5
        coins = [1, 2, 5]

        Başlangıç:
            dp = [1, 0, 0, 0, 0, 0]

        Coin = 1 sonrası:
            dp = [1, 1, 1, 1, 1, 1]

        Her amount sadece 1’lerle yapılabilir.

        Coin = 2 sonrası:
            a = 2 → dp[2] += dp[0] → 1 + 1 = 2
            a = 3 → dp[3] += dp[1] → 1 + 1 = 2
            a = 4 → dp[4] += dp[2] → 1 + 2 = 3
            a = 5 → dp[5] += dp[3] → 1 + 2 = 3
            dp = [1, 1, 2, 2, 3, 3]

        Coin = 5 sonrası:
            a = 5 → dp[5] += dp[0] → 3 + 1 = 4

        Final: dp = [1, 1, 2, 2, 3, 4]
        Cevap: 4
    */
}
