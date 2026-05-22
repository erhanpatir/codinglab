package dynamicprogramming.linear;

public class Q0053_MaximumSubarray {
    // 53. Maximum Subarray - Medium
    // https://leetcode.com/problems/maximum-subarray/

    /*  ------------------------------------------------------
        | PATTERN: Linear DP / Kadane's Algorithm            |
        ------------------------------------------------------
         STATE
        ------------
            dp[i] = i index’inde biten maximum subarray sum
            Dikkat:
                i’ye kadar olan max değil
                i’de biten max
            Bu çok önemli.
        ------------
         TRANSITION
        ------------
            i index’indeki subarray için iki seçenek var:
            1) Önceki subarray’e devam et
                dp[i-1] + nums[i]
            2) Buradan yeniden başla
                nums[i]
            O yüzden:
                dp[i] = max(nums[i], dp[i-1] + nums[i])
    */

    /* Complexity
        Time  : O(n)
        Space : O(1)
    */
    public static int maxSubArray_kadane(int[] nums) {
        int current = nums[0]; // stores the maximum subarray sum ending at the current index.
        int best = nums[0];    // tracks the maximum value seen so far.

        for (int i = 1; i < nums.length; i++) {
            current = Math.max(
                    nums[i],
                    current + nums[i]
            );

            best = Math.max(best, current);
        }

        return best;
    }

    public int maxSubArray_classicDP(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        dp[0] = nums[0];
        int answer = dp[0];

        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(
                    nums[i],
                    dp[i - 1] + nums[i]
            );
            answer = Math.max(answer, dp[i]);
        }
        return answer;
    }

    public int maxSubArray_divideAndConquer(int[] nums) {
        return divideAndConquer(nums, 0, nums.length - 1);
    }

    private int divideAndConquer(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }

        int mid = left + (right - left) / 2;

        int leftBest = divideAndConquer(nums, left, mid);
        int rightBest = divideAndConquer(nums, mid + 1, right);
        int crossingBest = maxCrossingSum(nums, left, mid, right);

        return Math.max(
                Math.max(leftBest, rightBest),
                crossingBest
        );
    }

    private int maxCrossingSum(int[] nums, int left, int mid, int right) {
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            leftSum = Math.max(leftSum, sum);
        }

        int rightSum = Integer.MIN_VALUE;
        sum = 0;

        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            rightSum = Math.max(rightSum, sum);
        }

        return leftSum + rightSum;
    }
}
