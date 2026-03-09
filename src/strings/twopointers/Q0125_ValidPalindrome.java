package strings.twopointers;

// 125 - Valid Palindrome - Easy
// https://leetcode.com/problems/valid-palindrome/
public class Q0125_ValidPalindrome {
    /*
        Complexity Analysis
            Time Complexity: O(n), where n is the length of the input string.
                                   We traverse each character twice in the worst case
                                   (once for cleaning and once for palindrome checking).
            Space Complexity: O(n) for the cleaned buffer.
    */

    public static boolean isPalindrome(String s) {
        // Step 1: Clean the string using StringBuilder
        StringBuilder cleaned = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                cleaned.append(Character.toLowerCase(c));
            }
        }
        // Step 2: Initialize two pointers ✅
        int left = 0;
        int right = cleaned.length() - 1;

        // Step 3: Check palindrome property
        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                return false; // Not a palindrome if any mismatch occurs
            }
            left++;
            right--;
        }
        return true;
    }

    // Two-pointers: O(1) space
    //"A man, a plan, a canal: Panama")
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
