package arrays.slidingwindow;

public class Q0643_MaximumAverageSubarray1 {
    // 643. Maximum Average Subarray I - Easy
    // https://leetcode.com/problems/maximum-average-subarray-i/
    // --------------------------------------------
    // |PATTERN: Fixed Size Sliding Window      ✅|
    // --------------------------------------------
    /*
        Window size sabit: k

        İlk k elemanın sum’ını hesapla.
        Sonra window’u sağa kaydırırken:
            yeni gelen elemanı ekle
            çıkan elemanı çıkar

        Yani her window için tekrar baştan toplama yok.

        3. State / Invariant
        State:
            windowSum
            maxSum

        Invariant:
            windowSum her zaman son k elemanın toplamını temsil eder.

        Kaydırma kuralı:
            windowSum += nums[right]
            windowSum -= nums[right - k]
    */
    /* Complexity Analysis
        Time:  O(n)
        Space: O(1)
    */
    public static double findMaxAverage (int[] nums, int k) {
        int windowSum = 0;

        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }

        int maxSum = windowSum;

        for (int right = k; right < nums.length; right++) {
            windowSum += nums[right];
            windowSum -= nums[right - k];

            maxSum = Math.max(maxSum, windowSum);
        }

        return (double) maxSum / k;
    }
}
