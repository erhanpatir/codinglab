package hashing;

import java.util.HashMap;
import java.util.Map;

public class Q1189_MaximumNumberOfBalloons {
    // 1189. Maximum Number of Balloons - Easy
    // https://leetcode.com/problems/maximum-number-of-balloons/
    /* -----------------------------------------------------------
      | PATTERN:           Frequency Counting                  ✅|
      ------------------------------------------------------------
   /* ⭐Optimal pattern
        Bu soru klasik bir frequency counting sorusu.
        HashMap / array ile her harfin kaç kez geçtiğini sayarız.
        Sonra "balloon" için gerekli harflere bakarız:

            b: count[b] / 1
            a: count[a] / 1
            l: count[l] / 2
            o: count[o] / 2
            n: count[n] / 1

        Cevap bunların minimumudur.
        Çünkü "balloon" oluşturmak için tüm harfler yeterli olmalı.

        answer = min(
          count[b],
          count[a],
          count[l] / 2,
          count[o] / 2,
          count[n]
        )
    */
    /*  Complexity
        n = text.length()
        HashMap veya array ile sayma:

        Time: O(n)
        Space: O(1)

        Neden space O(1)?
        Çünkü sadece küçük harf İngilizce karakterleri sayıyoruz. En fazla 26 harf var.
    */
    public static int maxNumberOfBalloons(String text) {
        Map<Character, Integer> freq = new HashMap<>();

        for (char c : text.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        int b = freq.getOrDefault('b', 0);
        int a = freq.getOrDefault('a', 0);
        int l = freq.getOrDefault('l', 0) / 2;
        int o = freq.getOrDefault('o', 0) / 2;
        int n = freq.getOrDefault('n', 0);

        return Math.min(
                Math.min(b, a),
                Math.min(Math.min(l, o), n)
        );
    }

    public static int maxNumberOfBalloons_array(String text) {
        int[] freq = new int[26];

        for (char c : text.toCharArray()) {
            freq[c - 'a']++;
        }

        int b = freq['b' - 'a'];
        int a = freq['a' - 'a'];
        int l = freq['l' - 'a'] / 2;
        int o = freq['o' - 'a'] / 2;
        int n = freq['n' - 'a'];


        return Math.min(
                Math.min(b, a),
                Math.min(Math.min(l, o), n)
        );
    }
}
