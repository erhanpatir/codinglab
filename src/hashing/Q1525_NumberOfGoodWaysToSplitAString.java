package hashing;

import java.util.*;

public class Q1525_NumberOfGoodWaysToSplitAString {
    // 1525. Number of Good Ways to Split a String - Medium
    // https://leetcode.com/problems/number-of-good-ways-to-split-a-string/

    /* ------------------------------------------------------------
       | PATTERN: Hash / Counting (sol ve sağ farklı karakter sayısı)
       ------------------------------------------------------------
       Sağ taraf için tüm karakterlerin frekansını say. Soldan gezerken karakteri sol set'e ekle,
       sağdaki frekansını azalt (0 olursa sağ map'ten sil). Her ayrım noktasında sol set ile sağ map'in boyutları eşitse say.
    */
    /*  Complexity
        Time  : O(n)
        Space : O(Σ)
    */

    public static int numSplits(String s) {
        Map<Character, Integer> cnt = new HashMap<>();
        for (char c : s.toCharArray()) {
            cnt.merge(c, 1, Integer::sum);
        }
        Set<Character> vis = new HashSet<>();
        int ans = 0;
        for (char c : s.toCharArray()) {
            vis.add(c);
            if (cnt.merge(c, -1, Integer::sum) == 0) {
                cnt.remove(c);
            }
            if (vis.size() == cnt.size()) {
                ++ans;
            }
        }
        return ans;
    }
}
