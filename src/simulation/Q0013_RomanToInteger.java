package simulation;

import java.util.*;

public class Q0013_RomanToInteger {
    // 13. Roman to Integer - Easy
    // https://leetcode.com/problems/roman-to-integer/

    /* ------------------------------------------------------------
       | PATTERN: Hash Map + Simülasyon
       ------------------------------------------------------------
       Sembol değerlerini map'te tut. Soldan sağa gez:
       bir sembolün değeri sağındakinden küçükse çıkar (IV = 5 - 1), değilse ekle.
       Son karakter her zaman eklenir.
    */
    /*  Complexity
        Time  : O(n)
        Space : O(1)
    */

    public static int romanToInt(String s) {
        String cs = "IVXLCDM";
        int[] vs = {1, 5, 10, 50, 100, 500, 1000};
        Map<Character, Integer> d = new HashMap<>();
        for (int i = 0; i < vs.length; ++i) {
            d.put(cs.charAt(i), vs[i]);
        }
        int n = s.length();
        int ans = d.get(s.charAt(n - 1));
        for (int i = 0; i < n - 1; ++i) {
            int sign = d.get(s.charAt(i)) < d.get(s.charAt(i + 1)) ? -1 : 1;
            ans += sign * d.get(s.charAt(i));
        }
        return ans;
    }
}
