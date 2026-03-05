package Algorithms.TreeTraversal.PreOrder;

import Algorithms.TreeTraversal.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    int postorderIndex = 0;
    Map<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postorderIndex = postorder.length - 1;
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildTree(postorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] postorder, int left, int right) {
        if (left > right) return null;

        int rootVal = postorder[postorderIndex--];

        TreeNode root = new TreeNode(rootVal);
        int mid = indexMap.get(rootVal);

        root.right = buildTree(postorder, mid + 1, right);
        root.left = buildTree(postorder, left, mid - 1);

        return root;
    }
}
