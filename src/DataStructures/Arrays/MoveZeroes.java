package DataStructures.Arrays;

/* 283. Move Zeroes - Easy
     Given an integer array nums, move all 0's to the end of it
     while maintaining the relative order of the non-zero elements.

    Note that you must do this in-place without making a copy of the array.

    Example 1:

    Input: nums = [0,1,0,3,12]
    Output: [1,3,12,0,0]

    Complexity Analysis
        Time Complexity: O(n), where n is the length of the array.
        Space Complexity: O(1), since we are modifying the array in place without using additional storage.
*/

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int pos = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[pos] = nums[i];
                pos++;
            }
        }

        while (pos < nums.length) {
            nums[pos] = 0;
            pos++;
        }
    }
}
