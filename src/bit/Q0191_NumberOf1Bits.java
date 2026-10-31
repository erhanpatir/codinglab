package bit;

import java.util.*;

public class Q0191_NumberOf1Bits {
    // Öncelik   : 🟡 Orta
    // Şirketler : Apple (#53)
    //
    // 191. Number of 1 Bits - Easy
    // https://leetcode.com/problems/number-of-1-bits/description/

    /* ------------------------------------------------------------
       | PATTERN: Bit Manipulation - n & (n - 1)
       ------------------------------------------------------------
       n & (n - 1) en sağdaki 1 bitini siler. n sıfır olana kadar kaç kez yapıldığı = 1 bit sayısı.
       Döngü yalnızca 1 bitlerinin sayısı kadar döner.
    */
    /*  Complexity
        Time  : O(1) (en fazla 32)
        Space : O(1)
    */

    // you need to treat n as an unsigned value
    public static int hammingWeight(int n) {
        int ans = 0;
        while (n != 0) {
            n &= n - 1;
            ++ans;
        }
        return ans;
    }
}
