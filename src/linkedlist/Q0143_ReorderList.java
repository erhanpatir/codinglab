package linkedlist;

import common.model.ListNode;
import java.util.*;

public class Q0143_ReorderList {
    // 143. Reorder List - Medium
    // https://leetcode.com/problems/reorder-list/

    /* ------------------------------------------------------------
       | PATTERN: Linked List - Orta + Reverse + Merge
       ------------------------------------------------------------
       1) fast/slow ile ortayı bul. 2) İkinci yarıyı ters çevir.
       3) İki yarıyı sırayla birbirine örerek birleştir: L0, Ln, L1, Ln-1, ...
       Üç klasik linked list tekniği tek soruda.
    */
    /*  Complexity
        Time  : O(n)
        Space : O(1)
    */

    public static void reorderList(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode cur = slow.next;
        slow.next = null;

        ListNode pre = null;
        while (cur != null) {
            ListNode t = cur.next;
            cur.next = pre;
            pre = cur;
            cur = t;
        }
        cur = head;

        while (pre != null) {
            ListNode t = pre.next;
            pre.next = cur.next;
            cur.next = pre;
            cur = pre.next;
            pre = t;
        }
    }
}
