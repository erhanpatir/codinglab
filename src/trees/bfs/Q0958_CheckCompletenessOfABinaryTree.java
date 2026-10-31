package trees.bfs;

import common.model.TreeNode;
import java.util.*;

public class Q0958_CheckCompletenessOfABinaryTree {
    // 958. Check Completeness of a Binary Tree - Medium
    // https://leetcode.com/problems/check-completeness-of-a-binary-tree/

    /* ------------------------------------------------------------
       | PATTERN: Tree BFS (null'dan sonra düğüm olmamalı)
       ------------------------------------------------------------
       Level order gezerken null çocukları da kuyruğa koy. İlk null'a ulaşınca dur;
       kuyruğun kalanında null olmayan bir düğüm varsa ağaç complete değildir.
    */
    /*  Complexity
        Time  : O(n)
        Space : O(n)
    */

    public static boolean isCompleteTree(TreeNode root) {
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (q.peek() != null) {
            TreeNode node = q.poll();
            q.offer(node.left);
            q.offer(node.right);
        }
        while (!q.isEmpty() && q.peek() == null) {
            q.poll();
        }
        return q.isEmpty();
    }
}
