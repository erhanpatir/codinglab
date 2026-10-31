package trees.bfs;

import common.model.TreeNode;
import java.util.*;

public class Q0987_VerticalOrderTraversalOfABinaryTree {
    // Öncelik   : 🔴 Yüksek
    // Şirketler : Meta ✅ (#51), Bloomberg ✅ (#103)
    //
    // 987. Vertical Order Traversal of a Binary Tree - Hard
    // https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/

    /* ------------------------------------------------------------
       | PATTERN: Tree DFS + Sıralama (sütun, satır, değer)
       ------------------------------------------------------------
       DFS ile her düğüm için (sütun, satır, değer) kaydet. Bu üçlüye göre sırala:
       önce sütun, sonra satır, aynı konumdakiler değere göre. Aynı sütundakileri gruplayarak listele.
       314'ten farkı: aynı konumdaki düğümler değere göre sıralanır, bu yüzden sıralama gerekir.
    */
    /*  Complexity
        Time  : O(n log n)
        Space : O(n)
    */

    private List<int[]> nodes = new ArrayList<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        dfs(root, 0, 0);
        Collections.sort(nodes, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[2], b[2]);
        });
        List<List<Integer>> ans = new ArrayList<>();
        int prev = -2000;
        for (int[] node : nodes) {
            int j = node[0], val = node[2];
            if (prev != j) {
                ans.add(new ArrayList<>());
                prev = j;
            }
            ans.get(ans.size() - 1).add(val);
        }

        return ans;
    }

    private void dfs(TreeNode root, int i, int j) {
        if (root == null) {
            return;
        }
        nodes.add(new int[] {j, i, root.val});
        dfs(root.left, i + 1, j - 1);
        dfs(root.right, i + 1, j + 1);
    }
}
