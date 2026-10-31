package math;

import java.util.*;

public class Q0149_MaxPointsOnALine {
    // Öncelik   : 🟡 Orta
    // Şirketler : Apple (#70)
    //
    // 149. Max Points on a Line - Hard
    // https://leetcode.com/problems/max-points-on-a-line/

    /* ------------------------------------------------------------
       | PATTERN: Math / Hash Map - eğim sayma
       ------------------------------------------------------------
       Her i noktası için diğer noktalarla oluşan eğimleri say. Eğim double yerine
       (dx/g, dy/g) sadeleştirilmiş kesir olarak tutulur (g = gcd), işaret normalize edilir: hassasiyet sorunu olmaz.
       Aynı eğimi paylaşan nokta sayısı + 1 (i'nin kendisi) bir doğrudaki nokta sayısıdır.
    */
    /*  Complexity
        Time  : O(n^2 log M)
        Space : O(n)
    */

    public static int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) return n;
        int best = 1;
        for (int i = 0; i < n; i++) {
            Map<String, Integer> slopes = new HashMap<>();
            for (int j = i + 1; j < n; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];
                int g = gcd(dx, dy);
                dx /= g;
                dy /= g;
                if (dx < 0 || (dx == 0 && dy < 0)) {  // eğimi tek bir forma normalize et
                    dx = -dx;
                    dy = -dy;
                }
                int count = slopes.merge(dx + "/" + dy, 1, Integer::sum);
                best = Math.max(best, count + 1);
            }
        }
        return best;
    }

    private static int gcd(int a, int b) {
        return b == 0 ? Math.abs(a) : gcd(b, a % b);
    }
}
