package trie;

import java.util.*;

public class Q0648_ReplaceWords {
    // 648. Replace Words - Medium
    // https://leetcode.com/problems/replace-words/description/

    /* ------------------------------------------------------------
       | PATTERN: Trie (en kısa kök)
       ------------------------------------------------------------
       Kökleri Trie'ye ekle. Her kelime için Trie'de ilerle; ilk isEnd düğümünde o kökü döndür,
       yol koparsa kelimenin kendisini döndür. En kısa kök otomatik olarak ilk bulunur.
    */
    /*  Complexity
        Time  : O(toplam karakter)
        Space : O(sözlük boyutu)
    */

    public static String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for (String w : dictionary) {
            trie.insert(w);
        }

        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            words[i] = trie.search(words[i]);
        }
        return String.join(" ", words);
    }

    static class Trie {
        Trie[] children = new Trie[26];
        boolean isEnd = false;

        void insert(String w) {
            Trie node = this;
            for (char c : w.toCharArray()) {
                int idx = c - 'a';
                if (node.children[idx] == null) {
                    node.children[idx] = new Trie();
                }
                node = node.children[idx];
            }
            node.isEnd = true;
        }

        String search(String w) {
            Trie node = this;
            for (int i = 0; i < w.length(); i++) {
                int idx = w.charAt(i) - 'a';
                if (node.children[idx] == null) {
                    return w;
                }
                node = node.children[idx];
                if (node.isEnd) {
                    return w.substring(0, i + 1);
                }
            }
            return w;
        }
    }
}
