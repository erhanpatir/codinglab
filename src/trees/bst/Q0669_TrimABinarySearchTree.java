package trees.bst;

import common.model.TreeNode;
import java.util.*;

public class Q0669_TrimABinarySearchTree {
    // 669. Trim a Binary Search Tree - Medium
    // https://leetcode.com/problems/trim-a-binary-search-tree/description/

    /* ------------------------------------------------------------
       | PATTERN: BST - recursive budama
       ------------------------------------------------------------
       Kök < low ise sol alt ağacın tamamı da küçüktür: sonuç trim(sağ). Kök > high ise sonuç trim(sol).
       Aralıktaysa sol ve sağ çocukları recursive budayıp kökü döndür.
    */
    /*  Complexity
        Time  : O(n)
        Space : O(h)
    */

    public static TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return root;
        }
        if (root.val > high) {
            return trimBST(root.left, low, high);
        }
        if (root.val < low) {
            return trimBST(root.right, low, high);
        }
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}
