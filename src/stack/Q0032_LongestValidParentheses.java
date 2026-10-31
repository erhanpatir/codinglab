package stack;

import java.util.*;

public class Q0032_LongestValidParentheses {
    // 32. Longest Valid Parentheses - Hard
    // https://leetcode.com/problems/longest-valid-parentheses/

    /* ------------------------------------------------------------
       | PATTERN: Stack (indeks tutan)
       ------------------------------------------------------------
       Stack'te indeks tut; başlangıçta -1 (geçerli bölümün başlangıcından bir önceki sınır).
       '(' -> indeksi push. ')' -> pop; stack boşaldıysa bu ')' yeni sınır olur (push i),
       değilse geçerli uzunluk = i - stack.peek(). En büyük uzunluğu tut.
    */
    /*  Complexity
        Time  : O(n)
        Space : O(n)
    */

    public static int longestValidParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1); // geçerli bölümün başlangıcından bir önceki indeks
        int best = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i); // eşleşmeyen ')' yeni sınır olur
                } else {
                    best = Math.max(best, i - stack.peek());
                }
            }
        }
        return best;
    }
}
