import arrays.binarysearch.Q0035_SearchInsertPosition;
import arrays.dp.*;
import arrays.greedy.Q0045_JumpGame2;
import arrays.greedy.Q1642_FurthestBuildingYouCanReach;
import arrays.hashing.Q0036_ValidSudoku;
import arrays.hashing.Q0169_MajorityElement;
import arrays.hashing.Q0202_HappyNumber;
import arrays.intervals.Q0056_MergeIntervals;
import arrays.prefixsum.Q0303_RangeSumQueryImmutable;
import arrays.slidingwindow.Q0643_MaximumAverageSubarray1;
import arrays.twopointers.*;
import backtracking.parentheses.Q0022_GenerateParentheses;
import bit.Q0136_SingleNumber;
import bit.Q0338_CountingBits;
import common.model.ListNode;
import common.model.Node;
import common.model.TreeNode;
import design.Q0706_DesignHashMap;
import design.Q1472_DesignBrowserHistory;
import graphs.matrix.dfs.Q0200_NumberOfIslands;
import graphs.matrix.multisource.Q0994_RottingOranges;
import graphs.minimumspantree.Q1584_MinCostToConnectAllPoints;
import graphs.shortestpath.dijkstra.Q0743_NetworkDelayTime;
import graphs.topologicalsort.Q0210_CourseSchedule2;
import graphs.unionfind.Q0547_NumberOfProvinces;
import heaps.topk.Q0373_FindKPairsWithSmallestSums;
import heaps.topk.Q0703_KthLargestElementInAStream;
import linkedlists.construction.Q0109_ConvertSortedListToBinarySearchTree;
import linkedlists.fastslow.Q0234_PalindromeLinkedList;
import linkedlists.fastslow.Q0876_MiddleOfTheLinkedList;
import linkedlists.merge.Q0021_MergeTwoSortedLists;
import linkedlists.reversal.Q0206_ReverseLinkedList;
import linkedlists.sorting.Q0148_SortList;
import linkedlists.twopointers.Q0160_IntersectionOfTwoLinkedLists;
import math.Q0009_PalindromeNumber;
import queue.bfs.Q0933_NumberOfRecentCalls;
import queue.monotonic.Q1696_JumpGame6;
import stack.monotonic.Q0496_NextGreaterElement1;
import strings.basic.Q0014_LongestCommonPrefix;
import strings.dp.Q0139_WordBreak;
import strings.dp.Q1143_LongestCommonSubsequence;
import strings.hashing.Q0451_SortCharactersByFrequency;
import strings.slidingwindow.Q0003_LongestSubstringWithoutRepeatingCharacters;
import strings.stack.Q0020_ValidParentheses;
import strings.stack.Q1047_RemoveAllAdjacentDuplicatesInString;
import strings.subsequence.Q0392_IsSubsequence;
import strings.trie.Q0208_ImplementTrie;
import strings.twopointers.Q0125_ValidPalindrome;
import trees.recursion.Q0572_SubtreeOfAnotherTree;


static ListNode fromArray(int[] values) {
    if (values == null || values.length == 0) return null;
    ListNode dummy = new ListNode(0);
    ListNode curr = dummy;
    for (int v : values) {
        curr.next = new ListNode(v);
        curr = curr.next;
    }
    return dummy.next;
}

public static TreeNode buildTree(Integer[] arr) {
    if (arr == null || arr.length == 0 || arr[0] == null) {
        return null;
    }

    TreeNode root = new TreeNode(arr[0]);
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    int i = 1;

    while (i < arr.length) {
        TreeNode current = queue.poll();

        // left child
        if (i < arr.length && arr[i] != null) {
            current.left = new TreeNode(arr[i]);
            queue.offer(current.left);
        }
        i++;

        // right child
        if (i < arr.length && arr[i] != null) {
            current.right = new TreeNode(arr[i]);
            queue.offer(current.right);
        }
        i++;
    }

    return root;
}

public static ListNode buildList(int[] values) {
    if (values == null || values.length == 0) {
        return null;
    }

    ListNode head = new ListNode(values[0]);
    ListNode current = head;

    for (int i = 1; i < values.length; i++) {
        current.next = new ListNode(values[i]);
        current = current.next;
    }

    return head;
}

public static Node buildNode(int[] arr) {
    if (arr == null || arr.length == 0) return null;

    Node[] nodes = new Node[arr.length];

    // create nodes
    for (int i = 0; i < arr.length; i++) {
        nodes[i] = new Node(arr[i]);
    }

    // connect children
    for (int i = 0; i < arr.length; i++) {

        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < arr.length) {
            nodes[i].left = nodes[left];
        }

        if (right < arr.length) {
            nodes[i].right = nodes[right];
        }
    }

    return nodes[0];
}

    void main () {
        run(94);
    }

    void run (int questionNumber){
        switch (questionNumber) {

    /* =========================
       ARRAYS / TWO POINTERS
       ========================= */

            case 26:
                Q0026_RemoveDuplicatesFromSortedArray.removeDuplicates(
                        new int[]{0,0,1,1,1,2,2,3,3,4});
                break;

            case 75:
                Q0075_SortColors.sortColors(new int[]{2,0,2,1,1,0});
                break;

            case 88:
                Q0088_MergeSortedArray.merge(
                        new int[]{1,2,3,0,0,0},3,new int[]{2,5,6},3);
                break;

            case 121:
                Q0121_BestTimeToBuyAndSellStock.maxProfit(
                        new int[]{7,1,5,3,6,4});
                break;

            case 283:
                Q0283_MoveZeroes.moveZeroes(
                        new int[]{0,1,0,3,12});
                break;


    /* =========================
       ARRAYS / SLIDING WINDOW
       ========================= */

            case 643:
                Q0643_MaximumAverageSubarray1.findMaxAverage(
                        new int[]{1,12,-5,-6,50,3},4);
                break;


    /* =========================
       ARRAYS / PREFIX SUM
       ========================= */

            case 303:
                Q0303_RangeSumQueryImmutable range =
                        new Q0303_RangeSumQueryImmutable(
                                new int[]{-2,0,3,-5,2,-1});
                range.sumRange(0,2);
                break;


    /* =========================
       ARRAYS / HASHING
       ========================= */

            case 169:
                Q0169_MajorityElement.majorityElement(
                        new int[]{2,2,1,1,1,2,2});
                break;

            case 202:
                Q0202_HappyNumber.isHappy_2(19);
                break;

            case 36:
                Q0036_ValidSudoku.isValidSudoku(new char[][]{
                        {'5','3','.','.','7','.','.','.','.'},
                        {'6','.','.','1','9','5','.','.','.'},
                        {'1','9','8','.','.','.','.','6','.'}
                });
                break;


    /* =========================
       ARRAYS / GREEDY
       ========================= */

            case 45:
                Q0045_JumpGame2.jump(new int[]{2,3,0,1,4});
                break;

            case 1642:
                Q1642_FurthestBuildingYouCanReach.furthestBuilding(
                        new int[]{4,12,2,7,3,18,20,3},19,1);
                break;


    /* =========================
       ARRAYS / INTERVALS
       ========================= */

            case 56:
                Q0056_MergeIntervals.merge(
                        new int[][]{{1,3},{2,6},{8,10},{15,18}});
                break;


    /* =========================
       ARRAYS / BINARY SEARCH
       ========================= */

            case 35:
                Q0035_SearchInsertPosition.searchInsert(
                        new int[]{1,3,5,6},5);
                break;


    /* =========================
       ARRAYS / DP
       ========================= */

            case 53:
                Q0053_MaximumSubarray.maxSubArray(
                        new int[]{-2,1,-3,4,-1,2,1,-5,4});
                break;

            case 63:
                Q0063_UniquePaths2.uniquePathsWithObstacles(
                        new int[][]{{0,0,0},{0,1,0},{0,0,0}});
                break;

            case 70:
                Q0070_ClimbingStairs.climbStairs(2);
                break;

            case 322:
                Q0322_CoinChange1.coinChange(
                        new int[]{1,2,5},11);
                break;

            case 416:
                Q0416_PartitionEqualSubsetSum.canPartition(
                        new int[]{1,5,11,5});
                break;

            case 518:
                Q0518_CoinChange2.change(
                        5,new int[]{1,2,5});
                break;


    /* =========================
       STRINGS
       ========================= */

            case 3:
                Q0003_LongestSubstringWithoutRepeatingCharacters
                        .lengthOfLongestSubstring("abcabcbb");
                break;

            case 14:
                Q0014_LongestCommonPrefix.longestCommonPrefix_3(
                        new String[]{"flower","flow","flight"});
                break;

            case 20:
                Q0020_ValidParentheses.isValid("()[]{}");
                break;

            case 125:
                Q0125_ValidPalindrome.isPalindrome(
                        "A man, a plan, a canal: Panama");
                break;

            case 392:
                Q0392_IsSubsequence.isSubsequence(
                        "abc","ahbgdc");
                break;

            case 451:
                Q0451_SortCharactersByFrequency.frequencySort("tree");
                break;

            case 1047:
                Q1047_RemoveAllAdjacentDuplicatesInString
                        .removeDuplicates("abbaca");
                break;

            case 1143:
                Q1143_LongestCommonSubsequence
                        .longestCommonSubsequence("abcde","ace");
                break;

            case 139:
                Q0139_WordBreak.wordBreak(
                        "leetcode", List.of("leet","code"));
                break;

            case 208:
                Q0208_ImplementTrie trie =
                        new Q0208_ImplementTrie();
                trie.insert("apple");
                break;


    /* =========================
       LINKED LISTS
       ========================= */

            case 21:
                Q0021_MergeTwoSortedLists.mergeTwoLists(
                        buildList(new int[]{-1,0,3}),
                        buildList(new int[]{-1,0,3}));
                break;

            case 148:
                Q0148_SortList.sortList(
                        buildList(new int[]{4,2,1,3}));
                break;

            case 160:
                ListNode a1 = fromArray(new int[]{4,1,8,4,5});
                ListNode b1 = fromArray(new int[]{5,6,1,8,4,5});
                Q0160_IntersectionOfTwoLinkedLists
                        .getIntersectionNod_twopointers(a1,b1);
                break;

            case 206:
                Q0206_ReverseLinkedList.reverseList(
                        fromArray(new int[]{1,2,3,4,5}));
                break;

            case 234:
                Q0234_PalindromeLinkedList.isPalindrome(
                        fromArray(new int[]{1,2,2,1}));
                break;

            case 876:
                Q0876_MiddleOfTheLinkedList.middleNode(
                        fromArray(new int[]{1,2,3,4,5}));
                break;

            case 109:
                Q0109_ConvertSortedListToBinarySearchTree
                        .sortedListToBST(
                                buildList(new int[]{-10,-3,0,5,9}));
                break;


    /* =========================
       STACK / QUEUE / HEAP
       ========================= */

            case 496:
                Q0496_NextGreaterElement1.nextGreaterElement_2(
                        new int[]{4,1,2},
                        new int[]{1,3,4,2});
                break;

            case 933:
                Q0933_NumberOfRecentCalls rc =
                        new Q0933_NumberOfRecentCalls();
                rc.ping(1);
                break;

            case 1696:
                Q1696_JumpGame6.maxResult(
                        new int[]{1,-1,-2,4,-7,3},2);
                break;

            case 373:
                Q0373_FindKPairsWithSmallestSums
                        .kSmallestPairs(
                                new int[]{1,7,11},
                                new int[]{2,4,6},3);
                break;

            case 703:
                Q0703_KthLargestElementInAStream kth =
                        new Q0703_KthLargestElementInAStream(
                                3,new int[]{4,5,8,2});
                kth.add(3);
                break;


    /* =========================
       TREES
       ========================= */

            case 572:
                Q0572_SubtreeOfAnotherTree.isSubtree(
                        buildTree(new Integer[]{3,4,5,1,2}),
                        buildTree(new Integer[]{4,1,2}));
                break;


    /* =========================
       GRAPHS
       ========================= */

            case 200:
                Q0200_NumberOfIslands.numIslands(
                        new char[][]{
                                {'1','1','1','1','0'},
                                {'1','1','0','1','0'},
                                {'1','1','0','0','0'},
                                {'0','0','0','0','0'}});
                break;

            case 210:
                Q0210_CourseSchedule2.findOrder(
                        2,new int[][]{{1,0}});
                break;

            case 547:
                Q0547_NumberOfProvinces.findCircleNum(
                        new int[][]{{1,1,0},{1,1,0},{0,0,1}});
                break;

            case 743:
                Q0743_NetworkDelayTime.networkDelayTime(
                        new int[][]{{2,1,1},{2,3,1},{3,4,1}},
                        4,2);
                break;

            case 994:
                Q0994_RottingOranges.orangesRotting(
                        new int[][]{{2,1,1},{1,1,0},{0,1,1}});
                break;

            case 1584:
                Q1584_MinCostToConnectAllPoints.minCostConnectPoints(
                        new int[][]{{0,0},{2,2},{3,10}});
                break;


    /* =========================
       BACKTRACKING
       ========================= */

            case 22:
                Q0022_GenerateParentheses.generateParenthesis(3);
                break;


    /* =========================
       BIT
       ========================= */

            case 136:
                Q0136_SingleNumber.singleNumber(new int[]{2,2,1});
                break;

            case 338:
                Q0338_CountingBits.countBits(5);
                break;


    /* =========================
       MATH
       ========================= */

            case 9:
                Q0009_PalindromeNumber.isPalindrome(121);
                break;


    /* =========================
       DESIGN
       ========================= */

            case 706:
                Q0706_DesignHashMap map = new Q0706_DesignHashMap();
                map.get(1);
                break;

            case 1472:
                Q1472_DesignBrowserHistory browser =
                        new Q1472_DesignBrowserHistory(
                                "https://leetcode.com/");
                browser.visit("https://leetcode.com/");
                break;
        }
    }

