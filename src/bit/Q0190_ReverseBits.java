package bit;

import java.util.*;

public class Q0190_ReverseBits {
    // Öncelik   : 🟡 Orta
    // Şirketler : Apple (#45)
    //
    // 190. Reverse Bits - Easy
    // https://leetcode.com/problems/reverse-bits/description/

    /* ------------------------------------------------------------
       | PATTERN: Bit Manipulation
       ------------------------------------------------------------
       32 kez: sonucu bir sola kaydır, n'nin son bitini ekle (n & 1), n'yi unsigned olarak sağa kaydır (>>>).
    */
    /*  Complexity
        Time  : O(1) (32 adım)
        Space : O(1)
    */

    // you need treat n as an unsigned value
    public static int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32 && n != 0; ++i) {
            ans |= (n & 1) << (31 - i);
            n >>>= 1;
        }
        return ans;
    }
}
