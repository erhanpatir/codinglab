package twopointers;

import java.util.*;

public class Q0344_ReverseString {
    // 344. Reverse String - Easy
    // https://leetcode.com/problems/reverse-string/

    /* ------------------------------------------------------------
       | PATTERN: Two Pointers
       ------------------------------------------------------------
       Baş ve sondan iki pointer; karakterleri swap et, pointer'ları ortaya doğru yaklaştır.
    */
    /*  Complexity
        Time  : O(n)
        Space : O(1)
    */

    public static void reverseString(char[] s) {
        for (int i = 0, j = s.length - 1; i < j; ++i, --j) {
            char t = s[i];
            s[i] = s[j];
            s[j] = t;
        }
    }
}
