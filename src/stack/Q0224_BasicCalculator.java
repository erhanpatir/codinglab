package stack;

import java.util.*;

public class Q0224_BasicCalculator {
    // Öncelik   : 🔴 Yüksek
    // Şirketler : Google ✅ (#96)
    //
    // 224. Basic Calculator - Hard
    // https://leetcode.com/problems/basic-calculator/

    /* ------------------------------------------------------------
       | PATTERN: Stack (parantezlerde işaret ve sonuç saklama)
       ------------------------------------------------------------
       ans ve sign tut; sayıları sign * x olarak ans'a ekle.
       '(' görünce mevcut ans ve sign'ı stack'e it, yeni alt ifade için ans = 0, sign = 1.
       ')' görünce alt ifadenin sonucunu stack'teki işaretle çarp ve önceki ans'a ekle.
    */
    /*  Complexity
        Time  : O(n)
        Space : O(n)
    */

    public static int calculate(String s) {
        Deque<Integer> stk = new ArrayDeque<>();
        int sign = 1;
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int j = i;
                int x = 0;
                while (j < n && Character.isDigit(s.charAt(j))) {
                    x = x * 10 + s.charAt(j) - '0';
                    j++;
                }
                ans += sign * x;
                i = j - 1;
            } else if (c == '+') {
                sign = 1;
            } else if (c == '-') {
                sign = -1;
            } else if (c == '(') {
                stk.push(ans);
                stk.push(sign);
                ans = 0;
                sign = 1;
            } else if (c == ')') {
                ans = stk.pop() * ans + stk.pop();
            }
        }
        return ans;
    }
}
