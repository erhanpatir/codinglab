package hashing;

import java.util.*;

public class Q0266_PalindromePermutation {
    // 266. Palindrome Permutation - Easy
    // https://leetcode.com/problems/palindrome-permutation/

    /* ------------------------------------------------------------
       | PATTERN: Hash / Counting
       ------------------------------------------------------------
       Palindrom permütasyonu varsa, tek sayıda geçen karakter sayısı en fazla 1 olmalı.
       Karakterleri say, tek frekanslıların sayısını kontrol et.
    */
    /*  Complexity
        Time  : O(n)
        Space : O(Σ) (alfabe boyutu)
    */

    public static boolean canPermutePalindrome(String s) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            ++cnt[c - 'a'];
        }
        int odd = 0;
        for (int x : cnt) {
            odd += x & 1;
        }
        return odd < 2;
    }
}
