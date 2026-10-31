package twopointers;

import java.util.*;

public class Q0647_PalindromicSubstrings {
    // 647. Palindromic Substrings - Medium
    // https://leetcode.com/problems/palindromic-substrings/

    /* ------------------------------------------------------------
       | PATTERN: Two Pointers - Expand Around Center
       ------------------------------------------------------------
       Her merkezden (2n - 1 merkez) genişlerken her başarılı adım bir palindrom demektir; hepsini say.
    */
    /*  Complexity
        Time  : O(n^2)
        Space : O(1)
    */

    public static int countSubstrings(String s) {
        int ans = 0;
        int n = s.length();
        for (int k = 0; k < n * 2 - 1; ++k) {
            int i = k / 2, j = (k + 1) / 2;
            while (i >= 0 && j < n && s.charAt(i) == s.charAt(j)) {
                ++ans;
                --i;
                ++j;
            }
        }
        return ans;
    }
}
