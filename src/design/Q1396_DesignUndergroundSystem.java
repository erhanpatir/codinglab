package design;

import java.util.*;

public class Q1396_DesignUndergroundSystem {
    // Öncelik   : 🔴 Yüksek
    // Şirketler : Bloomberg ✅ (#28)
    //
    // 1396. Design Underground System - Medium
    // https://leetcode.com/problems/design-underground-system/

    /* ------------------------------------------------------------
       | PATTERN: Design - Hash Map (check-in ve rota istatistikleri)
       ------------------------------------------------------------
       Kullanıcı id -> (istasyon, zaman) map'i tut. checkOut'ta yolculuk süresini hesapla,
       "başlangıç-bitiş" anahtarlı map'te (toplam süre, yolculuk sayısı) güncelle.
       getAverageTime toplam / sayı.
    */
    /*  Complexity
        Time  : O(1) her işlem
        Space : O(n)
    */

    public class UndergroundSystem {
        private Map<Integer, Integer> ts = new HashMap<>();
        private Map<Integer, String> names = new HashMap<>();
        private Map<String, int[]> d = new HashMap<>();

        public UndergroundSystem() {
        }

        public void checkIn(int id, String stationName, int t) {
            ts.put(id, t);
            names.put(id, stationName);
        }

        public void checkOut(int id, String stationName, int t) {
            String key = names.get(id) + "-" + stationName;
            int[] v = d.getOrDefault(key, new int[2]);
            v[0] += t - ts.get(id);
            v[1]++;
            d.put(key, v);
        }

        public double getAverageTime(String startStation, String endStation) {
            String key = startStation + "-" + endStation;
            int[] v = d.get(key);
            return (double) v[0] / v[1];
        }
    }
}
