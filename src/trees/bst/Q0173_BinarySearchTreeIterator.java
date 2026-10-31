package trees.bst;

import common.model.TreeNode;
import java.util.*;

public class Q0173_BinarySearchTreeIterator {
    // Öncelik   : 🟡 Orta
    // Şirketler : Meta (#74)
    //
    // 173. Binary Search Tree Iterator - Medium
    // https://leetcode.com/problems/binary-search-tree-iterator/

    /* ------------------------------------------------------------
       | PATTERN: BST - kontrollü inorder (stack)
       ------------------------------------------------------------
       Inorder gezinmeyi bölerek yap: stack'e kökten başlayarak tüm sol kolu it.
       next(): stack'ten pop, değeri döndür, o düğümün sağ alt ağacının sol kolunu stack'e it.
       Tüm ağacı listeye almak O(n) bellek ister; bu çözüm O(h) bellek kullanır ve next() amortize O(1)'dir.
    */
    /*  Complexity
        Time  : O(1) amortize (next / hasNext)
        Space : O(h)
    */

    public class BSTIterator {
        private final Deque<TreeNode> stack = new ArrayDeque<>();

        public BSTIterator(TreeNode root) {
            pushLeft(root);
        }

        public int next() {
            TreeNode node = stack.pop();
            pushLeft(node.right);   // sıradaki en küçükler sağ alt ağacın sol kolunda
            return node.val;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

        private void pushLeft(TreeNode node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
    }
}
