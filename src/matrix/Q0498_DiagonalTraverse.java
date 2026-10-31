package matrix;

import java.util.*;

public class Q0498_DiagonalTraverse {
    // 498. Diagonal Traverse - Medium
    // https://leetcode.com/problems/diagonal-traverse/

    /* ------------------------------------------------------------
       | PATTERN: Matrix - köşegen simülasyonu
       ------------------------------------------------------------
       m + n - 1 köşegen var. Her köşegenin başlangıç hücresini hesapla, köşegen boyunca (i++, j--) gez.
       Çift indeksli köşegenleri ters sırada ekle; böylece yukarı ve aşağı zigzag oluşur.
    */
    /*  Complexity
        Time  : O(m * n)
        Space : O(1) (çıktı hariç)
    */

    public static int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] ans = new int[m * n];
        int idx = 0;
        List<Integer> t = new ArrayList<>();
        for (int k = 0; k < m + n - 1; ++k) {
            int i = k < n ? 0 : k - n + 1;
            int j = k < n ? k : n - 1;
            while (i < m && j >= 0) {
                t.add(mat[i][j]);
                ++i;
                --j;
            }
            if (k % 2 == 0) {
                Collections.reverse(t);
            }
            for (int v : t) {
                ans[idx++] = v;
            }
            t.clear();
        }
        return ans;
    }
}
