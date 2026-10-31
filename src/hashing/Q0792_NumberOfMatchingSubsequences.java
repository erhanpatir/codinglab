package hashing;

import java.util.*;

public class Q0792_NumberOfMatchingSubsequences {
    // 792. Number of Matching Subsequences - Medium
    // https://leetcode.com/problems/number-of-matching-subsequences/

    /* ------------------------------------------------------------
       | PATTERN: Hash / Bucketing (bekleyen kelimeler)
       ------------------------------------------------------------
       Kelimeleri bekledikleri sıradaki harfe göre 26 kovaya koy. s'yi bir kez gez:
       c harfinin kovasındaki her kelime bir harf ilerler; bitmişse sayılır, bitmemişse yeni beklediği harfin kovasına geçer.
       s yalnızca bir kez gezilir.
    */
    /*  Complexity
        Time  : O(|s| + toplam kelime uzunluğu)
        Space : O(kelime sayısı)
    */

    public static int numMatchingSubseq(String s, String[] words) {
        Deque<String>[] d = new Deque[26];
        Arrays.setAll(d, k -> new ArrayDeque<>());
        for (String w : words) {
            d[w.charAt(0) - 'a'].add(w);
        }
        int ans = 0;
        for (char c : s.toCharArray()) {
            var q = d[c - 'a'];
            for (int k = q.size(); k > 0; --k) {
                String t = q.pollFirst();
                if (t.length() == 1) {
                    ++ans;
                } else {
                    d[t.charAt(1) - 'a'].offer(t.substring(1));
                }
            }
        }
        return ans;
    }
}
