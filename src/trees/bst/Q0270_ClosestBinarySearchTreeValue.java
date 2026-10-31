package trees.bst;

import common.model.TreeNode;
import java.util.*;

public class Q0270_ClosestBinarySearchTreeValue {
    // 270. Closest Binary Search Tree Value - Easy
    // https://leetcode.com/problems/closest-binary-search-tree-value/

    /* ------------------------------------------------------------
       | PATTERN: BST - yönlendirilmiş arama
       ------------------------------------------------------------
       BST özelliğini kullan: target kökten küçükse sola, büyükse sağa git.
       Yol boyunca |değer - target| en küçük olan (eşitlikte küçük değer) düğümü tut.
    */
    /*  Complexity
        Time  : O(h)
        Space : O(h) (recursion)
    */

    private int ans;
    private double target;
    private double diff = Double.MAX_VALUE;

    public int closestValue(TreeNode root, double target) {
        this.target = target;
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        double nxt = Math.abs(node.val - target);
        if (nxt < diff || (nxt == diff && node.val < ans)) {
            diff = nxt;
            ans = node.val;
        }
        node = target < node.val ? node.left : node.right;
        dfs(node);
    }
}
