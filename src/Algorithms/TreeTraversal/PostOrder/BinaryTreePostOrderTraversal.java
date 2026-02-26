package Algorithms.TreeTraversal.PostOrder;

import Algorithms.TreeTraversal.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostOrderTraversal {
    // 145. Binary Tree Postorder Traversal - Easy
    // https://leetcode.com/problems/binary-tree-postorder-traversal/

    // Time Complexity : O(n)
    // Space Complexity: O(n)
    public static List<Integer> postOrderTraversal_recursion(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postOrder(root, result);
        return result;
    }

    private static void postOrder(TreeNode root, List<Integer> result) {
        if (root == null) return;
        postOrder(root.left, result);
        postOrder(root.right, result);
        result.add(root.val);
    }

    // Time Complexity : O(n)
    // Space Complexity: O(n)
    public static List<Integer> postOrderTraversal_stack(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root;
        TreeNode prev = null;

        while (curr != null || !stack.isEmpty()) {

            // Sol tarafa kadar in
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            TreeNode node = stack.peek();

            // Sağ çocuk yoksa veya sağ çocuk zaten gezildiyse
            if (node.right == null || node.right == prev) {
                result.add(node.val);   // postorder noktası 🎯
                stack.pop();
                prev = node;
            } else {
                // Sağ subtree'ye geç
                curr = node.right;
            }
        }

        return result;
    }
}
