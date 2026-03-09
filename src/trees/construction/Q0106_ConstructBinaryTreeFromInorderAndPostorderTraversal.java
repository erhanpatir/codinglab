package trees.construction;

import common.model.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Q0106_ConstructBinaryTreeFromInorderAndPostorderTraversal {
    // 106. Construct Binary Tree from Inorder and Postorder Traversal - Medium
    // https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

    static int postorderIndex = 0;
    static Map<Integer, Integer> indexMap = new HashMap<>();

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        postorderIndex = postorder.length - 1;
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildTree(postorder, 0, inorder.length - 1);
    }

    // Time: O(n) (map sayesinde root index O(1))
    // Space: O(n) map + O(h) recursion stack
    private static TreeNode buildTree(int[] postorder, int left, int right) {
        if (left > right) return null;

        // postorder oldugu icin tersten okuyoruz
        int rootVal = postorder[postorderIndex--];

        TreeNode root = new TreeNode(rootVal);
        int mid = indexMap.get(rootVal);

        // IMPORTANT: build right first, then left
        root.right = buildTree(postorder, mid + 1, right);
        root.left = buildTree(postorder, left, mid - 1);

        return root;
    }
}
