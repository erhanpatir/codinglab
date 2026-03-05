package Algorithms.TreeTraversal.PreOrder;

import Algorithms.TreeTraversal.TreeNode;
import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    // 105. Construct Binary Tree from Preorder and Inorder Traversal - Medium
    // https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

    static Map<Integer, Integer> indexMap = new HashMap<>();
    static int preorderIndex = 0;

    // Time Complexity : O(n)
    // Space Complexity: O(n)
    public static TreeNode buildTree(int[] preorder, int[] inorder) {

        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }

        return build(preorder, 0, inorder.length - 1);
    }

    /*
        1️⃣ preorder'dan root al
        2️⃣ inorder'da root'u bul
        3️⃣ inorder'ı ikiye böl
        4️⃣ left subtree kur
        5️⃣ right subtree kur
    */
    private static TreeNode build(int[] preorder, int left, int right) {
        if (left > right) return null;

        int rootVal = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootVal);
        int mid = indexMap.get(rootVal);

        root.left = build(preorder, left, mid - 1);
        root.right = build(preorder, mid + 1, right);

        return root;
    }
}
