package dynamicprogramming.linear;

public class Q0213_HouseRobberII {
    // 213. House Robber II - Medium
    // https://leetcode.com/problems/house-robber-ii/

    /*  ------------------------------------------------------
        | PATTERN: Linear DP + circular constraint           |
        ------------------------------------------------------
        Circle varsa:
            ilk ve son birlikte alınamaz.
            problemi iki linear case'e böl:
                exclude first
                exclude last
    */

    /* Complexity
        Time  : O(n)
        Space : O(1)
    */
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) return nums[0];

        return Math.max(
                robLinear(nums, 0, n - 2),
                robLinear(nums, 1, n - 1));
    }

    private int robLinear(int[] nums, int start, int end) {
        int prev1 = 0;
        int prev2 = 0;

        for (int i = start; i <= end; i++) {
            int current = Math.max(
                    prev1,
                    prev2 + nums[i]);

            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }
}
