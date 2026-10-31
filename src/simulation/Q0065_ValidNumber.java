package simulation;

import java.util.*;

public class Q0065_ValidNumber {
    // Öncelik   : ⭐ Gerçek deneyim
    // Şirketler : Meta ✅ (#53)
    // Seviye    : Senior
    // Raporlar  : 1
    //             https://leetcode.com/discuss/post/6080203/
    //
    // 65. Valid Number - Hard
    // https://leetcode.com/problems/valid-number/

    /* ------------------------------------------------------------
       | PATTERN: String Parsing - durum kontrolü
       ------------------------------------------------------------
       Kurallar: işaret sadece başta ya da e/E'den hemen sonra olabilir; en fazla bir nokta,
       o da e'den önce; en fazla bir e, öncesinde ve sonrasında rakam olmalı.
       Karakterleri tek geçişte gezip "nokta görüldü / e görüldü / rakam görüldü" bayraklarıyla kontrol et.
    */
    /*  Complexity
        Time  : O(n)
        Space : O(1)
    */

    public static boolean isNumber(String s) {
        int n = s.length();
        int i = 0;
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            ++i;
        }
        if (i == n) {
            return false;
        }
        if (s.charAt(i) == '.'
            && (i + 1 == n || s.charAt(i + 1) == 'e' || s.charAt(i + 1) == 'E')) {
            return false;
        }
        int dot = 0, e = 0;
        for (int j = i; j < n; ++j) {
            if (s.charAt(j) == '.') {
                if (e > 0 || dot > 0) {
                    return false;
                }
                ++dot;
            } else if (s.charAt(j) == 'e' || s.charAt(j) == 'E') {
                if (e > 0 || j == i || j == n - 1) {
                    return false;
                }
                ++e;
                if (s.charAt(j + 1) == '+' || s.charAt(j + 1) == '-') {
                    if (++j == n - 1) {
                        return false;
                    }
                }
            } else if (s.charAt(j) < '0' || s.charAt(j) > '9') {
                return false;
            }
        }
        return true;
    }
}
