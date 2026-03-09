package trees.traversal.bfs;

import common.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q0102_BinaryTreeLevelOrderTraversal {
    // 102. Binary Tree Level Order Traversal - Medium
    // https://leetcode.com/problems/binary-tree-level-order-traversal/

    // Time: O(n)
    // Space: O(w) (max width)
    public static List<List<Integer>> levelOrder_bfs(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>(size);

            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                level.add(curr.val);

                if(curr.left != null) queue.offer(curr.left);
                if(curr.right != null) queue.offer(curr.right);
            }
            res.add(level);
        }
        return res;
    }

    public List<List<Integer>> levelOrder_recursive_dfs(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, 0, res);
        return res;
    }

    private void dfs(TreeNode node, int depth, List<List<Integer>> res) {
        if (node == null) return;
        if (res.size() == depth) res.add(new ArrayList<>());

        res.get(depth).add(node.val);

        dfs(node.left, depth + 1, res);
        dfs(node.right, depth + 1, res);
    }
}
