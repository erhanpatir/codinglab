package design;

import java.util.*;

public class Q0346_MovingAverageFromDataStream {
    // Öncelik   : ⭐ Gerçek deneyim
    // Şirketler : Meta (#40)
    // Seviye    : Senior, Staff
    // Raporlar  : 2 (1 📍London)
    //             https://leetcode.com/discuss/interview-experience/5351906/Meta-or-E5-or-London-or-Passed/
    //
    // 346. Moving Average from Data Stream - Easy
    // https://leetcode.com/problems/moving-average-from-data-stream/

    /* ------------------------------------------------------------
       | PATTERN: Design - Circular Array (sabit pencere)
       ------------------------------------------------------------
       size uzunlukta bir dizi ve toplam tut. Yeni değer, en eski değerin yerine yazılır (indeks % size);
       toplamdan eski değer çıkarılır, yenisi eklenir. Ortalama = toplam / min(eleman sayısı, size).
    */
    /*  Complexity
        Time  : O(1) her next
        Space : O(size)
    */

    public class MovingAverage {
        private int s;
        private int cnt;
        private int[] data;

        public MovingAverage(int size) {
            data = new int[size];
        }

        public double next(int val) {
            int i = cnt % data.length;
            s += val - data[i];
            data[i] = val;
            ++cnt;
            return s * 1.0 / Math.min(cnt, data.length);
        }
    }
}
