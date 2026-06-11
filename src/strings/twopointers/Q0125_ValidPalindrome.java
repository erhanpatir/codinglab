package strings.twopointers;

public class Q0125_ValidPalindrome {
    // 125 - Valid Palindrome - Easy
    // https://leetcode.com/problems/valid-palindrome/
    // --------------------------------------------
    // |PATTERN: Two Pointers                   ✅|
    // --------------------------------------------
    /*
        Bir pointer başta, bir pointer sonda:
            left = 0
            right = s.length() - 1

        Alphanumeric olmayan karakterleri skip ederiz.
        Sonra karakterleri lowercase olarak karşılaştırırız.
    */
    /*
        Complexity Analysis
        Time: O(n)
        Space: O(n)
    */
    public static boolean isPalindrome(String s) {
        StringBuilder cleaned = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                cleaned.append(Character.toLowerCase(c));
            }
        }

        int left = 0;
        int right = cleaned.length() - 1;

        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                return false; // Not a palindrome if any mismatch occurs
            }
            left++;
            right--;
        }
        return true;
    }

    // Time: O(n)
    // Space: O(1)
    public static boolean isPalindrome_2(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right++;
            }

            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }
        return true;
    }
}
