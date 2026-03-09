package linkedlists.reversal;

import common.model.ListNode;

// 206. Reverse Linked List - Easy
// https://leetcode.com/problems/reverse-linked-list/
public class Q0206_ReverseLinkedList {
    /*
        Complexity Analysis
            Time Complexity: O(n)
            Space Complexity: O(1)
    */
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null; // Previous node, initially null
        ListNode curr = head; // Current node starts from the head
        while (curr != null) {
            ListNode next = curr.next; // Store next node
            curr.next = prev; // Reverse the current node's pointer
            prev = curr; // Move prev to current
            curr = next; // Move curr to next
        }
        return prev; // New head of the reversed list
    }
}
