package stack;

import java.util.stream.*;
import java.util.*;

public class Q0735_AsteroidCollision {
    // 735. Asteroid Collision - Medium
    // https://leetcode.com/problems/asteroid-collision/

    /* ------------------------------------------------------------
       | PATTERN: Stack (çarpışma simülasyonu)
       ------------------------------------------------------------
       Stack hayatta kalan asteroidleri tutar. Negatif (sola giden) asteroid geldiğinde,
       tepedeki pozitif ve daha küçük asteroidleri pop et. Eşitse ikisi de yok olur.
       Tepe negatifse ya da stack boşsa yeni asteroid push edilir.
    */
    /*  Complexity
        Time  : O(n)
        Space : O(n)
    */

    public static int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stk = new ArrayDeque<>();
        for (int x : asteroids) {
            if (x > 0) {
                stk.offerLast(x);
            } else {
                while (!stk.isEmpty() && stk.peekLast() > 0 && stk.peekLast() < -x) {
                    stk.pollLast();
                }
                if (!stk.isEmpty() && stk.peekLast() == -x) {
                    stk.pollLast();
                } else if (stk.isEmpty() || stk.peekLast() < 0) {
                    stk.offerLast(x);
                }
            }
        }
        return stk.stream().mapToInt(Integer::valueOf).toArray();
    }
}
