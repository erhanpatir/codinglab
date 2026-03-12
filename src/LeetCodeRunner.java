import arrays.binarysearch.Q0035_SearchInsertPosition;
import arrays.hashing.Q0169_MajorityElement;
import arrays.hashing.Q0202_HappyNumber;
import arrays.slidingwindow.Q0643_MaximumAverageSubarray1;
import arrays.twopointers.*;
import backtracking.parentheses.Q0022_GenerateParentheses;
import bit.Q0136_SingleNumber;
import bit.Q0338_CountingBits;
import common.model.ListNode;
import common.ds.Node;
import common.model.TreeNode;
import design.Q0706_DesignHashMap;
import design.Q1472_DesignBrowserHistory;
import graphs.matrix.dfs.Q0130_SurroundedRegions;
import graphs.matrix.dfs.Q0200_NumberOfIslands;
import graphs.matrix.dfs.Q0417_PacificAtlanticWaterFlow;
import graphs.matrix.dfs.Q0695_MaxAreaOfIsland;
import graphs.shortestpath.dijkstra.Q0743_NetworkDelayTime;
import graphs.topologicalsort.Q0207_CourseSchedule;
import graphs.topologicalsort.Q0210_CourseSchedule2;
import graphs.topologicalsort.Q0269_AlienDictionary;
import graphs.traversal.dfs.Q0133_CloneGraph;
import graphs.unionfind.Q0547_NumberOfProvinces;
import heaps.topk.Q0703_KthLargestElementInAStream;
import linkedlists.merge.Q0021_MergeTwoSortedLists;
import linkedlists.sorting.Q0148_SortList;
import queue.bfs.Q0933_NumberOfRecentCalls;
import strings.basic.Q0014_LongestCommonPrefix;
import strings.hashing.Q0451_SortCharactersByFrequency;
import strings.slidingwindow.Q0003_LongestSubstringWithoutRepeatingCharacters;
import strings.stack.Q0020_ValidParentheses;
import strings.stack.Q1047_RemoveAllAdjacentDuplicatesInString;
import strings.subsequence.Q0392_IsSubsequence;
import strings.twopointers.Q0125_ValidPalindrome;
import trees.recursion.Q0572_SubtreeOfAnotherTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LeetCodeRunner {

    private static final Map<Integer, Runnable> QUESTIONS = new HashMap<>();

    static {

        /* =========================
           ARRAYS / TWO POINTERS
           ========================= */

        QUESTIONS.put(26, () ->
                Q0026_RemoveDuplicatesFromSortedArray.removeDuplicates(
                        new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));

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

        QUESTIONS.put(283, () ->
                Q0283_MoveZeroes.moveZeroes(
                        new int[]{0, 1, 0, 3, 12}));


        /* =========================
           ARRAYS / SLIDING WINDOW
           ========================= */

        QUESTIONS.put(643, () ->
                Q0643_MaximumAverageSubarray1.findMaxAverage(
                        new int[]{1, 12, -5, -6, 50, 3}, 4));


        /* =========================
           ARRAYS / HASHING
           ========================= */

        QUESTIONS.put(169, () ->
                Q0169_MajorityElement.majorityElement(
                        new int[]{2, 2, 1, 1, 1, 2, 2}));

        QUESTIONS.put(202, () ->
                Q0202_HappyNumber.isHappy_2(19));


        /* =========================
           ARRAYS / BINARY SEARCH
           ========================= */

        QUESTIONS.put(35, () ->
                Q0035_SearchInsertPosition.searchInsert(
                        new int[]{1, 3, 5, 6}, 5));


        /* =========================
           STRINGS
           ========================= */

        QUESTIONS.put(3, () ->
                Q0003_LongestSubstringWithoutRepeatingCharacters
                        .lengthOfLongestSubstring("abcabcbb"));

        QUESTIONS.put(14, () ->
                Q0014_LongestCommonPrefix.longestCommonPrefix_3(
                        new String[]{"flower", "flow", "flight"}));

        QUESTIONS.put(20, () ->
                Q0020_ValidParentheses.isValid("()[]{}"));

        QUESTIONS.put(125, () ->
                Q0125_ValidPalindrome.isPalindrome(
                        "A man, a plan, a canal: Panama"));

        QUESTIONS.put(392, () ->
                Q0392_IsSubsequence.isSubsequence(
                        "abc", "ahbgdc"));

        QUESTIONS.put(451, () ->
                Q0451_SortCharactersByFrequency.frequencySort("tree"));

        QUESTIONS.put(1047, () ->
                Q1047_RemoveAllAdjacentDuplicatesInString
                        .removeDuplicates("abbaca"));


        /* =========================
           LINKED LISTS
           ========================= */

        QUESTIONS.put(21, () ->
                Q0021_MergeTwoSortedLists.mergeTwoLists(
                        buildList(new int[]{-1, 0, 3}),
                        buildList(new int[]{-1, 0, 3})));

        QUESTIONS.put(148, () ->
                Q0148_SortList.sortList(
                        buildList(new int[]{4, 2, 1, 3})));


        /* =========================
           QUEUE / HEAP
           ========================= */

        QUESTIONS.put(933, () -> {
            Q0933_NumberOfRecentCalls rc =
                    new Q0933_NumberOfRecentCalls();
            rc.ping(1);
        });

        QUESTIONS.put(703, () -> {
            Q0703_KthLargestElementInAStream kth =
                    new Q0703_KthLargestElementInAStream(
                            3, new int[]{4, 5, 8, 2});
            kth.add(3);
        });


        /* =========================
           TREES
           ========================= */

        QUESTIONS.put(572, () ->
                Q0572_SubtreeOfAnotherTree.isSubtree(
                        buildTree(new Integer[]{3, 4, 5, 1, 2}),
                        buildTree(new Integer[]{4, 1, 2})));


        /* =========================
           GRAPHS
           ========================= */

        QUESTIONS.put(200, () ->
                Q0200_NumberOfIslands.numIslands(
                        new char[][]{
                                {'1', '1', '1', '1', '0'},
                                {'1', '1', '0', '1', '0'},
                                {'1', '1', '0', '0', '0'},
                                {'0', '0', '0', '0', '0'}}));

        QUESTIONS.put(130, () -> Q0130_SurroundedRegions.solve(
                new char[][]{
                        {'X','X','X','X'},
                        {'X','O','O','X'},
                        {'X','X','O','X'},
                        {'X','O','X','X'}}));

        QUESTIONS.put(133, () -> Q0133_CloneGraph.cloneGraph(
                buildGraph(new int[][]{{1, 2}, {1, 3}, {2, 4}, {3, 4}})));

        QUESTIONS.put(417, () ->
                Q0417_PacificAtlanticWaterFlow.pacificAtlantic(
                        new int[][]{{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}}));

        QUESTIONS.put(695, () ->
                Q0695_MaxAreaOfIsland.maxAreaOfIsland(
                        new int[][]{{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}}));

        QUESTIONS.put(210, () ->
                Q0210_CourseSchedule2.findOrder(
                        2, new int[][]{{1, 0}}));

        QUESTIONS.put(269, () ->
                Q0269_AlienDictionary.alienOrder(
                        new String[]{"wrt", "wrf", "er", "ett", "rftt"}));

        QUESTIONS.put(207, () ->
                Q0207_CourseSchedule.canFinish(
                        2, new int[][]{{1, 0}}));

        QUESTIONS.put(547, () ->
                Q0547_NumberOfProvinces.findCircleNum(
                        new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));

        QUESTIONS.put(743, () ->
                Q0743_NetworkDelayTime.networkDelayTime(
                        new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}},
                        4, 2));


        /* =========================
           BACKTRACKING
           ========================= */

        QUESTIONS.put(22, () ->
                Q0022_GenerateParentheses.generateParenthesis(3));


        /* =========================
           BIT
           ========================= */

        QUESTIONS.put(136, () ->
                Q0136_SingleNumber.singleNumber(
                        new int[]{2, 2, 1}));

        QUESTIONS.put(338, () ->
                Q0338_CountingBits.countBits(5));


        /* =========================
           DESIGN
           ========================= */

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
    }


    public static void run(int questionNumber) {

        Runnable runnable = QUESTIONS.get(questionNumber);

        if (runnable == null) {
            System.out.println("Question not implemented: " + questionNumber);
            return;
        }

        runnable.run();
    }

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

    public static common.model.Node buildNode(int[] arr) {
        if (arr == null || arr.length == 0) return null;

        common.model.Node[] nodes = new common.model.Node[arr.length];

        // create nodes
        for (int i = 0; i < arr.length; i++) {
            nodes[i] = new common.model.Node(arr[i]);
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
            toNode.neighbors.add(fromNode); // undirected graph
        }

        return nodes.get(1); // start node
    }

}