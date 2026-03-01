package Algorithms.TreeTraversal.PostOrder;

import Algorithms.TreeTraversal.TreeNode;

import java.util.*;

public class LowestCommonAncestorOfABinaryTree {
    // 236. Lowest Common Ancestor of a Binary Tree - Medium
    // https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

    // Time: O(n)
    // Space: O(h)

    //IDEA: “bulduğunu yukarı taşı, iki koldan gelirse burada kes”
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;

        if(p == root || q == root) return root;

        var right = lowestCommonAncestor(root.right, p, q);
        var left = lowestCommonAncestor(root.left, p, q);

        if (left != null && right != null) return root;

        return left != null ? left : right;
    }

    public static TreeNode lowestCommonAncestor_iterative(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        Deque<TreeNode> stack = new ArrayDeque<>();

        parent.put(root, null);
        stack.push(root);

        // build parent pointers until we have both p and q
        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode node = stack.pop();

            if (node.left != null) {
                parent.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                stack.push(node.right);
            }
        }

        // mark all ancestors of p
        Set<TreeNode> ancestors = new HashSet<>();
        TreeNode cur = p;
        while (cur != null) {
            ancestors.add(cur);
            cur = parent.get(cur);
        }

        // walk q up until common ancestor found
        cur = q;
        while (!ancestors.contains(cur)) {
            cur = parent.get(cur);
        }

        return cur;
    }
}
