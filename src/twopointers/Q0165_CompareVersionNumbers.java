package twopointers;

import java.util.*;

public class Q0165_CompareVersionNumbers {
    // Öncelik   : 🟡 Orta
    // Şirketler : Apple (#52)
    //
    // 165. Compare Version Numbers - Medium
    // https://leetcode.com/problems/compare-version-numbers/

    /* ------------------------------------------------------------
       | PATTERN: Two Pointers (parça parça karşılaştırma)
       ------------------------------------------------------------
       İki versiyonu '.' ile ayrılmış parçalar halinde aynı anda oku; her parçayı sayıya çevir
       (baştaki 0'lar kendiliğinden düşer). Eksik parça 0 sayılır. İlk farklı parçada -1 ya da 1 döner.
    */
    /*  Complexity
        Time  : O(max(m, n))
        Space : O(1)
    */

    public static int compareVersion(String version1, String version2) {
        int m = version1.length(), n = version2.length();
        for (int i = 0, j = 0; i < m || j < n; ++i, ++j) {
            int a = 0, b = 0;
            while (i < m && version1.charAt(i) != '.') {
                a = a * 10 + (version1.charAt(i++) - '0');
            }
            while (j < n && version2.charAt(j) != '.') {
                b = b * 10 + (version2.charAt(j++) - '0');
            }
            if (a != b) {
                return a < b ? -1 : 1;
            }
        }
        return 0;
    }
}
