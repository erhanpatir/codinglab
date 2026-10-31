package math;

import java.util.*;

public class Q3625_CountNumberOfTrapezoidsII {
    // Öncelik   : 🟡 Orta
    // Şirketler : Google (#103)
    //
    // 3625. Count Number of Trapezoids II - Hard
    // https://leetcode.com/problems/count-number-of-trapezoids-ii/

    /* ------------------------------------------------------------
       | PATTERN: Math / Hash Map (eğim ve kesişim sayma)
       ------------------------------------------------------------
       Her nokta çiftinin oluşturduğu doğruyu (eğim, kesişim) olarak say. Aynı eğimli ama farklı doğrular üzerindeki
       segment çiftleri yamuk oluşturur. Paralelkenarlar iki kez sayıldığı için, aynı orta noktayı paylaşan
       segment çiftleri (köşegenler) üzerinden ayrıca sayılıp çıkarılır.
    */
    /*  Complexity
        Time  : O(n^2)
        Space : O(n^2)
    */

    public static int countTrapezoids(int[][] points) {
        int n = points.length;
        Map<Double, Map<Double, Integer>> cnt1 = new HashMap<>(n * n);
        Map<Integer, Map<Double, Integer>> cnt2 = new HashMap<>(n * n);

        for (int i = 0; i < n; ++i) {
            int x1 = points[i][0], y1 = points[i][1];
            for (int j = 0; j < i; ++j) {
                int x2 = points[j][0], y2 = points[j][1];
                int dx = x2 - x1, dy = y2 - y1;
                double k = dx == 0 ? Double.MAX_VALUE : 1.0 * dy / dx;
                double b = dx == 0 ? x1 : 1.0 * (y1 * dx - x1 * dy) / dx;
                if (k == -0.0) {
                    k = 0.0;
                }
                if (b == -0.0) {
                    b = 0.0;
                }
                cnt1.computeIfAbsent(k, unused -> new HashMap<>()).merge(b, 1, Integer::sum);
                int p = (x1 + x2 + 2000) * 4001 + (y1 + y2 + 2000);
                cnt2.computeIfAbsent(p, unused -> new HashMap<>()).merge(k, 1, Integer::sum);
            }
        }

        int ans = 0;
        for (var e : cnt1.values()) {
            int s = 0;
            for (int t : e.values()) {
                ans += s * t;
                s += t;
            }
        }
        for (var e : cnt2.values()) {
            int s = 0;
            for (int t : e.values()) {
                ans -= s * t;
                s += t;
            }
        }
        return ans;
    }
}
