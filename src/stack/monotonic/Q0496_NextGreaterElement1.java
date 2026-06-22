package stack.monotonic;

import java.util.*;

public class Q0496_NextGreaterElement1 {
    // 496. Next Greater Element I - Easy
    // https://leetcode.com/problems/next-greater-element-i/
    /* ------------------------------------------------------
       | PATTERN:         Monotonic Stack                 ✅|
       ------------------------------------------------------
    /*
        Şunu görürsen monotonic stack düşün:
        For each element, find the first greater element on the right.

        Burada aradığımız şey:
            Her eleman için sağındaki ilk daha büyük eleman
        Yani:
            Next Greater Element
        Bu direkt:
            Monotonic Stack sorusudur.
    */

    /*  Complexity
        Time
            nums2 bir kere gezilir.
            Her eleman stack’e bir kere girer, bir kere çıkar.
            Sonra nums1 bir kere gezilir.
            O(n + m)
        Space
            Stack ve map kullanıyoruz.
            O(n)
    */
    public static int[] nextGreaterElement_2(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nextGreater = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();

        for (int num : nums2) {
            while (!stack.isEmpty() && num > stack.peek()) {
                int smaller = stack.pop();
                nextGreater.put(smaller, num);
            }

            stack.push(num);
        }

        int[] answer = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            answer[i] = nextGreater.getOrDefault(nums1[i], -1);
        }

        return answer;
    }

    // Time Complexity : O(n * m)
    // Space Complexity: O(1)
    public static int[] nextGreaterElement_BruteForce(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = -1;

            boolean found = false;
            for (int j = 0; j < nums2.length; j++) {
                if (nums2[j] == nums1[i]) {
                    found = true;
                }

                if (found && nums2[j] > nums1[i]) {
                    res[i] = nums2[j];
                    break;
                }
            }
        }
        return res;
    }
}
