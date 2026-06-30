import arrays.binarysearch.*;
import arrays.greedy.Q1642_FurthestBuildingYouCanReach;
import arrays.hashing.*;
import arrays.intervals.*;
import arrays.prefixsum.*;
import arrays.slidingwindow.*;
import arrays.twopointers.*;
import backtracking.combinations.*;
import backtracking.grid.*;
import backtracking.parentheses.Q0022_GenerateParentheses;
import backtracking.permutations.*;
import backtracking.strings.*;
import backtracking.subsets.*;
import bit.Q0136_SingleNumber;
import bit.Q0338_CountingBits;
import common.model.ListNode;
import common.ds.Node;
import common.model.TreeNode;
import design.Q0208_ImplementTrie;
import design.Q0706_DesignHashMap;
import design.Q1472_DesignBrowserHistory;
import dynamicprogramming.grid.*;
import dynamicprogramming.knapstack.*;
import dynamicprogramming.linear.*;
import dynamicprogramming.lis.*;
import dynamicprogramming.state.*;
import dynamicprogramming.subsequence.*;
import dynamicprogramming.trees.Q0337_HouseRobber3;
import graphs.matrix.bfs.Q1091_ShortestPathInBinaryMatrix;
import graphs.matrix.dfs.*;
import graphs.matrix.multisource.Q0994_RottingOranges;
import graphs.minimumspantree.Q1584_MinCostToConnectAllPoints;
import graphs.shortestpath.dijkstra.*;
import graphs.shortestpath.stategraph.Q0787_CheapestFlightsWithinKStops;
import graphs.topologicalsort.*;
import graphs.traversal.dfs.Q0133_CloneGraph;
import graphs.unionfind.Q0547_NumberOfProvinces;
import hashing.*;
import heaps.topk.*;
import linkedlists.construction.Q0109_ConvertSortedListToBinarySearchTree;
import linkedlists.fastslow.*;
import linkedlists.merge.Q0021_MergeTwoSortedLists;
import linkedlists.reversal.Q0206_ReverseLinkedList;
import linkedlists.sorting.Q0148_SortList;
import linkedlists.twopointers.Q0160_IntersectionOfTwoLinkedLists;
import math.Q0009_PalindromeNumber;
import queue.Q0933_NumberOfRecentCalls;
import queue.Q0950_RevealCardsInIncreasingOrder;
import queue.Q2073_TimeNeededToBuyTickets;
import queue.monotonic.Q0862_ShortestSubarrayWithSumAtLeastK;
import queue.monotonic.Q1696_JumpGame6;
import stack.Q0071_SimplifyPath;
import stack.Q0227_BasicCalculator2;
import stack.Q0394_DecodeString;
import stack.Q0853_CarFleet;
import stack.basic.*;
import stack.monotonic.*;
import strings.basic.Q0014_LongestCommonPrefix;
import strings.hashing.*;
import strings.stack.Q1047_RemoveAllAdjacentDuplicatesInString;
import strings.subsequence.Q0392_IsSubsequence;
import strings.twopointers.Q0125_ValidPalindrome;
import trees.bst.*;
import trees.construction.*;
import trees.lca.*;
import trees.path.*;
import trees.pointer.*;
import trees.recursion.Q0572_SubtreeOfAnotherTree;
import trees.traversal.bfs.*;
import trees.traversal.dfs.*;
import tries.Q0211_DesignAddAndSearchWords;
import tries.Q0212_WordSearchII;
import tries.Q0648_ReplaceWords;
import tries.Q0677_MapSumPairs;
import tries.Q1268_SearchSuggestionsSystem;

import java.util.*;

public class LeetCodeRunner {

    private static final Map<Integer, Runnable> QUESTIONS = new HashMap<>();

