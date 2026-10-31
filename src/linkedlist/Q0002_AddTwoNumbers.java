package linkedlist;

import common.model.ListNode;
import java.util.*;

public class Q0002_AddTwoNumbers {
    // 2. Add Two Numbers - Medium
    // https://leetcode.com/problems/add-two-numbers/

    /* ------------------------------------------------------------
       | PATTERN: Linked List + Carry (simülasyon)
       ------------------------------------------------------------
       İki listeyi aynı anda gez; her adımda iki basamak + carry toplanır.
       Yeni düğüm (toplam % 10), carry = toplam / 10. Dummy head ile baş düğüm özel durumu ortadan kalkar.
       Döngü l1, l2 ve carry'nin üçü de bitene kadar sürer; son carry'yi unutma.
    */
    /*  Complexity
        Time  : O(max(m, n))
        Space : O(1) (çıktı listesi hariç)
    */

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        int carry = 0;
        ListNode cur = dummy;
        while (l1 != null || l2 != null || carry != 0) {
            int s = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            carry = s / 10;
            cur.next = new ListNode(s % 10);
            cur = cur.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        return dummy.next;
    }
}
