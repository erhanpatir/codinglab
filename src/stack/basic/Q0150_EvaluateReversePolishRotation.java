package stack.basic;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q0150_EvaluateReversePolishRotation {
    // 150. Evaluate Reverse Polish Notation - Medium
    // https://leetcode.com/problems/evaluate-reverse-polish-notation/
    /* ------------------------------------------------------
       | PATTERN:    Stack ile expression evaluation      ✅|
       ------------------------------------------------------
    /* Kural:
        Sayı gördün → stack’e push
        Operator gördün → stack’ten iki sayı pop et
        İşlemi yap
        Sonucu tekrar stack’e push et
        En sonda stack’te tek sayı kalır.
        O sayı cevap olur.

        Dikkat:
            Çıkarma ve bölmede sıra önemli.
                a - b
                a / b
        Stack’ten önce çıkan b, sonra çıkan a olur.
        int b = stack.pop();
        int a = stack.pop()
    */
    /*  Complexity
        Time: O(n)
            Her token bir kere işlenir.
        Space: O(n)
            Worst case bütün token’lar sayı olabilir.
    */
    public static int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String token : tokens) {
            if (isOperator(token)) {
                int b = stack.pop();
                int a = stack.pop();

                int result = apply(a, b, token);
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    private static boolean isOperator(String token) {
        return token.equals("+")
                || token.equals("-")
                || token.equals("*")
                || token.equals("/");
    }

    private static int apply(int a, int b, String operator) {
        if (operator.equals("+")) {
            return a + b;
        }

        if (operator.equals("-")) {
            return a - b;
        }

        if (operator.equals("*")) {
            return a * b;
        }

        return a / b;
    }
}
