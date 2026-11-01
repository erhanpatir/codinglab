package matrix;

import java.util.*;

public class Q0073_SetMatrixZeroes {
    // Öncelik   : 🟡 Orta  ·  🌍 Ortak soru
    // Şirketler : Meta ✅ (#91), Google ✅ (#92), Bloomberg ✅ (#84)
    //
    // 73. Set Matrix Zeroes - Medium
    // https://leetcode.com/problems/set-matrix-zeroes/

    /* ------------------------------------------------------------
       | PATTERN: Matrix - satır/sütun işaretleme
       ------------------------------------------------------------
       İlk geçişte 0 içeren satır ve sütunları iki boolean dizide işaretle,
       ikinci geçişte işaretli satır ya da sütundaki hücreleri 0 yap.
       Takip sorusu: O(1) bellek için işaretleri matrisin ilk satır ve ilk sütununda tutmak.
    */
    /*  Complexity
        Time  : O(m * n)
        Space : O(m + n)
    */

    public static void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == 0) {
                    row[i] = col[j] = true;
                }
            }
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
