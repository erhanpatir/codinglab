package arrays.prefixsum;

import java.util.HashMap;
import java.util.Map;

public class Q0525_ContiguousArray {
    // 525. Contiguous Array - Medium
    // https://leetcode.com/problems/contiguous-array/
    // --------------------------------------------
    // | PATTERN: Prefix Sum + Balance Trick    ✅|
    // --------------------------------------------
    /*
       Buradaki trick şu:
        0 -> -1
        1 -> +1

       O zaman eşit sayıda 0 ve 1 olan subarray’in toplamı: 0
       Çünkü:
        0,1  -> -1 + 1 = 0
        0,1,1,0 -> -1 + 1 + 1 -1 = 0

       Yani soru şuna dönüşüyor:
        Prefix balance aynı değere tekrar gelirse, aradaki subarray balanced’dır.

        3. State / Invariant
        State:
            balance
            Map<balance, firstIndex>
            maxLength

        Invariant:
            Aynı balance değeri iki farklı index’te görülürse, aradaki subarray’de 0 ve 1 sayısı eşittir.

        Başlangıç:
            map.put(0, -1);
        Bu önemli.
        Çünkü array başından başlayan balanced subarray’leri yakalar.
    */
    /* Complexity Analysis
        Time: O(n)
        Space: O(n)
    */
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> firstSeen = new HashMap<>();
        firstSeen.put(0, -1);

        int balance = 0;
        int maxLength = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                balance--;
            } else {
                balance++;
            }

            if (firstSeen.containsKey(balance)) {
                int previousIndex = firstSeen.get(balance);
                maxLength = Math.max(maxLength, i - previousIndex);
            } else {
                firstSeen.put(balance, i);
            }
        }

        return maxLength;
    }
    /* 4. Görselli Dry Run
            Daha büyük görsel

                nums:      [0, 1, 1, 0, 1, 0, 0]
                value:     -1 +1 +1 -1 +1 -1 -1
                balance: 0 -1  0  1  0  1  0 -1
                index:   -1  0  1  2  3  4  5  6

            Aynı balance tekrar edince arası balanced:

            balance 0:
            first index = -1
            again at index 5

            length = 5 - (-1) = 6
            subarray = [0,1,1,0,1,0]

            Bu subarray’de:

            0 sayısı = 3
            1 sayısı = 3
    */
}

