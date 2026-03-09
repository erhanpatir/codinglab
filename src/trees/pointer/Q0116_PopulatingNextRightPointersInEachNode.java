package trees.pointer;

import common.model.Node;

import java.util.LinkedList;
import java.util.Queue;

public class Q0116_PopulatingNextRightPointersInEachNode {
    // 116. Populating Next Right Pointers in Each Node - Medium
    // https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

    /*
            1 -> null
          /   \
         2 ->  3 -> null
        / \   / \
       4->5->6->7 -> null
    */
    // Time: O(n)
    // Space: O(w)
    public static Node connect_bfs(Node root) {
        if (root == null) return null;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            Node prev = null;

            for (int i = 0; i < size; i++) {
                Node cur = q.poll();

                if (prev != null) {
                    prev.next = cur;
                }
                prev = cur;

                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
            }
        }

        return root;
    }

    // Time: O(n)
    // Space: O(1)
    public static Node connect(Node root) {
        if (root == null) return null;

        Node leftmost = root;

        while (leftmost.left != null) {
            Node head = leftmost;

            while (head != null) {
                // same parent
                head.left.next = head.right;

                // across parents
                if (head.next != null) {
                    head.right.next = head.next.left;
                }

                head = head.next;
            }

            leftmost = leftmost.left;
        }

        return root;
    }
}
