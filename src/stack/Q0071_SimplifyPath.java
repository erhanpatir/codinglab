package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q0071_SimplifyPath {
    // 71. Simplify Path - Medium
    // https://leetcode.com/problems/simplify-path/
    /* -----------------------------------------
       | PATTERN:  STACK + StringBuilder     ✅|
       -----------------------------------------
    /* ⭐ Stack kullanırız.
            Her path component için:
            Ignore
                ""
                "."
            Parent’a çık
                ".."
            Stack boş değilse pop.

            Normal folder
                "home"
                "foo"
                "bar"

            Stack’e push.
    */
    /*  Complexity
            Time
            Path split + parçaları gezme:
                O(n)

            Space
            Stack worst-case bütün klasörleri tutabilir:
                O(n)
    */
    public static String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();

        String[] parts = path.split("/");

        for (String part : parts) {
            if (part.isEmpty() || part.equals(".")) {
                continue;
            }

            if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(part);
            }
        }

        StringBuilder result = new StringBuilder();

        for (String directory : stack) {
            result.append("/").append(directory);
        }

        return result.toString();
    }
}
