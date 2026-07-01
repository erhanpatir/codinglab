package backtracking.recursion;

import java.util.ArrayList;
import java.util.List;

public class Q0017_LetterCombinationsOfAPhoneNumber {
    // 17. Letter Combinations of a Phone Number - Medium
    // https://leetcode.com/problems/letter-combinations-of-a-phone-number/

    // PATTERN: Backtrack: position-based choice

    // Time:  O(4^n * n)
    // Diyelim digits uzunluğu n. Her digit için ortalama 3 ya da 4 harf var.
    // Worst-case tümü 7 veya 9 gibi 4 harfli olsa: * n çünkü her sonucu string olarak kopyalıyoruz.

    // Space: O(n)

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }

        String[] map = {
                "", "", "abc", "def", "ghi",
                "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        backtrack(digits, 0, map, new StringBuilder(), result);
        return result;
    }

    private static void backtrack(String digits,
                                  int index,
                                  String[] map,
                                  StringBuilder current,
                                  List<String> result) {

        if (index == digits.length()) { // base case
            result.add(current.toString());
            return;
        }

        String letters = map[digits.charAt(index) - '0']; // recursive step

        for (char ch : letters.toCharArray()) {
            current.append(ch);
            backtrack(digits, index + 1, map, current, result);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
