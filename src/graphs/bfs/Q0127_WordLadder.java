package graphs.bfs;

import java.util.*;

public class Q0127_WordLadder {
    // Öncelik   : ⭐ Gerçek deneyim  ·  🌍 Ortak soru
    // Şirketler : Meta ✅ (#89), Amazon ✅ (#33), Apple ✅ (#29)
    // Raporlar  : 1
    //             https://www.vervecopilot.com/blog/apple-leetcode-interview-questions
    //
    // 127. Word Ladder - Hard
    // https://leetcode.com/problems/word-ladder/

    /* ------------------------------------------------------------
       | PATTERN: Graph BFS (kelimeler düğüm, tek harf fark kenar)
       ------------------------------------------------------------
       beginWord'den başlayarak seviye seviye BFS yap; seviye sayısı dönüşüm sayısıdır.
       Her kelimenin her pozisyonuna 'a'..'z' dene; oluşan kelime sözlükteyse kuyruğa ekle ve
       sözlükten sil (visited yerine geçer). endWord'e ulaşınca seviye döner, ulaşılamazsa 0.
    */
    /*  Complexity
        Time  : O(N * L * 26) (N kelime, L uzunluk)
        Space : O(N * L)
    */

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        Queue<String> q = new ArrayDeque<>();
        q.offer(beginWord);
        int ans = 1;
        while (!q.isEmpty()) {
            ++ans;
            for (int i = q.size(); i > 0; --i) {
                String s = q.poll();
                char[] chars = s.toCharArray();
                for (int j = 0; j < chars.length; ++j) {
                    char ch = chars[j];
                    for (char k = 'a'; k <= 'z'; ++k) {
                        chars[j] = k;
                        String t = new String(chars);
                        if (!words.contains(t)) {
                            continue;
                        }
                        if (endWord.equals(t)) {
                            return ans;
                        }
                        q.offer(t);
                        words.remove(t);
                    }
                    chars[j] = ch;
                }
            }
        }
        return 0;
    }
}
