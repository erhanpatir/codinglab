package DataStructures.Arrays;

// LeetCode 26 - Remove Duplicates from Sorted Array - Easy
// https://leetcode.com/problems/remove-duplicates-from-sorted-array/
public class RemoveDuplicatesFromSortedArray {
    /*
        Cozum mantigi: ✅

        Two pointer teknigini kullanabiliriz.Update edecegin indexi bir pointer olarak tut.
        Array'i sonuna kadar dolas, writePos index'indeki degiskeni kiyasla.
        eger farkli bir element yakalarsan bir index ilerle ve setle.
    */

    public static int removeDuplicates(int[] nums) {
        int writePos = 0; // first pointer

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[writePos]) { // compare
                writePos++;
                nums[writePos] = nums[i];
            }
        }
        return writePos + 1;
    }
}
