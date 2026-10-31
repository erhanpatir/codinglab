package bit;

import java.util.*;

public class Q0136_SingleNumber {
    // 136. Single Number - Easy
    // https://leetcode.com/problems/single-number/

    /* ------------------------------------------------------------
       | PATTERN: Bit Manipulation - XOR
       ------------------------------------------------------------
       a ^ a = 0 ve a ^ 0 = a. Tüm sayıları XOR'layınca çiftler birbirini götürür,
       tek kalan sayı geriye kalır.
    */
    /*  Complexity
        Time  : O(n)
        Space : O(1)
    */

    public static int singleNumber(int[] nums) {
        int ans = 0;
        for (int v : nums) {
            ans ^= v;
        }
        return ans;
    }
}
