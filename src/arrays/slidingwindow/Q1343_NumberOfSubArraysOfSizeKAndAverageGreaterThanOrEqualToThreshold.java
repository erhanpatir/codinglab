package arrays.slidingwindow;

public class Q1343_NumberOfSubArraysOfSizeKAndAverageGreaterThanOrEqualToThreshold {
    // 1343. Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold - Medium
    // https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/
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
    public static int numOfSubarrays(int[] arr, int k, int threshold) {
        int minSum = k * threshold;

        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        int subArrayCount = windowSum >= minSum ? 1 : 0;

        for (int i = k; i < arr.length; i++) {
            windowSum = windowSum - arr[i - k] + arr[i];
            if (windowSum >= minSum) subArrayCount++;
        }

        return subArrayCount;
    }
}
