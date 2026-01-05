import DataStructures.Arrays.MajorityElement;
import DataStructures.Arrays.MoveZeroes;
import DataStructures.Arrays.RemoveDuplicatesFromSortedArray;
import DataStructures.LinkedLists.IntersectionOfTwoLinkedLists;
import DataStructures.LinkedLists.ListNode;
import DataStructures.Strings.IsSubsequence;
import DataStructures.Strings.LongestCommonPrefix;
import DataStructures.Strings.ValidPalindrome;
import ProblemSolvingTechniques.FastSlowPointers.HappyNumber;
import ProblemSolvingTechniques.SlidingWindow.MaximumAverageSubarray1;
import ProblemSolvingTechniques.TwoPointers.MergeSortedArray;


void main() {
    run(14);
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
            // ortak kısım: [8,4,5]
            ListNode c1 = new ListNode(8);
            ListNode c2 = new ListNode(4);
            ListNode c3 = new ListNode(5);
            c1.next = c2;
            c2.next = c3;

            // listA: [4,1] + ortak
            ListNode a1 = new ListNode(4);
            ListNode a2 = new ListNode(1);
            a1.next = a2;
            a2.next = c1;

            // listB: [5,6,1] + ortak
            ListNode b1 = new ListNode(5);
            ListNode b2 = new ListNode(6);
            ListNode b3 = new ListNode(1);
            b1.next = b2;
            b2.next = b3;
            b3.next = c1;

            IntersectionOfTwoLinkedLists.getIntersectionNod_twopointers(a1, b1);
            break;
    }
}
