package trees.construction;

import common.model.ListNode;
import common.model.TreeNode;
import java.util.*;

public class Q0109_ConvertSortedListToBinarySearchTree {
    // 109. Convert Sorted List to Binary Search Tree - Medium
    // https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/

    /* ------------------------------------------------------------
       | PATTERN: Divide & Conquer - ortadaki eleman kök
       ------------------------------------------------------------
       Liste değerlerini diziye aktar. dfs(i, j): ortadaki eleman kök olur,
       sol yarı sol alt ağacı, sağ yarı sağ alt ağacı oluşturur. Böylece ağaç dengeli kalır.
       Alternatif: fast/slow pointer ile ortayı bulmak (O(n log n), O(log n) bellek).
    */
    /*  Complexity
        Time  : O(n)
        Space : O(n)
    */

    private List<Integer> nums = new ArrayList<>();

    public TreeNode sortedListToBST(ListNode head) {
        for (; head != null; head = head.next) {
            nums.add(head.val);
        }
        return dfs(0, nums.size() - 1);
    }

    private TreeNode dfs(int i, int j) {
        if (i > j) {
            return null;
        }
        int mid = (i + j) >> 1;
        TreeNode left = dfs(i, mid - 1);
        TreeNode right = dfs(mid + 1, j);
        return new TreeNode(nums.get(mid), left, right);
    }
}
