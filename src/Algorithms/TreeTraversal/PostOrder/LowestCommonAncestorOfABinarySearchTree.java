package Algorithms.TreeTraversal.PostOrder;

import Algorithms.TreeTraversal.TreeNode;

public class LowestCommonAncestorOfABinarySearchTree {
    // 235. Lowest Common Ancestor of a Binary Search Tree - Medium
    // https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

    // Time: O(h)
    // Space: O(h)
    public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        int high = Math.max(p.val, q.val);
        int low  = Math.min(p.val, q.val);

        if (root.val > high) {
            return lowestCommonAncestor2(root.left, p, q);
        }

        if (root.val < low) {
            return lowestCommonAncestor2(root.right, p, q);
        }

        return root;
    }

    public static TreeNode lowestCommonAncestor_iterative(TreeNode root, TreeNode p, TreeNode q) {
        int high = Math.max(p.val, q.val);
        int low  = Math.min(p.val, q.val);

        TreeNode curr = root;

        while (curr != null) {
            if (curr.val > high) {
                curr = curr.left;
            } else if (curr.val < low) {
                curr = curr.right;
            } else {
                return curr;
            }
        }
        return null;
    }
}
