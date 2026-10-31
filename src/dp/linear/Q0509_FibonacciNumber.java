package dp.linear;

import java.util.*;

public class Q0509_FibonacciNumber {
    // 509. Fibonacci Number - Easy
    // https://leetcode.com/problems/fibonacci-number/

    /* ------------------------------------------------------------
       | PATTERN: 1-D DP (iki değişken)
       ------------------------------------------------------------
       f(n) = f(n-1) + f(n-2). Sadece son iki değeri tutmak yeterli; dizi gerekmez.
    */
    /*  Complexity
        Time  : O(n)
        Space : O(1)
    */

    public static int fib(int n) {
        int a = 0, b = 1;
        while (n-- > 0) {
            int c = a + b;
            a = b;
            b = c;
        }
        return a;
    }
}
