package design;

import java.util.*;

public class Q0380_InsertDeleteGetRandomO1 {
    // Öncelik   : ⭐ Gerçek deneyim  ·  🌍 Ortak soru
    // Şirketler : Amazon ✅, Apple ✅, Bloomberg ✅
    // Raporlar  : 1
    //             https://www.vervecopilot.com/blog/apple-leetcode-interview-questions
    //
    // 380. Insert Delete GetRandom O(1) - Medium
    // https://leetcode.com/problems/insert-delete-getrandom-o1/

    /* ------------------------------------------------------------
       | PATTERN: Design - Hash Map + Dinamik Dizi
       ------------------------------------------------------------
       Map: değer -> dizideki indeks. Dizi rastgele seçim için.
       remove: silinecek elemanın yerine dizinin son elemanını koy, map'te o elemanın indeksini güncelle,
       sonra son elemanı sil. Böylece silme de O(1) olur.
    */
    /*  Complexity
        Time  : O(1) ortalama
        Space : O(n)
    */

    public class RandomizedSet {
        private Map<Integer, Integer> d = new HashMap<>();
        private List<Integer> q = new ArrayList<>();
        private Random rnd = new Random();

        public RandomizedSet() {
        }

        public boolean insert(int val) {
            if (d.containsKey(val)) {
                return false;
            }
            d.put(val, q.size());
            q.add(val);
            return true;
        }

        public boolean remove(int val) {
            if (!d.containsKey(val)) {
                return false;
            }
            int i = d.get(val);
            d.put(q.get(q.size() - 1), i);
            q.set(i, q.get(q.size() - 1));
            q.remove(q.size() - 1);
            d.remove(val);
            return true;
        }

        public int getRandom() {
            return q.get(rnd.nextInt(q.size()));
        }
    }
}
