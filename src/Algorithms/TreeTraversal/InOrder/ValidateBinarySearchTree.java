package Algorithms.TreeTraversal.InOrder;

import Algorithms.TreeTraversal.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidateBinarySearchTree {
    // 98. Validate Binary Search Tree - Medium
    // https://leetcode.com/problems/validate-binary-search-tree/

    public static boolean isValidBST(TreeNode root) {
        // range patterni
        return dfs(root, null, null); // null cunku root icin sinirsiz aralik
    }

    /*
                           2
                          / \
        (less than root) 1   3 (greater than root)
    */
    private static boolean dfs(TreeNode node, Integer min, Integer max) {
        if(node == null) return true;

        if(min != null && node.val <= min) return false;
        if(max != null && node.val >= max) return false;

        return dfs(node.left, min, node.val)
            && dfs(node.right, node.val, max);
    }

    public static boolean isValidBST_dfs(TreeNode root) {
        Deque<State> stack = new ArrayDeque<>();
        stack.push(new State(root, null, null));

        while (!stack.isEmpty()) {
            State s = stack.pop();
            if (s.node == null) continue;

            if (s.min != null && s.node.val <= s.min) return false;
            if (s.max != null && s.node.val >= s.max) return false;

            stack.push(new State(s.node.right, s.node.val, s.max));
            stack.push(new State(s.node.left, s.min, s.node.val));
        }
        return true;
    }

    public static class State {
        TreeNode node;
        Integer min, max;
        State(TreeNode n, Integer min, Integer max) {
            this.node = n;
            this.min = min;
            this.max = max;
        }
    }
}
