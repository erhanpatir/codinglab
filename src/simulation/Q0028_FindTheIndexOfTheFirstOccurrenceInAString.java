package simulation;

import java.util.*;

public class Q0028_FindTheIndexOfTheFirstOccurrenceInAString {
    // Öncelik   : 🔵 Trend  ·  🌍 Ortak soru
    // Şirketler : Google ✅ (#58), Amazon ✅ (#95), Apple (#58), Bloomberg ✅ (#95)
    //
    // 28. Find the Index of the First Occurrence in a String - Easy
    // https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/

    /* ------------------------------------------------------------
       | PATTERN: String - Brute Force karşılaştırma (KMP opsiyonel)
       ------------------------------------------------------------
       haystack'teki her i başlangıcı için needle ile karakter karakter karşılaştır; ilk eşleşmede i döner.
       Mülakatta bu çözüm genelde yeterli. Takip sorusu olarak KMP (LPS dizisi) ile O(n + m) yapılabilir.
    */
    /*  Complexity
        Time  : O((n - m) * m)
        Space : O(1)
    */

    public static int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        for (int i = 0; i + m <= n; ++i) {
            if (haystack.substring(i, i + m).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
