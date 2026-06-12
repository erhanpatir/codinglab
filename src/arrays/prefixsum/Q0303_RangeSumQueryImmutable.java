package arrays.prefixsum;

public class Q0303_RangeSumQueryImmutable {
    // 303. Range Sum Query - Immutable - Easy
    // https://leetcode.com/problems/range-sum-query-immutable/description/
    // --------------------------------------------
    // |         PATTERN: Prefix Sum            ✅|
    // --------------------------------------------
    /* Pattern Trigger
        Şunları görürsen:
            range sum query
            multiple sum queries
            subarray sum from i to j
            immutable array

        akla gelsin:
            prefix sum
            rangeSum = prefix[right + 1] - prefix[left]
    */
    /*
       Önden bir array hazırlarız:
       prefix[i] = nums[0] + nums[1] + ... + nums[i - 1]
       Burada prefix uzunluğu n + 1 olur.

       prefix[0] = 0

       Böylece herhangi bir range sum:
        sum(left, right) = prefix[right + 1] - prefix[left]

       3. State / Invariant
       Invariant:
        prefix[i], nums array’indeki ilk i elemanın toplamıdır.

       Yani:
        prefix[0] = 0
        prefix[1] = nums[0]
        prefix[2] = nums[0] + nums[1]
        prefix[3] = nums[0] + nums[1] + nums[2]
        -----------------------------------------
        | Bu yüzden left..right arası:          |
        |   prefix[right + 1] - prefix[left]    |
        -----------------------------------------
    */
    /* Complexity Analysis
        Constructor:
            Time: O(n)
            Space: O(n)
        Each query:
            Time: O(1)
            Space: O(1)
    */
    private final int[] prefix;
    public Q0303_RangeSumQueryImmutable(int[] nums) {
        this.prefix = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return prefix[right + 1] - prefix[left];
    }
}
/* 4. Dry Run
        nums = [-2, 0, 3, -5, 2, -1]
        Prefix:
            prefix[0] = 0
            prefix[1] = -2
            prefix[2] = -2
            prefix[3] = 1
            prefix[4] = -4
            prefix[5] = -2
            prefix[6] = -3

        Yani:
            prefix = [0, -2, -2, 1, -4, -2, -3]
            sumRange(0, 2)
            nums[0..2] = [-2,0,3]

        Formula:
            prefix[3] - prefix[0]
            = 1 - 0
            = 1
            sumRange(2, 5)
            nums[2..5] = [3,-5,2,-1]

        Formula:
            prefix[6] - prefix[2]
            = -3 - (-2)
            = -1
            sumRange(0, 5)
            prefix[6] - prefix[0]
            = -3 - 0
            = -3
*/

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
