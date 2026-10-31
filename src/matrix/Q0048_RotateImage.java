package matrix;

import java.util.*;

public class Q0048_RotateImage {
    // 48. Rotate Image - Medium
    // https://leetcode.com/problems/rotate-image/description/

    /* ------------------------------------------------------------
       | PATTERN: Matrix - Flip + Transpose (in-place)
       ------------------------------------------------------------
       Saat yönünde 90 derece döndürme = önce yukarıdan aşağı ters çevir (satırları yer değiştir), sonra transpose (i, j <-> j, i).
       İki işlem de yerinde yapıldığı için ekstra bellek gerekmez.
    */
    /*  Complexity
        Time  : O(n^2)
        Space : O(1)
    */

    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n >> 1; ++i) {
            for (int j = 0; j < n; ++j) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = t;
            }
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }
    }
}
