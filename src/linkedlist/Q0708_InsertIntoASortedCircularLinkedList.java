package linkedlist;

import common.model.Node;
import java.util.*;

public class Q0708_InsertIntoASortedCircularLinkedList {
    // 708. Insert into a Sorted Circular Linked List - Medium
    // https://leetcode.com/problems/insert-into-a-sorted-circular-linked-list/

    /* ------------------------------------------------------------
       | PATTERN: Linked List (dairesel, sıralı)
       ------------------------------------------------------------
       prev ve curr ile listeyi bir tur gez. Ekleme yeri: prev.val <= x <= curr.val,
       ya da sınır noktası (prev.val > curr.val) ve x yeni en büyük ya da en küçükse.
       Tur tamamlanırsa (tüm değerler eşit) herhangi bir yere ekle. Boş listede tek düğümlü daire oluştur.
    */
    /*  Complexity
        Time  : O(n)
        Space : O(1)
    */

    public static Node insert(Node head, int insertVal) {
        Node node = new Node(insertVal);
        if (head == null) {
            node.next = node;
            return node;
        }
        Node prev = head, curr = head.next;
        while (curr != head) {
            if ((prev.val <= insertVal && insertVal <= curr.val)
                || (prev.val > curr.val && (insertVal >= prev.val || insertVal <= curr.val))) {
                break;
            }
            prev = curr;
            curr = curr.next;
        }
        prev.next = node;
        node.next = curr;
        return head;
    }
}
