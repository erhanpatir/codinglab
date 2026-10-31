package linkedlist;

import common.model.ListNode;
import java.util.*;

public class Q0237_DeleteNodeInALinkedList {
    // 237. Delete Node in a Linked List - Medium
    // https://leetcode.com/problems/delete-node-in-a-linked-list/

    /* ------------------------------------------------------------
       | PATTERN: Linked List - değer kopyalama
       ------------------------------------------------------------
       Önceki düğüme erişim yok. Sonraki düğümün değerini bu düğüme kopyala ve
       sonraki düğümü atla: node.next = node.next.next. Böylece bu düğüm silinmiş gibi olur.
    */
    /*  Complexity
        Time  : O(1)
        Space : O(1)
    */

    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
