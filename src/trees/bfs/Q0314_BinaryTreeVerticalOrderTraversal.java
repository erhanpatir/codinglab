package trees.bfs;

import common.model.TreeNode;
import java.util.*;

public class Q0314_BinaryTreeVerticalOrderTraversal {
    // Öncelik   : ⭐ Gerçek deneyim
    // Şirketler : Meta (#5), Bloomberg ✅ (#87)
    // Seviye    : Mid, Senior, Staff
    // Raporlar  : 5 (3 📍London)
    //             https://leetcode.com/discuss/post/5732927/META-or-PHONE-SCREEN-or-E4-or-London-or-Sept-2024-or-PASSED/
    //
    // 314. Binary Tree Vertical Order Traversal - Medium
    // https://leetcode.com/problems/binary-tree-vertical-order-traversal/

    /* ------------------------------------------------------------
       | PATTERN: Tree BFS + sütun indeksi
       ------------------------------------------------------------
       Kök sütun 0, sol çocuk sütun - 1, sağ çocuk sütun + 1. BFS kullanmak, aynı sütunda
       yukarıdaki düğümlerin önce gelmesini garanti eder (sıralama gerekmez).
       Sütun -> liste map'i tut, min ve max sütunu takip et; sonunda minCol'dan maxCol'a sırayla ekle.
    */
    /*  Complexity
        Time  : O(n)
        Space : O(n)
    */

    public static List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Map<Integer, List<Integer>> columns = new HashMap<>();
        Deque<TreeNode> nodes = new ArrayDeque<>();
        Deque<Integer> cols = new ArrayDeque<>();
        nodes.offer(root);
        cols.offer(0);
        int minCol = 0, maxCol = 0;
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.poll();
            int col = cols.poll();
            columns.computeIfAbsent(col, c -> new ArrayList<>()).add(node.val);
            minCol = Math.min(minCol, col);
            maxCol = Math.max(maxCol, col);
            if (node.left != null) {
                nodes.offer(node.left);
                cols.offer(col - 1);
            }
            if (node.right != null) {
                nodes.offer(node.right);
                cols.offer(col + 1);
            }
        }
        for (int c = minCol; c <= maxCol; c++) result.add(columns.get(c));
        return result;
    }
}
