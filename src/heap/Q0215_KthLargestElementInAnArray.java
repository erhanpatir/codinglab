package heap;

import java.util.*;

public class Q0215_KthLargestElementInAnArray {
    // Öncelik   : ⭐ Gerçek deneyim  ·  🌍 Ortak soru
    // Şirketler : Meta ✅, Google ✅, Amazon ✅, Apple, Bloomberg ✅
    // Seviye    : Mid, Senior
    // Raporlar  : 4 (2 📍London)
    //             https://leetcode.com/discuss/post/5501360/MetaorLondonorOnsite/
    //
    // 215. Kth Largest Element in an Array - Medium
    // https://leetcode.com/problems/kth-largest-element-in-an-array/

    /* ------------------------------------------------------------
       | PATTERN: Heap - Top K (size k min-heap)
       ------------------------------------------------------------
       Boyutu k olan bir min-heap tut; heap k'yı aşınca en küçüğü at.
       Sonunda heap'te en büyük k eleman kalır, tepedeki k. en büyüktür.
       Takip: Quickselect ile ortalama O(n) (worst O(n^2)), mülakatta genelde konuşulur.
    */
    /*  Complexity
        Time  : O(n log k)
        Space : O(k)
    */

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // en küçüğü at, heap'te en büyük k eleman kalsın
            }
        }
        return minHeap.peek();
    }
}
