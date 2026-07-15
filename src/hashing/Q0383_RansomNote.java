package hashing;

import java.util.HashMap;
import java.util.Map;

public class Q0383_RansomNote {
    // 383. Ransom Note - Easy
    // https://leetcode.com/problems/ransom-note/
    /* -----------------------------------------------------------
      | PATTERN:           Resource Counting                   ✅|
      ------------------------------------------------------------
   /* ⭐Optimal pattern
            Bu soru bir resource counting problemidir.
            magazine, elimizdeki karakter kaynaklarını temsil eder.
            ransomNote, ihtiyaç duyduğumuz karakterleri temsil eder.
            Önce magazine içindeki karakterleri sayarız:
            freq[c] = magazine içinde c karakterinden kaç tane var?
            Sonra ransomNote üzerinde dolaşırız.
            Her karakter için:
            Bu karakterden elimizde var mı?

            Varsa bir tane tüketiriz:
                freq[c]--

            Yoksa:
                return false

            Temel mantık:
                1. Kaynakları say.
                2. İhtiyaçları tek tek tüket.
                3. Bir kaynak sıfırken tekrar gerekirse başarısız ol.
    */
    /*  Complexity
        HashMap çözümü
        m = magazine.length()
        r = ransomNote.length()

        Magazine’i saymak: O(m)
        Ransom note karakterlerini tüketmek: O(r)

        Toplam:
        Time: O(m + r)

        HashMap space: O(k)

        Burada k, farklı karakter sayısıdır.
        Soruda yalnızca lowercase English letters olduğu için en fazla 26 farklı karakter vardır.

        Bu nedenle teorik olarak:
            Space: O(1)

        Genel bir karakter kümesi düşünürsek:
            Space: O(k)
    */
    public static boolean canConstruct_hashMap(String ransomNote, String magazine) {
        Map<Character, Integer> frequency = new HashMap<>();

        for (char c : magazine.toCharArray()) {
            int available = frequency.getOrDefault(c, 0);

            if (available == 0) return false;

            frequency.put(c, available - 1);
        }

        return true;
    }

    public static boolean canConstruct_array(String ransomNote, String magazine) {
        int[] frequency = new int[26];

        for (char c : magazine.toCharArray()) {
            frequency[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            int index = c - 'a';

            if (frequency[index] == 0) return false;

            frequency[index]--;
        }

        return true;
    }
}
