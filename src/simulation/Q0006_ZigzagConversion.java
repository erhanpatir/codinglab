package simulation;

import java.util.*;

public class Q0006_ZigzagConversion {
    // Öncelik   : 🔵 Trend  ·  🌍 Ortak soru
    // Şirketler : Google ✅ (#65), Amazon ✅ (#84), Bloomberg ✅ (#70)
    //
    // 6. Zigzag Conversion - Medium
    // https://leetcode.com/problems/zigzag-conversion/

    /* ------------------------------------------------------------
       | PATTERN: Simülasyon (satır satır yürüme)
       ------------------------------------------------------------
       numRows kadar StringBuilder tut. Karakterleri sırayla satırlara dağıt;
       satır indeksi 0'a ya da numRows-1'e geldiğinde yön değiştir (zigzag).
       Sonunda satırları sırayla birleştir. numRows == 1 ise string aynen döner.
    */
    /*  Complexity
        Time  : O(n)
        Space : O(n)
    */

    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder[] g = new StringBuilder[numRows];
        Arrays.setAll(g, k -> new StringBuilder());
        int i = 0, k = -1;
        for (char c : s.toCharArray()) {
            g[i].append(c);
            if (i == 0 || i == numRows - 1) {
                k = -k;
            }
            i += k;
        }
        return String.join("", g);
    }
}
