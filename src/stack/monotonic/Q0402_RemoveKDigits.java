package stack.monotonic;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q0402_RemoveKDigits {
    // 402. Remove K Digits - Medium
    // https://leetcode.com/problems/remove-k-digits/
    /* ------------------------------------------------------------
       | PATTERN:        Monotonic Increasing Stack             ✅|
       ------------------------------------------------------------
    /* ⭐ Şu mantık kritik:
            Solda büyük digit, sağda daha küçük digit varsa,
            soldaki büyük digit’i silmek sayıyı küçültür.

            Örnek: 1432219

            4ten sonra 3 geliyor.
                14...
                13...

            13..., 14...ten küçüktür.
            O yüzden 4 silinmeli.

            Bu pattern: Monotonic Increasing Stack ⭐
            Stack içinde digit’leri increasing tutmaya çalışırız.
            ---------------------------------------
            State / Invariant
            Invariant:
            Stack mümkün olduğunca increasing digit sırası tutar.
            Her yeni digit için:
                while stack top > current digit and k > 0:
                    pop
                    k--

            Sonra current digit push edilir.
            En sonunda hâlâ k > 0 ise, sondan sileriz.
            Çünkü sayı zaten increasing kalmıştır; en büyük katkı sondaki digit’lerdedir.
     */
    /*  Complexity
        Time
            Her digit stack’e bir kere girer, en fazla bir kere çıkar.
                O(n)
            Leading zero cleanup da bir kere gezer.
            Toplam: O(n)
        Space
            Stack ve result: O(n)
    */
    public static String removeKdigits(String num, int k) {
        Deque<Character> stack = new ArrayDeque<>();
        // result oluştururken başa ekleme yapmamak için addLast/removeLast kullanmak daha temiz.
        for (char digit : num.toCharArray()) {
            while (!stack.isEmpty()
                    && k > 0
                    && stack.peekLast() > digit) {

                stack.removeLast();
                k--;
            }

            stack.addLast(digit);
        }

        // edge case: k hâlâ kaldıysa
        while (k > 0 && !stack.isEmpty()) {
            stack.removeLast();
            k--;
        }

        StringBuilder result = new StringBuilder();

        boolean leadingZero = true;

        // edge case: leading zero lari temizle
        for (char digit : stack) {
            if (leadingZero && digit == '0') {
                continue;
            }

            leadingZero = false;
            result.append(digit);
        }

        // edge case: hepsi silinirse sonuc 0'dir.
        return result.length() == 0 ? "0" : result.toString();
    }

    /* Görselli Dry Run
---------------------------------
        Input:
            num = "1432219"
            k = 3
---------------------------------
        Başlangıç:

            stack = []
            k = 3
            digit = '1'

        Push.

            stack = [1]
            k = 3
            digit = '4'

        Top 1.
            1 > 4 ? false
            Push.
            stack = [1,4]
            k = 3
            digit = '3'

        Top 4.
            4 > 3
            Pop 4.
            stack = [1]
            k = 2

        Top 1.
            1 > 3 ? false
            Push 3.
            stack = [1,3]
            k = 2
            digit = '2'

        Top 3.

            3 > 2
            Pop 3.
            stack = [1]
            k = 1

        Top 1.

            1 > 2 ? false
            Push 2.
            stack = [1,2]
            k = 1
            digit = '2'

        Top 2.

            2 > 2 ? false
            Push.
            stack = [1,2,2]
            k = 1
            Not: Equal olduğunda pop yapmıyoruz. Çünkü relative order korunur.
            digit = '1'

        Top 2.

            2 > 1
            Pop.
            stack = [1,2]
            k = 0
            Artık silme hakkı bitti.
            Push 1.
            stack = [1,2,1]
            k = 0
            digit = '9'
            k = 0 olduğu için pop yok.
            Push.

        stack = [1,2,1,9]

        Final: 1219
    */
}
