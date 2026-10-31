package math;

import java.util.*;

public class Q0415_AddStrings {
    // 415. Add Strings - Easy
    // https://leetcode.com/problems/add-strings/

    /* ------------------------------------------------------------
       | PATTERN: Two Pointers + Carry
       ------------------------------------------------------------
       İki string'i sondan gez, basamakları ve carry'yi topla, StringBuilder'a ekle, en sonda ters çevir.
       Herhangi biri bitince 0 kabul edilir; döngü carry de bitene kadar sürer.
    */
    /*  Complexity
        Time  : O(max(m, n))
        Space : O(1) (çıktı hariç)
    */

    public static String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1;
        StringBuilder ans = new StringBuilder();
        for (int c = 0; i >= 0 || j >= 0 || c > 0; --i, --j) {
            int a = i < 0 ? 0 : num1.charAt(i) - '0';
            int b = j < 0 ? 0 : num2.charAt(j) - '0';
            c += a + b;
            ans.append(c % 10);
            c /= 10;
        }
        return ans.reverse().toString();
    }

    public static String subStrings(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        boolean neg = m < n || (m == n && num1.compareTo(num2) < 0);
        if (neg) {
            String t = num1;
            num1 = num2;
            num2 = t;
        }
        int i = num1.length() - 1, j = num2.length() - 1;
        StringBuilder ans = new StringBuilder();
        for (int c = 0; i >= 0; --i, --j) {
            c = (num1.charAt(i) - '0') - c - (j < 0 ? 0 : num2.charAt(j) - '0');
            ans.append((c + 10) % 10);
            c = c < 0 ? 1 : 0;
        }
        while (ans.length() > 1 && ans.charAt(ans.length() - 1) == '0') {
            ans.deleteCharAt(ans.length() - 1);
        }
        if (neg) {
            ans.append('-');
        }
        return ans.reverse().toString();
    }
}
