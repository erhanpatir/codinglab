import Algorithms.TreeTraversal.InOrder.BinaryTreeInOrderTraversal;
import Algorithms.TreeTraversal.PostOrder.*;
import Algorithms.TreeTraversal.PreOrder.BinaryTreePaths;
import Algorithms.TreeTraversal.PreOrder.BinaryTreePreOrderTraversal;
import Algorithms.TreeTraversal.PreOrder.SameTree;
import Algorithms.TreeTraversal.PreOrder.SymmetricTree;
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


void main() {
    run(543);
}

void run (int questionNumber) {
    switch(questionNumber) {
        case 283:
            MoveZeroes.moveZeroes(new int[] {0,1,0,3,12});
            break;
        case 169:
            MajorityElement.majorityElement(new int[] {2,2,1,1,1,2,2});
            break;
       case 26:
           RemoveDuplicatesFromSortedArray.removeDuplicates(new int[] {0,0,1,1,1,2,2,3,3,4});
           break;
        case 392:
            IsSubsequence.isSubsequence("abc", "ahbgdc");
            break;
        case 125:
            ValidPalindrome.isPalindrome("A man, a plan, a canal: Panama");
            break;
        case 14:
            LongestCommonPrefix.longestCommonPrefix_3(new String[] {"flower","flow","flight"});
            break;
        case 88:
            MergeSortedArray.merge(new int[] {1,2,3,0,0,0}, 3, new int[] {2,5,6}, 3);
            break;
        case 643:
            MaximumAverageSubarray1.findMaxAverage(new int[] {1,12,-5,-6,50,3}, 4);
            break;
        case 202:
            HappyNumber.isHappy_2(19);
            break;
        case 160:
            ListNode a1 = fromArray(new int[] {4,1,8,4,5});
            ListNode b1 = fromArray(new int[] {5,6,1,8,4,5});
            IntersectionOfTwoLinkedLists.getIntersectionNod_twopointers(a1, b1);
            break;
        case 206:
            ListNode head = fromArray(new int[] {1,2,3,4,5});
            ReverseLinkedList.reverseList(head);
            break;
        case 234:
            ListNode headNode = fromArray(new int[] {1,2,2,1});
            PalindromeLinkedList.isPalindrome(headNode);
            break;
        case 876:
            ListNode headNode2 = fromArray(new int[] {1,2,3,4,5});
            MiddleOfTheLinkedList.middleNode(headNode2);
            break;
        case 121:
            BestTimeToBuyAndSellStock.maxProfit(new int[] {7,1,5,3,6,4});
            break;
        case 20:
            ValidParentheses.isValid("()[]{}" );
            break;
        case 1047:
            RemoveAllAdjacentDuplicatesInString.removeDuplicates("abbaca");
            break;
        case 496:
            NextGreaterElement1.nextGreaterElement_2(new int[] {4,1,2}, new int[] {1,3,4,2});
            break;
        case 144:
            BinaryTreePreOrderTraversal.preorderTraversal_stack( buildTree(new Integer[] {1, null, 2, 3}));
            break;
        case 94:
            BinaryTreeInOrderTraversal.inorderTraversal_stack(buildTree(new Integer[] {1,null,2,3}));
            break;
        case 145:
            BinaryTreePostOrderTraversal.postOrderTraversal_stack(buildTree(new Integer[] {1,null,2,3}));
            break;
        case 100:
            SameTree.isSameTree(buildTree(new Integer[] {1,2,3}), buildTree(new Integer[] {1,2,3}));
            break;
        case 101:
            SymmetricTree.isSymmetric(buildTree(new Integer[] {1,2,2,3,4,4,3}));
            break;
        case 226:
            InvertBinaryTree.invertTree_dfs(buildTree(new Integer[] {1,2,2,3,4,4,3}));
            break;
        case 543:
            DiameterOfBinaryTree.diameterOfBinaryTree(buildTree(new Integer[] {1,2,2,3,4,4,3}));
            break;
        case 257:
            BinaryTreePaths.binaryTreePaths(buildTree(new Integer[] {1,2,2,3,4,4,3}));
            break;
        case 104:
            MaximumDepthOfBinaryTree.maxDepth(buildTree(new Integer[] {1,2,2,3,4,4,3}));
            break;
        case 111:
            MinimumDepthOfBinaryTree.minDepth_bfs(buildTree(new Integer[] {1,2,2,3,4,4,3}));
            break;
        case 110:
            BalancedBinaryTree.isBalanced(buildTree(new Integer[] {1,2,2,3,4,4,3}));
            break;
    }
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

public static TreeNode buildTree(Integer[] values) {
    if (values == null || values.length == 0) return null;

    TreeNode root = new TreeNode(values[0]);
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    int i = 1;

    while (i < values.length) {
        TreeNode current = queue.poll();

        if (i < values.length) {
            current.left = new TreeNode(values[i]);
            queue.offer(current.left);
        }
        i++;

        if (i < values.length) {
            current.right = new TreeNode(values[i]);
            queue.offer(current.right);
        }
        i++;
    }

    return root;
}
