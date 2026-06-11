package arrays.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class Q0003_LongestSubstringWithoutRepeatingCharacters {
    // 3. Longest Substring Without Repeating Characters - Medium
    // https://leetcode.com/problems/longest-substring-without-repeating-characters/
    /* -------------------------------------------------------
       |   PATTERN: Dynamic Sliding Window + HashSet       ✅|
       -------------------------------------------------------
       Window şu anki tekrar etmeyen substring’i temsil eder.
        State:
            left
            right
            Set<Character> seen
            maxLength
        right yeni karakteri eklemeye çalışır.
        Eğer karakter zaten window içindeyse:
            left'i ilerlet
            set'ten çıkar
        ta ki tekrar kaybolana kadar.

        3. State / Invariant
        Invariant:
            s[left ... right] window’u içinde duplicate karakter yoktur.
        Bu invariant bozulacaksa, önce left ilerletilerek düzeltilir.
    */
    /* Complexity
        Time: O(n)
        Space: O(min(n, charset))
    */
    public static int lengthOfLongestSubstring(String s) {

        Set<Character> seen = new HashSet<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);

            while (seen.contains(current)) {
                seen.remove(s.charAt(left));
                left++;
            }

            seen.add(current);

            int windowLength = right - left + 1;
            maxLength = Math.max(maxLength, windowLength);
        }

        return maxLength;
    }
}
