package dynamicprogramming.linear;

public class Q0152_MaximumProductSubarray {
    // 152. Maximum Product Subarray - Medium
    // https://leetcode.com/problems/maximum-product-subarray/

    /*  ------------------------------------------------------
        | PATTERN: linear DP with max/min state.             |
        ------------------------------------------------------
         STATE
        ------------
        Her index için iki şey tutarız:
            maxEndingHere = bu index’te biten maximum product
            minEndingHere = bu index’te biten minimum product

        Neden minimum?
        Çünkü minimum negatif değer, negatif sayı ile çarpılınca maximum olabilir.
        ------------
         TRANSITION
        ------------
        newMax = max(num, num * maxEndingHere, num * minEndingHere)
        newMin = min(num, num * maxEndingHere, num * minEndingHere)
    */

    /* Complexity
        Time  : O(n)
        Space : O(1)
    */
    public static int maxProduct(int[] nums) {
        int maxEnding = nums[0];
        int minEnding = nums[0];
        int answer = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];

            int candidate1 = num;
            int candidate2 = num * maxEnding;
            int candidate3 = num * minEnding;

            int newMax = Math.max(candidate1, Math.max(candidate2, candidate3));
            int newMin = Math.min(candidate1, Math.min(candidate2, candidate3));

            maxEnding = newMax;
            minEnding = newMin; // bunu saklıyoruz çünkü ileride negatifle çarpılırsa büyük pozitif olabilir.

            answer = Math.max(answer, maxEnding);
        }
        return answer;
    }
}
