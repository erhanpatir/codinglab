package twopointers;

import java.util.*;

public class Q0005_LongestPalindromicSubstring {
    // 5. Longest Palindromic Substring - Medium
    // https://leetcode.com/problems/longest-palindromic-substring/

    /* ------------------------------------------------------------
       | PATTERN: Two Pointers - Expand Around Center
       ------------------------------------------------------------
       Her palindromun bir merkezi vardır: tek uzunlukta bir karakter, çift uzunlukta iki karakter arası.
       2n-1 merkezin her birinden sola ve sağa karakterler eşit olduğu sürece genişle.
       En uzun genişlemenin başlangıcını ve uzunluğunu tut. DP'ye göre O(1) bellek kullanır.
    */
    /*  Complexity
        Time  : O(n^2)
        Space : O(1)
    */

    public static String longestPalindrome(String s) {
        int start = 0, maxLen = 0;
        for (int center = 0; center < s.length(); center++) {
            int odd = expand(s, center, center);       // "aba" gibi tek uzunluklu
            int even = expand(s, center, center + 1);  // "abba" gibi çift uzunluklu
            int len = Math.max(odd, even);
            if (len > maxLen) {
                maxLen = len;
                start = center - (len - 1) / 2;
            }
        }
        return s.substring(start, start + maxLen);
    }

    private static int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
