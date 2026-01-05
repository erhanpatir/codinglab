package ProblemSolvingTechniques.FastSlowPointers;

import java.util.HashSet;
import java.util.Set;

// 202. Happy Number - Easy
// https://leetcode.com/problems/happy-number/
public class HappyNumber {
    /* Solution: Floyd's Cycle Detection (Tortoise and Hare) ✅
       More space-optimized solution

       Steps:
        Initialize slow and fast pointers both to the original number.
        Compute the next number for the slow pointer (one step) and for the fast pointer (two steps).
        If fast pointer reaches 1, return true.
        If slow equals fast and they are not 1, a cycle is detected, return false.
        Repeat these steps until a conclusion is reached.

      Complexity Analysis
        Time Complexity:  O(log n)  Similar to the set-based approach, but faster in practice due to constant space usage.
        Space Complexity: O(1)      no need for additional data structures.
    */
    public static boolean isHappy_2(int n) {
        int slow = n;
        int fast = findSum(n);

        while (slow != fast && fast != 1) {
            slow = findSum(slow);
            fast = findSum(findSum(fast));
        }
        return fast == 1;
    }

    private static int findSum(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n = n / 10;
        }
        return sum;
    }

    /* Solution: HashSet ✅
      The simplest approach is to detect cycles by using a set to track sums of squared digits that we've seen.
      If we encounter a sum that we've seen before, we know we're in a cycle

      Complexity Analysis
        Time Complexity:  O(log n). In the worst case, each number leads to a value with fewer digits.
        Space Complexity: O(log n). We store each intermediate value in a set until we reach 1 or encounter a cycle.
    */
    public static boolean isHappy(int n) {
        // Initialize a set to keep track of the sums we've encountered.
        Set<Integer> trackSet = new HashSet<>();
        // If the sum is already in the set, return false (cycle detected).
        while (n != 1 && !trackSet.contains(n)) {
            trackSet.add(n);
            n = findSum(n);
        }
        return n == 1;
    }
}
