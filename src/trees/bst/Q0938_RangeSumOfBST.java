package trees.bst;

import common.model.TreeNode;
import java.util.*;

public class Q0938_RangeSumOfBST {
    // Öncelik   : ⭐ Gerçek deneyim
    // Şirketler : Meta (#29)
    // Seviye    : Senior
    // Raporlar  : 1 (1 📍London)
    //             https://leetcode.com/discuss/post/5264755/Meta-or-E5-or-London-or-Offer/
    //
    // 938. Range Sum of BST - Easy
    // https://leetcode.com/problems/range-sum-of-bst/

    /* ------------------------------------------------------------
       | PATTERN: BST - budamalı DFS
       ------------------------------------------------------------
       Düğüm aralıktaysa değerini ekle. BST özelliğiyle gereksiz dalları atla:
       değer > low ise sola, değer < high ise sağa in.
    */
    /*  Complexity
        Time  : O(n)
        Space : O(h)
    */

    public static int rangeSumBST(TreeNode root, int low, int high) {
        return dfs(root, low, high);
    }

    private static int dfs(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        int x = root.val;
        int ans = low <= x && x <= high ? x : 0;
        if (x > low) {
            ans += dfs(root.left, low, high);
        }
        if (x < high) {
            ans += dfs(root.right, low, high);
        }
        return ans;
    }
}
