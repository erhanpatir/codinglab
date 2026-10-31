package simulation;

import java.util.*;

public class Q0824_GoatLatin {
    // Öncelik   : 🟡 Orta
    // Şirketler : Meta (#76)
    //
    // 824. Goat Latin - Easy
    // https://leetcode.com/problems/goat-latin/

    /* ------------------------------------------------------------
       | PATTERN: String Simülasyon
       ------------------------------------------------------------
       Kelimeleri ayır. Sesli harfle başlıyorsa olduğu gibi al, değilse ilk harfi sona taşı.
       Sonra "ma" ve kelimenin sırası kadar "a" ekle.
    */
    /*  Complexity
        Time  : O(n^2) (eklenen 'a'lar nedeniyle)
        Space : O(n^2)
    */

    public static String toGoatLatin(String sentence) {
        List<String> ans = new ArrayList<>();
        Set<Character> vowels
            = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        int i = 1;
        for (String word : sentence.split(" ")) {
            StringBuilder t = new StringBuilder();
            if (!vowels.contains(word.charAt(0))) {
                t.append(word.substring(1));
                t.append(word.charAt(0));
            } else {
                t.append(word);
            }
            t.append("ma");
            for (int j = 0; j < i; ++j) {
                t.append("a");
            }
            ++i;
            ans.add(t.toString());
        }
        return String.join(" ", ans);
    }
}
