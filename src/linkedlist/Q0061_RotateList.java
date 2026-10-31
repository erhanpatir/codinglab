package linkedlist;

import common.model.ListNode;
import java.util.*;

public class Q0061_RotateList {
    // Öncelik   : 🔴 Yüksek
    // Şirketler : Bloomberg ✅ (#118)
    //
    // 61. Rotate List - Medium
    // https://leetcode.com/problems/rotate-list/

    /* ------------------------------------------------------------
       | PATTERN: Linked List - Fast & Slow (n adım arayla)
       ------------------------------------------------------------
       Uzunluğu bul, k %= n. k == 0 ise liste aynen döner.
       fast'i k adım ileri götür, sonra ikisini birlikte sona kadar ilerlet.
       Yeni baş = slow.next; slow.next = null; fast.next = eski baş.
    */
    /*  Complexity
        Time  : O(n)
        Space : O(1)
    */

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        int n = 0;
        for (; cur != null; cur = cur.next) {
            n++;
        }
        k %= n;
        if (k == 0) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (k-- > 0) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        ListNode ans = slow.next;
        slow.next = null;
        fast.next = head;
        return ans;
    }
}
