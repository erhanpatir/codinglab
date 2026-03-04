package Algorithms.TreeTraversal.PreOrder;

import Algorithms.TreeTraversal.TreeNode;

public class CountCompleteTreeNodes {
    // 222. Count Complete Tree Nodes - Easy
    // https://leetcode.com/problems/count-complete-tree-nodes/

    // Time Complexity : O(n)
    // Space Complexity: O(n)
    public static int countNodes_dfs(TreeNode root) {
        if(root == null) return 0;
        return 1 + countNodes_dfs(root.right) + countNodes_dfs(root.left);
    }

    /*
        Çözüm B — Complete Tree Optimization (O(log² n)) ⭐
            LeetCode 222'nin asıl amacı bu.
            Complete tree özelliğini kullanıp:
            perfect subtree’leri direkt sayıyoruz
            recursion derinliği düşüyor
            Bu yüzden height hesaplıyoruz.
    */

    // Time Complexity : O(log² n)
    // Space Complexity: O(log n)
    public static int countNodes(TreeNode root) {
        if(root == null) return 0;

        int heightLeft = heightLeft(root);
        int heightRight = heightRight(root);

        if (heightLeft == heightRight) {
            // perfect binary tree node sayısı formülü : 2^h - 1
            return (1 << heightLeft) - 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private static int heightLeft(TreeNode node) {
        int count = 0;
        while (node != null) {
            count++;
            node = node.left;
        }
        return count;
    }

    private static int heightRight(TreeNode node) {
        int count = 0;
        while (node != null) {
            count++;
            node = node.right;
        }
        return count;
    }
}
