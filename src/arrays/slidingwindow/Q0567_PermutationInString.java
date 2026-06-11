package arrays.slidingwindow;

import java.util.Arrays;

public class Q0567_PermutationInString {
    // 567. Permutation in String - Medium
    // https://leetcode.com/problems/permutation-in-string/
    /* ------------------------------------------------------------------
       |   PATTERN: Fixed-size Sliding Window + Frequency Count       ✅|
       ------------------------------------------------------------------
       Permutation/anagram demek:
        same characters, same counts

        Window size sabit:
            s1.length()
        Yani s2 içinde her s1.length() uzunluğundaki window’un frequency’sini kontrol ederiz.

        3. State / Invariant
        State:
            targetFreq[26]
            windowFreq[26]
            window size = s1.length()

        Invariant:
            windowFreq, s2 içindeki current fixed-size window’un karakter frekanslarını tutar.

        Eğer:
            targetFreq == windowFreq
        ise permutation bulundu.
    */
    /* Complexity
        Her window’da Arrays.equals(freq1, freq2) yaparsak 26 karakter kontrol eder.
            Time: O(26 * n) => O(n)
            Space: O(1)
    */
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] target = new int[26];
        int[] window = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            target[s1.charAt(i) - 'a']++;
            window[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(target, window)) {
            return true;
        }

        for (int right = s1.length(); right < s2.length(); right++) {
            window[s2.charAt(right) - 'a']++; // window kaydigi icin right karakteri giriyor

            int left = right - s1.length();
            window[s2.charAt(left) - 'a']--; // window kaydigi icin left karakteri çıkıyor

            if (Arrays.equals(target, window)) {
                return true;
            }
        }

        return false;
    }
    /* Dry Run
     Window sağa kayıyor

        Eski window:
            "ei"

        Yeni window:
            "id"

        Ne oldu?
            e çıktı
            d girdi

        Yani frequency update:
            e: -1
            d: +1

        Window frequency:
            i:1
            d:1

        Target:
            a:1
            b:1

        Eşit mi?
            hayır
     */
}
