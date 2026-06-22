package stack.basic;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Q0020_ValidParentheses {
    // 20. Valid Parentheses - Easy
    // https://leetcode.com/problems/valid-parentheses/
    /* ------------------------------------------------------
       | PATTERN: Stack                                   ✅|
       ------------------------------------------------------
    /* Stack içinde sadece henüz kapanmamış açılış parantezlerini tutacağız.
        Invariant:
        Stack her zaman şu ana kadar açılmış ama kapanmamış parantezleri tutar.

        Kurallar:
        Eğer karakter açılışsa: (  {  [
            stack’e push et.

        Eğer karakter kapanışsa: )  }  ]

        stack boşsa false.
        Stack’in tepesindeki açılış bu kapanışla eşleşmiyorsa false.
        Eşleşiyorsa pop et.
        En sonda stack boşsa true.
    */
    /*
        Complexity Analysis
            Time Complexity: O(n)
            Space Complexity: O(n)
    */
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(Character ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                // If stack is empty, there's no matching opening bracket
                if(stack.isEmpty()) return false;

                char top = stack.pop();

                if(ch == ')' && top != '(') return false;
                if(ch == ']' && top != '[') return false;
                if(ch == '}' && top != '{') return false;
            }
        }

        return stack.empty();
    }

    public boolean isValid_mine(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character,Character> charMap = new HashMap<>();
        charMap.put('(', ')');
        charMap.put('[', ']');
        charMap.put('{', '}');

        for(Character ch : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(ch);
            } else {
                if(ch == charMap.get(stack.peek())) {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }
        }

        return stack.empty();
    }
}
