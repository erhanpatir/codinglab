package DataStructures.Arrays;

public class RemoveDuplicatesFromSortedArray {
    /* 26. Remove Duplicates from Sorted Array -Easy

        Given an integer array nums sorted in non-decreasing order,
        remove the duplicates in-place such that each unique element appears only once.
        The relative order of the elements should be kept the same.
        Consider the number of unique elements in nums to be k.
        After removing duplicates, return the number of unique elements k.

        The first k elements of nums should contain the unique numbers in sorted order.
        The remaining elements beyond index k - 1 can be ignored.

        Example 2:

            Input: nums = [0,0,1,1,1,2,2,3,3,4]
            Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
            Explanation: Your function should return k = 5,
            with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
            It does not matter what you leave beyond the returned k (hence they are underscores).

        Complexity Analysis
            Time Complexity: O(n), where n is the number of elements in the array.
                             We traverse the array with a single pass using the two pointers.
            Space Complexity: O(1), as we are using extra space only for the pointers and directly modifying the input array.
     */

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
