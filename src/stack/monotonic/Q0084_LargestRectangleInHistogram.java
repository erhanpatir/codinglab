package stack.monotonic;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q0084_LargestRectangleInHistogram {
    // 84. Largest Rectangle in Histogram - Hard
    // https://leetcode.com/problems/largest-rectangle-in-histogram/
    /* ------------------------------------------------------------
       | PATTERN:        Monotonic increasing stack             ✅|
       ------------------------------------------------------------
    /*
        Burada ihtiyacımız olan şey:
            Her bar için soldaki ilk küçük eleman
            Her bar için sağdaki ilk küçük eleman

        Çünkü bir bar, kendinden küçük bir bar gelene kadar genişleyebilir.

        Bu yüzden pattern:
            Monotonic Increasing Stack

        ⭐ Stack içinde index tutacağız.

        Stack şu mantıkta olacak:
            heights[stack[0]] <= heights[stack[1]] <= heights[stack[2]]
        Yani stack increasing height tutar.

        State / Invariant
        Invariant:
            Stack içinde yükseklikler increasing order'dadır.
        Yeni gelen height, stack top’tan küçükse:
            Bu yeni bar, stack top için sağdaki ilk küçük bardır.

        O zaman stack top’taki barın maksimum alanını hesaplayabiliriz.
    */

    /*  Complexity
        Time  : O(n)
        Space : O(n)
    */
    public static int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;

        for (int i = 0; i <= heights.length; i++) {
            // En son bar da hesaplansin diye fake 0 gonderilir
            int currentHeight = i == heights.length ? 0 : heights[i];

            // Yeni gelen height, stack top’tan küçükse:
            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                // Bu yeni bar, stack top için sağdaki ilk küçük bardır demektir.
                int height = heights[stack.pop()];

                int width;
                if (stack.isEmpty()) {
                    width = i;
                } else {
                    // width = sağdaki ilk küçük - soldaki ilk küçük - 1
                    width = i - stack.peek() - 1;
                }

                int area = height * width;
                maxArea = Math.max(maxArea, area);
            }

            stack.push(i);
        }

        return maxArea;
    }
}
