package slidingwindow;

import java.util.*;

public class Q3413_MaximumCoinsFromKConsecutiveBags {
    // Öncelik   : ⭐ Gerçek deneyim
    // Şirketler : Amazon ✅ (#71)
    // Seviye    : Mid
    // Raporlar  : 1
    //             https://www.hellointerview.com/guides/amazon/l5
    //
    // 3413. Maximum Coins From K Consecutive Bags - Medium
    // https://leetcode.com/problems/maximum-coins-from-k-consecutive-bags/

    /* ------------------------------------------------------------
       | PATTERN: Sliding Window (segmentler üzerinde)
       ------------------------------------------------------------
       Segmentleri başlangıca göre sırala. Optimal pencere ya bir segmentin başında başlar ya da bir segmentin sonunda biter.
       İlk durum için her segment başlangıcında k uzunluğunda pencere aç, tamamen içerdeki segmentleri topla,
       kısmen giren son segmenti ekle. İkinci durum için ekseni ters çevirip aynı fonksiyonu kullan.
    */
    /*  Complexity
        Time  : O(n log n)
        Space : O(n)
    */

    public static long maximumCoins(int[][] coins, int k) {
        Arrays.sort(coins, (a, b) -> Integer.compare(a[0], b[0]));
        int n = coins.length;
        int[][] mirrored = new int[n][];
        for (int i = 0; i < n; i++) {
            int[] c = coins[n - 1 - i];
            mirrored[i] = new int[]{-c[1], -c[0], c[2]};
        }
        // Pencere ya bir segmentin başında başlar ya da bir segmentin sonunda biter.
        // İkinci durumu, ekseni ters çevirip aynı fonksiyonla çözüyoruz.
        return Math.max(windowStartingAtSegmentStart(coins, k), windowStartingAtSegmentStart(mirrored, k));
    }

    private static long windowStartingAtSegmentStart(int[][] coins, int k) {
        long best = 0, fullSum = 0;
        int j = 0;
        for (int i = 0; i < coins.length; i++) {
            long right = (long) coins[i][0] + k - 1;
            while (j < coins.length && coins[j][1] <= right) {
                fullSum += (long) (coins[j][1] - coins[j][0] + 1) * coins[j][2];
                j++;
            }
            long partial = 0;
            if (j < coins.length && coins[j][0] <= right) {
                partial = (right - coins[j][0] + 1) * coins[j][2];
            }
            best = Math.max(best, fullSum + partial);
            if (j > i) {
                fullSum -= (long) (coins[i][1] - coins[i][0] + 1) * coins[i][2];
            } else {
                j = i + 1;
            }
        }
        return best;
    }
}
