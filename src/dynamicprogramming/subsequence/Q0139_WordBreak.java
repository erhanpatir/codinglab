package dynamicprogramming.subsequence;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q0139_WordBreak {
    // 139. Word Break - Medium
    // https://leetcode.com/problems/word-break/

    /*  -----------------------------------------------
        | PATTERN: String DP + segmentation           |
        -----------------------------------------------
         STATE
        ------------
            dp[i] = s'in ilk i karakteri wordDict ile oluşturulabilir mi?
            Örnek:
                dp[4]
                şu demek: s[0...3] oluşturulabilir mi?
        ------------
         TRANSITION
        ------------
        dp[i] = true if exists j:
                dp[j] && dict.contains(s.substring(j, i))
    */

    /* Complexity
        Time  : genelde O(n² * k) denir.
        Space : O(n + dictionary size)
    */
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true; // Çünkü boş string oluşturulabilir.

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && words.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}
