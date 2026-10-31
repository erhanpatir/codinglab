package design;

import java.util.*;

public class Q0362_DesignHitCounter {
    // 362. Design Hit Counter - Medium
    // https://leetcode.com/problems/design-hit-counter/

    /* ------------------------------------------------------------
       | PATTERN: Design - Binary Search (zaman damgaları listesi)
       ------------------------------------------------------------
       hit: zaman damgasını listeye ekle (artan sırayla gelir).
       getHits: timestamp - 299'dan büyük ya da eşit ilk indeksi binary search ile bul; cevap = boyut - indeks.
       Takip: 300 hücrelik dairesel dizi ile O(1) bellek.
    */
    /*  Complexity
        Time  : hit O(1), getHits O(log n)
        Space : O(n)
    */

    public class HitCounter {
        private List<Integer> ts = new ArrayList<>();

        public HitCounter() {
        }

        public void hit(int timestamp) {
            ts.add(timestamp);
        }

        public int getHits(int timestamp) {
            int l = search(timestamp - 300 + 1);
            return ts.size() - l;
        }

        private int search(int x) {
            int l = 0, r = ts.size();
            while (l < r) {
                int mid = (l + r) >> 1;
                if (ts.get(mid) >= x) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            return l;
        }
    }
}
