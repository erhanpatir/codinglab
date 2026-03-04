package Algorithms.TreeTraversal.LevelOrder;

import Algorithms.TreeTraversal.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
    // 199. Binary Tree Right Side View - Medium
    // https://leetcode.com/problems/binary-tree-right-side-view/description/

    // Time: O(n)
    // Space: O(w) (max width)
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                if (i == size - 1) { // last in this level
                    res.add(node.val);
                }

                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
        }
        return res;
    }

    public static List<Integer> rightSideView_dfs(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, 0, res);
        return res;
    }

    private static void dfs(TreeNode node, int depth, List<Integer> res) {
        if (node == null) return;

        if (res.size() == depth) { // first time at this depth
            res.add(node.val);
        }

        dfs(node.right, depth + 1, res); // right-first
        dfs(node.left, depth + 1, res);
    }
}
