package bit;

import java.util.*;

public class Q0231_PowerOfTwo {
    // 231. Power of Two - Easy
    // https://leetcode.com/problems/power-of-two/

    /* ------------------------------------------------------------
       | PATTERN: Bit Manipulation
       ------------------------------------------------------------
       2'nin kuvvetlerinde tam bir 1 biti vardır. n > 0 ve n & (n - 1) == 0 ise n 2'nin kuvvetidir.
    */
    /*  Complexity
        Time  : O(1)
        Space : O(1)
    */

    public static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
