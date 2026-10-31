package heap;

import java.util.*;

public class Q0378_KthSmallestElementInASortedMatrix {
    // 378. Kth Smallest Element in a Sorted Matrix - Medium
    // https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/

    /* ------------------------------------------------------------
       | PATTERN: Binary Search (değer aralığında)
       ------------------------------------------------------------
       Cevap [min, max] aralığında. mid için "mid'den küçük ya da eşit kaç eleman var" sorusunu
       sol alt köşeden başlayan merdiven taramasıyla O(n)'de say. Sayı >= k ise cevap mid ya da daha küçük.
       Alternatif: min-heap ile k-way merge (O(k log n)).
    */
    /*  Complexity
        Time  : O(n * log(max - min))
        Space : O(1)
    */

    public static int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0], right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = (left + right) >> 1;
            if (check(matrix, mid, k, n)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static boolean check(int[][] matrix, int mid, int k, int n) {
        int count = 0;
        int i = n - 1, j = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= mid) {
                count += (i + 1);
                ++j;
            } else {
                --i;
            }
        }
        return count >= k;
    }
}
