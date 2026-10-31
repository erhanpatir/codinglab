package trees.dfs;

import common.model.TreeNode;
import java.util.*;

public class Q0129_SumRootToLeafNumbers {
    // Öncelik   : 🔴 Yüksek
    // Şirketler : Meta ✅ (#26)
    //
    // 129. Sum Root to Leaf Numbers - Medium
    // https://leetcode.com/problems/sum-root-to-leaf-numbers/

    /* ------------------------------------------------------------
       | PATTERN: Tree DFS (yol boyunca sayı taşıma)
       ------------------------------------------------------------
       dfs(node, s): s = s * 10 + node.val. Yaprağa gelince s'yi döndür,
       değilse sol ve sağ alt ağaçların sonuçlarını topla.
    */
    /*  Complexity
        Time  : O(n)
        Space : O(h)
    */

    public static int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private static int dfs(TreeNode root, int s) {
        if (root == null) {
            return 0;
        }
        s = s * 10 + root.val;
        if (root.left == null && root.right == null) {
            return s;
        }
        return dfs(root.left, s) + dfs(root.right, s);
    }
}
