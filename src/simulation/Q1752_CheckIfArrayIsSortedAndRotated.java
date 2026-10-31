package simulation;

import java.util.*;

public class Q1752_CheckIfArrayIsSortedAndRotated {
    // 1752. Check if Array Is Sorted and Rotated - Easy
    // https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/

    /* ------------------------------------------------------------
       | PATTERN: Array Simülasyon (düşüş sayma)
       ------------------------------------------------------------
       Diziyi dairesel düşün; nums[i] > nums[(i+1) % n] olan konumları say.
       Sıralı ve döndürülmüş bir dizide bu düşüş en fazla bir kez olur.
    */
    /*  Complexity
        Time  : O(n)
        Space : O(1)
    */

    public static boolean check(int[] nums) {
        int cnt = 0;
        for (int i = 0, n = nums.length; i < n; ++i) {
            if (nums[i] > nums[(i + 1) % n]) {
                ++cnt;
            }
        }
        return cnt <= 1;
    }
}
