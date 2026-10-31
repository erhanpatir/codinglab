package hashing;

import java.util.*;

public class Q2423_RemoveLetterToEqualizeFrequency {
    // Öncelik   : 🔴 Yüksek
    // Şirketler : Bloomberg ✅ (#78)
    //
    // 2423. Remove Letter To Equalize Frequency - Easy
    // https://leetcode.com/problems/remove-letter-to-equalize-frequency/

    /* ------------------------------------------------------------
       | PATTERN: Hash / Counting + Enumeration
       ------------------------------------------------------------
       Her harften birini silmeyi dene: frekansını bir azalt, kalan sıfır olmayan frekansların
       hepsi eşit mi kontrol et, sonra geri al. 26 harf olduğu için deneme sayısı sabit.
    */
    /*  Complexity
        Time  : O(n + 26^2)
        Space : O(26)
    */

    public static boolean equalFrequency(String word) {
        int[] cnt = new int[26];
        for (int i = 0; i < word.length(); ++i) {
            ++cnt[word.charAt(i) - 'a'];
        }
        for (int i = 0; i < 26; ++i) {
            if (cnt[i] > 0) {
                --cnt[i];
                int x = 0;
                boolean ok = true;
                for (int v : cnt) {
                    if (v == 0) {
                        continue;
                    }
                    if (x > 0 && v != x) {
                        ok = false;
                        break;
                    }
                    x = v;
                }
                if (ok) {
                    return true;
                }
                ++cnt[i];
            }
        }
        return false;
    }
}
