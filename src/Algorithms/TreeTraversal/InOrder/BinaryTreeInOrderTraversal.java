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
        if (root == null) return result;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;  // en soldaki node'a git
            }

            cur = stack.pop();
            result.add(cur.val);

            // visit the right subtree
            cur = cur.right;
        }
        return result;
    }

    // LEFT --> ROOT --> RIGHT
    public static List<Integer> inorderTraversal_recursion(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    public static void inorder(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        System.out.println(node.val + " -> " + "degerli node'a girildi.");
        inorder(node.left, result);
        result.add(node.val);
        System.out.println(node.val);
        System.out.println(result);
        inorder(node.right, result);
    }
}
