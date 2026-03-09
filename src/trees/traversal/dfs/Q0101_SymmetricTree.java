package trees.traversal.dfs;

import common.model.TreeNode;

public class Q0101_SymmetricTree {
    // 101. Symmetric Tree - Easy
    // https://leetcode.com/problems/symmetric-tree/

    // Time Complexity : O(n)
    // Space Complexity: O(n)
    public static boolean isSymmetric(TreeNode root) {
        // An empty tree is symmetric
        if (root == null) return true;

        return isMirror(root.right, root.left);
    }

    private static boolean isMirror(TreeNode t1, TreeNode t2) {
        // If both nodes are null, they are mirrors
        if (t1 == null && t2 == null) return true;
        // If one node is null, not mirrors
        if (t1 == null || t2 == null) return false;

        if(t1.val != t2.val) return false;

        return isMirror(t1.right, t2.left) && isMirror(t1.left, t2.right);
    }
}
