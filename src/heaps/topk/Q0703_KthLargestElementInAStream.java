package heaps.topk;

import java.util.PriorityQueue;

public class Q0703_KthLargestElementInAStream {
    // 703. Kth Largest Element in a Stream - Easy
    // https://leetcode.com/problems/kth-largest-element-in-a-stream/
    // ------------------------------------------------------
    // | PATTERN: Min Heap of Size K                      ✅|
    // ------------------------------------------------------
    /*
        Biz bütün sayıları tutmak zorunda değiliz.
        Sadece en büyük k sayıyı tutarsak yeter.
        Min heap içinde:
            şu ana kadarki en büyük k eleman bulunur.

        Min heap’in tepesi:
        bu k eleman içindeki en küçük olur.

        Bu da genel stream’de: kth largest demektir.
    */
    /*
        Constructor’da n eleman eklersek: O(n log k)
        Her add: O(log k)
        Space: O(k)
    */

    private final int k;
    private final PriorityQueue<Integer> minHeap;

    public Q0703_KthLargestElementInAStream(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>((a, b) -> a - b);

        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        minHeap.offer(val);
        if (minHeap.size() > k) {
            minHeap.poll();
        }
        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */