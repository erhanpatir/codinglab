package Algorithms.TreeTraversal.PostOrder;

import Algorithms.TreeTraversal.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBinaryTree {
    public static int minDepth(TreeNode root) {
        if(root == null) return 0;

        // leaf
        if(root.left == null && root.right == null) {
            return 1;
        }
        // only right child
        if(root.left == null) {
            return 1 + minDepth(root.right);
        }
        // only left child
        if(root.right == null) {
            return 1 + minDepth(root.left);
        }
        // both children exist
        return 1 + Math.min(
                minDepth(root.left),
                minDepth(root.right)
        );
    }

    // Time Complexity : O(n)
    // Space Complexity: O(h) // the min height of the tree
    public static int minDepth_bfs(TreeNode root) {
        if(root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int minDepth = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();
            minDepth++;

            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if(node.left == null && node.right == null) {
                    return minDepth; // first leaf
                }

                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
        }
        return minDepth;
    }
}
