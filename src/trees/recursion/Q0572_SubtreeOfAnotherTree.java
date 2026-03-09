package trees.recursion;

import common.model.TreeNode;

public class Q0572_SubtreeOfAnotherTree {
    // 572. Subtree of Another Tree - Easy
    // https://leetcode.com/problems/subtree-of-another-tree/description/

    /* Problem özü
        s ağacının içinde, yapısı ve değerleriyle birebir aynı olan bir subtree var mı?
        Yani “t ağacı, s’nin herhangi bir node’undan başlayan alt ağaç olarak bulunuyor mu?”

        En klasik çözüm: DFS + SameTree
            İki parça:
                isSame(a,b) → iki ağaç birebir aynı mı? (LeetCode 100)
                isSubtree(s,t) → s üzerinde gezer:
                ya isSame(s,t) true
                ya da solda / sağda isSubtree
    */

    //recursive

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) return false;
        if(isSame(root, subRoot)) return true;

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    private static boolean isSame(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if(root == null || subRoot == null) return false;
        if(root.val != subRoot.val) return false;

        return isSame(root.left, subRoot.left) && isSame(root.right, subRoot.right);
    }
}
