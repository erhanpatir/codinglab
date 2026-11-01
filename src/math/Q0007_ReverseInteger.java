package math;

import java.util.*;

public class Q0007_ReverseInteger {
    // Öncelik   : 🔵 Trend  ·  🌍 Ortak soru
    // Şirketler : Meta ✅ (#98), Google ✅ (#18), Amazon ✅ (#48), Apple (#32), Bloomberg ✅ (#20)
    //
    // 7. Reverse Integer - Medium
    // https://leetcode.com/problems/reverse-integer/

    /* ------------------------------------------------------------
       | PATTERN: Math - basamak basamak ters çevirme
       ------------------------------------------------------------
       x % 10 ile son basamağı al, x /= 10 ile at, sonucu ans * 10 + basamak ile kur.
       Kritik nokta overflow: ans * 10 yapmadan önce ans'ın Integer.MAX_VALUE / 10 ve
       Integer.MIN_VALUE / 10 sınırlarını aşıp aşmadığını kontrol et; aşıyorsa 0 döndür.
    */
    /*  Complexity
        Time  : O(log |x|)
        Space : O(1)
    */

    public static int reverse(int x) {
        int ans = 0;
        for (; x != 0; x /= 10) {
            if (ans < Integer.MIN_VALUE / 10 || ans > Integer.MAX_VALUE / 10) {
                return 0;
            }
            ans = ans * 10 + x % 10;
        }
        return ans;
    }
}
