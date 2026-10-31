package linkedlist;

import common.model.Node;
import java.util.*;

public class Q0138_CopyListWithRandomPointer {
    // Öncelik   : 🔴 Yüksek
    // Şirketler : Meta (#30), Amazon ✅ (#30), Bloomberg ✅ (#111)
    //
    // 138. Copy List with Random Pointer - Medium
    // https://leetcode.com/problems/copy-list-with-random-pointer/

    /* ------------------------------------------------------------
       | PATTERN: Hash Map (eski düğüm -> yeni düğüm)
       ------------------------------------------------------------
       İlk geçişte her düğümün kopyasını oluştur ve map'e koy.
       İkinci geçişte kopyaların next ve random pointer'larını map üzerinden bağla.
       Takip: O(1) bellek için kopyaları orijinal düğümlerin arasına serpiştirme tekniği.
    */
    /*  Complexity
        Time  : O(n)
        Space : O(n)
    */

    public static Node copyRandomList(Node head) {
        Map<Node, Node> d = new HashMap<>();
        Node dummy = new Node(0);
        Node tail = dummy;
        for (Node cur = head; cur != null; cur = cur.next) {
            Node node = new Node(cur.val);
            tail.next = node;
            tail = node;
            d.put(cur, node);
        }
        for (Node cur = head; cur != null; cur = cur.next) {
            d.get(cur).random = cur.random == null ? null : d.get(cur.random);
        }
        return dummy.next;
    }
}