    static {

        /* =========================
           MATH
           ========================= */

        QUESTIONS.put(9, () ->
                Q0009_PalindromeNumber.isPalindrome(121));


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

        QUESTIONS.put(76, () ->
                Q0076_MinimumWindowSubstring.minWindow(
                        "ADOBECODEBANC", "ABC"));

        QUESTIONS.put(209, () ->
                Q0209_MinimumSizeSubarraySum.minSubArrayLen(
                        7, new int[]{2, 3, 1, 2, 4, 3}));

        QUESTIONS.put(239, () ->
                Q0239_SlidingWindowMaximum.maxSlidingWindow(
                        new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));

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
                arrays.hashing.Q0036_ValidSudoku.isValidSudoku(new char[][]{
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
           ARRAYS / MATRIX
           ========================= */

        QUESTIONS.put(48, () ->
                arrays.matrix.Q0048_RotateImage.rotate(
                        new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));

        QUESTIONS.put(54, () ->
                arrays.matrix.Q0054_SpiralMatrix.spiralOrder(
                        new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));

        QUESTIONS.put(73, () ->
                arrays.matrix.Q0073_SetMatrixZeroes.setZeroes(
                        new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}}));

        QUESTIONS.put(289, () ->
                arrays.matrix.Q0289_GameOfLife.gameOfLife(
                        new int[][]{{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}}));


        /* =========================
           ARRAYS / GREEDY
           ========================= */

        QUESTIONS.put(1642, () ->
                Q1642_FurthestBuildingYouCanReach.furthestBuilding(
                        new int[]{4, 2, 7, 6, 9, 14, 12}, 5, 1));


        /* =========================
           STRINGS
           ========================= */

        QUESTIONS.put(3, () ->
                strings.slidingwindow.Q0003_LongestSubstringWithoutRepeatingCharacters
                        .lengthOfLongestSubstring("abcabcbb"));

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

        QUESTIONS.put(451, () ->
                Q0451_SortCharactersByFrequency.frequencySort("tree"));

        QUESTIONS.put(1047, () ->
                Q1047_RemoveAllAdjacentDuplicatesInString
                        .removeDuplicates("abbaca"));


        /* =========================
           HASHING
           ========================= */

        QUESTIONS.put(128, () ->
                Q0128_LongestConsecutiveSequence.longestConsecutive(
                        new int[]{100, 4, 200, 1, 3, 2}));

        QUESTIONS.put(205, () ->
                Q0205_IsomorphicStrings.isIsomorphic("egg", "add"));

        QUESTIONS.put(219, () ->
                Q0219_ContainsDuplicateII.containsNearbyDuplicate(
                        new int[]{1, 2, 3, 1}, 3));

        QUESTIONS.put(290, () ->
                Q0290_WordPattern.wordPattern("abba", "dog cat cat dog"));

        QUESTIONS.put(383, () ->
                Q0383_RansomNote.canConstruct("aa", "aab"));

        QUESTIONS.put(659, () ->
                Q0659_SplitArrayIntoConsecutiveSubsequences.isPossible(
                        new int[]{1, 2, 3, 3, 4, 5}));

        QUESTIONS.put(792, () ->
                Q0792_NumberOfMatchingSubsequences.numMatchingSubseq(
                        "abcde", new String[]{"a", "bb", "acd", "ace"}));

        QUESTIONS.put(1189, () ->
                Q1189_MaximumNumberOfBalloons.maxNumberOfBalloons("nlaebolko"));

        QUESTIONS.put(1512, () ->
                Q1512_NumberOfGoodPairs.numIdenticalPairs(
                        new int[]{1, 2, 3, 1, 1, 3}));

        QUESTIONS.put(1525, () ->
                Q1525_NumberOfGoodWaysToSplitAString.numSplits("aacaba"));


        /* =========================
           LINKED LISTS
           ========================= */

        QUESTIONS.put(21, () ->
                Q0021_MergeTwoSortedLists.mergeTwoLists(
                        buildList(new int[]{-1, 0, 3}),
                        buildList(new int[]{-1, 0, 3})));

        QUESTIONS.put(109, () ->
                Q0109_ConvertSortedListToBinarySearchTree.sortedListToBST(
                        buildList(new int[]{-10, -3, 0, 5, 9})));

        QUESTIONS.put(148, () ->
                Q0148_SortList.sortList(
                        buildList(new int[]{4, 2, 1, 3})));

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
           STACK / BASIC
           ========================= */

        QUESTIONS.put(20, () ->
                Q0020_ValidParentheses.isValid("()[]{}"));

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


        /* =========================
           STACK / GENERAL
           ========================= */

        QUESTIONS.put(71, () ->
                Q0071_SimplifyPath.simplifyPath("/home/"));

        QUESTIONS.put(227, () ->
                Q0227_BasicCalculator2.calculate("3+2*2"));

        QUESTIONS.put(394, () ->
                Q0394_DecodeString.decodeString("3[a]2[bc]"));

        QUESTIONS.put(853, () ->
                Q0853_CarFleet.carFleet(12,
                        new int[]{10, 8, 0, 5, 3},
                        new int[]{2, 4, 1, 1, 3}));


        /* =========================
           STACK / MONOTONIC
           ========================= */

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
            stockSpan.next(60);
            stockSpan.next(70);
        });


        /* =========================
           QUEUE
           ========================= */

        QUESTIONS.put(933, () -> {
            Q0933_NumberOfRecentCalls outer = new Q0933_NumberOfRecentCalls();
            Q0933_NumberOfRecentCalls.RecentCounter rc = outer.new RecentCounter();
            rc.ping(1);
        });

        QUESTIONS.put(950, () ->
                Q0950_RevealCardsInIncreasingOrder.deckRevealedIncreasing(
                        new int[]{17, 13, 11, 2, 3, 5, 7}));

        QUESTIONS.put(2073, () ->
                Q2073_TimeNeededToBuyTickets.timeRequiredToBuy(
                        new int[]{2, 3, 2}, 2));


        /* =========================
           QUEUE / MONOTONIC
           ========================= */

        QUESTIONS.put(862, () ->
                Q0862_ShortestSubarrayWithSumAtLeastK.shortestSubarray(
                        new int[]{1}, 1));


        /* =========================
           HEAPS / TOP-K
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

        QUESTIONS.put(669, () ->
                Q0669_TrimABinarySearchTree.trimBST(
                        buildTree(new Integer[]{1, 0, 2}), 1, 2));

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

        QUESTIONS.put(994, () ->
                Q0994_RottingOranges.orangesRotting(
                        new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}));

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
           GRAPHS / UNION FIND
           ========================= */

        QUESTIONS.put(547, () ->
                Q0547_NumberOfProvinces.findCircleNum(
                        new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));


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

        QUESTIONS.put(1584, () ->
                Q1584_MinCostToConnectAllPoints.minCostConnectPoints(
                        new int[][]{{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}}));


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


        /* =========================
           BIT MANIPULATION
           ========================= */

        QUESTIONS.put(136, () ->
                Q0136_SingleNumber.singleNumber(
                        new int[]{2, 2, 1}));

        QUESTIONS.put(338, () ->
                Q0338_CountingBits.countBits(5));


        /* =========================
           DYNAMIC PROGRAMMING / LINEAR
           ========================= */

        QUESTIONS.put(53, () ->
                Q0053_MaximumSubarray.maxSubArray_kadane(
                        new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));

        QUESTIONS.put(70, () ->
                Q0070_ClimbingStairs.climbStairs(5));

        QUESTIONS.put(152, () ->
                Q0152_MaximumProductSubarray.maxProduct(
                        new int[]{2, 3, -2, 4}));

        QUESTIONS.put(198, () ->
                Q0198_HouseRobber.rob(
                        new int[]{1, 2, 3, 1}));

        QUESTIONS.put(213, () ->
                Q0213_HouseRobberII.rob(
                        new int[]{2, 3, 2}));

        QUESTIONS.put(746, () ->
                Q0746_MinCostClimbingStairs.minCostClimbingStairs(
                        new int[]{10, 15, 20}));

        QUESTIONS.put(918, () ->
                Q0918_MaximumCircularSubarray.maxSubarraySumCircular(
                        new int[]{1, -2, 3, -2}));


        /* =========================
           DYNAMIC PROGRAMMING / GRID
           ========================= */

        QUESTIONS.put(62, () ->
                Q0062_UniquePaths.uniquePaths(3, 7));

        QUESTIONS.put(63, () ->
                Q0063_UniquePaths2.uniquePathsWithObstacles(
                        new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));

        QUESTIONS.put(64, () ->
                Q0064_MinimumPathSum.minPathSum(
                        new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));

        QUESTIONS.put(221, () ->
                Q0221_MaximalSquare.maximalSquare(
                        new char[][]{{'1','0','1','0','0'},
                                     {'1','0','1','1','1'},
                                     {'1','1','1','1','1'},
                                     {'1','0','0','1','0'}}));

        QUESTIONS.put(931, () ->
                Q0931_MinimumFallingPathSum.minFallingPathSum(
                        new int[][]{{2, 1, 3}, {6, 5, 4}, {7, 8, 9}}));


        /* =========================
           DYNAMIC PROGRAMMING / KNAPSACK
           ========================= */

        QUESTIONS.put(322, () ->
                Q0322_CoinChange1.coinChange(
                        new int[]{1, 2, 5}, 11));

        QUESTIONS.put(416, () ->
                Q0416_PartitionEqualSubsetSum.canPartition(
                        new int[]{1, 5, 11, 5}));

        QUESTIONS.put(474, () ->
                Q0474_OnesAndZeroes.findMaxForm(
                        new String[]{"10", "0001", "111001", "1", "0"}, 5, 3));

        QUESTIONS.put(494, () ->
                Q0494_TargetSum.findTargetSumWays(
                        new int[]{1, 1, 1, 1, 1}, 3));

        QUESTIONS.put(518, () ->
                Q0518_CoinChange2.change(
                        5, new int[]{1, 2, 5}));


        /* =========================
           DYNAMIC PROGRAMMING / LIS
           ========================= */

        QUESTIONS.put(300, () ->
                Q0300_LongestIncreasingSubsequence.lengthOfLIS(
                        new int[]{10, 9, 2, 5, 3, 7, 101, 18}));

        QUESTIONS.put(354, () ->
                Q0354_RussianDollEnvelopes.maxEnvelopes_DP(
                        new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}}));

        QUESTIONS.put(673, () ->
                Q0673_NumberOfLongestIncreasingSubsequence.findNumberOfLIS(
                        new int[]{1, 3, 5, 4, 7}));


        /* =========================
           DYNAMIC PROGRAMMING / STATE
           ========================= */

        QUESTIONS.put(45, () ->
                Q0045_JumpGame2.jump(
                        new int[]{2, 3, 1, 1, 4}));

        QUESTIONS.put(55, () ->
                Q0055_JumpGame.jumpGame(
                        new int[]{2, 3, 1, 1, 4}));

        QUESTIONS.put(1696, () ->
                Q1696_JumpGame6.maxResult(
                        new int[]{1, -1, -2, 4, -7, 3}, 2));


        /* =========================
           DYNAMIC PROGRAMMING / SUBSEQUENCE
           ========================= */

        QUESTIONS.put(72, () ->
                Q0072_EditDistance.minDistance("horse", "ros"));

        QUESTIONS.put(115, () ->
                Q0115_DistinctSubsequences.numDistinct("rabbbit", "rabbit"));

        QUESTIONS.put(139, () ->
                Q0139_WordBreak.wordBreak(
                        "leetcode", Arrays.asList("leet", "code")));

        QUESTIONS.put(516, () ->
                Q0516_LongestPalindromicSubsequence.longestPalindromeSubseq("bbbab"));

        QUESTIONS.put(1143, () ->
                Q1143_LongestCommonSubsequence.longestCommonSubsequence(
                        "abcde", "ace"));


        /* =========================
           DYNAMIC PROGRAMMING / TREES
           ========================= */

        QUESTIONS.put(337, () ->
                Q0337_HouseRobber3.rob(
                        buildTree(new Integer[]{3, 2, 3, null, 3, null, 1})));


        /* =========================
           DESIGN
           ========================= */

        QUESTIONS.put(208, () -> {
            Q0208_ImplementTrie trie = new Q0208_ImplementTrie();
            trie.insert("apple");
            trie.search("apple");
            trie.startsWith("app");
        });

        QUESTIONS.put(706, () -> {
            Q0706_DesignHashMap map = new Q0706_DesignHashMap();
            map.get(1);
        });

        QUESTIONS.put(1472, () -> {
            Q1472_DesignBrowserHistory browser =
                    new Q1472_DesignBrowserHistory(
                            "https://leetcode.com/");
            browser.visit("https://leetcode.com/");
        });


        /* =========================
           TRIES
           ========================= */

        QUESTIONS.put(211, () -> {
            Q0211_DesignAddAndSearchWords outer = new Q0211_DesignAddAndSearchWords();
            Q0211_DesignAddAndSearchWords.WordDictionary dict = outer.new WordDictionary();
            dict.addWord("bad");
            dict.search("b.d");
        });

        QUESTIONS.put(212, () ->
                Q0212_WordSearchII.findWords(
                        new char[][]{{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}},
                        new String[]{"oath", "pea", "eat", "rain"}));

        QUESTIONS.put(648, () ->
                Q0648_ReplaceWords.replaceWords(
                        Arrays.asList("cat", "bat", "rat"), "the cattle was rattled by the battery"));

        QUESTIONS.put(677, () -> {
            Q0677_MapSumPairs outer = new Q0677_MapSumPairs();
            Q0677_MapSumPairs.MapSum mapSum = outer.new MapSum();
            mapSum.insert("apple", 3);
            mapSum.sum("ap");
        });

        QUESTIONS.put(1268, () ->
                Q1268_SearchSuggestionsSystem.suggestedProducts(
                        new String[]{"mobile", "mouse", "moneypot", "monitor", "mousepad"}, "mouse"));

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
        if (arr == null || arr.length == 0 || arr[0] == null) {
            return null;
        }

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

    public static common.model.Node buildNode(int[] arr) {
        if (arr == null || arr.length == 0) return null;

        common.model.Node[] nodes = new common.model.Node[arr.length];

        for (int i = 0; i < arr.length; i++) {
            nodes[i] = new common.model.Node(arr[i]);
        }

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

    public static Node buildGraph(int[][] edges) {
        Map<Integer, Node> nodes = new HashMap<>();

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];

            nodes.putIfAbsent(from, new Node(from));
            nodes.putIfAbsent(to, new Node(to));

            Node fromNode = nodes.get(from);
            Node toNode = nodes.get(to);

            fromNode.neighbors.add(toNode);
            toNode.neighbors.add(fromNode);
        }

        return nodes.get(1);
    }

}
