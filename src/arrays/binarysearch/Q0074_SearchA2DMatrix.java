package arrays.binarysearch;

public class Q0074_SearchA2DMatrix {
    // 74. Search a 2D Matrix - Medium
    // https://leetcode.com/problems/search-a-2d-matrix/
    /* ------------------------------------------------------------
       | PATTERN:        Binary Search                          ✅|
       ------------------------------------------------------------
    /* ⭐ Asıl Fikir
            Matrix'i hiç değiştirmeden
            şunu hayal et:

                index
                0  1  2  3  4  5  6  7  8  9  10 11

                1  3  5  7 10 11 16 20 23 30 34 60

            Toplam eleman sayısı: m * n

            Dolayısıyla binary search yapabiliriz.

            Kritik Mapping
            Elimizde sanal bir index var:
                0
                1
                2
                3
                ...
                m*n-1

            Bu index'in matrix'teki karşılığı:
                row = mid / cols
                col = mid % cols

            Örnek:
                cols = 4
            mid = 6
                row = 6 / 4 = 1
                col = 6 % 4 = 2

            Matrix:
                [
                 [1, 3, 5, 7],
                 [10,11,16,20],
                 [23,30,34,60]
                ]
            matrix[1][2] = 16

            Bu mapping'i ezberle.
            Interview'da çok kullanılıyor.
     */
    public static boolean searchMatrix_flatArray(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[] flat = new int[m * n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                flat[i * n + j] = matrix[i][j];
            }
        }

        int left = 0;
        int right = flat.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (flat[mid] == target) {
                return true;
            }

            if (flat[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    /** Complexity
         Time: O(log(m * n))
         Çünkü:
            m*n eleman üzerinde
            tek binary search yapıyoruz.

         Space: O(1)
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0;
        int right = rows * cols - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int row = mid / cols;
            int col = mid % cols;

            int value = matrix[row][col];

            if (value == target) {
                return true;
            }

            if (value < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}
