package arrays.binarysearch;

public class Q0704_BinarySearch {
    // 704. Binary Search - Easy
    // https://leetcode.com/problems/binary-search/
    /* ------------------------------------------------------------
       | PATTERN:        Binary Search                          ✅|
       ------------------------------------------------------------
    /* ⭐ Binary search fikri:
            Her adımda ortadaki elemana bakarız.
            ------------------------------------------------
                nums[mid] == target  → bulduk
                nums[mid] < target   → sağ tarafa git
                nums[mid] > target   → sol tarafa git
            ------------------------------------------------
            Çünkü array sorted.

     */
    /*  Complexity
        Time : O(n log n)
        Space : O(1)
    */
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            /* int mid = (left + right) / 2;
                 Ama büyük sayılarda left + right integer overflow yapabilir
            */

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}
