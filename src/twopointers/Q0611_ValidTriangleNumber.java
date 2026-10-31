package twopointers;

import java.util.*;

public class Q0611_ValidTriangleNumber {
    // 611. Valid Triangle Number - Medium
    // https://leetcode.com/problems/valid-triangle-number/

    /* ------------------------------------------------------------
       | PATTERN: Two Pointers (sırala, en büyük kenarı sabitle)
       ------------------------------------------------------------
       Sırala. En büyük kenar k'yi sabitle, i = 0, j = k-1.
       nums[i] + nums[j] > nums[k] ise i..j-1 arasındaki her eleman nums[j] ile geçerli üçgen kurar:
       count += j - i, j--. Değilse i++.
    */
    /*  Complexity
        Time  : O(n^2)
        Space : O(log n)
    */

    public static int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        // En büyük kenarı sabitle, diğer ikisini iki pointer ile ara.
        for (int k = nums.length - 1; k >= 2; k--) {
            int i = 0, j = k - 1;
            while (i < j) {
                if (nums[i] + nums[j] > nums[k]) {
                    count += j - i; // i..j-1 arasındaki her eleman nums[j] ile geçerli
                    j--;
                } else {
                    i++;
                }
            }
        }
        return count;
    }
}
