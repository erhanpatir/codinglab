package matrix;

import java.util.*;

public class Q0054_SpiralMatrix {
    // 54. Spiral Matrix - Medium
    // https://leetcode.com/problems/spiral-matrix/

    /* ------------------------------------------------------------
       | PATTERN: Matrix - Sınır daraltma (layer by layer)
       ------------------------------------------------------------
       top, bottom, left, right sınırlarını tut. Sırasıyla üst satır (soldan sağa), sağ sütun (yukarıdan aşağıya),
       alt satır (sağdan sola), sol sütun (aşağıdan yukarıya) gezilir; her yönden sonra o sınır daraltılır.
       Alt satır ve sol sütun gezilmeden önce sınırların hâlâ geçerli olup olmadığı kontrol edilir (tek satır/sütun kaldığında).
    */
    /*  Complexity
        Time  : O(m * n)
        Space : O(1) (çıktı hariç)
    */

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;
        while (top <= bottom && left <= right) {
            for (int j = left; j <= right; j++) result.add(matrix[top][j]);
            top++;
            for (int i = top; i <= bottom; i++) result.add(matrix[i][right]);
            right--;
            if (top <= bottom) {
                for (int j = right; j >= left; j--) result.add(matrix[bottom][j]);
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) result.add(matrix[i][left]);
                left++;
            }
        }
        return result;
    }
}
