package heap;

import java.util.*;

public class Q0295_FindMedianFromDataStream {
    // 295. Find Median from Data Stream - Hard
    // https://leetcode.com/problems/find-median-from-data-stream/

    /* ------------------------------------------------------------
       | PATTERN: Heap - Two Heaps (max-heap + min-heap)
       ------------------------------------------------------------
       Sol yarı max-heap'te, sağ yarı min-heap'te. Her ekleme max-heap'e girip tepedekini min-heap'e geçirir,
       boyutlar en fazla 1 farklı olacak şekilde dengelenir.
       Medyan: boyutlar eşitse iki tepenin ortalaması, değilse büyük heap'in tepesi.
    */
    /*  Complexity
        Time  : addNum O(log n), findMedian O(1)
        Space : O(n)
    */

    public class MedianFinder {
        private PriorityQueue<Integer> minQ = new PriorityQueue<>();
        private PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());

        public MedianFinder() {
        }

        public void addNum(int num) {
            maxQ.offer(num);
            minQ.offer(maxQ.poll());
            if (minQ.size() - maxQ.size() > 1) {
                maxQ.offer(minQ.poll());
            }
        }

        public double findMedian() {
            return minQ.size() == maxQ.size() ? (minQ.peek() + maxQ.peek()) / 2.0 : minQ.peek();
        }
    }
}
