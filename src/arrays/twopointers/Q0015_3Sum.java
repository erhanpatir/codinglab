package arrays.twopointers;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q0015_3Sum {
    // 15. 3Sum - Medium
    // https://leetcode.com/problems/3sum/

    // -------------------------------------------------------------
    // |PATTERN: Sort + Fixed First Element + Two Pointers       ✅|
    // -------------------------------------------------------------
    /*
        Önce array’i sort ederiz:
            [-4, -1, -1, 0, 1, 2]

        Sonra her i için:
            nums[i] + nums[left] + nums[right] = 0
        olacak pair’i ararız.

        Bu artık Two Sum II gibi çalışır.
            left = i + 1
            right = n - 1

        Eğer sum küçükse:
            left++
        Eğer sum büyükse:
            right--
    */
    /*
        Time: O(n²)
        Space: O(1) extra
    */
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    left++;
                    right--;

                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }

                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }

                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }
}
