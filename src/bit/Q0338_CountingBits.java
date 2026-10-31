package bit;

import java.util.*;

public class Q0338_CountingBits {
    // 338. Counting Bits - Easy
    // https://leetcode.com/problems/counting-bits/

    /* ------------------------------------------------------------
       | PATTERN: Bit Manipulation + DP
       ------------------------------------------------------------
       i'nin 1 bit sayısı = (i >> 1)'in 1 bit sayısı + i'nin son biti (i & 1).
       (i >> 1) < i olduğu için değeri zaten hesaplanmıştır.
    */
    /*  Complexity
        Time  : O(n)
        Space : O(1) (çıktı hariç)
    */

    public static int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i >> 1] + (i & 1);   // i'nin bitleri = (i/2)'nin bitleri + son bit
        }
        return ans;
    }
}
