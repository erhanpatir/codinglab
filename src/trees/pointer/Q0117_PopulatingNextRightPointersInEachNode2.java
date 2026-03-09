package trees.pointer;

import common.model.Node;

import java.util.LinkedList;
import java.util.Queue;

public class Q0117_PopulatingNextRightPointersInEachNode2 {
    // 117. Populating Next Right Pointers in Each Node II - Medium
    // https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/

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
        Node curr = root;

        while (curr != null) {
            Node dummy = new Node(0);
            Node tail = dummy;

            while (curr != null) {
                if (curr.left != null) {
                    tail.next = curr.left;
                    tail = tail.next;
                }

                if (curr.right != null) {
                    tail.next = curr.right;
                    tail = tail.next;
                }

                curr = curr.next;
            }

            curr = dummy.next;
        }

        return root;
    }
}
