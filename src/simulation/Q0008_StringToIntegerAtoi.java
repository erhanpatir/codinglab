package simulation;

import java.util.*;

public class Q0008_StringToIntegerAtoi {
    // 8. String to Integer (atoi) - Medium
    // https://leetcode.com/problems/string-to-integer-atoi/

    /* ------------------------------------------------------------
       | PATTERN: String Parsing / Simülasyon
       ------------------------------------------------------------
       Adımlar: baştaki boşlukları atla -> işareti oku -> rakamları oku -> rakam olmayan ilk karakterde dur.
       Her rakam eklenmeden önce overflow kontrolü yapılır: res > MAX/10 ya da
       res == MAX/10 ve basamak > 7 ise sonuç işarete göre MAX ya da MIN olur.
    */
    /*  Complexity
        Time  : O(n)
        Space : O(1)
    */

    public static int myAtoi(String s) {
        if (s == null) return 0;
        int n = s.length();
        if (n == 0) return 0;
        int i = 0;
        while (s.charAt(i) == ' ') {
            if (++i == n) return 0;
        }
        int sign = 1;
        if (s.charAt(i) == '-') sign = -1;
        if (s.charAt(i) == '-' || s.charAt(i) == '+') ++i;
        int res = 0, flag = Integer.MAX_VALUE / 10;
        for (; i < n; ++i) {
            if (s.charAt(i) < '0' || s.charAt(i) > '9') break;
            if (res > flag || (res == flag && s.charAt(i) > '7'))
                return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res * 10 + (s.charAt(i) - '0');
        }
        return sign * res;
    }
}
