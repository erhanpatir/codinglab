package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q0227_BasicCalculator2 {
    // Öncelik   : ⭐ Gerçek deneyim  ·  🌍 Ortak soru
    // Şirketler : Meta (#7), Apple ✅ (#46)
    // Seviye    : Mid, Senior, Staff
    // Raporlar  : 3 (1 📍London)
    //             https://leetcode.com/discuss/post/6485719/meta-e4-software-engineer-interview-expe-osx7/
    //
    // 227. Basic Calculator II - Medium
    // https://leetcode.com/problems/basic-calculator-ii/
    /* ------------------------------------------------------------
       | PATTERN:                   STACK                       ✅|
       ------------------------------------------------------------
    /* ⭐ Stack kullanacağız.
            Ana fikir:
                + number  -> stack'e +number koy
                - number  -> stack'e -number koy
                * number  -> önceki sayıyı pop et, çarp, geri koy
                / number  -> önceki sayıyı pop et, böl, geri koy

            En sonda stack’teki her şeyi toplarız.

            State / Invariant
            Şu state’leri tutarız:
                int number
                char operation
                stack

            Invariant:
            Stack, önceliği çözülmüş ara değerleri tutar.

            Örneğin: 3 + 2 * 2
            Stack süreci:
                +3      -> [3]
                +2      -> [3, 2]
                *2      -> [3, 4]
                sum     -> 7
     */
    /*  Complexity
        Time
        String bir kere gezilir.
        Stack en fazla sayı sayısı kadar büyür.
            O(n)
        Space
            O(n)
    */
    public static int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();

        int number = 0;
        char operation = '+';

        for (int i =0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                number = number * 10 + (c - '0');
            }

            if ((!Character.isDigit(c) && c != ' ') // operator ise
                    || i == s.length() - 1) {       // ya da son sayi ise
                if (operation == '+') {
                    stack.push(number);
                } else if (operation == '-') {
                    stack.push(-number);
                } else if (operation == '*') {
                    stack.push(stack.pop() * number);
                } else if (operation == '/') {
                    stack.push(stack.pop() / number);
                }
                operation = c;
                number = 0;
            }
        }
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }
}
