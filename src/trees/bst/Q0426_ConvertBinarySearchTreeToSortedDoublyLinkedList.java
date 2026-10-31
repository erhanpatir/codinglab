package trees.bst;

import common.model.Node;
import java.util.*;

public class Q0426_ConvertBinarySearchTreeToSortedDoublyLinkedList {
    // Öncelik   : 🟡 Orta
    // Şirketler : Meta (#69)
    //
    // 426. Convert Binary Search Tree to Sorted Doubly Linked List - Medium
    // https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/

    /* ------------------------------------------------------------
       | PATTERN: BST - Inorder ile bağlama
       ------------------------------------------------------------
       Inorder gezinme BST'yi sıralı verir. prev düğümü tut: prev.right = root, root.left = prev.
       İlk düğüm head olur. Sonunda baş ile sonu birbirine bağlayarak listeyi dairesel yap.
    */
    /*  Complexity
        Time  : O(n)
        Space : O(h)
    */

    private Node prev;
    private Node head;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        prev = null;
        head = null;
        dfs(root);
        prev.right = head;
        head.left = prev;
        return head;
    }

    private void dfs(Node root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (prev != null) {
            prev.right = root;
            root.left = prev;
        } else {
            head = root;
        }
        prev = root;
        dfs(root.right);
    }
}
