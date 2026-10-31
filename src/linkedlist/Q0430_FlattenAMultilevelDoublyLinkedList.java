package linkedlist;

import common.model.Node;
import java.util.*;

public class Q0430_FlattenAMultilevelDoublyLinkedList {
    // 430. Flatten a Multilevel Doubly Linked List - Medium
    // https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/

    /* ------------------------------------------------------------
       | PATTERN: Linked List - DFS ile düzleştirme
       ------------------------------------------------------------
       child'ı olan her düğümde child listesini o düğümün hemen arkasına yerleştir.
       preorder(pre, cur): cur'u pre'ye bağla, önce child'ı recursive düzleştir, child listesinin
       son düğümünden sonra eski next ile devam et. child pointer'ları null yapılır.
    */
    /*  Complexity
        Time  : O(n)
        Space : O(depth)
    */

    public static Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        Node dummy = new Node();
        dummy.next = head;
        preorder(dummy, head);
        dummy.next.prev = null;
        return dummy.next;
    }

    private static Node preorder(Node pre, Node cur) {
        if (cur == null) {
            return pre;
        }
        cur.prev = pre;
        pre.next = cur;

        Node t = cur.next;
        Node tail = preorder(cur, cur.child);
        cur.child = null;
        return preorder(tail, t);
    }
}
