package arrays.slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q0438_FindAllAnagramsInAString {
    // 438. Find All Anagrams in a String - Medium
    // https://leetcode.com/problems/find-all-anagrams-in-a-string/
    /* -------------------------------------------
       |   PATTERN: Fixed Sliding Window       ✅|
       -------------------------------------------
       Window boyutu: p.length()
       Target frequency: p

       Window frequency:
           current window

       Eğer:
           targetFreq == windowFreq
       ise:
           result.add(windowStart)

       3. State / Invariant
        State:
            target[26]
            window[26]

        Invariant:
         window array'i her zaman current substring'in frekansını temsil eder.
    */
    /* Complexity
        Time: O(n)
        Space: O(1)
    */
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if (p.length() > s.length()) {
            return result;
        }

        int[] target = new int[26];
        int[] window = new int[26];

        for (int i = 0; i < p.length(); i++) {
            target[p.charAt(i) - 'a']++;
            window[s.charAt(i) - 'a']++;
        }

        if (Arrays.equals(target, window)) {
            result.add(0);
        }

        for (int right = p.length(); right < s.length(); right++) {

            window[s.charAt(right) - 'a']++;

            int left = right - p.length();

            window[s.charAt(left) - 'a']--;

            // compare frequency
            if (Arrays.equals(target, window)) {
                result.add(left + 1);
            }
        }

        return result;
    }
}
