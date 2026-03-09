package trees.bst;

import common.model.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q0783_MinimumDistanceBetweenBSTNodes {
    // 783. Minimum Distance Between BST Nodes - Easy
    // https://leetcode.com/problems/minimum-distance-between-bst-nodes/description/

    /*
        Ana fikir (kritik)
            BST’nin inorder traversal’ı: artan (sorted) bir dizi verir.
            ➡️ En küçük fark yalnızca yan yana elemanlar arasında olabilir.
        Yani problem şuna indirgenir:
            “Sorted sırada gezerken, current - previous farklarının min’ini bul.”
    */
    private static Integer prev = null;
    private static int minDiff = Integer.MAX_VALUE;

    public static int minDiffInBST_recursive(TreeNode root) {
        inorder(root);
        return minDiff;
    }

    private static void inorder(TreeNode node) {
        if (node == null) return;

        inorder(node.left);

        if (prev != null) {
            minDiff = Math.min(minDiff, node.val - prev);
        }
        prev = node.val;

        inorder(node.right);
    }

    // Time: O(n)
    // Space: recursive O(h), iterative O(h)
    public static int minDiffInBST_stack(TreeNode root) {
        Deque<TreeNode>  stack = new ArrayDeque<>();
        TreeNode curr = root;

        Integer prev = null;
        int minDiff = Integer.MAX_VALUE;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();

            if (prev != null) {
                minDiff = Math.min(minDiff, curr.val - prev);
            }
            prev = curr.val;
            curr = curr.right;
        }
        return minDiff;
    }
}
