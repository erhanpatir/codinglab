package twopointers;

import java.util.*;

public class Q0977_SquaresOfASortedArray {
    // 977. Squares of a Sorted Array - Easy
    // https://leetcode.com/problems/squares-of-a-sorted-array/

    /* ------------------------------------------------------------
       | PATTERN: Two Pointers (uçlardan büyük kare)
       ------------------------------------------------------------
       En büyük kare dizinin uçlarından birindedir. Sol ve sağ pointer'ın karelerinden büyük olanı
       sonuç dizisinin sonundan başa doğru yerleştir.
    */
    /*  Complexity
        Time  : O(n)
        Space : O(1) (çıktı hariç)
    */

    public static int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0, j = n - 1, k = n - 1; i <= j; --k) {
            int a = nums[i] * nums[i];
            int b = nums[j] * nums[j];
            if (a > b) {
                ans[k] = a;
                ++i;
            } else {
                ans[k] = b;
                --j;
            }
        }
        return ans;
    }
}
