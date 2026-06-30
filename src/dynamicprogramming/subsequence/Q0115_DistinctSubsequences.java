package dynamicprogramming.subsequence;

public class Q0115_DistinctSubsequences {
    // 115. Distinct Subsequences - Hard
    // https://leetcode.com/problems/distinct-subsequences/

    /*  ------------------------------------------------------
        | PATTERN: 2D String DP + counting                   |
        ------------------------------------------------------
           STATE
           dp[i][j] =
            s'nin ilk i karakterinden
            t'nin ilk j karakterini oluşturma sayısı
        ------------------------
           equal chars:
            use it OR skip it
           different chars:
            must skip
        ------------------------
        “Kullanma” neden şart?
            Çünkü aynı karakterin ileride başka kopyası olabilir.
            Mesela: s = "bbb", t = "bb"
            Kaç yol var? Cevap: 3
            Çünkü:
                1. b b b
                   ↑ ↑
                2. b b b
                   ↑   ↑
                3. b b b
                     ↑ ↑

            Eğer “kullanma” seçeneği olmasaydı:
            ilk b’yi seçince diğer kombinasyonları kaçırırdın.
            Kısacası
                “Kullanma” saçma değil, subsequence’in özü.
                Subsequence:
                karakter seçme / atlama özgürlüğü demek.
    */
    /* Complexity
        Time  : O(m * n)
        Space : O(m * n)
    */
    public static int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        long[][] dp = new long[m + 1][n + 1];

        // Boş string oluşturmanın her zaman 1 yolu vardır:
        // hiç karakter seçmemek, O yüzden ilk kolon hep 1.
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    // bütün olası subsequence seçimlerini saymak icin
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j]; // use or skip
                } else {
                    dp[i][j] = dp[i - 1][j]; // skip
                }
            }
        }
        return (int) dp[m][n];
        /* Final matrix
                    ""  b  b
            ""       1  0  0
            b        1  1  0
            a        1  1  0
            b        1  2  1
        */
    }
}
