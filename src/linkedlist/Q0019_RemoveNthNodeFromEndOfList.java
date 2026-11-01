package linkedlist;

import common.model.ListNode;
import java.util.*;

public class Q0019_RemoveNthNodeFromEndOfList {
    // Öncelik   : 🟡 Orta  ·  🌍 Ortak soru
    // Şirketler : Meta ✅ (#59), Google ✅ (#94), Apple (#100)
    //
    // 19. Remove Nth Node From End of List - Medium
    // https://leetcode.com/problems/remove-nth-node-from-end-of-list/

    /* ------------------------------------------------------------
       | PATTERN: Fast & Slow Pointers (n adım arayla)
       ------------------------------------------------------------
       Dummy düğümden başla. fast'i n adım ileri götür, sonra fast sona gelene kadar
       fast ve slow'u birlikte ilerlet. slow, silinecek düğümün bir öncesinde durur:
       slow.next = slow.next.next. Dummy sayesinde ilk düğümü silme durumu ayrıca ele alınmaz.
    */
    /*  Complexity
        Time  : O(n)
        Space : O(1)
    */

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode fast = dummy, slow = dummy;
        while (n-- > 0) {
            fast = fast.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
