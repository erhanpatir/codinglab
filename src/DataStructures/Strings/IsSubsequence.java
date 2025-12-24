package DataStructures.Strings;

/*  392. Is Subsequence - Easy
        Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
        A subsequence of a string is a new string that is formed from the original string
        by deleting some (can be none) of the characters without disturbing
        the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

        Example 1:

        Input: s = "abc", t = "ahbgdc"
        Output: true
        Example 2:

        Input: s = "axc", t = "ahbgdc"
        Output: false

     Complexity Analysis
        Time Complexity: O(n),  where n is the length of the array.
        Space Complexity: O(n), due to the use of additional array.
*/

/*
      Cozum mantigi: ✅

      Two pointer teknigini kullanabiliriz.Ikinci string'i tamamen dolasiyoruz ve s string inin
      karakterini sirayla kiyasliyoruz. Bunun icin de birer pointer kullanabiliriz.
      Varsa bir pointeri ilerletiriz. Yoksa diger pointeri ilerletiriz.
*/
public class IsSubsequence {
    public static boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) return true;
        if (t.isEmpty()) return false;

        var sIndex = 0;

        for (char tChar : t.toCharArray()) {
            if (tChar == s.charAt(sIndex)) {
                sIndex++;
                if (sIndex == s.length()) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean isSubsequence_2(String s, String t) {
        // two pointer technique
        int i = 0, j = 0;

        // iterate through strings
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }

        return i == s.length();
    }
}
