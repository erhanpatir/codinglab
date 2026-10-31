package twopointers;

import java.util.*;

public class Q0151_ReverseWordsInAString {
    // 151. Reverse Words in a String - Medium
    // https://leetcode.com/problems/reverse-words-in-a-string/

    /* ------------------------------------------------------------
       | PATTERN: Two Pointers (kelime kelime)
       ------------------------------------------------------------
       String'i iki pointer ile gezip boşluklarla ayrılmış kelimeleri çıkar, listeye ekle.
       Listeyi ters çevirip tek boşlukla birleştir. Fazla boşluklar kendiliğinden atılır.
    */
    /*  Complexity
        Time  : O(n)
        Space : O(n)
    */

    public static String reverseWords(String s) {
        List<String> words = new ArrayList<>();
        int n = s.length();
        for (int i = 0; i < n;) {
            while (i < n && s.charAt(i) == ' ') {
                ++i;
            }
            if (i < n) {
                StringBuilder t = new StringBuilder();
                int j = i;
                while (j < n && s.charAt(j) != ' ') {
                    t.append(s.charAt(j++));
                }
                words.add(t.toString());
                i = j;
            }
        }
        Collections.reverse(words);
        return String.join(" ", words);
    }
}
