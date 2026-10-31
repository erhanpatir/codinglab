package linkedlist;

import common.model.ListNode;
import java.util.*;

public class Q0025_ReverseNodesInKGroup {
    // Öncelik   : 🔴 Yüksek
    // Şirketler : Amazon ✅ (#109)
    //
    // 25. Reverse Nodes in k-Group - Hard
    // https://leetcode.com/problems/reverse-nodes-in-k-group/

    /* ------------------------------------------------------------
       | PATTERN: Linked List - Grup halinde in-place reverse
       ------------------------------------------------------------
       pre, grubun bir önceki düğümü. pre'den k adım ileri git; k düğüm yoksa dur, kalan aynen kalır.
       Grubu ayır (cur.next = null), ters çevir, sonra pre.next = ters grubun başı,
       grubun eski başı (yeni sonu) = sonraki grubun başına bağlanır. pre bu eski başa taşınır.
    */
    /*  Complexity
        Time  : O(n)
        Space : O(1)
    */

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        dummy.next = head;
        ListNode pre = dummy;
        while (pre != null) {
            ListNode cur = pre;
            for (int i = 0; i < k; i++) {
                cur = cur.next;
                if (cur == null) {
                    return dummy.next;
                }
            }
            ListNode node = pre.next;
            ListNode nxt = cur.next;
            cur.next = null;
            pre.next = reverse(node);
            node.next = nxt;
            pre = node;
        }
        return dummy.next;
    }

    private static ListNode reverse(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode cur = head;
        while (cur != null) {
            ListNode nxt = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;
            cur = nxt;
        }
        return dummy.next;
    }
}
