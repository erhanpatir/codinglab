package hashing;

import java.util.*;

public class Q0387_FirstUniqueCharacterInAString {
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
