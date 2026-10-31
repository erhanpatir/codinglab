package trees.construction;

import common.model.TreeNode;
import java.util.*;

public class Q0297_SerializeAndDeserializeBinaryTree {
    // 297. Serialize and Deserialize Binary Tree - Hard
    // https://leetcode.com/problems/serialize-and-deserialize-binary-tree/

    /* ------------------------------------------------------------
       | PATTERN: Tree BFS (level order serialization)
       ------------------------------------------------------------
       serialize: level order gez, null çocuklar için "#" yaz, virgülle birleştir.
       deserialize: ilk değer kök; kuyruktaki her düğüm için sıradaki iki değer onun sol ve sağ çocuğu.
    */
    /*  Complexity
        Time  : O(n)
        Space : O(n)
    */

    public class Codec {
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return null;
            }
            List<String> ans = new ArrayList<>();
            Deque<TreeNode> q = new LinkedList<>();
            q.offer(root);
            while (!q.isEmpty()) {
                TreeNode node = q.poll();
                if (node != null) {
                    ans.add(node.val + "");
                    q.offer(node.left);
                    q.offer(node.right);
                } else {
                    ans.add("#");
                }
            }
            return String.join(",", ans);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == null) {
                return null;
            }
            String[] vals = data.split(",");
            int i = 0;
            TreeNode root = new TreeNode(Integer.valueOf(vals[i++]));
            Deque<TreeNode> q = new ArrayDeque<>();
            q.offer(root);
            while (!q.isEmpty()) {
                TreeNode node = q.poll();
                if (!"#".equals(vals[i])) {
                    node.left = new TreeNode(Integer.valueOf(vals[i]));
                    q.offer(node.left);
                }
                ++i;
                if (!"#".equals(vals[i])) {
                    node.right = new TreeNode(Integer.valueOf(vals[i]));
                    q.offer(node.right);
                }
                ++i;
            }
            return root;
        }
    }
}
