package arrays.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// LeetCode 169 - Majority Element - Easy
// https://leetcode.com/problems/majority-element/
public class Q0169_MajorityElement {
    /* Cozum: Boyer-Moore Voting Algorithm ✅
        Bir mevcut elemani, bir de adeti tutan iki degisken tutariz.
        Ayni eleman geldikce artar, farkli eleman geldikce azalir.
        Butun array'i gezeriz, en sonunda candidate en fazla gecen eleman olur.
        Onu da doneriz.

        Complexity Analysis
            Time :  O(n)
            Space : O(1)

        Ya da array'i sort eder. n/2 inci elemani doneriz. Cunki majority element n/2'den daha fazla geciyor.
        Her kosulda orta eleman majority element olur.

        Complexity Analysis
            Time : O(n log n) due to sorting.
            Space : O(1) when using in-place sorting (ignoring input space).
     */

    public static int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            // Ayni eleman geldikce artar, farkli eleman geldikce azalir.
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }

    // Time: O(n log n)
    // Space: O(1)
    public static int majorityElement_2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    // Time: O(n)
    // Space: O(n)
    public static int majorityElement_3(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();

        for (int num : nums) {
            int newCount = count.getOrDefault(num, 0) + 1;

            if (newCount > nums.length / 2) {
                return num;
            }
            count.put(num, newCount);
        }
        return -1;
    }
}
