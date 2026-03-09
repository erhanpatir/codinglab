package trees.traversal.bfs;

import common.model.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q0662_MaximumWidthOfBinaryTree {
    // 662. Maximum Width of Binary Tree - Medium
    // https://leetcode.com/problems/maximum-width-of-binary-tree/description/

    /*  =====================================
         En kolay yaklaşım: BFS + heap index
        =====================================

        Bir complete binary tree gibi index ver:
        Root index = 0
        Sol child = 2*i
        Sağ child = 2*i + 1

        Bir level’ın genişliği:

        width = lastIndex - firstIndex + 1

        Overflow tuzağı (önemli)

        Index çok büyüyebilir. Çözüm:
        Her level başında normalize et:

        base = firstIndex

        O level’da kullandığın index = index - base
        Böylece sayılar küçük kalır.
    */

    // Time: O(n)
    // Space: O(w) (queue)
    public static int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        Deque<NodePos> q = new ArrayDeque<>();
        q.offer(new NodePos(root, 0));

        long best = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            long base = q.peekFirst().pos; // leftmost pos in this level
            long first = 0, last = 0;

            for (int i = 0; i < size; i++) {
                NodePos cur = q.poll();
                long pos = cur.pos - base; // normalize

                if (i == 0) first = pos;
                if (i == size - 1) last = pos;

                TreeNode node = cur.node;

                if (node.left != null)  q.offer(new NodePos(node.left,  2 * pos));
                if (node.right != null) q.offer(new NodePos(node.right, 2 * pos + 1));
            }

            best = Math.max(best, last - first + 1);
        }

        return (int) best;
    }

    static class NodePos {
        TreeNode node;
        long pos; // long to be safe
        NodePos(TreeNode n, long p) { node = n; pos = p; }
    }
}
