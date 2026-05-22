package dynamicprogramming.knapstack;

import java.util.Arrays;

public class Q0322_CoinChange1 {
    // 322. Coin Change - Medium
    // https://leetcode.com/problems/coin-change/

    /*  -------------------------------------------
        | PATTERN: Unbounded Knapsack / Amount DP |
        -------------------------------------------
        State: dp[a] = a amount’unu yapmak için gereken minimum coin sayısı
        Transition
            Bir amount a için her coin’i denersin.
            Eğer coin <= a ise:
                dp[a] = min(dp[a], dp[a - coin] + 1)
        Neden?
            Çünkü:
                a = (a - coin) + coin
                Yani önce a - coin amount’unu yapmış oluyorsun, sonra 1 coin daha ekliyorsun.
    */

    /* Complexity
        Diyelim:
            A = amount, C = coins.length

        Time: O(A * C)
            Her amount için tüm coin’leri deniyoruz.
        Space: O(A)
            amount + 1 boyutunda DP array tutuyoruz.
        */
    public static int coinChange(int[] coins, int amount) {
        int impossible = amount + 1; // impossible marker

        int[] dp = new int[amount + 1]; // her amount için minimum coin sayısını saklıyoruz.
        Arrays.fill(dp, impossible);

        dp[0] = 0; // base case

        for (int a = 1; a <= amount; a++) {
            for (int coin : coins) {
                if (coin <= a) {
                    // transition
                    dp[a] = Math.min(dp[a], dp[a - coin] + 1);
                }
            }
        }

        return dp[amount] == impossible ? -1 : dp[amount];
    }

    /* Dry run
        coins = [1, 2, 5]
        amount = 11

       Başlangıç:

        dp[0] = 0
        dp[1..11] = INF

       Bazı değerler:

        dp[1] = 1        // 1
        dp[2] = 1        // 2
        dp[3] = 2        // 2 + 1
        dp[4] = 2        // 2 + 2
        dp[5] = 1        // 5
        dp[6] = 2        // 5 + 1
        ...
        dp[11] = 3       // 5 + 5 + 1

       Cevap:
        3
    */
}
