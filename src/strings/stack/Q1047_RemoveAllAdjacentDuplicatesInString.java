package strings.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q1047_RemoveAllAdjacentDuplicatesInString {
    // 1047. Remove All Adjacent Duplicates In String
    // https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/description/
    /*
        Complexity Analysis
            Time Complexity: O(n)
            Space Complexity: O(n)
    */
    public static String removeDuplicates(String s) {
        if (s == null || s.isEmpty()) return s;

        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!stack.isEmpty() && stack.peekLast() == c) {
                stack.removeLast();
            } else {
                stack.addLast(c);
            }
        }

        StringBuilder result = new StringBuilder(stack.size());
        for (char ch : stack) {
            result.append(ch);
        }
        return result.toString();
    }

    public String removeDuplicates_2(String s) {
        StringBuilder stack = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (stack.length() > 0 && stack.charAt(stack.length() - 1) == c) {
                stack.deleteCharAt(stack.length() - 1);
            } else {
                stack.append(c);
            }
        }
        return stack.toString();
    }
}
