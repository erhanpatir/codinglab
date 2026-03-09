package trees.traversal.dfs;

import common.model.TreeNode;

public class Q0543_DiameterOfBinaryTree {
    // 543. Diameter of Binary Tree - Easy
    // https://leetcode.com/problems/diameter-of-binary-tree/
    // The maximum path of a node is calculated as the sum of the heights of its left and right subtrees.

    // Time Complexity : O(n)
    // Space Complexity: O(n)
    private static int maxDiameter = 0;

    public static int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return maxDiameter;
    }

    private static int height(TreeNode node) {
        if (node == null) return 0;

        int left = height(node.left);
        int right = height(node.right);

        // update the max diameter
        maxDiameter = Math.max(maxDiameter, left + right);

        // return the height of the current node
        return 1 + Math.max(left, right);
    }
}
