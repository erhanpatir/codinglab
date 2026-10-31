package linkedlist;

import common.model.ListNode;
import java.util.*;

public class Q0021_MergeTwoSortedLists {
    // Öncelik   : 🔵 Trend  ·  🌍 Ortak soru
    // Şirketler : Meta ✅, Google ✅, Amazon ✅, Apple, Bloomberg ✅
    //
    // 21. Merge Two Sorted Lists - Easy
    // https://leetcode.com/problems/merge-two-sorted-lists/

    /* ------------------------------------------------------------
       | PATTERN: Linked List - Two Pointers ile Merge (dummy head)
       ------------------------------------------------------------
       Dummy düğüm ve tail pointer'ı tut. İki listenin başındaki küçük değeri tail'e bağla ve o listede ilerle.
       Bir liste bitince diğerinin kalanını olduğu gibi bağla.
       Recursive çözüm de olur ama O(m+n) stack kullanır; iteratif çözüm O(1) bellek kullanır.
    */
    /*  Complexity
        Time  : O(m + n)
        Space : O(1)
    */

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        tail.next = (list1 != null) ? list1 : list2;
        return dummy.next;
    }
}
