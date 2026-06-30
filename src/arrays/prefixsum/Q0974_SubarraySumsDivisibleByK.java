package arrays.prefixsum;

import java.util.HashMap;
import java.util.Map;

public class Q0974_SubarraySumsDivisibleByK {
    // 974. Subarray Sums Divisible by K - Medium
    // https://leetcode.com/problems/subarray-sums-divisible-by-k/
    /* ------------------------------------------
       | PATTERN: Prefix Sum + Modulo         ✅|
       ------------------------------------------

    */
    /* Complexity Analysis
        Time: O(n)
        Space: O(min(n, k))
    */
    public static int subarraysDivByK(int[] nums, int k) {
        // <remainder, frequency>
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        frequencyMap.put(0, 1);

        int count = 0;
        int prefixSum = 0;

        for (Integer num : nums) {
            prefixSum += num;

            int remainder = ((prefixSum % k) + k) % k;

            // remainder varsa, onun frequency’sini al, count'a ekle
            count += frequencyMap.getOrDefault(remainder, 0);

            // yoksa ekle, varsa +1 ekle
            frequencyMap.put(remainder,
                    frequencyMap.getOrDefault(remainder, 0) + 1);

        }
        return count;
    }
}

