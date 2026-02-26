package Algorithms.TreeTraversal.PreOrder;

import Algorithms.TreeTraversal.TreeNode;

public class SameTree {
    // 100. Same Tree - Easy
    // https://leetcode.com/problems/same-tree/

    // Time Complexity : O(n)
    // Space Complexity: O(n)

    // Recursive Depth-First Search (DFS)
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        // If both nodes are null, the subtrees are identical.
        if (p == null && q == null)
            return true;

        // If one is null and the other is not, the subtrees are not identical
        if (p == null || q == null)
            return false;

        // If the values differ, the subtrees are not identical
        if (p.val != q.val)
            return false;

        return isSameTree(p.right, q.right) && isSameTree(p.left, q.left);
    }
}
