package Algorithms.TreeTraversal.PreOrder;

import Algorithms.TreeTraversal.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreOrderTraversal {
    // 144. Binary Tree Preorder Traversal - Easy
    // https://leetcode.com/problems/binary-tree-preorder-traversal/

    // Time Complexity : O(n)
    // Space Complexity: O(n)
    public static List<Integer> preorderTraversal_recursion(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorder(root, result);
        return result;
    }

    private static void preorder(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        // Visit the root node first
        result.add(node.val);
        // Recursively traverse the left subtree
        preorder(node.left, result);
        // Recursively traverse the right subtree
        preorder(node.right, result);
    }

    // Time Complexity : O(n)
    // Space Complexity: O(n)
    public static List<Integer> preorderTraversal_stack(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            result.add(current.val);

            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }
        return result;
    }
}
