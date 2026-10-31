package design;

import java.util.*;

public class Q2502_DesignMemoryAllocator {
    // Öncelik   : 🔵 Trend
    // Şirketler : Apple ✅ (#110)
    //
    // 2502. Design Memory Allocator - Medium
    // https://leetcode.com/problems/design-memory-allocator/

    /* ------------------------------------------------------------
       | PATTERN: Design - Dizi Simülasyonu
       ------------------------------------------------------------
       Belleği bir dizi olarak tut (0 boş, değilse mID). allocate: soldan ardışık size kadar boş hücre ara,
       ilk bulunan bloğu mID ile doldur. freeMemory: mID'ye ait tüm hücreleri boşalt ve sayısını döndür.
    */
    /*  Complexity
        Time  : O(n) her işlem
        Space : O(n)
    */

    public class Allocator {
        private int[] m;

        public Allocator(int n) {
            m = new int[n];
        }

        public int allocate(int size, int mID) {
            int cnt = 0;
            for (int i = 0; i < m.length; ++i) {
                if (m[i] > 0) {
                    cnt = 0;
                } else if (++cnt == size) {
                    Arrays.fill(m, i - size + 1, i + 1, mID);
                    return i - size + 1;
                }
            }
            return -1;
        }

        public int freeMemory(int mID) {
            int ans = 0;
            for (int i = 0; i < m.length; ++i) {
                if (m[i] == mID) {
                    m[i] = 0;
                    ++ans;
                }
            }
            return ans;
        }
    }
}
