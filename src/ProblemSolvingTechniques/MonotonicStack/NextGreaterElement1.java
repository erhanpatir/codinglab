package ProblemSolvingTechniques.MonotonicStack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement1 {
    // 496. Next Greater Element I - Easy
    // https://leetcode.com/problems/next-greater-element-i/

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

    // Time Complexity : O(m + n)
    // Space Complexity: O(m)
    public static int[] nextGreaterElement_2(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int num : nums2) {
            // While stack is not empty and current num is greater than stack's top element
            while (!stack.isEmpty() && stack.peek() < num) {
                // map the last element to the current as its next greater
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }

        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.getOrDefault(nums1[i], -1);
        }
        return result;
    }
}
