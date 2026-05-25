package arrays.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q0001_TwoSum {
    // 1. Two Sum - Easy
    // https://leetcode.com/problems/two-sum/

    // ------------------------------------------------------
    // | PATTERN: Hashing                                    |
    // ------------------------------------------------------
    /* 2. Optimal Pattern

        ***** HashMap ile complement lookup *****

        Şunu düşünüyoruz:
            target = 9
            current = 7

            ihtiyacım olan sayı:
            9 - 7 = 2

        Yani:
        Her sayı için:
            complement = target - current
        diyoruz.

        Sonra:
            “Bu complement daha önce görüldü mü?”
        diye hashmap’te kontrol ediyoruz.

        HashMap:
            value -> index
        tutuyor.
    */

    /* Optimal
        Time: O(n)
        Space: O(n)

       Çünkü:
        array’i bir kez geziyoruz
        hashmap lookup O(1)
    */
    public int[] twoSum(int[] nums, int target) {
        // HashMap her zaman daha önce gördüğüm sayıların indexlerini tutar.
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            map.put(nums[i], i);
        }

        return new int[] {};
    }
}
