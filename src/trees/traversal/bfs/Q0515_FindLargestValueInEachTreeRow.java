package trees.traversal.bfs;

import common.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q0515_FindLargestValueInEachTreeRow {
    // 515. Find Largest Value in Each Tree Row - Medium
    // https://leetcode.com/problems/find-largest-value-in-each-tree-row/description/

    // Time: O(n)
    // Space: O(w) (max width)
    public static List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;

            for(int i = 0; i < size; i++) {
                var node = queue.poll();
                max = Math.max(max, node.val);

                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            res.add(max);
        }
        return res;
    }

    public static List<Integer> largestValues_dfs(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        dfs(root, 0, res);
        return res;
    }

    private static void dfs(TreeNode node, int depth, List<Integer> res) {
        if(node == null) return;

        if (res.size() == depth) { // “Bu depth için res içinde henüz bir slot yok. ilk kez bir node görüyorum.”
            res.add(node.val);
        } else {
            res.set(depth, Math.max(res.get(depth), node.val));
        }

        dfs(node.left, depth + 1, res);
        dfs(node.right, depth + 1, res);
    }
}
