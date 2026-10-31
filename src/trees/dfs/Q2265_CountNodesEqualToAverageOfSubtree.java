package trees.dfs;

import common.model.TreeNode;
import java.util.*;

public class Q2265_CountNodesEqualToAverageOfSubtree {
    // 2265. Count Nodes Equal to Average of Subtree - Medium
    // https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/

    /* ------------------------------------------------------------
       | PATTERN: Tree DFS (post-order, toplam ve sayı)
       ------------------------------------------------------------
       dfs her düğüm için alt ağacın (toplam, düğüm sayısı) ikilisini döndürür.
       Toplam / sayı (tam sayı bölmesi) düğüm değerine eşitse cevabı artır.
    */
    /*  Complexity
        Time  : O(n)
        Space : O(h)
    */

    private int ans;

    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        var l = dfs(root.left);
        var r = dfs(root.right);
        int s = l[0] + r[0] + root.val;
        int n = l[1] + r[1] + 1;
        if (s / n == root.val) {
            ++ans;
        }
        return new int[] {s, n};
    }
}
