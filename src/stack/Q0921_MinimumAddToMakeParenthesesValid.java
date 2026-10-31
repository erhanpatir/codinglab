package stack;

import java.util.*;

public class Q0921_MinimumAddToMakeParenthesesValid {
    // 921. Minimum Add to Make Parentheses Valid - Medium
    // https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/

    /* ------------------------------------------------------------
       | PATTERN: Stack (eşleşmeyen parantezler)
       ------------------------------------------------------------
       ')' geldiğinde tepede '(' varsa eşleşir, pop et; değilse push et.
       Sonunda stack'te kalan her karakter eşleşmemiş bir parantezdir; sayısı cevap.
       O(1) bellek için iki sayaç da yeterlidir.
    */
    /*  Complexity
        Time  : O(n)
        Space : O(n)
    */

    public static int minAddToMakeValid(String s) {
        Deque<Character> stk = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == ')' && !stk.isEmpty() && stk.peek() == '(') {
                stk.pop();
            } else {
                stk.push(c);
            }
        }
        return stk.size();
    }
}
