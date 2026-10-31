package monotonic;

import java.util.*;

public class Q1944_NumberOfVisiblePeopleInAQueue {
    // 1944. Number of Visible People in a Queue - Hard
    // https://leetcode.com/problems/number-of-visible-people-in-a-queue/

    /* ------------------------------------------------------------
       | PATTERN: Monotonic Stack (sağdan azalan)
       ------------------------------------------------------------
       Sağdan sola gez; stack sağdaki görünür kişilerin boylarını azalan tutar.
       Kendinden kısa olan herkesi pop et, her biri görülür (sayaç++). Stack'te hâlâ biri kalırsa
       o kişi de görülür (ilk uzun kişi). Sonra kendini push et.
    */
    /*  Complexity
        Time  : O(n)
        Space : O(n)
    */

    public static int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        int[] ans = new int[n];
        Deque<Integer> stk = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; --i) {
            while (!stk.isEmpty() && stk.peek() < heights[i]) {
                stk.pop();
                ++ans[i];
            }
            if (!stk.isEmpty()) {
                ++ans[i];
            }
            stk.push(heights[i]);
        }
        return ans;
    }
}
