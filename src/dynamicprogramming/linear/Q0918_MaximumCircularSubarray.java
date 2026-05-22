package dynamicprogramming.linear;

public class Q0918_MaximumCircularSubarray {
    // 918. Maximum Sum Circular Subarray - Medium
    // https://leetcode.com/problems/maximum-sum-circular-subarray/

    /*  ------------------------------------------------------
         PATTERN: Circular Kadane
            Pattern
            max(
                normalMax,
                totalSum - minSubarray
            )
            Edge case
                all negative
        ------------------------------------------------------
         WRAP YAPAN SUBARRAY
            Array’in sonundan başına sarar.
            Mesela: [5, -3, 5]

            Wrap yapan en iyi subarray: 5 + 5

            Aslında ne yaptık?
                ortadaki kötü kısmı çıkardık

            Yani: totalSum - minimumSubarray
            En önemli formül
                maxCircular = totalSum - minSubarraySum

            Çünkü:
                minimum contiguous kısmı çıkarınca
                geri kalan parçalar circular max olur
    */
    /* Şunları hesaplıyoruz:
        1) maxSubarraySum
        2) minSubarraySum
        3) totalSum
        Sonra:
        if maxSubarray < 0:
            return maxSubarray
        Else:
            return max(maxSubarray, totalSum - minSubarray)
    */

    /* Complexity
        Time  : O(n)
        Space : O(1)
    */
    public int maxSubarraySumCircular(int[] nums) {
        int total = 0;

        int currentMax = 0;
        int maxSum = nums[0];

        int currentMin = 0;
        int minSum = nums[0];

        for (int num : nums) {
            currentMax = Math.max(num, currentMax + num);
            maxSum = Math.max(maxSum, currentMax);

            currentMin = Math.min(num, currentMin + num);
            minSum = Math.min(minSum, currentMin);

            total += num;
        }

        // all negative
        if (maxSum < 0) return maxSum;

        return Math.max(maxSum, total - minSum);
    }
}
