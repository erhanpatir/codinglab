package arrays.slidingwindow;

public class Q0209_MinimumSizeSubarraySum {
    // 209. Minimum Size Subarray Sum - Medium
    // https://leetcode.com/problems/minimum-size-subarray-sum/
     /* ------------------------------------------
       | PATTERN: Dynamic Sliding Window       ✅|
       -------------------------------------------
       State:
        left
        windowSum
        minLength

        Invariant:
            windowSum, her zaman nums[left ... right] toplamıdır.

        Valid condition:
            windowSum >= target

        Valid olduğunda:
            minLength update et
            left’i ilerletip daha kısa mümkün mü dene
    */
    /* Mantik:
        right ile window'u büyüt
        valid olduktan sonra yani sum >= target olunca left ile küçült
        her valid durumda minLength update et
    */
    /* Complexity
        Time:  O(n)
        Space: O(1)
    */
    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum >= target) {
                int windowLength = right - left + 1;
                minLength = Math.min(minLength, windowLength);

                sum -= nums[left];
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
