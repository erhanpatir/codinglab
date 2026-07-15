package hashing;

import java.util.HashMap;
import java.util.Map;

public class Q0205_IsomorphicStrings {
    // 205. Isomorphic Strings - Easy
    // https://leetcode.com/problems/isomorphic-strings/
    /* ------------------------------------------------------------
       | PATTERN:             İki yönlü mapping                 ✅|
       ------------------------------------------------------------
    /* ⭐Optimal pattern
        İki yönlü mapping gerekir:
            s -> t
            t -> s

        Neden tek map yetmez?

        Örnek:
            s = "badc"
            t = "baba"

        Tek yönlü map ile:
            b -> b
            a -> a
            d -> b
            c -> a

        Her s karakteri kendi içinde tutarlı görünebilir.

        Ama farklı karakterler aynı hedefe gidiyor:
            b -> b
            d -> b

        Bu yasak.

        Bu yüzden iki map kullanırız:
            Map<Character, Character> sToT;
            Map<Character, Character> tToS;

        Her index için iki yönü de kontrol ederiz.
     */
    /*  Complexity
        Time: O(n)
        Space: O(k)
            k, farklı karakter sayısıdır.

        ASCII karakter seti sabit kabul edilirse:
        Space: O(1)
    */
    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> sToT = new HashMap<>();
        Map<Character, Character> tToS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if (sToT.containsKey(sChar)
                    && sToT.get(sChar) != tChar) {
                return false;
            }

            if (tToS.containsKey(tChar)
                    && tToS.get(tChar) != sChar) {
                return false;
            }

            sToT.put(sChar, tChar);
            tToS.put(tChar, sChar);
        }

        return true;
    }
    /* 5. Görselli dry run
            Örnek:
            s = "paper"
            t = "title"

            Başlangıç:
                sToT = {}
                tToS = {}

            i	s[i]	t[i]	İşlem	             sToT	                 tToS
            0	 p	     t	  yeni eşleşme	        {p=t}	                {t=p}
            1	 a	     i	  yeni eşleşme	        {p=t, a=i}	            {t=p, i=a}
            2	 p	     t	  mevcut eşleşme doğru	değişmez	            değişmez
            3	 e	     l	  yeni eşleşme	        {p=t, a=i, e=l}	        {t=p, i=a, l=e}
            4	 r	     e	  yeni eşleşme	        {p=t, a=i, e=l, r=e}	{t=p, i=a, l=e, e=r}

            Sonuç: true

            Mapping:
                p -> t
                a -> i
                e -> l
                r -> e
    */
}
