package trees.bst;

import common.model.TreeNode;

public class Q0108_ConvertSortedArrayToBinarySearchTree {
    // 108. Convert Sorted Array to Binary Search Tree - Easy
    // https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/

    /*
        Problem özü
            Sıralı (ascending) bir array’den height-balanced BST oluştur.

        Ana fikir (en kolay)
            Ortadaki eleman root olur (median)
            Sol yarı → sol subtree
            Sağ yarı → sağ subtree
            Bu otomatik olarak balanced yapar.
    */

    // Time: O(n) (her eleman 1 kez node olur)
    // Space: O(log n) recursion depth (balanced olduğu için)
    public static TreeNode sortedArrayToBST(int[] nums) {
        return convert(nums, 0, nums.length - 1);
    }

    private static TreeNode convert(int[] nums, int startIndex, int endIndex) {
        if (startIndex > endIndex) return null;

        int mid = startIndex + (endIndex - startIndex) / 2;

        TreeNode node = new TreeNode((nums[mid]));
        node.left = convert(nums, startIndex, mid - 1);
        node.right = convert(nums, mid + 1, endIndex);

        return node;
    }
}
