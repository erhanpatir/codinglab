package math;

import java.util.*;

public class Q0066_PlusOne {
    // 66. Plus One - Easy
    // https://leetcode.com/problems/plus-one/

    /* ------------------------------------------------------------
       | PATTERN: Math - sondan carry ile toplama
       ------------------------------------------------------------
       Son basamaktan başla: basamağı 1 artır, 10'a göre mod al. 0 değilse taşma yok, diziyi döndür.
       Döngü bitti ise tüm basamaklar 9'du (999 -> 1000); n+1 uzunlukta dizi oluştur, ilk eleman 1.
    */
    /*  Complexity
        Time  : O(n)
        Space : O(1) (999.. durumu hariç)
    */

    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; --i) {
            ++digits[i];
            digits[i] %= 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[n + 1];
        digits[0] = 1;
        return digits;
    }
}
