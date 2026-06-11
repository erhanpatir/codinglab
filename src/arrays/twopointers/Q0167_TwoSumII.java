package arrays.twopointers;

public class Q0167_TwoSumII {
    // 167. Two Sum II - Input Array Is Sorted - Medium
    // https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

    // --------------------------------
    // |PATTERN: Two Pointers       ✅|
    // --------------------------------
    /*
        Aradığımız pair her zaman [left, right] aralığının içindedir.
        Eğer sum < target ise left çok küçük kalmıştır. Daha büyük toplam için left++.
        Eğer sum > target ise right çok büyüktür. Daha küçük toplam için right--.

        Bir pointer başta, bir pointer sonda:
        left = 0
        right = n - 1

        Toplamı kontrol ederiz:
            sum = numbers[left] + numbers[right]
        Eğer:
            sum == target -> answer
            sum < target  -> left++
            sum > target  -> right--
        Çünkü array sorted.
    */
    /*
        Time: O(n)
        Space: O(1)
    */
    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                return new int[] { left + 1, right + 1 };
            }

            if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[] {};
    }
}
