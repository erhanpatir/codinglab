package dynamicprogramming.lis;

import java.util.Arrays;

public class Q0673_NumberOfLongestIncreasingSubsequence {
    // 673. Number of Longest Increasing Subsequence - Medium
    // https://leetcode.com/problems/number-of-longest-increasing-subsequence/

    /*  ------------------------------------------------------
        | PATTERN: Sequence DP                               |
        ------------------------------------------------------
        Her index için şu soruyu sor:
            “Bu index’te biten en uzun increasing subsequence kaç?”

        State
        Length DP
            length[i] = i index’inde biten LIS uzunluğu
        Count DP
            count[i] = i index’inde biten LIS sayısı

        Transition
        Her j < i için:
            if nums[j] < nums[i]
        ise nums[i], j’de biten subsequence’i uzatabilir.
    */
    /* Complexity
        Time  : O(n²)
        Space : O(n)
    */
    public static int findNumberOfLIS(int[] nums) {
        int n = nums.length;

        int[] length = new int[n];
        int[] count  = new int[n];

        Arrays.fill(length, 1);
        Arrays.fill(count, 1);

        int maxLength = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (length[j] + 1 > length[i]) {       // CASE 1 — Daha uzun subsequence bulduk

                        // Çünkü artık yeni en iyi subsequence bulundu.
                        length[i] = length[j] + 1;
                        count[i] = count[j]; // Eski count çöpe gider.

                    } else if (length[j] + 1 == length[i]) { // CASE 2 — Aynen uzun subsequence bulduk

                        count[i] += count[j];
                        // aynı LIS uzunluğunu oluşturan başka bir yol daha bulduk.
                    }
                }
            }
            maxLength = Math.max(maxLength, length[i]);
        }
        int answer = 0;

        for (int i = 0; i < n; i++) {
            if (length[i] == maxLength) {
                answer += count[i];
            }
        }
        return answer;
    }
}
