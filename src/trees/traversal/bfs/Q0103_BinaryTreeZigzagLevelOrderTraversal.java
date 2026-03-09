package trees.traversal.bfs;

import common.model.TreeNode;

import java.util.*;

public class Q0103_BinaryTreeZigzagLevelOrderTraversal {
    // 103. Binary Tree Zigzag Level Order Traversal - Medium
    // https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

    // Time: O(n)
    // Space: O(w) (max width)
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        boolean leftToRight = true;

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                level.add(node.val);

                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }

            if (!leftToRight) {
                Collections.reverse(level);
            }

            res.add(level);
            leftToRight = !leftToRight;
        }

        return res;
    }

    public static List<List<Integer>> zigzagLevelOrder_withNCopies(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        boolean leftToRight = true;

        while (!q.isEmpty()) {
            int size = q.size();

            // Collections.nCopies(size, 0),
            // size elemanlı, her elemanı 0 olan, read-only (immutable) bir liste üretir.
            // ArrayList constructor'ina verilir cunku immutable liste set edilemez.
            // Biz set kullaniyoruz cunku add yapmak istemiyoruz. Dogru indexe set etmek istiyoruz.
            // Bu yuzden listenin dolu olmasi gerekiyor.
            List<Integer> level = new ArrayList<>(Collections.nCopies(size, 0));

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                int idx = leftToRight ? i : (size - 1 - i);
                level.set(idx, node.val);

                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }

            res.add(level);
            leftToRight = !leftToRight;
        }

        return res;
    }

    public static List<List<Integer>> zigzagLevelOrder_dfs(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, 0, res);
        return res;
    }

    private static void dfs(TreeNode node, int depth, List<List<Integer>> res) {
        if (node == null) return;

        if (res.size() == depth) res.add(new LinkedList<>()); // addFirst() O(1)

        if (depth % 2 == 0) {
            res.get(depth).add(node.val);          // left -> right
        } else {
            ((LinkedList<Integer>) res.get(depth)).addFirst(node.val); // right -> left
        }

        dfs(node.left, depth + 1, res);
        dfs(node.right, depth + 1, res);
    }
}
