package backtracking.strings;

import java.util.ArrayList;
import java.util.List;

public class Q0131_PalindromePartitioning {
    // 131. Palindrome Partitioning - Medium
    // https://leetcode.com/problems/palindrome-partitioning/description/
    // PATTERN : backtracking - partition / cut positions + validity check

    // Time: O(n * 2^n) - Partition sayısı üstel olabilir. Ama her partition sırasında palindrome check de var.
    // Space: O(n)

    /* Bu sorunun ana fikri

        Bu soru şunu soruyor:
            String’i hangi noktalardan bölebilirim ki, çıkan her parça palindrome olsun?

            Yani her adımda:
                bulunduğun index’ten başla
                her possible substring’i dene
                palindrome ise seç
                devam et

            Bu tam bir backtracking sorusu.

        State ne?
            Bu soruda state:

                start → şu anda string’in neresindeyim
                path → şu ana kadar seçtiğim palindrome parçalar
    */

    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(String s,
                           int start,
                           List<String> path,
                           List<List<String>> result) {

        if (start == s.length()) { // string’in tamamını kapladın mı? start, tuektilen index
            result.add(new ArrayList<>(path));
            return;
        }

        for (int end = start; end < s.length(); end++) {
            if (!isPalindrome(s, start, end)) {
                continue;
            }

            path.add(s.substring(start, end + 1));
            backtrack(s, end + 1, path, result);
            path.remove(path.size() - 1);
        }
    }

    private static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
