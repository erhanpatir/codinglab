package twopointers;

import java.util.*;

public class Q1768_MergeStringsAlternately {
    // Öncelik   : 🔵 Trend  ·  🌍 Ortak soru
    // Şirketler : Meta ✅, Google ✅, Amazon ✅
    //
    // 1768. Merge Strings Alternately - Easy
    // https://leetcode.com/problems/merge-strings-alternately/

    /* ------------------------------------------------------------
       | PATTERN: Two Pointers (sırayla birleştirme)
       ------------------------------------------------------------
       İki kelimeyi aynı i indeksiyle gez; varsa word1[i], sonra word2[i] ekle.
       Uzun olanın kalan karakterleri kendiliğinden sona eklenir.
    */
    /*  Complexity
        Time  : O(m + n)
        Space : O(1) (çıktı hariç)
    */

    public static String mergeAlternately(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < m || i < n; ++i) {
            if (i < m) {
                ans.append(word1.charAt(i));
            }
            if (i < n) {
                ans.append(word2.charAt(i));
            }
        }
        return ans.toString();
    }
}
