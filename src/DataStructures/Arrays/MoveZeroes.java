package DataStructures.Arrays;

// LeetCode 283 - Move Zeroes - Easy
// https://leetcode.com/problems/move-zeroes/
public class MoveZeroes {
    /*
        Complexity Analysis
            Time Complexity: O(n), where n is the length of the array.
            Space Complexity: O(1), since we are modifying the array in place without using additional storage.
    */
    public static void moveZeroes(int[] nums) {
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
