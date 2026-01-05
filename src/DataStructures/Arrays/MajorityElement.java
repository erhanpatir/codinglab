package DataStructures.Arrays;

import java.util.Arrays;

// LeetCode 169 - Majority Element - Easy
// https://leetcode.com/problems/majority-element/
public class MajorityElement {
    /* Cozum: Boyer-Moore Voting Algorithm ✅

        Bir mevcut elemani, bir de adeti tutan iki degisken tutariz.
        Ayni eleman geldikce artar, farkli eleman geldikce azalir.
        Butun array'i gezeriz, en sonunda candidate en fazla gecen eleman olur.
        Onu da doneriz.

        Complexity Analysis
            Time Complexity:  O(n) since it passes through the array once.
            Space Complexity: O(1) since only a few additional variables are used.

        Ya da array'i sort eder. n/2 inci elemani doneriz. Cunki majority element n/2'den daha fazla geciyor.
        Her kosulda orta eleman majority element olur.

        Complexity Analysis
            Time Complexity: O(n log n) due to sorting.
            Space Complexity: O(1) when using in-place sorting (ignoring input space).
     */

    public static int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }

    public static int majorityElement_2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
