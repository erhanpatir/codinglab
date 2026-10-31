package trees.lca;

import common.model.TreeNode;
import java.util.*;

public class Q1644_LowestCommonAncestorOfABinaryTreeII {
    // Öncelik   : ⭐ Gerçek deneyim
    // Şirketler : Meta (#289), Amazon
    // Seviye    : Mid
    // Raporlar  : 2 (1 📍London)
    //             https://leetcode.com/discuss/post/7646418/
    //
    // 1644. Lowest Common Ancestor of a Binary Tree II - Medium
    // https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-ii/

    /* ------------------------------------------------------------
       | PATTERN: LCA - DFS (p ve q var olmayabilir)
       ------------------------------------------------------------
       236'dan farkı: p ya da q ağaçta olmayabilir, bu yüzden erken çıkış yapılamaz; tüm ağaç gezilir.
       dfs, alt ağaçta p ya da q bulunup bulunmadığını döndürür. Sol ve sağdan ikisi de true ise ya da
       düğümün kendisi biri olup diğeri alt ağaçtaysa bu düğüm LCA'dır. Bulunamazsa null.
    */
    /*  Complexity
        Time  : O(n)
        Space : O(h)
    */

    private TreeNode ans;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean l = dfs(root.left, p, q);
        boolean r = dfs(root.right, p, q);
        if (l && r) {
            ans = root;
        }
        if ((l || r) && (root.val == p.val || root.val == q.val)) {
            ans = root;
        }
        return l || r || root.val == p.val || root.val == q.val;
    }
}
