package Algorithms.TreeTraversal.PostOrder;

import Algorithms.TreeTraversal.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class PathSum {
    // 112. Path Sum - Easy
    // https://leetcode.com/problems/path-sum/

    // Time Complexity : O(n)
    // Space Complexity: O(h)
    public static boolean hasPathSum_recursive(TreeNode root, int targetSum) {
        if (root == null) return false;

        // leaf
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        int remaining = targetSum - root.val;  //primitive kopyaliyoruz ama return etmeye calismiyoruz.
        return hasPathSum_recursive(root.left, remaining)
            || hasPathSum_recursive(root.right, remaining);
    }

    public static boolean hasPathSum_bfs(TreeNode root, int targetSum) {
        if (root == null) return false;

        Queue<State> q = new LinkedList<>();
        q.offer(new State(root, targetSum));

        while (!q.isEmpty()) {
            State cur = q.poll();
            TreeNode node = cur.node;
            int remaining = cur.remaining;

            // leaf check
            if (node.left == null && node.right == null) {
                if (remaining == node.val) return true;
            }

            int nextRemaining = remaining - node.val;

            if (node.left != null) q.offer(new State(node.left, nextRemaining));
            if (node.right != null) q.offer(new State(node.right, nextRemaining));
        }

        return false;
    }

    public static class State {
        TreeNode node;
        int remaining;
        State(TreeNode n, int r) { node = n; remaining = r; }
    }
}
