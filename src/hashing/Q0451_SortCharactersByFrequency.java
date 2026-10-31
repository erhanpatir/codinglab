package hashing;

import java.util.*;

public class Q0451_SortCharactersByFrequency {
    // 451. Sort Characters By Frequency - Medium
    // https://leetcode.com/problems/sort-characters-by-frequency/

    /* ------------------------------------------------------------
       | PATTERN: Hash Map + Sıralama (frekans)
       ------------------------------------------------------------
       Karakter frekanslarını say, karakterleri frekansa göre azalan sırala, her karakteri frekansı kadar yaz.
       Alternatif: bucket sort ile O(n).
    */
    /*  Complexity
        Time  : O(n + k log k)
        Space : O(n + k)
    */

    public static String frequencySort(String s) {
        Map<Character, Integer> cnt = new HashMap<>(52);
        for (int i = 0; i < s.length(); ++i) {
            cnt.merge(s.charAt(i), 1, Integer::sum);
        }
        List<Character> cs = new ArrayList<>(cnt.keySet());
        cs.sort((a, b) -> cnt.get(b) - cnt.get(a));
        StringBuilder ans = new StringBuilder();
        for (char c : cs) {
            for (int v = cnt.get(c); v > 0; --v) {
                ans.append(c);
            }
        }
        return ans.toString();
    }
}
