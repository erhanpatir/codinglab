package dynamicprogramming.lis;

import java.util.Arrays;

public class Q0354_RussianDollEnvelopes {
    // 354. Russian Doll Envelopes - Hard
    // https://leetcode.com/problems/russian-doll-envelopes/

    /*  ------------------------------------------------------
        | PATTERN: LIS reduction                             |
        ------------------------------------------------------
           Neden width aynıysa height descending?

           Bu en önemli kısım.
           Eğer width aynı olanları height ascending sıralarsan:
                [6,4], [6,7]
           height LIS bunları artan sanıp ikisini de seçebilir.
           Ama bu yanlış çünkü width eşit:
                6 < 6 false
           İç içe giremezler.
           Bu yüzden aynı width için height descending yaparız:
                [6,7], [6,4]
           Böylece height üzerinde increasing LIS bunları birlikte seçemez.
    */
    /* Complexity
        Time  : O(n²)
        Space : O(n)
    */
    public static int maxEnvelopes_DP(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1]; // if width equal, height descending
            }
            return a[0] - b[0];
        });

        int n = envelopes.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int answer = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[j][1] < envelopes[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            answer = Math.max(answer, dp[i]);
        }
        return answer;
    }

    /* Complexity
        Time  : O(n log n)
        Space : O(n)
    */
    public static int maxEnvelopes_binarysearch_LIS(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1]; // if width equal, height descending
            }
            return a[0] - b[0];
        });

        // uzunluğu i+1 olan increasing subsequence’lerin mümkün olan en küçük tail değeri
        int[] tails = new int[envelopes.length];
        int size = 0;

        for (int[] envelope : envelopes) {
            int height = envelope[1];

            int left = 0;
            int right = size;

            while (left < right) {
                int mid = left + (right - left) / 2;

                if (tails[mid] < height) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            tails[left] = height;

            if (left == size) {
                size++;
            }
        }
        return size;
    }
}
