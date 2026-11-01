package twopointers;

import java.util.*;

public class Q0443_StringCompression {
    // Öncelik   : 🔴 Yüksek  ·  🌍 Ortak soru
    // Şirketler : Amazon ✅ (#112), Apple ✅ (#49), Bloomberg ✅ (#114)
    //
    // 443. String Compression - Medium
    // https://leetcode.com/problems/string-compression/

    /* ------------------------------------------------------------
       | PATTERN: Two Pointers (okuma / yazma)
       ------------------------------------------------------------
       i grubun başlangıcı, j grubun bittiği yer. Karakteri k yazma pointer'ına yaz;
       grup uzunluğu 1'den büyükse uzunluğun basamaklarını da yaz. i = j ile devam et.
       Sonuç dizinin kendisine yazılır; yeni uzunluk k döner.
    */
    /*  Complexity
        Time  : O(n)
        Space : O(1)
    */

    public static int compress(char[] chars) {
        int k = 0, n = chars.length;
        for (int i = 0, j = i + 1; i < n;) {
            while (j < n && chars[j] == chars[i]) {
                ++j;
            }
            chars[k++] = chars[i];
            if (j - i > 1) {
                String cnt = String.valueOf(j - i);
                for (char c : cnt.toCharArray()) {
                    chars[k++] = c;
                }
            }
            i = j;
        }
        return k;
    }
}
