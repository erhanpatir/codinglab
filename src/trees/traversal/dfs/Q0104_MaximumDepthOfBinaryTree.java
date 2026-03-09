package trees.traversal.dfs;

import common.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Q0104_MaximumDepthOfBinaryTree {
    // 104. Maximum Depth of Binary Tree - Easy
    // https://leetcode.com/problems/maximum-depth-of-binary-tree/

    // Time Complexity : O(n)
    // Space Complexity: O(n)
    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return 1 + Math.max(left, right);
    }

    public static int maxDepth_bfs(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int maxDepth = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();
            maxDepth++;

            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if(node.left != null) {
                    maxDepth_bfs(node.left);
                }
                if(node.right != null) {
                    maxDepth_bfs(node.right);
                }
            }
        }
        return maxDepth;
    }
}
