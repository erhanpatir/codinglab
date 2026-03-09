package trees.path;

import common.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q0113_PathSum2 {
    // 113. Path Sum II - Medium
    // https://leetcode.com/problems/path-sum-ii/

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, targetSum, new ArrayList<>(), res);
        return res;
    }
    /*          5
              / \
             4   8
            /   / \
           11  13  4
          /  \      \
         7    2      1    */
    private static void dfs(TreeNode node, int remaining,
                            List<Integer> path,
                            List<List<Integer>> res) {
        if (node == null) return; // base

        path.add(node.val); // node'a giris, state update

        if (node.left == null && node.right == null) { // leaf check - decision
            if (remaining == node.val) {
                res.add(new ArrayList<>(path));// copy
            }
        } else {
            int next = remaining - node.val;
            dfs(node.left, next, path, res);
            dfs(node.right, next, path, res);
        }

        // combine/ decide/ return
        path.remove(path.size() - 1); // backtrack
    }
}
