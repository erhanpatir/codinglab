import DataStructures.Arrays.MajorityElement;
import DataStructures.Arrays.MoveZeroes;
import DataStructures.Arrays.RemoveDuplicatesFromSortedArray;
import DataStructures.Strings.IsSubsequence;
import DataStructures.Strings.LongestCommonPrefix;
import DataStructures.Strings.ValidPalindrome;
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
    }
}
