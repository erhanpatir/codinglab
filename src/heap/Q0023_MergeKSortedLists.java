package heap;

import common.model.ListNode;
import java.util.*;

public class Q0023_MergeKSortedLists {
    // Öncelik   : 🔴 Yüksek  ·  🌍 Ortak soru
    // Şirketler : Meta ✅, Google ✅, Amazon ✅, Apple ✅, Bloomberg ✅
    //
    // 23. Merge k Sorted Lists - Hard
    // https://leetcode.com/problems/merge-k-sorted-lists/

    /* ------------------------------------------------------------
       | PATTERN: Heap - K-way Merge (Min Heap)
       ------------------------------------------------------------
       Her listenin ilk düğümünü min-heap'e koy. Heap'ten en küçüğü çek, sonuca ekle,
       o düğümün next'ini heap'e koy. Heap'te aynı anda en fazla k düğüm olur.
       Alternatif: listeleri ikişer ikişer birleştiren divide & conquer (aynı complexity).
    */
    /*  Complexity
        Time  : O(N log k) (N = toplam düğüm)
        Space : O(k)
    */

    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode head : lists) {
            if (head != null) {
                pq.offer(head);
            }
        }
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            if (node.next != null) {
                pq.offer(node.next);
            }
            cur.next = node;
            cur = cur.next;
        }
        return dummy.next;
    }
}
