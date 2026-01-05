package ProblemSolvingTechniques.FastSlowPointers;

import DataStructures.LinkedLists.ListNode;

// 876. Middle of the Linked List - Easy
// https://leetcode.com/problems/middle-of-the-linked-list/
public class MiddleOfTheLinkedList {
    /*
        Complexity Analysis
            Time Complexity: O(n)
            Space Complexity: O(1)
    */
    public static ListNode middleNode(ListNode head) {
        // Initialize two pointers, 'slow' and 'fast'
        ListNode slow = head, fast = head;

        // Move 'slow' by 1 step and 'fast' by 2 steps
        while (fast != null && fast.next != null) {
            slow = slow.next; // slow moves 1 step
            fast = fast.next.next; // fast moves 2 steps
        }

        // When 'fast' reaches the end, 'slow' will be at the middle
        return slow;
    }
}
