package DataStructures.LinkedListInPlaceReversal;

import DataStructures.LinkedLists.ListNode;

// 234. Palindrome Linked List - Easy
// https://leetcode.com/problems/palindrome-linked-list/
public class PalindromeLinkedList {
    /*
        Complexity Analysis
            Time Complexity: O(n)
            Space Complexity: O(1)
    */
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        // Step 1: Find the end of the first half
        ListNode firstHalfEnd = endOfFirstHalf(head);
        // Step 2: Reverse the second half
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        // Step 3: Check whether or not there's a palindrome
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.val != p2.val) {
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // (Optional) Step 4: Restore the list
        firstHalfEnd.next = reverseList(secondHalfStart);

        return result;
    }

    // Helper function to reverse the linked list from a given node
    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }

    // Helper function to find the end node of the first half
    private static ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
