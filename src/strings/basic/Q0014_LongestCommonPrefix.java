package strings.basic;

import java.util.Arrays;

// 14 - Longest Common Prefix - Easy
// https://leetcode.com/problems/longest-common-prefix/
public class Q0014_LongestCommonPrefix {
    /* COZUM :
        ✅ En pratik mantık (prefix’i kısaltarak gitmek)
        İlk kelimeyi prefix al.
        Diğer kelimeler prefix ile başlamıyorsa prefix’i 1 karakter kısalt.
        Prefix boşalırsa cevap "".

        ✅ Ya da string leri sort edip, ilk ve son
    */

    public static String longestCommonPrefix(String[] strs) {
        // TC : O(n logn)
        // SC : O(1)

        StringBuilder sb = new StringBuilder();
        // sort strings alphabetically
        Arrays.sort(strs);

        char[] firstStr = strs[0].toCharArray();
        char[] lastStr = strs[strs.length - 1].toCharArray();

        for (int i = 0; i < firstStr.length; i ++) {
            if (firstStr[i] != lastStr[i])
                break;
            sb.append(firstStr[i]);
        }
        System.out.println("Result: " + sb.toString());
        return sb.toString();
    }

    // Horizontal Scanning
    public static String longestCommonPrefix_2(String[] strs) {
        // TC : O(n)
        // SC : O(1)

        if (strs == null || strs.length == 0) return "";
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                // If prefix becomes empty, this means there is no common prefix
                if (prefix.isEmpty()) return "";
            }
        }
        System.out.println("Result: " + prefix);
        return prefix;
    }

    // Vertical Scanning
    public static String longestCommonPrefix_3(String[] strs) {
        // TC : O(n)
        // SC : O(1)

        if (strs == null || strs.length == 0) return "";
        var first = strs[0];

        for (int i = 0; i < first.length(); i++) {
            char c = first.charAt(i);

            for (int j = 1; j < strs.length; j++) {
                // If the character exceeds the length of one of the strings or the character doesn't match
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return first.substring(0, i);
                }
            }
        }
        System.out.println("Result: " + first);
        return first;
    }
}
