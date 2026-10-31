package trees.dfs;

import common.model.TreeNode;
import java.util.*;

public class Q0337_HouseRobber3 {
    // 337. House Robber III - Medium
    // https://leetcode.com/problems/house-robber-iii/

    /* ------------------------------------------------------------
       | PATTERN: Tree DP (post-order)
       ------------------------------------------------------------
       dfs(node) iki değer döndürür: [bu düğümü soyarsak en iyi, soymazsak en iyi].
       Soyarsak çocuklar soyulamaz: val + sol[1] + sağ[1].
       Soymazsak her çocuk için iki seçenekten büyüğü: max(sol) + max(sağ).
    */
    /*  Complexity
        Time  : O(n)
        Space : O(h)
    */

    public static int rob(TreeNode root) {
        int[] ans = dfs(root);
        return Math.max(ans[0], ans[1]);
    }

    private static int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        int[] l = dfs(root.left);
        int[] r = dfs(root.right);
        return new int[] {root.val + l[1] + r[1], Math.max(l[0], l[1]) + Math.max(r[0], r[1])};
    }
}
