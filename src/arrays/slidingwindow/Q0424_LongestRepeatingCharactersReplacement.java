package arrays.slidingwindow;

public class Q0424_LongestRepeatingCharactersReplacement {
    // 424. Longest Repeating Characters Replacement - Medium
    // https://leetcode.com/problems/longest-repeating-characters-replacement/

    /* ---------------------------------------------------------------
       |   PATTERN: Dynamic Sliding Window + Frequency Count       ✅|
       ---------------------------------------------------------------
       Bir window içindeyiz.
       Window’u aynı karaktere çevirmek için gereken değişim sayısı:
        windowLength - maxFrequency

        Örnek:
            window = "AABA"

        Frekans:
            A = 3
            B = 1
            windowLength = 4
            maxFrequency = 3
            needed replacements = 4 - 3 = 1

        Eğer:
            windowLength - maxFrequency <= k
        window valid.
    */
    /* Complexity
        Time: O(n)
        Space: O(1)
    */
    public static int characterReplacement(String s, int k) {
        int[] freq = new int[26];

        int left = 0;
        int maxFrequency = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);

            freq[current - 'A']++;
            maxFrequency = Math.max(maxFrequency, freq[current - 'A']);

            int windowLength = right - left + 1;

            while (windowLength - maxFrequency > k) { // window invalid
                char leftChar = s.charAt(left);
                freq[leftChar - 'A']--;
                left++;

                windowLength = right - left + 1;
            }

            maxLength = Math.max(maxLength, windowLength);
        }
        return maxLength;
    }
}
