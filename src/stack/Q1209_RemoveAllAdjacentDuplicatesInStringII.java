package stack;

import java.util.*;

public class Q1209_RemoveAllAdjacentDuplicatesInStringII {
    // 1209. Remove All Adjacent Duplicates in String II - Medium
    // https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/

    /* ------------------------------------------------------------
       | PATTERN: Stack (karakter + ardışık sayı)
       ------------------------------------------------------------
       Stack'te (karakter, ardışık sayısı) çiftleri tut. Aynı karakter gelince sayıyı artır, k olunca pop et.
       Farklı karakter gelince yeni çift push et. Sonunda stack'i sayılara göre açarak string'i kur.
    */
    /*  Complexity
        Time  : O(n)
        Space : O(n)
    */

    public static String removeDuplicates(String s, int k) {
        Deque<int[]> stk = new ArrayDeque<>();
        for (int i = 0; i < s.length(); ++i) {
            int j = s.charAt(i) - 'a';
            if (!stk.isEmpty() && stk.peek()[0] == j) {
                stk.peek()[1] = (stk.peek()[1] + 1) % k;
                if (stk.peek()[1] == 0) {
                    stk.pop();
                }
            } else {
                stk.push(new int[] {j, 1});
            }
        }
        StringBuilder ans = new StringBuilder();
        for (var e : stk) {
            char c = (char) (e[0] + 'a');
            for (int i = 0; i < e[1]; ++i) {
                ans.append(c);
            }
        }
        ans.reverse();
        return ans.toString();
    }
}
