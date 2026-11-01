package math;

import java.util.*;

public class Q0067_AddBinary {
    // Öncelik   : 🔴 Yüksek  ·  🌍 Ortak soru
    // Şirketler : Meta ✅ (#118), Google ✅ (#71)
    //
    // 67. Add Binary - Easy
    // https://leetcode.com/problems/add-binary/

    /* ------------------------------------------------------------
       | PATTERN: Math - iki string üzerinde carry ile toplama
       ------------------------------------------------------------
       İki string'i sondan başa gez, karşılık gelen bitleri ve carry'yi topla.
       Basamak = toplam % 2, carry = toplam / 2. Sonucu StringBuilder'a ekle ve sonda ters çevir.
    */
    /*  Complexity
        Time  : O(max(m, n))
        Space : O(1) (çıktı hariç)
    */

    public static String addBinary(String a, String b) {
        var sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1;
        for (int carry = 0; i >= 0 || j >= 0 || carry > 0; --i, --j) {
            carry += (i >= 0 ? a.charAt(i) - '0' : 0) + (j >= 0 ? b.charAt(j) - '0' : 0);
            sb.append(carry % 2);
            carry /= 2;
        }
        return sb.reverse().toString();
    }
}
