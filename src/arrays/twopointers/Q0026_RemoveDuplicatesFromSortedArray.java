package arrays.twopointers;

public class Q0026_RemoveDuplicatesFromSortedArray {
    // LeetCode 26 - Remove Duplicates from Sorted Array - Easy
    // https://leetcode.com/problems/remove-duplicates-from-sorted-array/
    /*
        Cozum mantigi: ✅

        Two pointer teknigini kullanabiliriz.Update edecegin indexi bir pointer olarak tut.
        Array'i sonuna kadar dolas, writePos index'indeki degiskeni kiyasla.
        eger farkli bir element yakalarsan bir index ilerle ve setle.
    */

    /* Complexity Analysis
        Time: O(n),
        Space: O(1),
    */
    public static int removeDuplicates(int[] nums) {
        /*
            “Since the array is sorted, duplicates are adjacent.
             I use a slow pointer to mark the next position for a unique value and
             a fast pointer to scan the array.
             Whenever the fast pointer finds a value different from the previous value,
             I write it at slow and move slow forward.”
        */
        if (nums.length == 0) return 0;

        int slow = 0; // first pointer

        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow]) {   // new unique element
                slow++;
                nums[slow] = nums[fast];
            }
        }
        return slow + 1;
    }
}
