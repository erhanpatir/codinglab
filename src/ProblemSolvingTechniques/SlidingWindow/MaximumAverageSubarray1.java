package ProblemSolvingTechniques.SlidingWindow;

// 643. Maximum Average Subarray I - Easy
// https://leetcode.com/problems/maximum-average-subarray-i/
public class MaximumAverageSubarray1 {
    /* Complexity Analysis
        Time Complexity:  O(n)
        Space Complexity: O(1)
    */
    // Sliding Window
    public static double findMaxAverage (int[] nums, int k) {
        int slidingWindowSum = 0;

        for (int i = 0; i < k; i++) {
            slidingWindowSum += nums[i];
        }

        int maxSum = slidingWindowSum;

        for (int i = k; i < nums.length; i++) {
            slidingWindowSum = slidingWindowSum - nums[i - k] + nums[i];
            maxSum = Math.max(maxSum, slidingWindowSum);
        }
        return (double) maxSum / k;
    }
}
