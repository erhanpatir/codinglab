package strings.hashing;

public class Q0242_ValidAnagram {
    // 242. Valid Anagram - Easy
    // https://leetcode.com/problems/valid-anagram/
    // ------------------------------------------------------
    // | PATTERN: Frequency Counting                                    |
    // ------------------------------------------------------
    /* 2. Optimal Pattern
        Array, s ve t arasındaki karakter frekans farkını tutar.

        Şöyle yaparız:
            s karakterleri için +1
            t karakterleri için -1

        En sonda her şey sıfırsa:
            aynı karakterler aynı sayıda var
        Sıfır olmayan bir değer varsa:
            anagram değildir.
    */
    /* Complexity:
        Time  : O(n)
        Space : O(1)
    */
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] counts = new int[26]; // array for all english letters

        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
            counts[t.charAt(i) - 'a']--;
        }

        for (int count : counts) {
            if (count != 0) return false;
        }
        return true;
    }
}
