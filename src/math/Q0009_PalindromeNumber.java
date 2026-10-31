package math;

import java.util.*;

public class Q0009_PalindromeNumber {
    // Öncelik   : 🔵 Trend  ·  🌍 Ortak soru
    // Şirketler : Meta ✅, Google ✅, Amazon ✅, Bloomberg ✅
    //
    // 9. Palindrome Number - Easy
    // https://leetcode.com/problems/palindrome-number/description/

    /* ------------------------------------------------------------
       | PATTERN: Math - sayının yarısını ters çevirme
       ------------------------------------------------------------
       Negatif sayılar ve 0 hariç sonu 0 ile biten sayılar palindrom olamaz.
       Sayının son yarısını ters çevirip ilk yarıyla karşılaştır: x > rev olduğu sürece
       rev = rev * 10 + x % 10. Tek basamak sayısında ortadaki basamak rev / 10 ile atılır.
       String'e çevirmeden ve overflow riski olmadan çözer.
    */
    /*  Complexity
        Time  : O(log10 n)
        Space : O(1)
    */

    public static boolean isPalindrome(int x) {
        if (x < 0 || (x > 0 && x % 10 == 0)) {
            return false;
        }
        int y = 0;
        for (; y < x; x /= 10) {
            y = y * 10 + x % 10;
        }
        return x == y || x == y / 10;
    }
}
