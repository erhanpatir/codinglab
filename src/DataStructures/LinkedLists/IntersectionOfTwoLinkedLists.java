package DataStructures.LinkedLists;

import java.util.HashSet;

// LeetCode 160 - Intersection of Two Linked Lists
// https://leetcode.com/problems/intersection-of-two-linked-lists/
public class IntersectionOfTwoLinkedLists {
    // HashSet
    /*
       Complexity Analysis
       Time Complexity: O(m + n) where m and n are the lengths of the two linked lists.
       Space Complexity: O(n) where n is the length of the longer linked list since all its nodes are stored in a set.
    */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
       HashSet<ListNode> set = new HashSet<>();

       ListNode b= headB;
       while (b != null) {
           set.add(b);
           b = b.next;
       }

       ListNode a = headA;
       while (a != null) {
           if(set.contains(a)) {
               return a;
           }
           a = a.next;
       }
       return null;
    }

    // Two Pointers
    /*
        Complexity Analysis
        Time Complexity: O(m + n) where m and n are the lengths of the two linked lists.
        Space Complexity: O(1) as no extra space is used, just pointers are moved.
    */
    public static ListNode getIntersectionNod_twopointers(ListNode headA, ListNode headB) {
        // if either head is null, they cannot intersect
        if (headA == null || headB == null) {
            return null;
        }

        ListNode a = headA;
        ListNode b = headB;
        // Loop until the pointers meet or both reach to end
        while (a != b) {
            // if pointers reach to end, redirect to the head of the other list
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        // Either they met at intersection node or both are null
        return a;
    }
}
