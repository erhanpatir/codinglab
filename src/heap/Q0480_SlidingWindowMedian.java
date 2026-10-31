package heap;

import java.util.*;

public class Q0480_SlidingWindowMedian {
    // Öncelik   : 🟡 Orta
    // Şirketler : Meta (#92)
    //
    // 480. Sliding Window Median - Hard
    // https://leetcode.com/problems/sliding-window-median/

    /* ------------------------------------------------------------
       | PATTERN: Heap - Two Heaps + Sliding Window (lazy delete)
       ------------------------------------------------------------
       Pencerenin sol yarısı max-heap, sağ yarısı min-heap. Pencere kayınca çıkan eleman hemen silinmez,
       "silinecekler" map'ine yazılır ve ilgili heap'in tepesine geldiğinde atılır (lazy deletion).
       Heap'lerin geçerli eleman sayıları dengede tutulur; medyan iki tepeden hesaplanır.
    */
    /*  Complexity
        Time  : O(n log n)
        Space : O(n)
    */

    public static double[] medianSlidingWindow(int[] nums, int k) {
        MedianFinder finder = new MedianFinder(k);
        for (int i = 0; i < k; ++i) {
            finder.addNum(nums[i]);
        }
        int n = nums.length;
        double[] ans = new double[n - k + 1];
        ans[0] = finder.findMedian();
        for (int i = k; i < n; ++i) {
            finder.addNum(nums[i]);
            finder.removeNum(nums[i - k]);
            ans[i - k + 1] = finder.findMedian();
        }
        return ans;
    }

    static class MedianFinder {
        private PriorityQueue<Integer> small = new PriorityQueue<>(Comparator.reverseOrder());
        private PriorityQueue<Integer> large = new PriorityQueue<>();
        private Map<Integer, Integer> delayed = new HashMap<>();
        private int smallSize;
        private int largeSize;
        private int k;

        public MedianFinder(int k) {
            this.k = k;
        }

        public void addNum(int num) {
            if (small.isEmpty() || num <= small.peek()) {
                small.offer(num);
                ++smallSize;
            } else {
                large.offer(num);
                ++largeSize;
            }
            rebalance();
        }

        public double findMedian() {
            return (k & 1) == 1 ? small.peek() : ((double) small.peek() + large.peek()) / 2;
        }

        public void removeNum(int num) {
            delayed.merge(num, 1, Integer::sum);
            if (num <= small.peek()) {
                --smallSize;
                if (num == small.peek()) {
                    prune(small);
                }
            } else {
                --largeSize;
                if (num == large.peek()) {
                    prune(large);
                }
            }
            rebalance();
        }

        private void prune(PriorityQueue<Integer> pq) {
            while (!pq.isEmpty() && delayed.containsKey(pq.peek())) {
                if (delayed.merge(pq.peek(), -1, Integer::sum) == 0) {
                    delayed.remove(pq.peek());
                }
                pq.poll();
            }
        }

        private void rebalance() {
            if (smallSize > largeSize + 1) {
                large.offer(small.poll());
                --smallSize;
                ++largeSize;
                prune(small);
            } else if (smallSize < largeSize) {
                small.offer(large.poll());
                --largeSize;
                ++smallSize;
                prune(large);
            }
        }
    }
}
