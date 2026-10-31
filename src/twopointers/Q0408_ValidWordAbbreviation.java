package twopointers;

import java.util.*;

public class Q0408_ValidWordAbbreviation {
    // Öncelik   : ⭐ Gerçek deneyim
    // Şirketler : Meta (#2)
    // Seviye    : Mid, Senior
    // Raporlar  : 3 (2 📍London)
    //             https://leetcode.com/discuss/post/6485719/meta-e4-software-engineer-interview-expe-osx7/
    //
    // 408. Valid Word Abbreviation - Easy
    // https://leetcode.com/problems/valid-word-abbreviation/

    /* ------------------------------------------------------------
       | PATTERN: Two Pointers (word ve abbr üzerinde)
       ------------------------------------------------------------
       abbr'yi gezerken sayıları biriktir (başında 0 olan sayı geçersizdir).
       Harf gelince biriken sayı kadar word'de ilerle ve o konumdaki harfin eşleştiğini kontrol et.
       Sonunda iki pointer da tam bitmiş olmalı.
    */
    /*  Complexity
        Time  : O(m + n)
        Space : O(1)
    */

    public static boolean validWordAbbreviation(String word, String abbr) {
        int m = word.length(), n = abbr.length();
        int i = 0, j = 0, x = 0;
        for (; i < m && j < n; ++j) {
            char c = abbr.charAt(j);
            if (Character.isDigit(c)) {
                if (c == '0' && x == 0) {
                    return false;
                }
                x = x * 10 + (c - '0');
            } else {
                i += x;
                x = 0;
                if (i >= m || word.charAt(i) != c) {
                    return false;
                }
                ++i;
            }
        }
        return i + x == m && j == n;
    }
}
