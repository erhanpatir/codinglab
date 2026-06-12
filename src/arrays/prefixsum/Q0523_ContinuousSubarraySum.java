package arrays.prefixsum;

import java.util.HashMap;
import java.util.Map;

public class Q0523_ContinuousSubarraySum {
    // 523. Continuous Subarray Sum - Medium
    // https://leetcode.com/problems/continuous-subarray-sum/
    /* -------------------------------------------------------
       | PATTERN: Prefix Sum + Remainder Frequency         ✅|
       -------------------------------------------------------
        Bir subarray toplamı:
            prefix[j] - prefix[i]

        Eğer bu toplam k’ye bölünüyorsa:
            (prefix[j] - prefix[i]) % k == 0

        Bu şu demek:
            prefix[j] % k == prefix[i] % k

        Yani:
            Aynı remainder tekrar görülürse, aradaki subarray toplamı k’nin katıdır.

        3. State / Invariant
        State:
            prefixSum
            remainder
            Map<remainder, firstIndex>

        Invariant:
            Aynı remainder iki farklı index’te görülürse, aradaki subarray sum k’nin katıdır.

        Başlangıç yine önemli:
            map.put(0, -1);

        Bu, array başından başlayan subarray’leri yakalar.
        Ama burada ekstra şart var:
            subarray length >= 2

        Yani:
            i - previousIndex >= 2 olmalı.
      */
    /* Complexity Analysis
        Time: O(n)
        Space: O(min(n, k))
    */
    public boolean checkSubarraySum(int[] nums, int k) {
        // <remainder, firstIndex>
        Map<Integer, Integer> firstSeen = new HashMap<>();

        firstSeen.put(0, -1);

        int prefixSum = 0;

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            int remainder = prefixSum % k;

            // Aynı remainder iki farklı index’te görülürse, aradaki subarray sum k’nin katıdır.
            if (firstSeen.containsKey(remainder)) { // same remainder
                int previousIndex = firstSeen.get(remainder);

                if (i - previousIndex >= 2) { // at least two
                    return true;
                }
            } else {
                firstSeen.put(remainder, i);
            }
        }

        return false;
    }
     /*
        4. Görselli Dry Run

            nums = [23,2,4,6,7]
            k = 6

            Tablo:
                i      num   prefixSum   remainder
               -1       -      0           0
                0       23     23          5
                1       2      25          1
                2       4      29          5

        Başlangıç:
        remainder 0 -> index -1
            i = 0
            prefixSum = 23
            remainder = 23 % 6 = 5

        Remainder 5 ilk kez görüldü:
        map:
            0 -> -1
            5 -> 0
        i = 1
            prefixSum = 25
            remainder = 25 % 6 = 1

        Remainder 1 ilk kez görüldü:
        map:
            0 -> -1
            5 -> 0
            1 -> 1
        i = 2
            prefixSum = 29
            remainder = 29 % 6 = 5
        Remainder 5 daha önce index 0’da görülmüştü.

        Aradaki subarray: index 1..2 = [2,4]

        Length:
            2 - 0 = 2

        Sum:
            2 + 4 = 6
            6 % 6 = 0

        Return: true

        Küçük Görsel
        prefix remainder:
            index:       -1    0    1    2
            prefix:       0   23   25   29
            rem % 6:      0    5    1    5
                                ^         ^
                              same remainder

        Aynı remainder:
            prefix[2] % 6 == prefix[0] % 6

        Demek ki aradaki toplam: prefix[2] - prefix[0] 6’ya bölünür.

        Aradaki elemanlar: nums[1..2] = [2,4]
    */
}

