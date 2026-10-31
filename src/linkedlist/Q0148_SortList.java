package linkedlist;

import common.model.ListNode;
import java.util.*;

public class Q0148_SortList {
    // 148. Sort List - Medium
    // https://leetcode.com/problems/sort-list/

    /* ------------------------------------------------------------
       | PATTERN: Linked List - Merge Sort
       ------------------------------------------------------------
       fast/slow ile listeyi ortadan ikiye böl, iki yarıyı recursive sırala, sonra iki sıralı listeyi birleştir (21).
       Linked list'te merge sort tercih edilir: rastgele erişim gerekmez, birleştirme ekstra dizi istemez.
    */
    /*  Complexity
        Time  : O(n log n)
        Space : O(log n) (recursion)
    */

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode l1 = head, l2 = slow.next;
        slow.next = null;
        l1 = sortList(l1);
        l2 = sortList(l2);
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        tail.next = l1 != null ? l1 : l2;
        return dummy.next;
    }
}
