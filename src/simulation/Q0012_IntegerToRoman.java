package simulation;

import java.util.*;

public class Q0012_IntegerToRoman {
    // Öncelik   : 🔵 Trend
    // Şirketler : Meta ✅ (#206)
    //
    // 12. Integer to Roman - Medium
    // https://leetcode.com/problems/integer-to-roman/

    /* ------------------------------------------------------------
       | PATTERN: Greedy (büyükten küçüğe semboller)
       ------------------------------------------------------------
       Değerleri büyükten küçüğe sıralı tut (M, CM, D, CD, C, XC, L, XL, X, IX, V, IV, I).
       num, bir değerden büyük ya da ona eşit olduğu sürece o sembolü ekle ve değeri düş.
       Çıkarmalı formlar (CM, IV gibi) listeye eklendiği için özel durum gerekmez.
    */
    /*  Complexity
        Time  : O(1) (en fazla 15 karakter)
        Space : O(1)
    */

    public static String intToRoman(int num) {
        List<String> cs
            = List.of("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I");
        List<Integer> vs = List.of(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1);
        StringBuilder ans = new StringBuilder();
        for (int i = 0, n = cs.size(); i < n; ++i) {
            while (num >= vs.get(i)) {
                num -= vs.get(i);
                ans.append(cs.get(i));
            }
        }
        return ans.toString();
    }
}
