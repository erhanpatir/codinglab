package strings.subsequence;

// LeetCode 392 - Is Subsequence - Easy
// https://leetcode.com/problems/is-subsequence/
public class Q0392_IsSubsequence {
    /*
      Cozum mantigi: ✅
          Two pointer teknigini kullanabiliriz.Ikinci string'i tamamen dolasiyoruz ve s string inin
          karakterini sirayla kiyasliyoruz. Bunun icin de birer pointer kullanabiliriz.
          Varsa bir pointeri ilerletiriz. Yoksa diger pointeri ilerletiriz.
      Complexity Analysis
        Time Complexity: O(n), where n is the length of the array.
        Space Complexity: O(n), due to the use of additional array.
    */
    public static boolean isSubsequence(String s, String t) {
        // two pointer technique
        int i = 0, j = 0;
        // iterate through strings
        while (i < s.length() && j < t.length()) {
            // If characters match, move the pointer for s
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            // Always move the pointer for t
            j++;
        }
        // If i is equal to the length of s, all characters of s were found in t
        return i == s.length();
    }

    public static boolean isSubsequence_2(String s, String t) {
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
}
