package binarysearch;

import java.util.*;

public class Q0034_FindFirstAndLastPositionOfElementInSortedArray {
    // 34. Find First and Last Position of Element in Sorted Array - Medium
    // https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

    /* ------------------------------------------------------------
       | PATTERN: Binary Search (lower bound iki kez)
       ------------------------------------------------------------
       Sol sınır: target'tan büyük ya da eşit ilk indeks (lower bound).
       Sağ sınır: (target + 1)'den büyük ya da eşit ilk indeks - 1.
       Sol sınır dizinin dışındaysa ya da o konumdaki değer target değilse [-1, -1] döner.
    */
    /*  Complexity
        Time  : O(log n)
        Space : O(1)
    */

    public static int[] searchRange(int[] nums, int target) {
        int l = search(nums, target);
        int r = search(nums, target + 1);
        return l == r ? new int[] {-1, -1} : new int[] {l, r - 1};
    }

    private static int search(int[] nums, int x) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] >= x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
