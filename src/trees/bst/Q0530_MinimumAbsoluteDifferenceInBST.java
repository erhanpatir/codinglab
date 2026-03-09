package trees.bst;

import common.model.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q0530_MinimumAbsoluteDifferenceInBST {
    // 530. Minimum Absolute Difference in BST - Easy
    // https://leetcode.com/problems/minimum-absolute-difference-in-bst/description/

    private static Integer prev = null;
    private static int minDiff = Integer.MAX_VALUE;

    public static int getMinimumDifference_recursive(TreeNode root) {
        inorder(root);
        return minDiff;
    }

    private static void inorder(TreeNode node) {
        if (node == null) return;

        inorder(node.left);

        if (prev != null) {
            minDiff = Math.min(minDiff, node.val - prev);
        }
        prev = node.val;

        inorder(node.right);
    }

    //in-order traversal + prev
    //Time: O(n)
    //Space: recursive O(h), iterative O(h)
    public static int getMinimumDifference_iterative(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;

        Integer prev = null;
        int minDiff = Integer.MAX_VALUE;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();

            if (prev != null) {
                minDiff = Math.min(minDiff, cur.val - prev);
            }
            prev = cur.val;

            cur = cur.right;
        }

        return minDiff;
    }
}
