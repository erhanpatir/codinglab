package arrays.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class Q0076_MinimumWindowSubstring {
    // 76. Minimum Window Substring - Hard
    // https://leetcode.com/problems/minimum-window-substring/
    /* ---------------------------------------------------------------------
       |   PATTERN: Dynamic Sliding Window + Frequency Requirement       ✅|
       ---------------------------------------------------------------------
       Burada window değişken boyutlu.
        Mantık:
            right ile window'u büyüt
            t'yi kapsayınca left ile küçült
            en küçük valid window'u kaydet

        3. State / Invariant
        İki map/count array tutarız:

            need  -> t karakterlerinin gerekli sayısı
            window -> current window karakter sayısı

        Ek state:
            required = need içindeki unique karakter sayısı
            formed = requirement'ı karşılanan karakter sayısı

        Örnek:
            t = "ABC"
            need:
            A -> 1
            B -> 1
            C -> 1

            required = 3

        Window içinde A, B, C hepsi yeterli sayıya ulaşınca:
            formed == required
        Window valid olur.
    */
    /* Complexity
        Time: O(n)
        Space: O(1)
    */
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }

        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int required = need.size();
        int formed = 0;

        int left = 0;
        int minLength = Integer.MAX_VALUE;
        int minStart = 0;

        // 1. right ile window'u büyüt
        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);

            window.put(rightChar, window.getOrDefault(rightChar, 0) + 1);

            if (need.containsKey(rightChar)
            && window.get(rightChar).intValue() == need.get(rightChar).intValue()) {
                formed++;
            }

            // 2. valid olduktan sonra left ile küçült
            while (formed == required) { // Şimdi daha kısa yapabilir miyiz?
                int windowLength = right - left + 1;

                if (windowLength < minLength) {
                    minLength = windowLength;
                    minStart = left;
                }

                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);

                if (need.containsKey(leftChar)
                        && window.get(leftChar).intValue() < need.get(leftChar).intValue()) {
                    formed--;
                }
                left++;
            }
        }

        if (minLength == Integer.MAX_VALUE) return "";
        return s.substring(minStart, minStart + minLength);
    }
}
