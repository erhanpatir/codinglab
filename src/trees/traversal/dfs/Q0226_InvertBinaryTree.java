package trees.traversal.dfs;

import common.model.TreeNode;

import java.util.Stack;

public class Q0226_InvertBinaryTree {
    // 226. Invert Binary Tree - Easy
    // https://leetcode.com/problems/invert-binary-tree/

    // Time Complexity : O(n)
    // Space Complexity: O(n)
    public static TreeNode invertTree_dfs(TreeNode root) {
        if (root == null) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();

            // Swap the left and right children
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;

            if (current.left != null) {
                stack.push(current.left);
            }

            if (current.right != null) {
                stack.push(current.right);
            }
        }

        return root;
    }

    public static TreeNode invertTree_recursive(TreeNode root) {
        if (root == null) return root;

        root.left = invert(root.right);
        root.right = invert(root.left);

        return root;
    }

    public static TreeNode invert(TreeNode t1) {
        if (t1 == null) return t1;

        TreeNode temp = t1.left;
        t1.left = t1.right;
        t1.right = temp;

        return t1;
    }
}
