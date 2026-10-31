package hashing;

import java.util.*;

public class Q0249_GroupShiftedStrings {
    // 249. Group Shifted Strings - Medium
    // https://leetcode.com/problems/group-shifted-strings/

    /* ------------------------------------------------------------
       | PATTERN: Hash Map (normalize edilmiş anahtar)
       ------------------------------------------------------------
       Her kelimeyi ilk harfi 'a' olacak şekilde kaydır; aynı gruptaki kelimeler aynı anahtarı üretir.
       Kaydırma mod 26 ile yapılır (z -> a geçişi). Anahtara göre map'te grupla.
    */
    /*  Complexity
        Time  : O(L) (toplam karakter)
        Space : O(L)
    */

    public static List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> g = new HashMap<>();
        for (var s : strings) {
            char[] t = s.toCharArray();
            int diff = t[0] - 'a';
            for (int i = 0; i < t.length; ++i) {
                t[i] = (char) (t[i] - diff);
                if (t[i] < 'a') {
                    t[i] += 26;
                }
            }
            g.computeIfAbsent(new String(t), k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(g.values());
    }
}
