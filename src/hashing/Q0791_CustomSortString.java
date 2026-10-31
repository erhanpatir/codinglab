package hashing;

import java.util.stream.*;
import java.util.*;

public class Q0791_CustomSortString {
    // 791. Custom Sort String - Medium
    // https://leetcode.com/problems/custom-sort-string/

    /* ------------------------------------------------------------
       | PATTERN: Hash / Custom Sort
       ------------------------------------------------------------
       order'daki her harfin konumunu tut ve s'nin karakterlerini bu konuma göre sırala
       (order'da olmayanların konumu 0). Takip: counting ile O(n) - önce order sırasıyla, sonra kalanlar.
    */
    /*  Complexity
        Time  : O(n log n)
        Space : O(n)
    */

    public static String customSortString(String order, String s) {
        int[] d = new int[26];
        for (int i = 0; i < order.length(); ++i) {
            d[order.charAt(i) - 'a'] = i;
        }
        List<Character> cs = new ArrayList<>();
        for (int i = 0; i < s.length(); ++i) {
            cs.add(s.charAt(i));
        }
        cs.sort((a, b) -> d[a - 'a'] - d[b - 'a']);
        return cs.stream().map(String::valueOf).collect(Collectors.joining());
    }
}
