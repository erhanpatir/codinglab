package Algorithms.TreeTraversal.InOrder;

import Algorithms.TreeTraversal.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInOrderTraversal {
    // 94. Binary Tree Inorder Traversal - Easy
    // https://leetcode.com/problems/binary-tree-inorder-traversal/

    // Time Complexity : O(n)
    // Space Complexity: O(n)
    public static List<Integer> inorderTraversal_stack(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (!stack.isEmpty() || current != null) {

            // Reach the leftmost node of the current node
            while (current != null) {
                stack.push(current);
                current = current.left;  // en soldaki node'a git
            }

            current = stack.pop();
            result.add(current.val);

            // visit the right subtree
            current = current.right;
        }
        return result;
    }

    public static List<Integer> inorderTraversal_recursion(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    public static void inorder(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        inorder(node.left, result);
        result.add(node.val);
        inorder(node.right, result);
    }
}
