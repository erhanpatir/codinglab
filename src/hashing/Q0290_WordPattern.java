package hashing;

import java.util.HashMap;
import java.util.Map;

public class Q0290_WordPattern {
    // 290. Word Pattern - Easy
    // https://leetcode.com/problems/word-pattern/
    /* ------------------------------------------------------------
       | PATTERN:              Hashing                          ✅|
       ------------------------------------------------------------
    /* ⭐Optimal pattern
        Bu soru, 205. Isomorphic Strings ile aynı temel pattern’e sahiptir.
        İki yönlü mapping gerekir:
            character -> word
            word -> character

        Neden iki map?

        Örnek:
            pattern = "abba"
            s = "dog dog dog dog"

        Tek map kullanırsak:
            a -> dog
            b -> dog

        gibi iki farklı karakter aynı kelimeye eşleşebilir.

        Bu yasaktır.

        Bu yüzden:
            Map<Character, String> charToWord;
            Map<String, Character> wordToChar;
        kullanırız.
     */
    /*  Complexity
        n, kelime sayısı olsun.
        Time: O(n)
        Space: O(n)
        split işlemi ve HashMap erişimleriyle toplam lineer zamanda çalışır.
    */
    public static boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");

        if (pattern.length() != words.length) {
            return false;
        }

        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char character = pattern.charAt(i);
            String word = words[i];

            // String karşılaştırırken .equals() kullanıyoruz.
            // Çünkü String bir object’tir ve içerik karşılaştırması .equals() ile yapılır.
            if (charToWord.containsKey(character)
                    && !charToWord.get(character).equals(word)) {
                return false;
            }

            if (wordToChar.containsKey(word)
                    && wordToChar.get(word) != character) {
                return false;
            }

            charToWord.put(character, word);
            wordToChar.put(word, character);
        }

        return true;
    }
}
