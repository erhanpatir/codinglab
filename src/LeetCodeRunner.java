import backtracking.*;
import binarysearch.*;
import bit.*;
import cyclicsort.*;
import design.*;
import dp.grid.*;
import dp.knapsack.*;
import dp.linear.*;
import dp.state.*;
import dp.subsequence.*;
import graphs.bfs.*;
import graphs.dfs.*;
import graphs.mst.*;
import graphs.shortestpath.*;
import graphs.topologicalsort.*;
import graphs.unionfind.*;
import greedy.*;
import hashing.*;
import heap.*;
import intervals.*;
import linkedlist.*;
import math.*;
import matrix.*;
import monotonic.*;
import prefixsum.*;
import simulation.*;
import slidingwindow.*;
import sorting.*;
import stack.*;
import trees.bfs.*;
import trees.bst.*;
import trees.construction.*;
import trees.dfs.*;
import trees.lca.*;
import trie.*;
import twopointers.*;
import common.model.ListNode;
import common.ds.Node;
import common.model.TreeNode;
import common.model.NestedInteger;

import java.util.*;

public class LeetCodeRunner {

    private static final Map<Integer, Runnable> QUESTIONS = new HashMap<>();

    static {

        /* =========================
           ARRAYS / TWO POINTERS
           ========================= */

        QUESTIONS.put(11, () ->
                Q0011_ContainerWithMostWater.maxArea(
                        new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));

        QUESTIONS.put(15, () ->
                Q0015_3Sum.threeSum(
                        new int[]{-1, 0, 1, 2, -1, -4}));

        QUESTIONS.put(26, () ->
                Q0026_RemoveDuplicatesFromSortedArray.removeDuplicates(
                        new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));

        QUESTIONS.put(27, () ->
                Q0027_RemoveElement.removeElement(
                        new int[]{3, 2, 2, 3}, 3));

        QUESTIONS.put(42, () ->
                Q0042_TrappingRainWater.trap(
                        new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));

        QUESTIONS.put(75, () ->
                Q0075_SortColors.sortColors(
                        new int[]{2, 0, 2, 1, 1, 0}));

        QUESTIONS.put(88, () ->
                Q0088_MergeSortedArray.merge(
                        new int[]{1, 2, 3, 0, 0, 0}, 3,
                        new int[]{2, 5, 6}, 3));

        QUESTIONS.put(121, () ->
                Q0121_BestTimeToBuyAndSellStock.maxProfit(
                        new int[]{7, 1, 5, 3, 6, 4}));

        QUESTIONS.put(167, () ->
                Q0167_TwoSumII.twoSum(
                        new int[]{2, 7, 11, 15}, 9));

        QUESTIONS.put(283, () ->
                Q0283_MoveZeroes.moveZeroes(
                        new int[]{0, 1, 0, 3, 12}));


        /* =========================
           ARRAYS / SLIDING WINDOW
           ========================= */

        QUESTIONS.put(3, () ->
                Q0003_LongestSubstringWithoutRepeatingCharacters
                        .lengthOfLongestSubstring("abcabcbb"));

        QUESTIONS.put(76, () ->
                Q0076_MinimumWindowSubstring.minWindow(
                        "ADOBECODEBANC", "ABC"));

        QUESTIONS.put(209, () ->
                Q0209_MinimumSizeSubarraySum.minSubArrayLen(
                        7, new int[]{2, 3, 1, 2, 4, 3}));

        QUESTIONS.put(424, () ->
                Q0424_LongestRepeatingCharactersReplacement.characterReplacement(
                        "AABABBA", 1));

        QUESTIONS.put(438, () ->
                Q0438_FindAllAnagramsInAString.findAnagrams(
                        "cbaebabacd", "abc"));

        QUESTIONS.put(567, () ->
                Q0567_PermutationInString.checkInclusion(
                        "ab", "eidbaooo"));

        QUESTIONS.put(643, () ->
                Q0643_MaximumAverageSubarray1.findMaxAverage(
                        new int[]{1, 12, -5, -6, 50, 3}, 4));

        QUESTIONS.put(1004, () ->
                Q1004_MaxConsecutiveOnesIII.lonestOnes(
                        new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));

        QUESTIONS.put(1343, () ->
                Q1343_NumberOfSubArraysOfSizeKAndAverageGreaterThanOrEqualToThreshold
                        .numOfSubarrays(new int[]{2, 2, 2, 2, 5, 5, 5, 8}, 3, 4));

        QUESTIONS.put(1456, () ->
                Q1456_MaximumNumberOfVowelsInASubstringOfGivenLength.maxVowels(
                        "abciiidef", 3));


        /* =========================
           ARRAYS / HASHING
           ========================= */

        QUESTIONS.put(1, () ->
                Q0001_TwoSum.twoSum(
                        new int[]{2, 7, 11, 15}, 9));

        QUESTIONS.put(36, () ->
                Q0036_ValidSudoku.isValidSudoku(new char[][]{
                        {'5','3','.','.','7','.','.','.','.'},
                        {'6','.','.','1','9','5','.','.','.'},
                        {'.','9','8','.','.','.','.','6','.'},
                        {'8','.','.','.','6','.','.','.','3'},
                        {'4','.','.','8','.','3','.','.','1'},
                        {'7','.','.','.','2','.','.','.','6'},
                        {'.','6','.','.','.','.','2','8','.'},
                        {'.','.','.','4','1','9','.','.','5'},
                        {'.','.','.','.','8','.','.','7','9'}}));

        QUESTIONS.put(169, () ->
                Q0169_MajorityElement.majorityElement(
                        new int[]{2, 2, 1, 1, 1, 2, 2}));

        QUESTIONS.put(202, () ->
                Q0202_HappyNumber.isHappy_2(19));

        QUESTIONS.put(217, () ->
                Q0217_ContainsDuplicate.containsDuplicate(
                        new int[]{1, 2, 3, 1}));

        QUESTIONS.put(238, () ->
                Q0238_ProductOfArrayExceptSelf.productExceptSelf(
                        new int[]{1, 2, 3, 4}));


        /* =========================
           ARRAYS / BINARY SEARCH
           ========================= */

        QUESTIONS.put(33, () ->
                Q0033_SearchInRotatedSortedArray.search(
                        new int[]{4, 5, 6, 7, 0, 1, 2}, 0));

        QUESTIONS.put(35, () ->
                Q0035_SearchInsertPosition.searchInsert(
                        new int[]{1, 3, 5, 6}, 5));

        QUESTIONS.put(69, () ->
                Q0069_Sqrt.mySqrt(8));

        QUESTIONS.put(74, () ->
                Q0074_SearchA2DMatrix.searchMatrix(
                        new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 3));

        QUESTIONS.put(153, () ->
                Q0153_FindMinimumInRotatedSortedArray.findMin(
                        new int[]{3, 4, 5, 1, 2}));

        QUESTIONS.put(162, () ->
                Q0162_FindPeakElement.findPeakElement(
                        new int[]{1, 2, 3, 1}));

        QUESTIONS.put(240, () ->
                Q0240_SearchA2DMatrixII.searchMatrix(
                        new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}}, 5));

        QUESTIONS.put(278, () ->
                Q0278_FirstBadVersion.firstBadVersion(5));

        QUESTIONS.put(410, () ->
                Q0410_SplitArrayLargestSum.splitArray(
                        new int[]{7, 2, 5, 10, 8}, 2));

        QUESTIONS.put(704, () ->
                Q0704_BinarySearch.search(
                        new int[]{-1, 0, 3, 5, 9, 12}, 9));

        QUESTIONS.put(875, () ->
                Q0875_KokoEatingBananas.minEatingSpeed(
                        new int[]{3, 6, 7, 11}, 8));

        QUESTIONS.put(1011, () ->
                Q1011_CapacityToShipPackagesWithinDDays.shipWithinDays(
                        new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5));

        QUESTIONS.put(1482, () ->
                Q1482_MinimumDaysToMakeMBouqets.minDays(
                        new int[]{1, 10, 3, 10, 2}, 3, 1));


        /* =========================
           ARRAYS / INTERVALS
           ========================= */

        QUESTIONS.put(56, () ->
                Q0056_MergeIntervals.merge(
                        new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}}));

        QUESTIONS.put(57, () ->
                Q0057_InsertInterval.insert(
                        new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5}));

        QUESTIONS.put(252, () ->
                Q0252_MeetingRooms.canAttendMeetings(
                        new int[][]{{0, 30}, {5, 10}, {15, 20}}));

        QUESTIONS.put(253, () ->
                Q0253_MeetingRoomsII.minMeetingRooms(
                        new int[][]{{0, 30}, {5, 10}, {15, 20}}));


        /* =========================
           ARRAYS / PREFIX SUM
           ========================= */

        QUESTIONS.put(303, () -> {
            Q0303_RangeSumQueryImmutable obj =
                    new Q0303_RangeSumQueryImmutable(new int[]{-2, 0, 3, -5, 2, -1});
            obj.sumRange(0, 2);
        });

        QUESTIONS.put(523, () ->
                Q0523_ContinuousSubarraySum.checkSubarraySum(
                        new int[]{23, 2, 4, 6, 7}, 6));

        QUESTIONS.put(525, () ->
                Q0525_ContiguousArray.findMaxLength(
                        new int[]{0, 1, 0}));

        QUESTIONS.put(560, () ->
                Q0560_SubarraySumEqualsK.subarraySum(
                        new int[]{1, 1, 1}, 2));

        QUESTIONS.put(974, () ->
                Q0974_SubarraySumsDivisibleByK.subarraysDivByK(
                        new int[]{4, 5, 0, -2, -3, 1}, 5));


        /* =========================
           ARRAYS / GREEDY
           ========================= */

        QUESTIONS.put(349, () ->
                Q0349_IntersectionOfTwoArrays.intersection(
                        new int[]{1, 2, 2, 1}, new int[]{2, 2}));

        QUESTIONS.put(1642, () ->
                Q1642_FurthestBuildingYouCanReach.furthestBuilding(
                        new int[]{4, 2, 7, 6, 9, 14, 12}, 5, 1));


        /* =========================
           GREEDY
           ========================= */

        QUESTIONS.put(435, () ->
                Q0435_NonOverlappingIntervals.eraseOverlapIntervals(
                        new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}}));

        QUESTIONS.put(452, () ->
                Q0452_MinimumNumberOfArrowsToBurstBalloons.findMinArrowShots(
                        new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}}));

        QUESTIONS.put(621, () ->
                Q0621_TaskScheduler.leastInterval(
                        new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));


        /* =========================
           STRINGS
           ========================= */

        QUESTIONS.put(14, () ->
                Q0014_LongestCommonPrefix.longestCommonPrefix_3(
                        new String[]{"flower", "flow", "flight"}));

        QUESTIONS.put(49, () ->
                Q0049_GroupAnagrams.groupAnagrams_sorting(
                        new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));

        QUESTIONS.put(125, () ->
                Q0125_ValidPalindrome.isPalindrome(
                        "A man, a plan, a canal: Panama"));

        QUESTIONS.put(242, () ->
                Q0242_ValidAnagram.isAnagram("anagram", "nagaram"));

        QUESTIONS.put(392, () ->
                Q0392_IsSubsequence.isSubsequence(
                        "abc", "ahbgdc"));

        QUESTIONS.put(1047, () ->
                Q1047_RemoveAllAdjacentDuplicatesInString
                        .removeDuplicates("abbaca"));


        /* =========================
           HASHING
           ========================= */

        QUESTIONS.put(128, () ->
                Q0128_LongestConsecutiveSequence.longestConsecutive(
                        new int[]{100, 4, 200, 1, 3, 2}));


        /* =========================
           LINKED LISTS
           ========================= */

        QUESTIONS.put(160, () ->
                Q0160_IntersectionOfTwoLinkedLists.getIntersectionNode(
                        buildList(new int[]{4, 1, 8, 4, 5}),
                        buildList(new int[]{5, 6, 1, 8, 4, 5})));

        QUESTIONS.put(206, () ->
                Q0206_ReverseLinkedList.reverseList(
                        buildList(new int[]{1, 2, 3, 4, 5})));

        QUESTIONS.put(234, () ->
                Q0234_PalindromeLinkedList.isPalindrome(
                        buildList(new int[]{1, 2, 2, 1})));

        QUESTIONS.put(876, () ->
                Q0876_MiddleOfTheLinkedList.middleNode(
                        buildList(new int[]{1, 2, 3, 4, 5})));


        /* =========================
           STACK
           ========================= */

        QUESTIONS.put(20, () ->
                Q0020_ValidParentheses.isValid("()[]{}"));

        QUESTIONS.put(71, () ->
                Q0071_SimplifyPath.simplifyPath("/home/"));

        QUESTIONS.put(150, () ->
                Q0150_EvaluateReversePolishRotation.evalRPN(
                        new String[]{"2", "1", "+", "3", "*"}));

        QUESTIONS.put(155, () -> {
            Q0155_MinStack minStack = new Q0155_MinStack();
            minStack.push(-2);
            minStack.push(0);
            minStack.push(-3);
            minStack.getMin();
        });

        QUESTIONS.put(227, () ->
                Q0227_BasicCalculator2.calculate("3+2*2"));

        QUESTIONS.put(394, () ->
                Q0394_DecodeString.decodeString("3[a]2[bc]"));

        QUESTIONS.put(853, () ->
                Q0853_CarFleet.carFleet(12,
                        new int[]{10, 8, 0, 5, 3},
                        new int[]{2, 4, 1, 1, 3}));

        QUESTIONS.put(84, () ->
                Q0084_LargestRectangleInHistogram.largestRectangleArea(
                        new int[]{2, 1, 5, 6, 2, 3}));

        QUESTIONS.put(402, () ->
                Q0402_RemoveKDigits.removeKdigits("1432219", 3));

        QUESTIONS.put(496, () ->
                Q0496_NextGreaterElement1.nextGreaterElement_BruteForce(
                        new int[]{4, 1, 2}, new int[]{1, 3, 4, 2}));

        QUESTIONS.put(503, () ->
                Q0503_NextGreaterElement2.nextGreaterElements(
                        new int[]{1, 2, 1}));

        QUESTIONS.put(739, () ->
                Q0739_DailyTemperatures.dailyTemperatures(
                        new int[]{73, 74, 75, 71, 69, 72, 76, 73}));

        QUESTIONS.put(901, () -> {
            Q0901_OnlineStockSpan stockSpan = new Q0901_OnlineStockSpan();
            stockSpan.next(100);
            stockSpan.next(80);
        });


        /* =========================
           QUEUE / MONOTONIC
           ========================= */

        QUESTIONS.put(239, () ->
                Q0239_SlidingWindowMaximum.maxSlidingWindow(
                        new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));


        /* =========================
           HEAPS
           ========================= */

        QUESTIONS.put(347, () ->
                Q0347_TopKFrequentElements.topKFrequent_bucketsort(
                        new int[]{1, 1, 1, 2, 2, 3}, 2));

        QUESTIONS.put(373, () ->
                Q0373_FindKPairsWithSmallestSums.kSmallestPairs(
                        new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3));

        QUESTIONS.put(703, () -> {
            Q0703_KthLargestElementInAStream kth =
                    new Q0703_KthLargestElementInAStream(
                            3, new int[]{4, 5, 8, 2});
            kth.add(3);
        });

        QUESTIONS.put(973, () ->
                Q0973_KClosestPointsToOrigin.kClosest(
                        new int[][]{{1, 3}, {-2, 2}}, 1));


        /* =========================
           TREES / TRAVERSAL DFS
           ========================= */

        QUESTIONS.put(94, () ->
                Q0094_BinaryTreeInOrderTraversal.inorderTraversal_stack(
                        buildTree(new Integer[]{1, null, 2, 3})));

        QUESTIONS.put(100, () ->
                Q0100_SameTree.isSameTree(
                        buildTree(new Integer[]{1, 2, 3}),
                        buildTree(new Integer[]{1, 2, 3})));

        QUESTIONS.put(101, () ->
                Q0101_SymmetricTree.isSymmetric(
                        buildTree(new Integer[]{1, 2, 2, 3, 4, 4, 3})));

        QUESTIONS.put(104, () ->
                Q0104_MaximumDepthOfBinaryTree.maxDepth(
                        buildTree(new Integer[]{3, 9, 20, null, null, 15, 7})));

        QUESTIONS.put(110, () ->
                Q0110_BalancedBinaryTree.isBalanced(
                        buildTree(new Integer[]{3, 9, 20, null, null, 15, 7})));

        QUESTIONS.put(144, () ->
                Q0144_BinaryTreePreOrderTraversal.preorderTraversal_recursion(
                        buildTree(new Integer[]{1, null, 2, 3})));

        QUESTIONS.put(145, () ->
                Q0145_BinaryTreePostOrderTraversal.postOrderTraversal_recursion(
                        buildTree(new Integer[]{1, null, 2, 3})));

        QUESTIONS.put(222, () ->
                Q0222_CountCompleteTreeNodes.countNodes(
                        buildTree(new Integer[]{1, 2, 3, 4, 5, 6})));

        QUESTIONS.put(226, () ->
                Q0226_InvertBinaryTree.invertTree_dfs(
                        buildTree(new Integer[]{4, 2, 7, 1, 3, 6, 9})));

        QUESTIONS.put(543, () ->
                Q0543_DiameterOfBinaryTree.diameterOfBinaryTree(
                        buildTree(new Integer[]{1, 2, 3, 4, 5})));


        /* =========================
           TREES / TRAVERSAL BFS
           ========================= */

        QUESTIONS.put(102, () ->
                Q0102_BinaryTreeLevelOrderTraversal.levelOrder_bfs(
                        buildTree(new Integer[]{3, 9, 20, null, null, 15, 7})));

        QUESTIONS.put(103, () ->
                Q0103_BinaryTreeZigzagLevelOrderTraversal.zigzagLevelOrder(
                        buildTree(new Integer[]{3, 9, 20, null, null, 15, 7})));

        QUESTIONS.put(111, () ->
                Q0111_MinimumDepthOfBinaryTree.minDepth(
                        buildTree(new Integer[]{3, 9, 20, null, null, 15, 7})));

        QUESTIONS.put(199, () ->
                Q0199_BinaryTreeRightSideView.rightSideView(
                        buildTree(new Integer[]{1, 2, 3, null, 5, null, 4})));

        QUESTIONS.put(515, () ->
                Q0515_FindLargestValueInEachTreeRow.largestValues(
                        buildTree(new Integer[]{1, 3, 2, 5, 3, null, 9})));

        QUESTIONS.put(662, () ->
                Q0662_MaximumWidthOfBinaryTree.widthOfBinaryTree(
                        buildTree(new Integer[]{1, 3, 2, 5, 3, null, 9})));


        /* =========================
           TREES / BST
           ========================= */

        QUESTIONS.put(98, () ->
                Q0098_ValidateBinarySearchTree.isValidBST(
                        buildTree(new Integer[]{2, 1, 3})));

        QUESTIONS.put(108, () ->
                Q0108_ConvertSortedArrayToBinarySearchTree.sortedArrayToBST(
                        new int[]{-10, -3, 0, 5, 9}));

        QUESTIONS.put(230, () ->
                Q0230_KthSmallestElementInaBST.kthSmallest(
                        buildTree(new Integer[]{3, 1, 4, null, 2}), 1));

        QUESTIONS.put(530, () ->
                Q0530_MinimumAbsoluteDifferenceInBST.getMinimumDifference_recursive(
                        buildTree(new Integer[]{4, 2, 6, 1, 3})));

        QUESTIONS.put(783, () ->
                Q0783_MinimumDistanceBetweenBSTNodes.minDiffInBST_recursive(
                        buildTree(new Integer[]{4, 2, 6, 1, 3})));


        /* =========================
           TREES / CONSTRUCTION
           ========================= */

        QUESTIONS.put(105, () ->
                Q0105_ConstructBinaryTreeFromPreorderAndInorderTraversal.buildTree(
                        new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}));

        QUESTIONS.put(106, () ->
                Q0106_ConstructBinaryTreeFromInorderAndPostorderTraversal.buildTree(
                        new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3}));


        /* =========================
           TREES / LCA
           ========================= */

        QUESTIONS.put(235, () -> {
            TreeNode root = buildTree(new Integer[]{6, 2, 8, 0, 4, 7, 9, null, null, 3, 5});
            Q0235_LowestCommonAncestorOfABinarySearchTree.lowestCommonAncestor2(
                    root, root.left, root.right);
        });

        QUESTIONS.put(236, () -> {
            TreeNode root = buildTree(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
            Q0236_LowestCommonAncestorOfABinaryTree.lowestCommonAncestor(
                    root, root.left, root.right);
        });


        /* =========================
           TREES / PATH
           ========================= */

        QUESTIONS.put(112, () ->
                Q0112_PathSum.hasPathSum_recursive(
                        buildTree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1}), 22));

        QUESTIONS.put(113, () ->
                Q0113_PathSum2.pathSum(
                        buildTree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1}), 22));

        QUESTIONS.put(124, () ->
                Q0124_BinaryTreeMaximumPathSum.maxPathSum(
                        buildTree(new Integer[]{-10, 9, 20, null, null, 15, 7})));

        QUESTIONS.put(257, () ->
                Q0257_BinaryTreePaths.binaryTreePaths_recursion(
                        buildTree(new Integer[]{1, 2, 3, null, 5})));


        /* =========================
           TREES / POINTER
           ========================= */

        QUESTIONS.put(116, () ->
                Q0116_PopulatingNextRightPointersInEachNode.connect_bfs(
                        buildNode(new int[]{1, 2, 3, 4, 5, 6, 7})));

        QUESTIONS.put(117, () ->
                Q0117_PopulatingNextRightPointersInEachNode2.connect_bfs(
                        buildNode(new int[]{1, 2, 3, 4, 5, 0, 7})));


        /* =========================
           TREES / RECURSION
           ========================= */

        QUESTIONS.put(572, () ->
                Q0572_SubtreeOfAnotherTree.isSubtree(
                        buildTree(new Integer[]{3, 4, 5, 1, 2}),
                        buildTree(new Integer[]{4, 1, 2})));


        /* =========================
           GRAPHS / MATRIX
           ========================= */

        QUESTIONS.put(130, () -> Q0130_SurroundedRegions.solve(
                new char[][]{
                        {'X','X','X','X'},
                        {'X','O','O','X'},
                        {'X','X','O','X'},
                        {'X','O','X','X'}}));

        QUESTIONS.put(200, () ->
                Q0200_NumberOfIslands.numIslands(
                        new char[][]{
                                {'1', '1', '1', '1', '0'},
                                {'1', '1', '0', '1', '0'},
                                {'1', '1', '0', '0', '0'},
                                {'0', '0', '0', '0', '0'}}));

        QUESTIONS.put(417, () ->
                Q0417_PacificAtlanticWaterFlow.pacificAtlantic(
                        new int[][]{{1, 2, 2, 3, 5},
                                    {3, 2, 3, 4, 4},
                                    {2, 4, 5, 3, 1},
                                    {6, 7, 1, 4, 5},
                                    {5, 1, 1, 2, 4}}));

        QUESTIONS.put(695, () ->
                Q0695_MaxAreaOfIsland.maxAreaOfIsland(
                        new int[][]{{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                                    {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                                    {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                                    {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}}));

        QUESTIONS.put(1091, () ->
                Q1091_ShortestPathInBinaryMatrix.shortestPathBinaryMatrix(
                        new int[][]{{0, 1}, {1, 0}}));


        /* =========================
           GRAPHS / TRAVERSAL
           ========================= */

        QUESTIONS.put(133, () -> Q0133_CloneGraph.cloneGraph(
                buildGraph(new int[][]{{1, 2}, {1, 3}, {2, 4}, {3, 4}})));


        /* =========================
           GRAPHS / TOPOLOGICAL SORT
           ========================= */

        QUESTIONS.put(207, () ->
                Q0207_CourseSchedule.canFinish(
                        2, new int[][]{{1, 0}}));

        QUESTIONS.put(210, () ->
                Q0210_CourseSchedule2.findOrder(
                        2, new int[][]{{1, 0}}));

        QUESTIONS.put(269, () ->
                Q0269_AlienDictionary.alienOrder(
                        new String[]{"wrt", "wrf", "er", "ett", "rftt"}));

        QUESTIONS.put(310, () ->
                Q0310_MinimumHeightTrees.findMinHeightTrees(
                        4, new int[][]{{1, 0}, {1, 2}, {1, 3}}));

        QUESTIONS.put(444, () -> {
            List<List<Integer>> sequences = new ArrayList<>();
            sequences.add(Arrays.asList(1, 2));
            sequences.add(Arrays.asList(1, 3));
            sequences.add(Arrays.asList(2, 3));
            Q0444_SequenceReconstruction.sequenceReconstruction(
                    new int[]{1, 2, 3}, sequences);
        });

        QUESTIONS.put(802, () ->
                Q0802_FindEventualSafeStates.eventualSafeNodes(
                        new int[][]{{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}}));

        QUESTIONS.put(1136, () ->
                Q1136_ParallelCourses.minimumSemesters(
                        3, new int[][]{{1, 3}, {2, 3}}));


        /* =========================
           GRAPHS / SHORTEST PATH
           ========================= */

        QUESTIONS.put(743, () ->
                Q0743_NetworkDelayTime.networkDelayTime(
                        new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}},
                        4, 2));

        QUESTIONS.put(787, () ->
                Q0787_CheapestFlightsWithinKStops.findCheapestPrice(
                        3, new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}},
                        0, 2, 1));

        QUESTIONS.put(1514, () ->
                Q1514_PathWithMaximumProbability.maxProbability(
                        3, new int[][]{{0, 1}, {1, 2}, {0, 2}},
                        new double[]{0.5, 0.5, 0.2}, 0, 2));


        /* =========================
           BACKTRACKING
           ========================= */

        QUESTIONS.put(17, () ->
                Q0017_LetterCombinationsOfAPhoneNumber.letterCombinations("23"));
        QUESTIONS.put(22, () ->
                Q0022_GenerateParentheses.generateParenthesis(3));
        QUESTIONS.put(39, () ->
                Q0039_CombinationSum.combinationSum(
                        new int[]{2, 3, 6, 7}, 7));
        QUESTIONS.put(40, () ->
                Q0040_CombinationSumII.combinationSum2(
                        new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
        QUESTIONS.put(46, () ->
                Q0046_Permutations.permute(
                        new int[]{1, 2, 3}));
        QUESTIONS.put(47, () ->
                Q0047_PermutationsII.permuteUnique(
                        new int[]{1, 2, 3}));
        QUESTIONS.put(51, () ->
                Q0051_NQueens.solveNQueens(4));
        QUESTIONS.put(77, () ->
                Q0077_Combinations.combine(4, 2));
        QUESTIONS.put(78, () ->
                Q0078_Subsets.subsets(
                        new int[]{1, 2, 3}));
        QUESTIONS.put(79, () ->
                Q0079_WordSearch.exist(new char[][]{{'A','B','C','E'},
                        {'S','F','C','S'},
                        {'A','D','E','E'}}, "ABCCED"));
        QUESTIONS.put(90, () ->
                Q0090_SubsetsII.subsetsWithDup(
                        new int[]{1, 2, 2}));
        QUESTIONS.put(131, () ->
                Q0131_PalindromePartitioning.partition("aab"));

        QUESTIONS.put(216, () ->
                Q0216_CombinationSumIII.combinationSum3(2, 9));


        /* =========================
           DYNAMIC PROGRAMMING
           ========================= */

        QUESTIONS.put(53, () ->
                Q0053_MaximumSubarray.maxSubArray_kadane(
                        new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));

        QUESTIONS.put(55, () ->
                Q0055_JumpGame.jumpGame(
                        new int[]{2, 3, 1, 1, 4}));

        QUESTIONS.put(403, () ->
                Q0403_FrogJump.canCross(
                        new int[]{0, 1, 3, 5, 6, 8, 12, 17}));

        QUESTIONS.put(62, () ->
                Q0062_UniquePaths.uniquePaths(3, 7));

        QUESTIONS.put(63, () ->
                Q0063_UniquePaths2.uniquePathsWithObstacles(
                        new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));

        QUESTIONS.put(64, () ->
                Q0064_MinimumPathSum.minPathSum(
                        new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));

        QUESTIONS.put(70, () ->
                Q0070_ClimbingStairs.climbStairs(5));

        QUESTIONS.put(72, () ->
                Q0072_EditDistance.minDistance("horse", "ros"));

        QUESTIONS.put(115, () ->
                Q0115_DistinctSubsequences.numDistinct("rabbbit", "rabbit"));

        QUESTIONS.put(139, () ->
                Q0139_WordBreak.wordBreak(
                        "leetcode", Arrays.asList("leet", "code")));

        QUESTIONS.put(152, () ->
                Q0152_MaximumProductSubarray.maxProduct(
                        new int[]{2, 3, -2, 4}));

        QUESTIONS.put(198, () ->
                Q0198_HouseRobber.rob(
                        new int[]{1, 2, 3, 1}));

        QUESTIONS.put(213, () ->
                Q0213_HouseRobberII.rob(
                        new int[]{2, 3, 2}));

        QUESTIONS.put(221, () ->
                Q0221_MaximalSquare.maximalSquare(
                        new char[][]{{'1','0','1','0','0'},
                                     {'1','0','1','1','1'},
                                     {'1','1','1','1','1'},
                                     {'1','0','0','1','0'}}));

        QUESTIONS.put(300, () ->
                Q0300_LongestIncreasingSubsequence.lengthOfLIS(
                        new int[]{10, 9, 2, 5, 3, 7, 101, 18}));

        QUESTIONS.put(322, () ->
                Q0322_CoinChange1.coinChange(
                        new int[]{1, 2, 5}, 11));

        QUESTIONS.put(354, () ->
                Q0354_RussianDollEnvelopes.maxEnvelopes_DP(
                        new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}}));

        QUESTIONS.put(416, () ->
                Q0416_PartitionEqualSubsetSum.canPartition(
                        new int[]{1, 5, 11, 5}));

        QUESTIONS.put(474, () ->
                Q0474_OnesAndZeroes.findMaxForm(
                        new String[]{"10", "0001", "111001", "1", "0"}, 5, 3));

        QUESTIONS.put(494, () ->
                Q0494_TargetSum.findTargetSumWays(
                        new int[]{1, 1, 1, 1, 1}, 3));

        QUESTIONS.put(516, () ->
                Q0516_LongestPalindromicSubsequence.longestPalindromeSubseq("bbbab"));

        QUESTIONS.put(518, () ->
                Q0518_CoinChange2.change(
                        5, new int[]{1, 2, 5}));

        QUESTIONS.put(673, () ->
                Q0673_NumberOfLongestIncreasingSubsequence.findNumberOfLIS(
                        new int[]{1, 3, 5, 4, 7}));

        QUESTIONS.put(746, () ->
                Q0746_MinCostClimbingStairs.minCostClimbingStairs(
                        new int[]{10, 15, 20}));

        QUESTIONS.put(918, () ->
                Q0918_MaximumCircularSubarray.maxSubarraySumCircular(
                        new int[]{1, -2, 3, -2}));

        QUESTIONS.put(931, () ->
                Q0931_MinimumFallingPathSum.minFallingPathSum(
                        new int[][]{{2, 1, 3}, {6, 5, 4}, {7, 8, 9}}));

        QUESTIONS.put(1143, () ->
                Q1143_LongestCommonSubsequence.longestCommonSubsequence(
                        "abcde", "ace"));


        /* =========================
           MATH
           ========================= */

        QUESTIONS.put(9, () ->
                Q0009_PalindromeNumber.isPalindrome(121));


        /* =========================
           ARRAYS / MATRIX
           ========================= */

        QUESTIONS.put(48, () ->
                Q0048_RotateImage.rotate(
                        new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));

        QUESTIONS.put(54, () ->
                Q0054_SpiralMatrix.spiralOrder(
                        new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));

        QUESTIONS.put(73, () ->
                Q0073_SetMatrixZeroes.setZeroes(
                        new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}}));

        QUESTIONS.put(289, () ->
                Q0289_GameOfLife.gameOfLife(
                        new int[][]{{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}}));


        /* =========================
           BIT MANIPULATION
           ========================= */

        QUESTIONS.put(136, () ->
                Q0136_SingleNumber.singleNumber(new int[]{2, 2, 1}));

        QUESTIONS.put(190, () ->
                Q0190_ReverseBits.reverseBits(43261596));

        QUESTIONS.put(191, () ->
                Q0191_NumberOf1Bits.hammingWeight(11));

        QUESTIONS.put(268, () ->
                Q0268_MissingNumber.missingNumber(new int[]{3, 0, 1}));

        QUESTIONS.put(338, () ->
                Q0338_CountingBits.countBits(5));


        /* =========================
           LINKED LISTS
           ========================= */

        QUESTIONS.put(21, () ->
                Q0021_MergeTwoSortedLists.mergeTwoLists(
                        buildList(new int[]{1, 2, 4}),
                        buildList(new int[]{1, 3, 4})));

        QUESTIONS.put(109, () ->
                Q0109_ConvertSortedListToBinarySearchTree.sortedListToBST(
                        buildList(new int[]{-10, -3, 0, 5, 9})));

        QUESTIONS.put(148, () ->
                Q0148_SortList.sortList(
                        buildList(new int[]{4, 2, 1, 3})));


        /* =========================
           HASHING (remaining)
           ========================= */

        QUESTIONS.put(205, () ->
                Q0205_IsomorphicStrings.isIsomorphic("egg", "add"));

        QUESTIONS.put(219, () ->
                Q0219_ContainsDuplicateII.containsNearbyDuplicate(
                        new int[]{1, 2, 3, 1}, 3));

        QUESTIONS.put(290, () ->
                Q0290_WordPattern.wordPattern("abba", "dog cat cat dog"));

        QUESTIONS.put(383, () ->
                Q0383_RansomNote.canConstruct_hashMap("aa", "aab"));

        QUESTIONS.put(659, () ->
                Q0659_SplitArrayIntoConsecutiveSubsequences.isPossible(
                        new int[]{1, 2, 3, 3, 4, 5}));

        QUESTIONS.put(792, () ->
                Q0792_NumberOfMatchingSubsequences.numMatchingSubseq(
                        "abcde", new String[]{"a", "bb", "acd", "ace"}));

        QUESTIONS.put(1189, () ->
                Q1189_MaximumNumberOfBalloons.maxNumberOfBalloons("nlaebolko"));

        QUESTIONS.put(1512, () ->
                Q1512_NumberOfGoodPairs.numIdenticalPairs(new int[]{1, 2, 3, 1, 1, 3}));

        QUESTIONS.put(1525, () ->
                Q1525_NumberOfGoodWaysToSplitAString.numSplits("aacaba"));


        /* =========================
           STRINGS / HASHING
           ========================= */

        QUESTIONS.put(451, () ->
                Q0451_SortCharactersByFrequency.frequencySort("tree"));


        /* =========================
           QUEUE
           ========================= */

        QUESTIONS.put(862, () ->
                Q0862_ShortestSubarrayWithSumAtLeastK.shortestSubarray(new int[]{1}, 1));

        QUESTIONS.put(933, () -> {
            Q0933_NumberOfRecentCalls outer = new Q0933_NumberOfRecentCalls();
            Q0933_NumberOfRecentCalls.RecentCounter rc = outer.new RecentCounter();
            rc.ping(1);
        });

        QUESTIONS.put(950, () ->
                Q0950_RevealCardsInIncreasingOrder.deckRevealedIncreasing(
                        new int[]{17, 13, 11, 2, 3, 5, 7}));

        QUESTIONS.put(1696, () ->
                Q1696_JumpGameVI.maxResult(new int[]{1, -1, -2, 4, -7, 3}, 2));

        QUESTIONS.put(2073, () ->
                Q2073_TimeNeededToBuyTickets.timeRequiredToBuy(new int[]{2, 3, 2}, 2));


        /* =========================
           DYNAMIC PROGRAMMING (remaining)
           ========================= */

        QUESTIONS.put(45, () ->
                Q0045_JumpGame2.jump(new int[]{2, 3, 1, 1, 4}));

        QUESTIONS.put(337, () ->
                Q0337_HouseRobber3.rob(
                        buildTree(new Integer[]{3, 2, 3, null, 3, null, 1})));

        QUESTIONS.put(583, () ->
                Q0583_DeleteOperationForTwoStrings.minDistance("sea", "eat"));


        /* =========================
           GRAPHS (remaining)
           ========================= */

        QUESTIONS.put(127, () ->
                Q0127_WordLadder.ladderLength("hit", "cog",
                        Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));

        QUESTIONS.put(323, () ->
                Q0323_NumberOfConnectedComponentsInAnUndirectedGraph.countComponents(
                        5, new int[][]{{0, 1}, {1, 2}, {3, 4}}));

        QUESTIONS.put(433, () ->
                Q0433_MinimumGeneticMutation.minMutation(
                        "AACCGGTT", "AACCGGTA", new String[]{"AACCGGTA"}));

        QUESTIONS.put(261, () ->
                Q0261_GraphValidTree.validTree(
                        5, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 4}}));

        QUESTIONS.put(329, () ->
                Q0329_LongestIncreasingPathInAMatrix.longestIncreasingPath(
                        new int[][]{{9, 9, 4}, {6, 6, 8}, {2, 1, 1}}));

        QUESTIONS.put(547, () ->
                Q0547_NumberOfProvinces.findCircleNum(
                        new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));

        QUESTIONS.put(684, () ->
                Q0684_RedundantConnection.findRedundantConnection(
                        new int[][]{{1, 2}, {1, 3}, {2, 3}}));

        QUESTIONS.put(685, () ->
                Q0685_RedundantConnectionII.findRedundantDirectedConnection(
                        new int[][]{{1, 2}, {1, 3}, {2, 3}}));

        QUESTIONS.put(721, () ->
                Q0721_AccountsMerge.accountsMerge(
                        Arrays.asList(
                                Arrays.asList("John", "john@mail.com", "john_newyork@mail.com"),
                                Arrays.asList("John", "john@mail.com", "john00@mail.com"))));

        QUESTIONS.put(765, () ->
                Q0765_CouplesHoldingHands.minSwapsCouples(
                        new int[]{0, 2, 1, 3}));

        QUESTIONS.put(778, () ->
                Q0778_SwimInRisingWater.swimInWater(
                        new int[][]{{0, 2}, {1, 3}}));

        QUESTIONS.put(839, () ->
                Q0839_SimilarStringGroups.numSimilarGroups(
                        new String[]{"tars", "rats", "arts", "star"}));

        QUESTIONS.put(924, () ->
                Q0924_MinimizeMalwareSpread.minMalwareSpread(
                        new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}, new int[]{0, 1}));

        QUESTIONS.put(990, () ->
                Q0990_SatisfiabilityOfEqualityEquations.equationsPossible(
                        new String[]{"a==b", "b!=a"}));

        QUESTIONS.put(669, () ->
                Q0669_TrimABinarySearchTree.trimBST(
                        buildTree(new Integer[]{1, 0, 2}), 1, 2));

        QUESTIONS.put(994, () ->
                Q0994_RottingOranges.orangesRotting(
                        new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}));

        QUESTIONS.put(1584, () ->
                Q1584_MinCostToConnectAllPoints.minCostConnectPoints(
                        new int[][]{{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}}));

        QUESTIONS.put(1631, () ->
                Q1631_PathWithMinimumEffort.minimumEffortPath(
                        new int[][]{{1, 2, 2}, {3, 8, 2}, {5, 3, 5}}));


        /* =========================
           TRIES
           ========================= */

        QUESTIONS.put(212, () ->
                Q0212_WordSearchII.findWords(
                        new char[][]{{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}},
                        new String[]{"oath", "pea", "eat", "rain"}));

        QUESTIONS.put(648, () ->
                Q0648_ReplaceWords.replaceWords(
                        Arrays.asList("cat", "bat", "rat"), "the cattle was rattled by the battery"));

        QUESTIONS.put(1268, () ->
                Q1268_SearchSuggestionsSystem.suggestedProducts(
                        new String[]{"mobile", "mouse", "moneypot", "monitor", "mousepad"}, "mouse"));


        /* =========================
           DESIGN (inner class patterns)
           ========================= */

        QUESTIONS.put(146, () -> {
            Q0146_LRUCache outer = new Q0146_LRUCache();
            Q0146_LRUCache.LRUCache cache = outer.new LRUCache(2);
            cache.put(1, 1);
            cache.get(1);
        });

        QUESTIONS.put(706, () -> {
            Q0706_DesignHashMap outer = new Q0706_DesignHashMap();
            Q0706_DesignHashMap.MyHashMap map = outer.new MyHashMap();
            map.put(1, 1);
            map.get(1);
        });

        QUESTIONS.put(1472, () -> {
            Q1472_DesignBrowserHistory outer = new Q1472_DesignBrowserHistory();
            Q1472_DesignBrowserHistory.BrowserHistory bh = outer.new BrowserHistory("https://leetcode.com/");
            bh.visit("https://google.com/");
        });


        /* =========================
           TRIES (inner class patterns)
           ========================= */

        QUESTIONS.put(208, () -> {
            Q0208_ImplementTrie outer = new Q0208_ImplementTrie();
            Q0208_ImplementTrie.Trie trie = outer.new Trie();
            trie.insert("apple");
            trie.search("apple");
        });

        QUESTIONS.put(211, () -> {
            Q0211_DesignAddAndSearchWords outer = new Q0211_DesignAddAndSearchWords();
            Q0211_DesignAddAndSearchWords.WordDictionary dict = outer.new WordDictionary();
            dict.addWord("bad");
            dict.search("b.d");
        });

        QUESTIONS.put(677, () -> {
            Q0677_MapSumPairs outer = new Q0677_MapSumPairs();
            Q0677_MapSumPairs.MapSum ms = outer.new MapSum();
            ms.insert("apple", 3);
            ms.sum("ap");
        });


        /* =========================
           BINARY SEARCH (design patterns)
           ========================= */

        QUESTIONS.put(528, () -> {
            Q0528_RandomPickWithWeight outer = new Q0528_RandomPickWithWeight();
            Q0528_RandomPickWithWeight.Solution sol = outer.new Solution(new int[]{1, 3});
            sol.pickIndex();
        });

        QUESTIONS.put(981, () -> {
            Q0981_TimeBasedKeyValueStore outer = new Q0981_TimeBasedKeyValueStore();
        });



        /* =========================
           YENİ EKLENEN SORULAR (pattern bazlı)
           ========================= */

        // ---- Backtracking (backtracking)

        QUESTIONS.put(140, () ->
                Q0140_WordBreakII.wordBreak(
                        "catsanddog", new ArrayList<>(Arrays.asList("cat", "cats", "and", "sand", "dog"))));

        QUESTIONS.put(282, () ->
                Q0282_ExpressionAddOperators.addOperators(
                        "123", 6));

        // 489: örnek girdi otomatik üretilemedi (missing robot). Gerekirse elle ekle.
        QUESTIONS.put(489, () -> System.out.println("Q0489_RobotRoomCleaner: örnek girdi eklenmedi"));

        QUESTIONS.put(996, () ->
                Q0996_NumberOfSquarefulArrays.numSquarefulPerms(
                        new int[]{1, 17, 8}));

        QUESTIONS.put(2397, () ->
                Q2397_MaximumRowsCoveredByColumns.maximumRows(
                        new int[][]{new int[]{0, 0, 0}, new int[]{1, 0, 1}, new int[]{0, 1, 1}, new int[]{0, 0, 1}}, 2));

        // ---- Binary Search (binarysearch)

        QUESTIONS.put(4, () ->
                Q0004_MedianOfTwoSortedArrays.findMedianSortedArrays(
                        new int[]{1, 3}, new int[]{2}));

        QUESTIONS.put(34, () ->
                Q0034_FindFirstAndLastPositionOfElementInSortedArray.searchRange(
                        new int[]{5, 7, 7, 8, 8, 10}, 8));

        QUESTIONS.put(540, () ->
                Q0540_SingleElementInASortedArray.singleNonDuplicate(
                        new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}));

        QUESTIONS.put(658, () ->
                Q0658_FindKClosestElements.findClosestElements(
                        new int[]{1, 2, 3, 4, 5}, 4, 3));

        QUESTIONS.put(1060, () ->
                Q1060_MissingElementInSortedArray.missingElement(
                        new int[]{4, 7, 9, 10}, 1));

        // 1274: örnek girdi otomatik üretilemedi (Sea). Gerekirse elle ekle.
        QUESTIONS.put(1274, () -> System.out.println("Q1274_NumberOfShipsInARectangle: örnek girdi eklenmedi"));

        QUESTIONS.put(1539, () ->
                Q1539_KthMissingPositiveNumber.findKthPositive(
                        new int[]{2, 3, 4, 7, 11}, 5));

        // ---- Bit Manipulation (bit)

        QUESTIONS.put(231, () ->
                Q0231_PowerOfTwo.isPowerOfTwo(
                        1));

        QUESTIONS.put(477, () ->
                Q0477_TotalHammingDistance.totalHammingDistance(
                        new int[]{4, 14, 2}));

        // ---- Cyclic Sort (cyclicsort)

        QUESTIONS.put(41, () ->
                Q0041_FirstMissingPositive.firstMissingPositive(
                        new int[]{1, 2, 0}));

        QUESTIONS.put(287, () ->
                Q0287_FindTheDuplicateNumber.findDuplicate(
                        new int[]{1, 3, 4, 2, 2}));

        QUESTIONS.put(448, () ->
                Q0448_FindAllNumbersDisappearedInAnArray.findDisappearedNumbers(
                        new int[]{4, 3, 2, 7, 8, 2, 3, 1}));

        QUESTIONS.put(565, () ->
                Q0565_ArrayNesting.arrayNesting(
                        new int[]{5, 4, 0, 3, 1, 6, 2}));

        // ---- Data Structure Design (design)

        // 284: örnek girdi otomatik üretilemedi (iterator). Gerekirse elle ekle.
        QUESTIONS.put(284, () -> System.out.println("Q0284_PeekingIterator: örnek girdi eklenmedi"));

        // 341: örnek girdi otomatik üretilemedi (design parse). Gerekirse elle ekle.
        QUESTIONS.put(341, () -> System.out.println("Q0341_FlattenNestedListIterator: örnek girdi eklenmedi"));

        QUESTIONS.put(346, () -> {
            Q0346_MovingAverageFromDataStream outer = new Q0346_MovingAverageFromDataStream();
            Q0346_MovingAverageFromDataStream.MovingAverage obj = outer.new MovingAverage(3);
            obj.next(1);
            obj.next(10);
            obj.next(3);
            obj.next(5);
        });

        QUESTIONS.put(348, () -> {
            Q0348_DesignTicTacToe outer = new Q0348_DesignTicTacToe();
            Q0348_DesignTicTacToe.TicTacToe obj = outer.new TicTacToe(3);
            obj.move(0, 0, 1);
            obj.move(0, 2, 2);
            obj.move(2, 2, 1);
            obj.move(1, 1, 2);
            obj.move(2, 0, 1);
            obj.move(1, 0, 2);
            obj.move(2, 1, 1);
        });

        QUESTIONS.put(359, () -> {
            Q0359_LoggerRateLimiter outer = new Q0359_LoggerRateLimiter();
            Q0359_LoggerRateLimiter.Logger obj = outer.new Logger();
            obj.shouldPrintMessage(1, "foo");
            obj.shouldPrintMessage(2, "bar");
            obj.shouldPrintMessage(3, "foo");
            obj.shouldPrintMessage(8, "bar");
            obj.shouldPrintMessage(10, "foo");
            obj.shouldPrintMessage(11, "foo");
        });

        QUESTIONS.put(362, () -> {
            Q0362_DesignHitCounter outer = new Q0362_DesignHitCounter();
            Q0362_DesignHitCounter.HitCounter obj = outer.new HitCounter();
            obj.hit(1);
            obj.hit(2);
            obj.hit(3);
            obj.getHits(4);
            obj.hit(300);
            obj.getHits(300);
            obj.getHits(301);
        });

        QUESTIONS.put(380, () -> {
            Q0380_InsertDeleteGetRandomO1 outer = new Q0380_InsertDeleteGetRandomO1();
            Q0380_InsertDeleteGetRandomO1.RandomizedSet obj = outer.new RandomizedSet();
            obj.insert(1);
            obj.remove(2);
            obj.insert(2);
            obj.getRandom();
            obj.remove(1);
            obj.insert(2);
            obj.getRandom();
        });

        QUESTIONS.put(460, () -> {
            Q0460_LFUCache outer = new Q0460_LFUCache();
            Q0460_LFUCache.LFUCache obj = outer.new LFUCache(2);
            obj.put(1, 1);
            obj.put(2, 2);
            obj.get(1);
            obj.put(3, 3);
            obj.get(2);
            obj.get(3);
            obj.put(4, 4);
            obj.get(1);
            obj.get(3);
            obj.get(4);
        });

        QUESTIONS.put(535, () -> {
            Q0535_EncodeAndDecodeTinyURL outer = new Q0535_EncodeAndDecodeTinyURL();
            Q0535_EncodeAndDecodeTinyURL.Codec_Integer codec = outer.new Codec_Integer();
            codec.decode(codec.encode("https://leetcode.com/problems/design-tinyurl"));
        });

        QUESTIONS.put(622, () -> {
            Q0622_DesignCircularQueue outer = new Q0622_DesignCircularQueue();
            Q0622_DesignCircularQueue.MyCircularQueue obj = outer.new MyCircularQueue(3);
            obj.enQueue(1);
            obj.enQueue(2);
            obj.enQueue(3);
            obj.enQueue(4);
            obj.Rear();
            obj.isFull();
            obj.deQueue();
            obj.enQueue(4);
            obj.Rear();
        });

        QUESTIONS.put(1146, () -> {
            Q1146_SnapshotArray outer = new Q1146_SnapshotArray();
            Q1146_SnapshotArray.SnapshotArray obj = outer.new SnapshotArray(3);
            obj.set(0, 5);
            obj.snap();
            obj.set(0, 6);
            obj.get(0, 0);
        });

        QUESTIONS.put(1396, () -> {
            Q1396_DesignUndergroundSystem outer = new Q1396_DesignUndergroundSystem();
            Q1396_DesignUndergroundSystem.UndergroundSystem obj = outer.new UndergroundSystem();
            obj.checkIn(45, "Leyton", 3);
            obj.checkIn(32, "Paradise", 8);
            obj.checkIn(27, "Leyton", 10);
            obj.checkOut(45, "Waterloo", 15);
            obj.checkOut(27, "Waterloo", 20);
            obj.checkOut(32, "Cambridge", 22);
            obj.getAverageTime("Paradise", "Cambridge");
            obj.getAverageTime("Leyton", "Waterloo");
            obj.checkIn(10, "Leyton", 24);
            obj.getAverageTime("Leyton", "Waterloo");
            obj.checkOut(10, "Waterloo", 38);
            obj.getAverageTime("Leyton", "Waterloo");
        });

        // 1570: örnek girdi otomatik üretilemedi ('int' object is not iterable). Gerekirse elle ekle.
        QUESTIONS.put(1570, () -> System.out.println("Q1570_DotProductOfTwoSparseVectors: örnek girdi eklenmedi"));

        QUESTIONS.put(1656, () -> {
            Q1656_DesignAnOrderedStream outer = new Q1656_DesignAnOrderedStream();
            Q1656_DesignAnOrderedStream.OrderedStream obj = outer.new OrderedStream(5);
            obj.insert(3, "ccccc");
            obj.insert(1, "aaaaa");
            obj.insert(2, "bbbbb");
            obj.insert(5, "eeeee");
            obj.insert(4, "ddddd");
        });

        QUESTIONS.put(2502, () -> {
            Q2502_DesignMemoryAllocator outer = new Q2502_DesignMemoryAllocator();
            Q2502_DesignMemoryAllocator.Allocator obj = outer.new Allocator(10);
            obj.allocate(1, 1);
            obj.allocate(1, 2);
            obj.allocate(1, 3);
            obj.freeMemory(2);
            obj.allocate(3, 4);
            obj.allocate(1, 1);
            obj.allocate(1, 1);
            obj.freeMemory(1);
            obj.allocate(10, 2);
            obj.freeMemory(7);
        });

        QUESTIONS.put(3408, () -> {
            Q3408_DesignTaskManager outer = new Q3408_DesignTaskManager();
            Q3408_DesignTaskManager.TaskManager obj = outer.new TaskManager(new ArrayList<>(Arrays.asList(new ArrayList<>(Arrays.asList(1, 101, 10)), new ArrayList<>(Arrays.asList(2, 102, 20)), new ArrayList<>(Arrays.asList(3, 103, 15)))));
            obj.add(4, 104, 5);
            obj.edit(102, 8);
            obj.execTop();
            obj.rmv(101);
            obj.add(5, 105, 15);
            obj.execTop();
        });

        // ---- Knapsack DP (dp.knapsack)

        QUESTIONS.put(1049, () ->
                Q1049_LastStoneWeightII.lastStoneWeightII(
                        new int[]{2, 7, 4, 1, 8, 1}));

        // ---- 1-D Dynamic Programming (dp.linear)

        QUESTIONS.put(118, () ->
                Q0118_PascalSTriangle.generate(
                        5));

        QUESTIONS.put(509, () ->
                Q0509_FibonacciNumber.fib(
                        2));

        QUESTIONS.put(1387, () ->
                Q1387_SortIntegersByThePowerValue.getKth(
                        12, 15, 2));

        // ---- State Machine DP (dp.state)

        QUESTIONS.put(714, () ->
                Q0714_BestTimeToBuyAndSellStockWithTransactionFee.maxProfit(
                        new int[]{1, 3, 2, 8, 4, 9}, 2));

        // ---- Subsequence / String DP (dp.subsequence)

        QUESTIONS.put(10, () ->
                Q0010_RegularExpressionMatching.isMatch(
                        "aa", "a"));

        QUESTIONS.put(1216, () ->
                Q1216_ValidPalindromeIII.isValidPalindrome(
                        "abcdeca", 2));

        // ---- Graph BFS (graphs.bfs)

        QUESTIONS.put(785, () ->
                Q0785_IsGraphBipartite.isBipartite(
                        new int[][]{new int[]{1, 2, 3}, new int[]{0, 2}, new int[]{0, 1, 3}, new int[]{0, 2}}));

        // ---- Graph DFS (graphs.dfs)

        QUESTIONS.put(399, () ->
                Q0399_EvaluateDivision.calcEquation(
                        new ArrayList<>(Arrays.asList(new ArrayList<>(Arrays.asList("a", "b")), new ArrayList<>(Arrays.asList("b", "c")))), new double[]{2.0, 3.0}, new ArrayList<>(Arrays.asList(new ArrayList<>(Arrays.asList("a", "c")), new ArrayList<>(Arrays.asList("b", "a")), new ArrayList<>(Arrays.asList("a", "e")), new ArrayList<>(Arrays.asList("a", "a")), new ArrayList<>(Arrays.asList("x", "x"))))));

        QUESTIONS.put(733, () ->
                Q0733_FloodFill.floodFill(
                        new int[][]{new int[]{1, 1, 1}, new int[]{1, 1, 0}, new int[]{1, 0, 1}}, 1, 1, 2));

        QUESTIONS.put(797, () ->
                Q0797_AllPathsFromSourceToTarget.allPathsSourceTarget(
                        new int[][]{new int[]{1, 2}, new int[]{3}, new int[]{3}, new int[]{}}));

        QUESTIONS.put(827, () ->
                Q0827_MakingALargeIsland.largestIsland(
                        new int[][]{new int[]{1, 0}, new int[]{0, 1}}));

        QUESTIONS.put(1254, () ->
                Q1254_NumberOfClosedIslands.closedIsland(
                        new int[][]{new int[]{1, 1, 1, 1, 1, 1, 1, 0}, new int[]{1, 0, 0, 0, 0, 1, 1, 0}, new int[]{1, 0, 1, 0, 1, 1, 1, 0}, new int[]{1, 0, 0, 0, 0, 1, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1, 0}}));

        // ---- Greedy (greedy)

        QUESTIONS.put(122, () ->
                Q0122_BestTimeToBuyAndSellStockII.maxProfit(
                        new int[]{7, 1, 5, 3, 6, 4}));

        QUESTIONS.put(134, () ->
                Q0134_GasStation.canCompleteCircuit(
                        new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));

        QUESTIONS.put(135, () ->
                Q0135_Candy.candy(
                        new int[]{1, 0, 2}));

        QUESTIONS.put(670, () ->
                Q0670_MaximumSwap.maximumSwap(
                        2736));

        QUESTIONS.put(1029, () ->
                Q1029_TwoCityScheduling.twoCitySchedCost(
                        new int[][]{new int[]{10, 20}, new int[]{30, 200}, new int[]{400, 50}, new int[]{30, 20}}));

        QUESTIONS.put(3914, () ->
                Q3914_MinimumOperationsToMakeArrayNonDecreasing.minOperations(
                        new int[]{3, 3, 2, 1}));

        // ---- Arrays & Hashing (hashing)

        QUESTIONS.put(249, () ->
                Q0249_GroupShiftedStrings.groupStrings(
                        new String[]{"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"}));

        QUESTIONS.put(266, () ->
                Q0266_PalindromePermutation.canPermutePalindrome(
                        "code"));

        QUESTIONS.put(387, () ->
                Q0387_FirstUniqueCharacterInAString.firstUniqChar(
                        "leetcode"));

        QUESTIONS.put(791, () ->
                Q0791_CustomSortString.customSortString(
                        "cba", "abcd"));

        QUESTIONS.put(1152, () ->
                Q1152_AnalyzeUserWebsiteVisitPattern.mostVisitedPattern(
                        new String[]{"joe", "joe", "joe", "james", "james", "james", "james", "mary", "mary", "mary"}, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, new String[]{"home", "about", "career", "home", "cart", "maps", "home", "home", "about", "career"}));

        QUESTIONS.put(1169, () ->
                Q1169_InvalidTransactions.invalidTransactions(
                        new String[]{"alice,20,800,mtv", "alice,50,100,beijing"}));

        QUESTIONS.put(2023, () ->
                Q2023_NumberOfPairsOfStringsWithConcatenationEqualToTarget.numOfPairs(
                        new String[]{"777", "7", "77", "77"}, "7777"));

        QUESTIONS.put(2150, () ->
                Q2150_FindAllLonelyNumbersInTheArray.findLonely(
                        new int[]{10, 6, 5, 8}));

        QUESTIONS.put(2423, () ->
                Q2423_RemoveLetterToEqualizeFrequency.equalFrequency(
                        "abcc"));

        QUESTIONS.put(2451, () ->
                Q2451_OddStringDifference.oddString(
                        new String[]{"adc", "wzy", "abc"}));

        QUESTIONS.put(3371, () ->
                Q3371_IdentifyTheLargestOutlierInAnArray.getLargestOutlier(
                        new int[]{2, 3, 5, 10}));

        // ---- Heap / Top-K (heap)

        QUESTIONS.put(23, () ->
                Q0023_MergeKSortedLists.mergeKLists(
                        new ListNode[]{buildList(new int[]{1, 4, 5}), buildList(new int[]{1, 3, 4}), buildList(new int[]{2, 6})}));

        QUESTIONS.put(215, () ->
                Q0215_KthLargestElementInAnArray.findKthLargest(
                        new int[]{3, 2, 1, 5, 6, 4}, 2));

        QUESTIONS.put(295, () -> {
            Q0295_FindMedianFromDataStream outer = new Q0295_FindMedianFromDataStream();
            Q0295_FindMedianFromDataStream.MedianFinder obj = outer.new MedianFinder();
            obj.addNum(1);
            obj.addNum(2);
            obj.findMedian();
            obj.addNum(3);
            obj.findMedian();
        });

        QUESTIONS.put(378, () ->
                Q0378_KthSmallestElementInASortedMatrix.kthSmallest(
                        new int[][]{new int[]{1, 5, 9}, new int[]{10, 11, 13}, new int[]{12, 13, 15}}, 8));

        QUESTIONS.put(480, () ->
                Q0480_SlidingWindowMedian.medianSlidingWindow(
                        new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));

        QUESTIONS.put(767, () ->
                new Q0767_ReorganizeString().reorganizeString("aab"));

        QUESTIONS.put(857, () ->
                Q0857_MinimumCostToHireKWorkers.mincostToHireWorkers(
                        new int[]{10, 20, 5}, new int[]{70, 50, 30}, 2));

        QUESTIONS.put(1606, () ->
                Q1606_FindServersThatHandledMostNumberOfRequests.busiestServers(
                        3, new int[]{1, 2, 3, 4, 5}, new int[]{5, 2, 3, 3, 3}));

        QUESTIONS.put(2402, () ->
                Q2402_MeetingRoomsIII.mostBooked(
                        2, new int[][]{new int[]{0, 10}, new int[]{1, 5}, new int[]{2, 7}, new int[]{3, 4}}));

        // ---- Intervals (intervals)

        QUESTIONS.put(163, () ->
                Q0163_MissingRanges.findMissingRanges(
                        new int[]{0, 1, 3, 50, 75}, 0, 99));

        QUESTIONS.put(986, () ->
                Q0986_IntervalListIntersections.intervalIntersection(
                        new int[][]{new int[]{0, 2}, new int[]{5, 10}, new int[]{13, 23}, new int[]{24, 25}}, new int[][]{new int[]{1, 5}, new int[]{8, 12}, new int[]{15, 24}, new int[]{25, 26}}));

        // ---- Linked List (linkedlist)

        QUESTIONS.put(2, () ->
                Q0002_AddTwoNumbers.addTwoNumbers(
                        buildList(new int[]{2, 4, 3}), buildList(new int[]{5, 6, 4})));

        QUESTIONS.put(19, () ->
                Q0019_RemoveNthNodeFromEndOfList.removeNthFromEnd(
                        buildList(new int[]{1, 2, 3, 4, 5}), 2));

        QUESTIONS.put(25, () ->
                Q0025_ReverseNodesInKGroup.reverseKGroup(
                        buildList(new int[]{1, 2, 3, 4, 5}), 2));

        QUESTIONS.put(61, () ->
                Q0061_RotateList.rotateRight(
                        buildList(new int[]{1, 2, 3, 4, 5}), 2));

        // 138: örnek girdi otomatik üretilemedi (Node). Gerekirse elle ekle.
        QUESTIONS.put(138, () -> System.out.println("Q0138_CopyListWithRandomPointer: örnek girdi eklenmedi"));

        QUESTIONS.put(143, () ->
                Q0143_ReorderList.reorderList(
                        buildList(new int[]{1, 2, 3, 4})));

        // 237: örnek girdi otomatik üretilemedi (ListNode). Gerekirse elle ekle.
        QUESTIONS.put(237, () -> System.out.println("Q0237_DeleteNodeInALinkedList: örnek girdi eklenmedi"));

        // 430: örnek girdi otomatik üretilemedi (Node). Gerekirse elle ekle.
        QUESTIONS.put(430, () -> System.out.println("Q0430_FlattenAMultilevelDoublyLinkedList: örnek girdi eklenmedi"));

        // 708: örnek girdi otomatik üretilemedi (Node). Gerekirse elle ekle.
        QUESTIONS.put(708, () -> System.out.println("Q0708_InsertIntoASortedCircularLinkedList: örnek girdi eklenmedi"));

        // ---- Math & Geometry (math)

        QUESTIONS.put(7, () ->
                Q0007_ReverseInteger.reverse(
                        123));

        QUESTIONS.put(50, () ->
                Q0050_PowXN.myPow(
                        2.0, 10));

        QUESTIONS.put(66, () ->
                Q0066_PlusOne.plusOne(
                        new int[]{1, 2, 3}));

        QUESTIONS.put(67, () ->
                Q0067_AddBinary.addBinary(
                        "11", "1"));

        QUESTIONS.put(149, () ->
                Q0149_MaxPointsOnALine.maxPoints(
                        new int[][]{new int[]{1, 1}, new int[]{2, 2}, new int[]{3, 3}}));

        QUESTIONS.put(398, () -> {
            Q0398_RandomPickIndex outer = new Q0398_RandomPickIndex();
            Q0398_RandomPickIndex.Solution obj = outer.new Solution(new int[]{1, 2, 3, 3, 3});
            obj.pick(3);
            obj.pick(1);
            obj.pick(3);
        });

        QUESTIONS.put(415, () ->
                Q0415_AddStrings.addStrings(
                        "11", "123"));

        QUESTIONS.put(2235, () ->
                Q2235_AddTwoIntegers.sum(
                        12, 5));

        QUESTIONS.put(3625, () ->
                Q3625_CountNumberOfTrapezoidsII.countTrapezoids(
                        new int[][]{new int[]{-3, 2}, new int[]{3, 0}, new int[]{2, 3}, new int[]{3, 2}, new int[]{2, -3}}));

        // ---- Matrix Simulation (matrix)

        QUESTIONS.put(498, () ->
                Q0498_DiagonalTraverse.findDiagonalOrder(
                        new int[][]{new int[]{1, 2, 3}, new int[]{4, 5, 6}, new int[]{7, 8, 9}}));

        QUESTIONS.put(3030, () ->
                Q3030_FindTheGridOfRegionAverage.resultGrid(
                        new int[][]{new int[]{5, 6, 7, 10}, new int[]{8, 9, 10, 10}, new int[]{11, 12, 13, 10}}, 3));

        // ---- Monotonic Stack / Queue (monotonic)

        QUESTIONS.put(85, () ->
                Q0085_MaximalRectangle.maximalRectangle(
                        new char[][]{new char[]{'1', '0', '1', '0', '0'}, new char[]{'1', '0', '1', '1', '1'}, new char[]{'1', '1', '1', '1', '1'}, new char[]{'1', '0', '0', '1', '0'}}));

        QUESTIONS.put(1762, () ->
                Q1762_BuildingsWithAnOceanView.findBuildings(
                        new int[]{4, 2, 3, 1}));

        QUESTIONS.put(1944, () ->
                Q1944_NumberOfVisiblePeopleInAQueue.canSeePersonsCount(
                        new int[]{10, 6, 8, 5, 11, 9}));

        // ---- Prefix Sum (prefixsum)

        QUESTIONS.put(1480, () ->
                Q1480_RunningSumOf1dArray.runningSum(
                        new int[]{1, 2, 3, 4}));

        // ---- String / Array Simulation (simulation)

        QUESTIONS.put(6, () ->
                Q0006_ZigzagConversion.convert(
                        "PAYPALISHIRING", 3));

        QUESTIONS.put(8, () ->
                Q0008_StringToIntegerAtoi.myAtoi(
                        "42"));

        QUESTIONS.put(12, () ->
                Q0012_IntegerToRoman.intToRoman(
                        3749));

        QUESTIONS.put(13, () ->
                Q0013_RomanToInteger.romanToInt(
                        "III"));

        QUESTIONS.put(28, () ->
                Q0028_FindTheIndexOfTheFirstOccurrenceInAString.strStr(
                        "sadbutsad", "sad"));

        QUESTIONS.put(58, () ->
                Q0058_LengthOfLastWord.lengthOfLastWord(
                        "Hello World"));

        QUESTIONS.put(65, () ->
                Q0065_ValidNumber.isNumber(
                        "0"));

        QUESTIONS.put(273, () ->
                Q0273_IntegerToEnglishWords.numberToWords(
                        123));

        QUESTIONS.put(824, () ->
                Q0824_GoatLatin.toGoatLatin(
                        "I speak Goat Latin"));

        QUESTIONS.put(1752, () ->
                Q1752_CheckIfArrayIsSortedAndRotated.check(
                        new int[]{3, 4, 5, 1, 2}));

        QUESTIONS.put(1929, () ->
                Q1929_ConcatenationOfArray.getConcatenation(
                        new int[]{1, 2, 1}));

        QUESTIONS.put(3522, () ->
                Q3522_CalculateScoreAfterPerformingInstructions.calculateScore(
                        new String[]{"jump", "add", "add", "jump", "add", "jump"}, new int[]{2, 1, 3, 1, -2, -3}));

        // ---- Sliding Window (slidingwindow)

        QUESTIONS.put(485, () ->
                Q0485_MaxConsecutiveOnes.findMaxConsecutiveOnes(
                        new int[]{1, 1, 0, 1, 1, 1}));

        QUESTIONS.put(713, () ->
                Q0713_SubarrayProductLessThanK.numSubarrayProductLessThanK(
                        new int[]{10, 5, 2, 6}, 100));

        QUESTIONS.put(904, () ->
                Q0904_FruitIntoBaskets.totalFruit(
                        new int[]{1, 2, 1}));

        QUESTIONS.put(3413, () ->
                Q3413_MaximumCoinsFromKConsecutiveBags.maximumCoins(
                        new int[][]{{8, 10, 1}, {1, 3, 2}, {5, 6, 4}}, 4));

        // ---- Sorting (sorting)

        QUESTIONS.put(912, () ->
                Q0912_SortAnArray.sortArray(
                        new int[]{5, 2, 3, 1}));

        // ---- Stack (stack)

        QUESTIONS.put(32, () ->
                Q0032_LongestValidParentheses.longestValidParentheses(
                        "(()"));

        QUESTIONS.put(224, () ->
                Q0224_BasicCalculator.calculate(
                        "1 + 1"));

        QUESTIONS.put(232, () -> {
            Q0232_ImplementQueueUsingStacks outer = new Q0232_ImplementQueueUsingStacks();
            Q0232_ImplementQueueUsingStacks.MyQueue obj = outer.new MyQueue();
            obj.push(1);
            obj.push(2);
            obj.peek();
            obj.pop();
            obj.empty();
        });

        QUESTIONS.put(636, () ->
                Q0636_ExclusiveTimeOfFunctions.exclusiveTime(
                        2, new ArrayList<>(Arrays.asList("0:start:0", "1:start:2", "1:end:5", "0:end:6"))));

        QUESTIONS.put(735, () ->
                Q0735_AsteroidCollision.asteroidCollision(
                        new int[]{5, 10, -5}));

        QUESTIONS.put(736, () ->
                Q0736_ParseLispExpression.evaluate(
                        "(let x 2 (mult x (let x 3 y 4 (add x y))))"));

        QUESTIONS.put(921, () ->
                Q0921_MinimumAddToMakeParenthesesValid.minAddToMakeValid(
                        "())"));

        QUESTIONS.put(1209, () ->
                Q1209_RemoveAllAdjacentDuplicatesInStringII.removeDuplicates(
                        "abcd", 2));

        QUESTIONS.put(1249, () ->
                Q1249_MinimumRemoveToMakeValidParentheses.minRemoveToMakeValid(
                        "lee(t(c)o)de)"));

        // ---- Tree BFS (trees.bfs)

        QUESTIONS.put(314, () ->
                Q0314_BinaryTreeVerticalOrderTraversal.verticalOrder(
                        buildTree(new Integer[]{3, 9, 20, null, null, 15, 7})));

        // 863: örnek girdi otomatik üretilemedi (TreeNode). Gerekirse elle ekle.
        QUESTIONS.put(863, () -> System.out.println("Q0863_AllNodesDistanceKInBinaryTree: örnek girdi eklenmedi"));

        QUESTIONS.put(958, () ->
                Q0958_CheckCompletenessOfABinaryTree.isCompleteTree(
                        buildTree(new Integer[]{1, 2, 3, 4, 5, 6})));

        QUESTIONS.put(987, () ->
                Q0987_VerticalOrderTraversalOfABinaryTree.verticalTraversal(
                        buildTree(new Integer[]{3, 9, 20, null, null, 15, 7})));

        // ---- Binary Search Tree (trees.bst)

        QUESTIONS.put(173, () -> {
            Q0173_BinarySearchTreeIterator outer = new Q0173_BinarySearchTreeIterator();
            Q0173_BinarySearchTreeIterator.BSTIterator obj = outer.new BSTIterator(buildTree(new Integer[]{7, 3, 15, null, null, 9, 20}));
            obj.next();
            obj.next();
            obj.hasNext();
            obj.next();
            obj.hasNext();
            obj.next();
            obj.hasNext();
            obj.next();
            obj.hasNext();
        });

        QUESTIONS.put(270, () ->
                Q0270_ClosestBinarySearchTreeValue.closestValue(
                        buildTree(new Integer[]{4, 2, 5, 1, 3}), 3.714286));

        // 426: örnek girdi otomatik üretilemedi (Node). Gerekirse elle ekle.
        QUESTIONS.put(426, () -> System.out.println("Q0426_ConvertBinarySearchTreeToSortedDoublyLinkedList: örnek girdi eklenmedi"));

        QUESTIONS.put(938, () ->
                Q0938_RangeSumOfBST.rangeSumBST(
                        buildTree(new Integer[]{10, 5, 15, 3, 7, null, 18}), 7, 15));

        // ---- Tree Construction / Serialization (trees.construction)

        // 297: örnek girdi otomatik üretilemedi (design parse). Gerekirse elle ekle.
        QUESTIONS.put(297, () -> System.out.println("Q0297_SerializeAndDeserializeBinaryTree: örnek girdi eklenmedi"));

        QUESTIONS.put(889, () ->
                Q0889_ConstructBinaryTreeFromPreorderAndPostorderTraversal.constructFromPrePost(
                        new int[]{1, 2, 4, 5, 3, 6, 7}, new int[]{4, 5, 2, 6, 7, 3, 1}));

        // ---- Tree DFS (trees.dfs)

        QUESTIONS.put(129, () ->
                Q0129_SumRootToLeafNumbers.sumNumbers(
                        buildTree(new Integer[]{1, 2, 3})));

        // 339: örnek girdi otomatik üretilemedi (NestedInteger). Gerekirse elle ekle.
        QUESTIONS.put(339, () -> System.out.println("Q0339_NestedListWeightSum: örnek girdi eklenmedi"));

        QUESTIONS.put(2265, () ->
                Q2265_CountNodesEqualToAverageOfSubtree.averageOfSubtree(
                        buildTree(new Integer[]{4, 8, 5, 0, 1, null, 6})));

        // ---- Lowest Common Ancestor (trees.lca)

        // 1644: örnek girdi otomatik üretilemedi (TreeNode). Gerekirse elle ekle.
        QUESTIONS.put(1644, () -> System.out.println("Q1644_LowestCommonAncestorOfABinaryTreeII: örnek girdi eklenmedi"));

        // 1650: örnek girdi otomatik üretilemedi (Node). Gerekirse elle ekle.
        QUESTIONS.put(1650, () -> System.out.println("Q1650_LowestCommonAncestorOfABinaryTreeIII: örnek girdi eklenmedi"));

        // ---- Two Pointers (twopointers)

        QUESTIONS.put(5, () ->
                Q0005_LongestPalindromicSubstring.longestPalindrome(
                        "babad"));

        QUESTIONS.put(16, () ->
                Q0016_3SumClosest.threeSumClosest(
                        new int[]{-1, 2, 1, -4}, 1));

        QUESTIONS.put(18, () ->
                Q0018_4Sum.fourSum(
                        new int[]{1, 0, -1, 0, -2, 2}, 0));

        QUESTIONS.put(31, () ->
                Q0031_NextPermutation.nextPermutation(
                        new int[]{1, 2, 3}));

        QUESTIONS.put(151, () ->
                Q0151_ReverseWordsInAString.reverseWords(
                        "the sky is blue"));

        QUESTIONS.put(165, () ->
                Q0165_CompareVersionNumbers.compareVersion(
                        "1.2", "1.10"));

        QUESTIONS.put(189, () ->
                Q0189_RotateArray.rotate(
                        new int[]{1, 2, 3, 4, 5, 6, 7}, 3));

        QUESTIONS.put(344, () ->
                Q0344_ReverseString.reverseString(
                        new char[]{'h', 'e', 'l', 'l', 'o'}));

        QUESTIONS.put(408, () ->
                Q0408_ValidWordAbbreviation.validWordAbbreviation(
                        "internationalization", "i12iz4n"));

        QUESTIONS.put(443, () ->
                Q0443_StringCompression.compress(
                        new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'}));

        QUESTIONS.put(611, () ->
                Q0611_ValidTriangleNumber.triangleNumber(
                        new int[]{2, 2, 3, 4}));

        QUESTIONS.put(647, () ->
                Q0647_PalindromicSubstrings.countSubstrings(
                        "abc"));

        QUESTIONS.put(680, () ->
                Q0680_ValidPalindromeII.validPalindrome(
                        "aba"));

        QUESTIONS.put(977, () ->
                Q0977_SquaresOfASortedArray.sortedSquares(
                        new int[]{-4, -1, 0, 3, 10}));

        QUESTIONS.put(1768, () ->
                Q1768_MergeStringsAlternately.mergeAlternately(
                        "abc", "pqr"));

        QUESTIONS.put(2970, () ->
                Q2970_CountTheNumberOfIncremovableSubarraysI.incremovableSubarrayCount(
                        new int[]{1, 2, 3, 4}));

        QUESTIONS.put(2972, () ->
                Q2972_CountTheNumberOfIncremovableSubarraysII.incremovableSubarrayCount(
                        new int[]{1, 2, 3, 4}));

        QUESTIONS.put(3649, () ->
                Q3649_NumberOfPerfectPairs.perfectPairs(
                        new int[]{0, 1, 2, 3}));

    }


    public static void run(int questionNumber) {
        Runnable runnable = QUESTIONS.get(questionNumber);
        if (runnable == null) {
            System.out.println("Question not implemented: " + questionNumber);
            return;
        }
        runnable.run();
    }

    public static TreeNode buildTree(Integer[] arr) {
        if (arr == null || arr.length == 0 || arr[0] == null) return null;
        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (i < arr.length) {
            TreeNode current = queue.poll();
            if (i < arr.length && arr[i] != null) {
                current.left = new TreeNode(arr[i]);
                queue.offer(current.left);
            }
            i++;
            if (i < arr.length && arr[i] != null) {
                current.right = new TreeNode(arr[i]);
                queue.offer(current.right);
            }
            i++;
        }
        return root;
    }

    public static ListNode buildList(int[] values) {
        if (values == null || values.length == 0) return null;
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        return head;
    }

    public static common.model.Node buildNode(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        common.model.Node[] nodes = new common.model.Node[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nodes[i] = new common.model.Node(arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            if (left < arr.length) nodes[i].left = nodes[left];
            if (right < arr.length) nodes[i].right = nodes[right];
        }
        return nodes[0];
    }

    public static Node buildGraph(int[][] edges) {
        Map<Integer, Node> nodes = new HashMap<>();
        for (int[] edge : edges) {
            int from = edge[0], to = edge[1];
            nodes.putIfAbsent(from, new Node(from));
            nodes.putIfAbsent(to, new Node(to));
            nodes.get(from).neighbors.add(nodes.get(to));
            nodes.get(to).neighbors.add(nodes.get(from));
        }
        return nodes.get(1);
    }
}
