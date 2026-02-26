package Algorithms.TreeTraversal.PostOrder;

import Algorithms.TreeTraversal.TreeNode;

public class BalancedBinaryTree {
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
}
