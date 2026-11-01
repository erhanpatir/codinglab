package greedy;

import java.util.*;

public class Q0670_MaximumSwap {
    // Öncelik   : ⭐ Gerçek deneyim  ·  🌍 Ortak soru
    // Şirketler : Meta (#46), Apple ✅ (#156)
    // Seviye    : Senior
    // Raporlar  : 1 (1 📍London)
    //             https://leetcode.com/discuss/post/5501360/MetaorLondonorOnsite/
    //
    // 670. Maximum Swap - Medium
    // https://leetcode.com/problems/maximum-swap/

    /* ------------------------------------------------------------
       | PATTERN: Greedy (sağdaki en büyük basamak)
       ------------------------------------------------------------
       Her pozisyon için sağında kalan en büyük basamağın indeksini (eşitlikte en sağdaki) hesapla.
       Soldan gez; kendinden büyük bir sağ basamağı olan ilk pozisyonu o basamakla swap et ve dur.
    */
    /*  Complexity
        Time  : O(log num)
        Space : O(log num)
    */

    public static int maximumSwap(int num) {
        char[] s = String.valueOf(num).toCharArray();
        int n = s.length;
        int[] d = new int[n];
        for (int i = 0; i < n; ++i) {
            d[i] = i;
        }
        for (int i = n - 2; i >= 0; --i) {
            if (s[i] <= s[d[i + 1]]) {
                d[i] = d[i + 1];
            }
        }
        for (int i = 0; i < n; ++i) {
            int j = d[i];
            if (s[i] < s[j]) {
                char t = s[i];
                s[i] = s[j];
                s[j] = t;
                break;
            }
        }
        return Integer.parseInt(String.valueOf(s));
    }
}
