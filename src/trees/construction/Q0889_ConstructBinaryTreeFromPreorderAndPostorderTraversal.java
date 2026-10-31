package trees.construction;

import common.model.TreeNode;
import java.util.*;

public class Q0889_ConstructBinaryTreeFromPreorderAndPostorderTraversal {
    // Öncelik   : 🔵 Trend
    // Şirketler : Apple ✅ (#255)
    //
    // 889. Construct Binary Tree from Preorder and Postorder Traversal - Medium
    // https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/

    /* ------------------------------------------------------------
       | PATTERN: Tree Construction (preorder + postorder)
       ------------------------------------------------------------
       preorder[a] kök, preorder[a+1] sol alt ağacın kökü.
       Bu değerin postorder'daki konumu sol alt ağacın boyutunu verir (map ile O(1)).
       Aralıkları bölerek sol ve sağ alt ağaçları recursive kur.
    */
    /*  Complexity
        Time  : O(n)
        Space : O(n)
    */

    private Map<Integer, Integer> pos = new HashMap<>();
    private int[] preorder;

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        this.preorder = preorder;
        for (int i = 0; i < postorder.length; ++i) {
            pos.put(postorder[i], i);
        }
        return dfs(0, preorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode dfs(int a, int b, int c, int d) {
        if (a > b) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[a]);
        if (a == b) {
            return root;
        }
        int i = pos.get(preorder[a + 1]);
        int m = i - c + 1;
        root.left = dfs(a + 1, a + m, c, i);
        root.right = dfs(a + m + 1, b, i + 1, d - 1);
        return root;
    }
}
