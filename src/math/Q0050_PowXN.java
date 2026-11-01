package math;

import java.util.*;

public class Q0050_PowXN {
    // Öncelik   : ⭐ Gerçek deneyim  ·  🌍 Ortak soru
    // Şirketler : Meta ✅ (#18), Google ✅ (#66), Bloomberg ✅ (#60)
    // Seviye    : Senior
    // Raporlar  : 1 (1 📍London)
    //             https://leetcode.com/discuss/post/5600735/Meta-or-E5-or-London-or-July-orReject/
    //
    // 50. Pow(x, n) - Medium
    // https://leetcode.com/problems/powx-n/

    /* ------------------------------------------------------------
       | PATTERN: Math - Fast Power (binary exponentiation)
       ------------------------------------------------------------
       n'nin bitlerini gez: bit 1 ise ans *= x; her adımda x = x * x, n >>= 1.
       Negatif üs için sonucu 1 / qpow(x, -n) olarak hesapla.
       -n işleminin taşmaması için n long olarak işlenir (Integer.MIN_VALUE durumu).
    */
    /*  Complexity
        Time  : O(log n)
        Space : O(1)
    */

    public static double myPow(double x, int n) {
        return n >= 0 ? qpow(x, n) : 1 / qpow(x, -(long) n);
    }

    private static double qpow(double a, long n) {
        double ans = 1;
        for (; n > 0; n >>= 1) {
            if ((n & 1) == 1) {
                ans = ans * a;
            }
            a = a * a;
        }
        return ans;
    }
}
