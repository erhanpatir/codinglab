package hashing;

import java.util.*;

public class Q0659_SplitArrayIntoConsecutiveSubsequences {
    // 659. Split Array into Consecutive Subsequences - Medium
    // https://leetcode.com/problems/split-array-into-consecutive-subsequences/

    /* ------------------------------------------------------------
       | PATTERN: Hash Map + Heap (greedy uzatma)
       ------------------------------------------------------------
       Her değer için "bu değerde biten alt dizilerin uzunlukları" min-heap'te tutulur.
       Yeni v gelince v-1'de biten en kısa diziyi uzat (heap'ten al, +1 ile v'ye ekle);
       yoksa v ile yeni dizi başlat. Sonunda uzunluğu 3'ten küçük dizi kalmamalı.
    */
    /*  Complexity
        Time  : O(n log n)
        Space : O(n)
    */

    public static boolean isPossible(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> d = new HashMap<>();
        for (int v : nums) {
            if (d.containsKey(v - 1)) {
                var q = d.get(v - 1);
                d.computeIfAbsent(v, k -> new PriorityQueue<>()).offer(q.poll() + 1);
                if (q.isEmpty()) {
                    d.remove(v - 1);
                }
            } else {
                d.computeIfAbsent(v, k -> new PriorityQueue<>()).offer(1);
            }
        }
        for (var v : d.values()) {
            if (v.peek() < 3) {
                return false;
            }
        }
        return true;
    }
}
