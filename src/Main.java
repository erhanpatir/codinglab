import Algorithms.TreeTraversal.InOrder.*;
import Algorithms.TreeTraversal.LevelOrder.*;
import Algorithms.TreeTraversal.Node;
import Algorithms.TreeTraversal.PostOrder.*;
import Algorithms.TreeTraversal.PreOrder.*;
import Algorithms.TreeTraversal.TreeNode;
import DataStructures.Arrays.BestTimeToBuyAndSellStock;
import DataStructures.Arrays.MajorityElement;
import DataStructures.Arrays.MoveZeroes;
import DataStructures.Arrays.RemoveDuplicatesFromSortedArray;
import DataStructures.LinkedListInPlaceReversal.PalindromeLinkedList;
import DataStructures.LinkedListInPlaceReversal.ReverseLinkedList;
import DataStructures.LinkedLists.IntersectionOfTwoLinkedLists;
import DataStructures.LinkedLists.ListNode;
import DataStructures.Stacks.RemoveAllAdjacentDuplicatesInString;
import DataStructures.Stacks.ValidParentheses;
import DataStructures.Strings.IsSubsequence;
import DataStructures.Strings.LongestCommonPrefix;
import DataStructures.Strings.ValidPalindrome;
import ProblemSolvingTechniques.FastSlowPointers.HappyNumber;
import ProblemSolvingTechniques.FastSlowPointers.MiddleOfTheLinkedList;
import ProblemSolvingTechniques.MonotonicStack.NextGreaterElement1;
import ProblemSolvingTechniques.SlidingWindow.MaximumAverageSubarray1;
import ProblemSolvingTechniques.TwoPointers.MergeSortedArray;


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
            case 283:
                MoveZeroes.moveZeroes(new int[]{0, 1, 0, 3, 12});
                break;
            case 169:
                MajorityElement.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2});
                break;
            case 26:
                RemoveDuplicatesFromSortedArray.removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4});
                break;
            case 392:
                IsSubsequence.isSubsequence("abc", "ahbgdc");
                break;
            case 125:
                ValidPalindrome.isPalindrome("A man, a plan, a canal: Panama");
                break;
            case 14:
                LongestCommonPrefix.longestCommonPrefix_3(new String[]{"flower", "flow", "flight"});
                break;
            case 88:
                MergeSortedArray.merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
                break;
            case 643:
                MaximumAverageSubarray1.findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4);
                break;
            case 202:
                HappyNumber.isHappy_2(19);
                break;
            case 160:
                ListNode a1 = fromArray(new int[]{4, 1, 8, 4, 5});
                ListNode b1 = fromArray(new int[]{5, 6, 1, 8, 4, 5});
                IntersectionOfTwoLinkedLists.getIntersectionNod_twopointers(a1, b1);
                break;
            case 206:
                ListNode head = fromArray(new int[]{1, 2, 3, 4, 5});
                ReverseLinkedList.reverseList(head);
                break;
            case 234:
                ListNode headNode = fromArray(new int[]{1, 2, 2, 1});
                PalindromeLinkedList.isPalindrome(headNode);
                break;
            case 876:
                ListNode headNode2 = fromArray(new int[]{1, 2, 3, 4, 5});
                MiddleOfTheLinkedList.middleNode(headNode2);
                break;
            case 121:
                BestTimeToBuyAndSellStock.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
                break;
            case 20:
                ValidParentheses.isValid("()[]{}");
                break;
            case 1047:
                RemoveAllAdjacentDuplicatesInString.removeDuplicates("abbaca");
                break;
            case 496:
                NextGreaterElement1.nextGreaterElement_2(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2});
                break;
            case 144:
                BinaryTreePreOrderTraversal.preorderTraversal_stack(buildTree(new Integer[]{1, null, 2, 3}));
                break;
            case 94:
                BinaryTreeInOrderTraversal.inorderTraversal_recursion(buildTree(new Integer[]{1, 2, 3, 4, 5, null, 8, null, null, 6, 7, 9}));
                break;
            case 145:
                BinaryTreePostOrderTraversal.postOrderTraversal_stack(buildTree(new Integer[]{1, null, 2, 3}));
                break;
            case 100:
                SameTree.isSameTree(buildTree(new Integer[]{1, 2, 3}), buildTree(new Integer[]{1, 2, 3}));
                break;
            case 101:
                SymmetricTree.isSymmetric(buildTree(new Integer[]{1, 2, 2, 3, 4, 4, 3}));
                break;
            case 226:
                InvertBinaryTree.invertTree_dfs(buildTree(new Integer[]{1, 2, 2, 3, 4, 4, 3}));
                break;
            case 543:
                DiameterOfBinaryTree.diameterOfBinaryTree(buildTree(new Integer[]{1, 2, 2, 3, 4, 4, 3}));
                break;
            case 257:
                BinaryTreePaths.binaryTreePaths(buildTree(new Integer[]{1, 2, 2, 3, 4, 4, 3}));
                break;
            case 104:
                MaximumDepthOfBinaryTree.maxDepth(buildTree(new Integer[]{1, 2, 2, 3, 4, 4, 3}));
                break;
            case 111:
                MinimumDepthOfBinaryTree.minDepth_bfs(buildTree(new Integer[]{1, 2, 2, 3, 4, 4, 3}));
                break;
            case 110:
                BalancedBinaryTree.isBalanced(buildTree(new Integer[]{1, 2, 2, 3, 4, 4, 3}));
                break;
            case 112:
                PathSum.hasPathSum_recursive(buildTree(new Integer[]{1, 2, 2, 3, 4, 4, 3}), 3);
                break;
            case 113:
                PathSum2.pathSum(buildTree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1}), 22);
                break;
            case 124:
                BinaryTreeMaximumPathSum.maxPathSum(buildTree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1}));
                break;
            case 98:
                ValidateBinarySearchTree.isValidBST(buildTree(new Integer[]{2, 1, 3}));
                break;
            case 236:
                LowestCommonAncestorOfABinaryTree.lowestCommonAncestor(buildTree(new Integer[]{1, 2, 2, 3, 4, 4, 3}),
                        new TreeNode(5), new TreeNode(1));
                break;
            case 235:
                LowestCommonAncestorOfABinarySearchTree.lowestCommonAncestor2(buildTree(new Integer[]{1, 2, 2, 3, 4, 4, 3}),
                        new TreeNode(5), new TreeNode(2));
                break;
            case 102:
                BinaryTreeLevelOrderTraversal.levelOrder_bfs(buildTree(new Integer[]{1, 2, 2, 3, 4, 4, 3}));
                break;
            case 103:
                BinaryTreeZigzagLevelOrderTraversal.zigzagLevelOrder(buildTree(new Integer[]{1, 2, 2, 3, 4, 4, 3}));
                break;
            case 199:
                BinaryTreeRightSideView.rightSideView(buildTree(new Integer[]{1, 2, 2, 3, 4, 4, 3}));
                break;
            case 515:
                FindLargestValueInEachTreeRow.largestValues(buildTree(new Integer[]{1, 3, 2, 5, 3, null, 9}));
                break;
            case 783:
                MinimumDistanceBetweenBSTNodes.minDiffInBST_stack(buildTree(new Integer[]{4, 2, 6, 1, 3}));
                break;
            case 530:
                MinimumAbsoluteDifferenceInBST.getMinimumDifference_iterative(buildTree(new Integer[]{4, 2, 6, 1, 3}));
                break;
            case 230:
                KthSmallestElementInaBST.kthSmallest_stack(buildTree(new Integer[]{5, 3, 6, 2, 4, null, null, 1}), 3);
                break;
            case 692:
                MaximumWidthOfBinaryTree.widthOfBinaryTree(buildTree(new Integer[]{1, 3, 2, 5, 3, null, 9}));
                break;
            case 108:
                ConvertSortedArrayToBinarySearchTree.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
                break;
            case 222:
                CountCompleteTreeNodes.countNodes(buildTree(new Integer[]{1, 2, 3, 4, 5, 6}));
                break;
            case 105:
                ConstructBinaryTreeFromPreorderAndInorderTraversal.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
                break;
            case 106:
                ConstructBinaryTreeFromInorderAndPostorderTraversal.buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 3, 15, 20, 7});
                break;
            case 116:
                PopulatingNextRightPointersInEachNode.connect_bfs(buildNode(new int[]{1, 2, 3, 4, 5, 6, 7}));
                break;
            case 117:
                PopulatingNextRightPointersInEachNode2.connect_bfs(buildNode(new int[]{1,2,3,4,5,6,7}));
                break;
        }
    }

