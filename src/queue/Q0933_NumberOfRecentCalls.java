package queue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Q0933_NumberOfRecentCalls {
    // 933. Number of Recent Calls - Easy
    // https://leetcode.com/problems/number-of-recent-calls/description/
    /* ------------------------------------------------------------
       | PATTERN:              Queue                            ✅|
       ------------------------------------------------------------
    /* ⭐Optimal pattern
            Burada ihtiyacımız olan şey:
            Sadece son 3000 ms içindeki request’leri tutmak.
            Eski request’ler bir daha asla lazım olmayacak.
            Çünkü zaman t artarak geliyor.

            ⭐ Bu yüzden FIFO mantığı çok uygun:
                    En eski request başta durur.
                    Aralıktan çıktıysa queue’dan atılır.
                    Yeni request sona eklenir.

            Yani burada veri yapısı: QUEUE
     */
    /*  Complexity
            Time per ping: Amortized O(1)
            Space: O(n)
    */
    public class RecentCounter {
        private Queue<Integer> queue;

        public RecentCounter() {
            queue = new ArrayDeque<>();
        }

        public int ping(int t) {
            queue.offer(t);

            while (!queue.isEmpty() && queue.peek() < t - 3000) {
                queue.poll();
            }

            return queue.size();
        }
    }

    /*
     * Your RecentCounter object will be instantiated and called as such:
     * RecentCounter obj = new RecentCounter();
     * int param_1 = obj.ping(t);
     */
}
