package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q0394_DecodeString {
    // 394. Decode String - Medium
    // https://leetcode.com/problems/decode-string/
    /* ------------------------------------------------------------
       | PATTERN:  Sort by position + compare arrival times     ✅|
       ------------------------------------------------------------
    /* ⭐ İki stack kullanacağız:
            countStack  -> tekrar sayıları
            stringStack -> önceki string seviyeleri

       Ayrıca mevcut seviyede build edilen string:
        StringBuilder current

        Ve sayı parse etmek için:
            int number

        Her [ gördüğümüzde yeni nested seviyeye giriyoruz.
        O ana kadar elimizde olanları stack’e koyarız:

            number
            current string

        Sonra yeni seviyeye başlarız:
            current = empty
            number = 0

        Her ] gördüğümüzde mevcut seviyeyi bitiririz.
            repeat current count kadar
            önceki string'e ekle
     */
    /*  Complexity
            Time:  O(n + outputLength)
            Space: O(n + outputLength)
    */
    public static String decodeString(String s) {
        Deque<Integer> countStack = new ArrayDeque<>();         // repeat count
        Deque<StringBuilder> stringStack = new ArrayDeque<>();  // previous string

        StringBuilder current = new StringBuilder();
        int number = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                number = number * 10 + (c - '0'); // Çünkü sayı birden fazla digit olabilir.
            } else if (c == '[') {
                countStack.push(number);
                stringStack.push(current);

                // yeni seviye baslar
                current = new StringBuilder();
                number = 0;
            } else if (c == ']') {
                int repeat = countStack.pop();
                StringBuilder previous = stringStack.pop();

                for (int i = 0; i < repeat; i++) {
                    previous.append(current);
                }

                current = previous;
            } else {
                current.append(c);
            }
        }

        return current.toString();
    }
}
