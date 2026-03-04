package Algorithms.TreeTraversal.InOrder;

import Algorithms.TreeTraversal.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class KthSmallestElementInaBST {
    // 230. Kth Smallest Element in a BST - Medium
    // https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/

    static int limit;
    static Integer res = null;

    public static int kthSmallest(TreeNode root, int k) {
        limit = k;
        inorder(root);
        return res;
    }

    private static void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        limit--;
        if (res != null) return;  // global stop
        if(limit == 0) {
            res = node.val;
            return;
        }
        inorder(node.right);
    }

    // Time: O(h + k) pratikte (k’ncı elemana kadar)
    // Worst-case time: O(n)
    // Space: O(h)
    public static int kthSmallest_stack(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        int res = 0;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            if (--k == 0) {
                res = cur.val;
                break;
            }

            cur = cur.right;
        }
        return res;
    }
}
