package stack;

import java.util.*;

public class Q1249_MinimumRemoveToMakeValidParentheses {
    // Öncelik   : ⭐ Gerçek deneyim  ·  🌍 Ortak soru
    // Şirketler : Meta ✅ (#1), Bloomberg (#107)
    // Seviye    : Senior, Staff
    // Raporlar  : 4 (2 📍London)
    //             https://leetcode.com/discuss/post/5501360/MetaorLondonorOnsite/
    //
    // 1249. Minimum Remove to Make Valid Parentheses - Medium
    // https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/

    /* ------------------------------------------------------------
       | PATTERN: Stack / Two Pass (sayaç ile)
       ------------------------------------------------------------
       İlk geçiş (soldan): açık '(' sayısını tut; eşleşmeyen ')' karakterlerini atla.
       İkinci geçiş (sağdan): fazla kalan '(' karakterlerini, sağdan eşleşmeyenleri atarak çıkar.
       Kalan karakterler doğru sırada birleştirilir. Meta'nın en sık sorduğu sorulardan biri.
    */
    /*  Complexity
        Time  : O(n)
        Space : O(n)
    */

    public static String minRemoveToMakeValid(String s) {
        Deque<Character> stk = new ArrayDeque<>();
        int x = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == ')' && x == 0) {
                continue;
            }
            if (c == '(') {
                ++x;
            } else if (c == ')') {
                --x;
            }
            stk.push(c);
        }
        StringBuilder ans = new StringBuilder();
        x = 0;
        while (!stk.isEmpty()) {
            char c = stk.pop();
            if (c == '(' && x == 0) {
                continue;
            }
            if (c == ')') {
                ++x;
            } else if (c == '(') {
                --x;
            }
            ans.append(c);
        }
        return ans.reverse().toString();
    }
}
