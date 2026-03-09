package trees.path;

import common.model.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Q0257_BinaryTreePaths {
    // 257. Binary Tree Paths - Easy
    // https://leetcode.com/problems/binary-tree-paths/

    // Time Complexity : O(n) // the number of nodes
    // Space Complexity: O(h) // the height of the binary tree
    public static List<String> binaryTreePaths_recursion(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        dfs_recursive(root, "", res);
        return res;
    }

    private static void dfs_recursive(TreeNode node, String path, List<String> res) {
        if (node == null) return;
        String cur = path.isEmpty() ? String.valueOf(node.val) : path + "->" + node.val;

        if (node.left == null && node.right == null) {
            res.add(cur);
            return;
        }
        dfs_recursive(node.left, cur, res);
        dfs_recursive(node.right, cur, res);
    }

    // Time Complexity : O(n)
    // Space Complexity: O(n)
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;

        Deque<State> stack = new ArrayDeque<>();
        stack.push(new State(root, String.valueOf(root.val)));

        while (!stack.isEmpty()) {
            State cur = stack.pop();

            if (cur.node.left == null && cur.node.right == null) {
                res.add(cur.path);
            }

            if (cur.node.right != null) {
                stack.push(new State(cur.node.right, cur.path + "->" + cur.node.right.val));
            }

            if (cur.node.right != null) {
                stack.push(new State(cur.node.left, cur.path + "->" + cur.node.left.val));
            }
        }
        return res;
    }

    static class State {
        TreeNode node;
        String path;
        State(TreeNode n, String p) {
            node = n;
            path = p;
        }
    }

}
