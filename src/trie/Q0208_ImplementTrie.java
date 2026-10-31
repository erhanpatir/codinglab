package trie;

import java.util.*;

public class Q0208_ImplementTrie {
    // Öncelik   : 🟡 Orta
    // Şirketler : Apple (#60)
    //
    // 208. Implement Trie (Prefix Tree) - Medium
    // https://leetcode.com/problems/implement-trie-prefix-tree/description/

    /* ------------------------------------------------------------
       | PATTERN: Trie (Prefix Tree)
       ------------------------------------------------------------
       Her düğümde 26 çocuk ve isEnd bayrağı.
       insert: karakterler için yoksa düğüm oluşturarak ilerle, sonda isEnd = true.
       search: yol varsa ve son düğüm isEnd ise true. startsWith: yolun var olması yeterli.
    */
    /*  Complexity
        Time  : O(L) her işlem
        Space : O(toplam karakter * 26)
    */

    public class Trie {
        private Trie[] children;
        private boolean isEnd;

        public Trie() {
            children = new Trie[26];
        }

        public void insert(String word) {
            Trie node = this;
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
            Trie node = searchPrefix(word);
            return node != null && node.isEnd;
        }

        public boolean startsWith(String prefix) {
            Trie node = searchPrefix(prefix);
            return node != null;
        }

        private Trie searchPrefix(String s) {
            Trie node = this;
            for (char c : s.toCharArray()) {
                int idx = c - 'a';
                if (node.children[idx] == null) {
                    return null;
                }
                node = node.children[idx];
            }
            return node;
        }
    }
}
