package backtracking;

import java.util.*;

public class Q0996_NumberOfSquarefulArrays {
    // 996. Number of Squareful Arrays - Hard
    // https://leetcode.com/problems/number-of-squareful-arrays/

    /* ------------------------------------------------------------
       | PATTERN: Backtracking (tekrarlı permütasyon + budama)
       ------------------------------------------------------------
       Sırala ki aynı değerler yan yana gelsin. Her adımda kullanılmamış bir eleman seç:
       aynı değeri aynı pozisyonda ikinci kez deneme (i > 0, nums[i] == nums[i-1], i-1 kullanılmamış ise atla).
       Önceki elemanla toplamı tam kare değilse dalı kes. Tam uzunluğa ulaşan her yol bir cevap.
    */
    /*  Complexity
        Time  : O(n!) worst case
        Space : O(n)
    */

    public static int numSquarefulPerms(int[] nums) {
        Arrays.sort(nums);   // tekrar eden değerleri yan yana getir
        return backtrack(nums, new boolean[nums.length], 0, 0);
    }

    private static int backtrack(int[] nums, boolean[] used, int prev, int depth) {
        if (depth == nums.length) return 1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            // aynı değeri aynı pozisyonda ikinci kez deneme (tekrarlı permütasyonları engeller)
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            if (depth > 0 && !isSquare(prev + nums[i])) continue;
            used[i] = true;
            count += backtrack(nums, used, nums[i], depth + 1);
            used[i] = false;
        }
        return count;
    }

    private static boolean isSquare(int x) {
        int r = (int) Math.sqrt(x);
        return r * r == x;
    }
}
