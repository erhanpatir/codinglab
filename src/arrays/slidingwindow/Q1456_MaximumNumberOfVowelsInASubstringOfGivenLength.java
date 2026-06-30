package arrays.slidingwindow;

public class Q1456_MaximumNumberOfVowelsInASubstringOfGivenLength {
    // 1456. Maximum Number of Vowels in a Substring of Given Length - Medium
    // https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/
    // --------------------------------------------
    // |PATTERN: Fixed Size Sliding Window      ✅|
    // --------------------------------------------
    /*
       Window size yine sabit: k

        State:
            currentVowels
            maxVowels

        Window kayarken:
            giren karakter vowel ise +1
            çıkan karakter vowel ise -1
        3. State / Invariant
        Invariant:
            currentVowels, her zaman current window içindeki vowel sayısını tutar.

        Kaydırma:
            right karakteri girer
            right - k karakteri çıkar
    */
    /* Complexity Analysis
        Time:  O(n)
        Space: O(1)
    */
    public static int maxVowels(String s, int k) {
        int currentVowels = 0;

        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                currentVowels++;
            }
        }
        int maxVowels = currentVowels;

        for (int i = k; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) {
                currentVowels++;
            }

            if (isVowel(s.charAt(i - k))) {
                currentVowels--;
            }

            maxVowels = Math.max(maxVowels, currentVowels);

            if (maxVowels == k) return maxVowels;
        }
        return maxVowels;
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
