package ProblemSolvingTechniques.SlidingWindow;

// 643. Maximum Average Subarray I - Easy
// https://leetcode.com/problems/maximum-average-subarray-i/
public class MaximumAverageSubarray1 {
    /* Complexity Analysis
        Time Complexity:  O(n), where n is the length of nums. We traverse the array once.
        Space Complexity: O(1), as we are using a constant amount of extra space.
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
