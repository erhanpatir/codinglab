package arrays.prefixsum;

import java.util.HashMap;
import java.util.Map;

public class Q0560_SubarraySumEqualsK {
    // 560. Subarray Sum Equals K - Medium
    // https://leetcode.com/problems/subarray-sum-equals-k/
    // --------------------------------------------
    // |     PATTERN: Prefix Sum + HashMap      ✅|
    // --------------------------------------------
    /*
       Prefix sum şu demek
        prefixSum = şu ana kadar gördüğüm toplam
       Bir subarray toplamı k ise:
        currentPrefix - previousPrefix = k

       Buradan:
        previousPrefix = currentPrefix - k
       Yani her index’te şunu soruyoruz:
        Daha önce currentPrefix - k prefix sum’ı kaç kere gördüm?
       Cevap kadar subarray vardır.

       3. State / Invariant
       State:
        prefixSum
        count
        Map<prefixSum, frequency>

       Invariant:
        Map, şu ana kadar gördüğümüz prefix sum değerlerinin kaç kere geçtiğini tutar.
       Başlangıç çok önemli:
        map.put(0, 1);

       Bu şu demek:
        Array başlamadan önce prefix sum 0 bir kere vardır.
       Bu sayede index 0’dan başlayan subarray’leri de yakalarız.
    */
    /* Complexity Analysis
        Time: O(n)
        Space: O(n)
    */
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixFrequency = new HashMap<>(); // frequencies of prefix sums

        prefixFrequency.put(0, 1);

        int prefixSum = 0;
        int count = 0;

        for (int num : nums) {
            prefixSum += num;
            // there must be a previous prefix sum equal to currentPrefix - k.
            int needed = prefixSum - k;

            count += prefixFrequency.getOrDefault(needed, 0);

            prefixFrequency.put(
                    prefixSum,
                    prefixFrequency.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}

