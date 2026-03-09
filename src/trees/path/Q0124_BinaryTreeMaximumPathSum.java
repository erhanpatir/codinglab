package trees.path;

import common.model.TreeNode;

public class Q0124_BinaryTreeMaximumPathSum {
    // 124. Binary Tree Maximum Path Sum - Hard
    // https://leetcode.com/problems/binary-tree-maximum-path-sum/

    private static int best = Integer.MIN_VALUE;

    // Time Complexity : O(n)
    // Space Complexity: O(h)
    public static int maxPathSum(TreeNode root) {
        dfs(root);
        return best;
    }

    /*
        -10
        /  \
       9   20
          /  \
         15   7
    */
    private static int dfs(TreeNode node) {
        if (node == null) return 0;

        // collect data from children
        int leftGain = Math.max(0, dfs(node.left));
        int rightGain = Math.max(0, dfs(node.right));

        // the path that uses this node as the "peak"
        best = Math.max(best, node.val + leftGain + rightGain);

        // conmbine
        return node.val + Math.max(leftGain, rightGain);
    }
}
