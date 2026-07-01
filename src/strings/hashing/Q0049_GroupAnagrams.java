package strings.hashing;

import java.util.*;

public class Q0049_GroupAnagrams {
    // 49. Group Anagrams - Medium
    // https://leetcode.com/problems/group-anagrams/

    // ------------------------------------------------------
    // | PATTERN: Frequency Signature                                    |
    // ------------------------------------------------------
    /* 2. Optimal Pattern
        Aynı anagramlar aynı signature’a sahip olmalı
        Mesela:
            eat -> aet
            tea -> aet
            ate -> aet
        Hepsinin sorted hali aynı.
        O zaman:
            signature -> list of words şeklinde HashMap tutarız.
    */
    /* Complexity:
        Time  : O(n * k log k)
        Space : O(n * k)
    */

    // Sorted Signature
    public static List<List<String>> groupAnagrams_sorting(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();

        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);     // Çünkü her kelimeyi sort ediyoruz.

            String key = new String(chars);

            groups
                    .computeIfAbsent(key, k -> new ArrayList<>())
                    .add(word);
        }

        return new ArrayList<>(groups.values());
    }

    /*
       Time: O(n * k)
       Space: O(n * k)
    */
    public static List<List<String>> groupAnagrams_frequency(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();

        for (String word : strs) {
            int[] count = new int[26];

            for (char c : word.toCharArray()) {
                count[c - 'a']++;
            }

            // frequency leri # ile ayirarak key olusturuyoruz.
            StringBuilder sb = new StringBuilder();
            for (int freq : count) {
                sb.append('#');
                sb.append(freq);
            }
            String key = sb.toString();

            groups
                    .computeIfAbsent(key, k -> new ArrayList<>())
                    .add(word);
        }
        return new ArrayList<>(groups.values());
    }
}
