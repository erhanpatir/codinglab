package twopointers;

import java.util.*;

public class Q0680_ValidPalindromeII {
    // Öncelik   : ⭐ Gerçek deneyim
    // Şirketler : Meta ✅ (#3)
    // Seviye    : Mid
    // Raporlar  : 1 (1 📍London)
    //             https://leetcode.com/discuss/post/5732927/META-or-PHONE-SCREEN-or-E4-or-London-or-Sept-2024-or-PASSED/
    //
    // 680. Valid Palindrome II - Easy
    // https://leetcode.com/problems/valid-palindrome-ii/

    /* ------------------------------------------------------------
       | PATTERN: Two Pointers (bir silme hakkı)
       ------------------------------------------------------------
       Uçlardan karşılaştır. İlk uyuşmazlıkta iki seçenek: soldaki ya da sağdaki karakteri atla;
       kalan aralıklardan biri palindromsa true. Sadece bir kez dallanıldığı için toplam O(n).
    */
    /*  Complexity
        Time  : O(n)
        Space : O(1)
    */

    private char[] s;

    public boolean validPalindrome(String S) {
        this.s = S.toCharArray();
        for (int i = 0, j = s.length - 1; i < j; ++i, --j) {
            if (s[i] != s[j]) {
                return check(i + 1, j) || check(i, j - 1);
            }
        }
        return true;
    }

    private boolean check(int i, int j) {
        for (; i < j; ++i, --j) {
            if (s[i] != s[j]) {
                return false;
            }
        }
        return true;
    }
}
