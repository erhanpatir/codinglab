package arrays.binarysearch;

public class Q0240_SearchA2DMatrixII {
    // 240. Search a 2D Matrix II - Medium
    // https://leetcode.com/problems/search-a-2d-matrix-ii/
    /* ------------------------------------------------------------
       | PATTERN:        Binary Search                          ✅|
       ------------------------------------------------------------
    /* ⭐ Optimal Pattern
            En iyi klasik çözüm:
            Top-right corner’dan başla.
            Yani:
                row = 0
                col = cols - 1

            Neden top-right?
            Çünkü bu noktada iki yön anlamlıdır:
                current > target  → sola git
                current < target  → aşağı git

            Neden Çalışıyor?
            Top-right eleman düşün:

                [1,  4,  7, 11, 15]
                                  ^
            Bu eleman bulunduğu satırın en büyüğü, bulunduğu kolonun en küçüğü gibi davranır.
            Eğer:
                current > target
            ise current’ın altındaki elemanlar daha da büyük olabilir.
            O yüzden o kolonu komple ele.
            col--;

            Eğer:
                current < target
            ise current’ın solundaki elemanlar daha da küçük.
            O yüzden o satırı komple ele.
                row++;
     */
    /*  Complexity
        Time: O(m + n)
        Space: O(1)
        Her adımda ya bir satırı ya bir kolonu eliyoruz.
    */
    public static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int row = 0;
        int col = cols - 1;

        while (row < rows && col >= 0) {
            int current = matrix[row][col];  // top right'tan baslariz.

            if (current == target) {
                return true;
            }

            if (current > target) {
                col--;  // left (target'in bulunabilecegi row'u bulduk)
            } else {
                row++;  // henuz bulamadik, satir satir asagi dogru ineriz.
            }
        }

        return false;
    }
}
