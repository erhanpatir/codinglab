package hashing;

import java.util.*;

public class Q0387_FirstUniqueCharacterInAString {
    // Öncelik   : ⭐ Gerçek deneyim  ·  🌍 Ortak soru
    // Şirketler : Amazon ✅ (#101), Apple (#64), Bloomberg ✅ (#52)
    // Raporlar  : 1 (1 📍London)
    //             https://arpita0412.medium.com/bloomberg-london-interview-experience-fd2a6a65c84c
    //
    // 387. First Unique Character in a String - Easy
    // https://leetcode.com/problems/first-unique-character-in-a-string/

    /* ------------------------------------------------------------
       | PATTERN: Hash / Counting
       ------------------------------------------------------------
       İlk geçişte her karakterin frekansını say, ikinci geçişte frekansı 1 olan ilk karakterin indeksini döndür.
    */
    /*  Complexity
        Time  : O(n)
        Space : O(Σ)
    */

    public static int firstUniqChar(String s) {
        int[] cnt = new int[26];
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            ++cnt[s.charAt(i) - 'a'];
        }
        for (int i = 0; i < n; ++i) {
            if (cnt[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
