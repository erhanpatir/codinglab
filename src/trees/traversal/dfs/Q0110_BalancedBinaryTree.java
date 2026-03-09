package trees.traversal.dfs;

import common.model.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Q0110_BalancedBinaryTree {
    // 110. Balanced Binary Tree - Easy
    // https://leetcode.com/problems/balanced-binary-tree/

    // Time Complexity : O(n)
    // Space Complexity: O(h)
    public static boolean isBalanced(TreeNode root) {
        return dfs(root) != -1;
    }

    private static int dfs(TreeNode node) {
        // base case
        // “Boş ağaç balanced, height’ı 0”
        if (node == null) return 0;

        // “Sol taraf bozuk mu?
        // Evetse ben de bozuğum, yukarı -1 gönderiyorum.”
        int left = dfs(node.left);
        if (left == -1) return -1;

        // “Sag taraf bozuk mu?
        // Evetse ben de bozuğum, yukarı -1 gönderiyorum.”
        int right = dfs(node.right);
        if (right == -1) return -1;

        // “Benim solumla sağım arasındaki fark 1’den büyük mü?
        // Evet → ben bozuğum.”
        if (Math.abs(left - right) > 1) return -1;

        // “Ben sağlamım, parent’ıma height’ımı gönderiyorum.”
        return 1 + Math.max(left, right);
    }

    // Time Complexity : O(n)
    // Space Complexity: O(n)
    public static boolean isBalanced_dfs(TreeNode root) {
        if (root == null) return true;

        Deque<Frame> stack = new ArrayDeque<>();
        Map<TreeNode, Integer> height = new HashMap<>();

        stack.push(new Frame(root, false));

        while (!stack.isEmpty()) {
            Frame f = stack.pop();
            TreeNode node = f.node;

            if (node == null) continue;

            if (!f.visited) {
                // postorder: children first, then node
                stack.push(new Frame(node, true));
                stack.push(new Frame(node.right, false));
                stack.push(new Frame(node.left, false));
            } else {
                int leftH = height.getOrDefault(node.left, 0);
                int rightH = height.getOrDefault(node.right, 0);

                if (Math.abs(leftH - rightH) > 1) return false;

                height.put(node, 1 + Math.max(leftH, rightH));
            }
        }

        return true;
    }

    public static class Frame {
        TreeNode node;
        boolean visited;
        Frame(TreeNode n, boolean v) { node = n; visited = v; }
    }
}
