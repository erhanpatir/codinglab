package trie;

import java.util.*;

public class Q0677_MapSumPairs {
    // 677. Map Sum Pairs - Medium
    // https://leetcode.com/problems/map-sum-pairs/description/

    /* ------------------------------------------------------------
       | PATTERN: Trie + Hash Map (prefix toplamı)
       ------------------------------------------------------------
       Trie'nin her düğümünde o önekle başlayan anahtarların toplamı tutulur.
       insert'te key daha önce varsa farkı (yeni - eski) yol boyunca ekle. sum(prefix) doğrudan son düğümdeki değer.
    */
    /*  Complexity
        Time  : insert O(L), sum O(L)
        Space : O(toplam karakter)
    */

    public class MapSum {
        private Map<String, Integer> d = new HashMap<>();
        private Trie trie = new Trie();

        public MapSum() {
        }

        public void insert(String key, int val) {
            int x = val - d.getOrDefault(key, 0);
            d.put(key, val);
            trie.insert(key, x);
        }

        public int sum(String prefix) {
            return trie.search(prefix);
        }
    }

    static class Trie {
        private Trie[] children = new Trie[26];
        private int val;

        public void insert(String w, int x) {
            Trie node = this;
            for (int i = 0; i < w.length(); ++i) {
                int idx = w.charAt(i) - 'a';
                if (node.children[idx] == null) {
                    node.children[idx] = new Trie();
                }
                node = node.children[idx];
                node.val += x;
            }
        }

        public int search(String w) {
            Trie node = this;
            for (int i = 0; i < w.length(); ++i) {
                int idx = w.charAt(i) - 'a';
                if (node.children[idx] == null) {
                    return 0;
                }
                node = node.children[idx];
            }
            return node.val;
        }
    }
}
