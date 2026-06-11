package arrays.slidingwindow;

public class Q1004_MaxConsecutiveOnesIII {
    // 1004. Max Consecutive Ones III - Medium
    // https://leetcode.com/problems/max-consecutive-ones-iii/
     /* ------------------------------------------
       | PATTERN: Dynamic Sliding Window       ✅|
       -------------------------------------------
       Window her zaman şunu sağlamalı:
        zeroCount <= k

        Eğer:
            zeroCount > k olursa:
        left'i ilerlet
    */
    /* Complexity
        Time:  O(n)
        Space: O(1)
    */
    public int lonestOnes(int[] nums, int k) {
        int left = 0;
        int zeroCount = 0;
        int maxLength = 0;

        // En fazla k tane 0 içeren en uzun window
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeroCount++;
            }

            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
    /* Dry Run
        nums = [1,1,1,0,0,0,1,1,1,1,0]
        k = 2

        Başlangıç:
            left = 0
            zeroCount = 0
            maxLength = 0

        right = 0
            [1]
            zeroCount = 0
            Valid.✅
            maxLength = 1

        right = 1
            [1,1]
            Valid.✅
            maxLength = 2

        right = 2
            [1,1,1]
            Valid.✅
            maxLength = 3

        right = 3
            [1,1,1,0]
            zeroCount = 1
            Valid.✅
            maxLength = 4

        right = 4
            [1,1,1,0,0]
            zeroCount = 2
            Valid.✅
            maxLength = 5

        right = 5
            [1,1,1,0,0,0]
            zeroCount = 3
            Problem.

        Çünkü: 3 > k
    */
}
