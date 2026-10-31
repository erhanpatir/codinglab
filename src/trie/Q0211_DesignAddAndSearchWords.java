package trie;

import java.util.*;

public class Q0211_DesignAddAndSearchWords {
    // 211. Design Add and Search Words Data Structure - Medium
    // https://leetcode.com/problems/design-add-and-search-words-data-structure/description/

    /* ------------------------------------------------------------
       | PATTERN: Trie + DFS (wildcard arama)
       ------------------------------------------------------------
       addWord standart Trie ekleme. search'te '.' karakteri tüm çocukları denemek demek:
       recursive DFS ile '.' için 26 dalın her birinde aramaya devam et, normal karakterde tek dal.
    */
    /*  Complexity
        Time  : add O(L), search worst O(26^L)
        Space : O(toplam karakter)
    */

    public class WordDictionary {
        private Trie trie;


        public WordDictionary() {
            trie = new Trie();
        }

        public void addWord(String word) {
            Trie node = trie;
            for (char c : word.toCharArray()) {
                int idx = c - 'a';
                if (node.children[idx] == null) {
                    node.children[idx] = new Trie();
                }
                node = node.children[idx];
            }
            node.isEnd = true;
        }

        public boolean search(String word) {
            return search(word, trie);
        }

        private boolean search(String word, Trie node) {
            for (int i = 0; i < word.length(); ++i) {
                char c = word.charAt(i);
                int idx = c - 'a';
                if (c != '.' && node.children[idx] == null) {
                    return false;
                }
                if (c == '.') {
                    for (Trie child : node.children) {
                        if (child != null && search(word.substring(i + 1), child)) {
                            return true;
                        }
                    }
                    return false;
                }
                node = node.children[idx];
            }
            return node.isEnd;
        }
    }

    static class Trie {
        Trie[] children = new Trie[26];
        boolean isEnd;
    }
}
