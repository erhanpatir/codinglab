package trie;

import java.util.*;

public class Q1268_SearchSuggestionsSystem {
    // 1268. Search Suggestions System - Medium
    // https://leetcode.com/problems/search-suggestions-system/description/

    /* ------------------------------------------------------------
       | PATTERN: Trie + Sıralama
       ------------------------------------------------------------
       Ürünleri sırala ve Trie'ye ekle; her düğümde bu önekle başlayan ilk 3 ürünün indeksini tut
       (sıralı eklendiği için ilk gelenler sözlük sırasına göre en küçükler). searchWord'ün her öneki için
       o düğümdeki listeyi döndür, yol koparsa boş liste. Alternatif: sıralı dizide binary search.
    */
    /*  Complexity
        Time  : O(L * log n + m)
        Space : O(L)
    */

    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        Trie trie = new Trie();
        for (int i = 0; i < products.length; ++i) {
            trie.insert(products[i], i);
        }
        List<List<String>> ans = new ArrayList<>();
        for (var v : trie.search(searchWord)) {
            List<String> t = new ArrayList<>();
            for (int i : v) {
                t.add(products[i]);
            }
            ans.add(t);
        }
        return ans;
    }

    static class Trie {
        Trie[] children = new Trie[26];
        List<Integer> v = new ArrayList<>();

        public void insert(String w, int i) {
            Trie node = this;
            for (int j = 0; j < w.length(); ++j) {
                int idx = w.charAt(j) - 'a';
                if (node.children[idx] == null) {
                    node.children[idx] = new Trie();
                }
                node = node.children[idx];
                if (node.v.size() < 3) {
                    node.v.add(i);
                }
            }
        }

        public List<Integer>[] search(String w) {
            Trie node = this;
            int n = w.length();
            List<Integer>[] ans = new List[n];
            Arrays.setAll(ans, k -> new ArrayList<>());
            for (int i = 0; i < n; ++i) {
                int idx = w.charAt(i) - 'a';
                if (node.children[idx] == null) {
                    break;
                }
                node = node.children[idx];
                ans[i] = node.v;
            }
            return ans;
        }
    }
}
