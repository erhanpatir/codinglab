# codinglab

Java LeetCode çözümleri, pattern bazlı klasörlerde.

- Toplam **388** soru, **388** çözüldü.
- Mülakat listesindeki (London coding hazırlık listesi) **280** sorunun **280** tanesi çözüldü.

Çalıştırmak için `Main.java` içinde `LeetCodeRunner.run(<soru no>)` çağır. Çözülmemiş dosyalarda metod yalnızca `return` satırı içerir.

**İşaretler:** ✅ çözüldü · ⬜ boş şablon · ⭐ mülakat listesinde

## Soru başlıklarındaki etiketler

Mülakat listesindeki her sorunun başlığında, soru adının üstünde öncelik, şirketler ve raporlar yazar:

- **Öncelik:** ⭐ Gerçek deneyim (aday raporunda geçiyor) · 🔴 Yüksek (klasik ve son 6 ayda aktif) · 🔵 Trend (son dönemde yükselen) · 🟡 Orta (klasik, son 6 ayda görünmüyor) · 🌍 Ortak soru (birden çok şirkette sık)
- **Şirketler:** ✅ o şirkette son 6 ayda raporlandı · (#n) şirketin LeetCode etiketindeki tüm zamanlar sırası
- **Raporlar:** toplam rapor sayısı, kaçının 📍 London'dan olduğu, 👤 senin mülakatın. Altındaki link varsa en güncel LeetCode Discuss raporu, yoksa en güncel kaynak.

## Pattern özeti

| Pattern | Paket | Soru | Çözülen | Listede |
|---|---|---:|---:|---:|
| Arrays & Hashing | `hashing` | 29 | 29 | 22 |
| Two Pointers | `twopointers` | 29 | 29 | 28 |
| Sliding Window | `slidingwindow` | 15 | 15 | 12 |
| Prefix Sum | `prefixsum` | 7 | 7 | 5 |
| Binary Search | `binarysearch` | 22 | 22 | 19 |
| Intervals | `intervals` | 8 | 8 | 5 |
| Cyclic Sort | `cyclicsort` | 4 | 4 | 4 |
| Stack | `stack` | 17 | 17 | 15 |
| Monotonic Stack / Queue | `monotonic` | 12 | 12 | 9 |
| Linked List | `linkedlist` | 15 | 15 | 13 |
| Tree DFS | `trees.dfs` | 19 | 19 | 8 |
| Tree BFS | `trees.bfs` | 12 | 12 | 7 |
| Binary Search Tree | `trees.bst` | 10 | 10 | 5 |
| Lowest Common Ancestor | `trees.lca` | 4 | 4 | 3 |
| Tree Construction / Serialization | `trees.construction` | 5 | 5 | 2 |
| Heap / Top-K | `heap` | 15 | 15 | 12 |
| Backtracking | `backtracking` | 18 | 18 | 13 |
| Graph DFS | `graphs.dfs` | 11 | 11 | 7 |
| Graph BFS | `graphs.bfs` | 5 | 5 | 4 |
| Topological Sort | `graphs.topologicalsort` | 7 | 7 | 3 |
| Union Find | `graphs.unionfind` | 9 | 9 | 2 |
| Shortest Path (Dijkstra / Bellman-Ford) | `graphs.shortestpath` | 5 | 5 | 1 |
| Minimum Spanning Tree | `graphs.mst` | 1 | 1 | 0 |
| Trie | `trie` | 6 | 6 | 1 |
| 1-D Dynamic Programming | `dp.linear` | 10 | 10 | 7 |
| Knapsack DP | `dp.knapsack` | 6 | 6 | 2 |
| Subsequence / String DP | `dp.subsequence` | 11 | 11 | 7 |
| Grid DP | `dp.grid` | 6 | 6 | 2 |
| State Machine DP | `dp.state` | 2 | 2 | 1 |
| Greedy | `greedy` | 8 | 8 | 8 |
| Data Structure Design | `design` | 20 | 20 | 17 |
| Bit Manipulation | `bit` | 7 | 7 | 6 |
| Math & Geometry | `math` | 11 | 11 | 11 |
| Matrix Simulation | `matrix` | 6 | 6 | 5 |
| String / Array Simulation | `simulation` | 15 | 15 | 13 |
| Sorting | `sorting` | 1 | 1 | 1 |

## Arrays & Hashing  (`hashing`)

- ✅ ⭐ [1. Two Sum](src/hashing/Q0001_TwoSum.java)
- ✅ ⭐ [36. Valid Sudoku](src/hashing/Q0036_ValidSudoku.java)
- ✅ ⭐ [49. Group Anagrams](src/hashing/Q0049_GroupAnagrams.java)
- ✅ ⭐ [128. Longest Consecutive Sequence](src/hashing/Q0128_LongestConsecutiveSequence.java)
- ✅ ⭐ [169. Majority Element](src/hashing/Q0169_MajorityElement.java)
- ✅ ⭐ [205. Isomorphic Strings](src/hashing/Q0205_IsomorphicStrings.java)
- ✅ ⭐ [217. Contains Duplicate](src/hashing/Q0217_ContainsDuplicate.java)
- ✅ ⭐ [219. Contains Duplicate II](src/hashing/Q0219_ContainsDuplicateII.java)
- ✅ ⭐ [242. Valid Anagram](src/hashing/Q0242_ValidAnagram.java)
- ✅ ⭐ [249. Group Shifted Strings](src/hashing/Q0249_GroupShiftedStrings.java)
- ✅ ⭐ [266. Palindrome Permutation](src/hashing/Q0266_PalindromePermutation.java)
- ✅ [290. Word Pattern](src/hashing/Q0290_WordPattern.java)
- ✅ ⭐ [349. Intersection of Two Arrays](src/hashing/Q0349_IntersectionOfTwoArrays.java)
- ✅ ⭐ [383. Ransom Note](src/hashing/Q0383_RansomNote.java)
- ✅ ⭐ [387. First Unique Character in a String](src/hashing/Q0387_FirstUniqueCharacterInAString.java)
- ✅ [451. Sort Characters By Frequency](src/hashing/Q0451_SortCharactersByFrequency.java)
- ✅ [659. Split Array Into Consecutive Subsequences](src/hashing/Q0659_SplitArrayIntoConsecutiveSubsequences.java)
- ✅ ⭐ [791. Custom Sort String](src/hashing/Q0791_CustomSortString.java)
- ✅ [792. Number Of Matching Subsequences](src/hashing/Q0792_NumberOfMatchingSubsequences.java)
- ✅ ⭐ [1152. Analyze User Website Visit Pattern](src/hashing/Q1152_AnalyzeUserWebsiteVisitPattern.java)
- ✅ ⭐ [1169. Invalid Transactions](src/hashing/Q1169_InvalidTransactions.java)
- ✅ [1189. Maximum Number Of Balloons](src/hashing/Q1189_MaximumNumberOfBalloons.java)
- ✅ [1512. Number Of Good Pairs](src/hashing/Q1512_NumberOfGoodPairs.java)
- ✅ [1525. Number Of Good Ways To Split A String](src/hashing/Q1525_NumberOfGoodWaysToSplitAString.java)
- ✅ ⭐ [2023. Number of Pairs of Strings With Concatenation Equal to Target](src/hashing/Q2023_NumberOfPairsOfStringsWithConcatenationEqualToTarget.java)
- ✅ ⭐ [2150. Find All Lonely Numbers in the Array](src/hashing/Q2150_FindAllLonelyNumbersInTheArray.java)
- ✅ ⭐ [2423. Remove Letter To Equalize Frequency](src/hashing/Q2423_RemoveLetterToEqualizeFrequency.java)
- ✅ ⭐ [2451. Odd String Difference](src/hashing/Q2451_OddStringDifference.java)
- ✅ ⭐ [3371. Identify the Largest Outlier in an Array](src/hashing/Q3371_IdentifyTheLargestOutlierInAnArray.java)

## Two Pointers  (`twopointers`)

- ✅ ⭐ [5. Longest Palindromic Substring](src/twopointers/Q0005_LongestPalindromicSubstring.java)
- ✅ ⭐ [11. Container With Most Water](src/twopointers/Q0011_ContainerWithMostWater.java)
- ✅ ⭐ [15. 3Sum](src/twopointers/Q0015_3Sum.java)
- ✅ ⭐ [16. 3Sum Closest](src/twopointers/Q0016_3SumClosest.java)
- ✅ ⭐ [18. 4Sum](src/twopointers/Q0018_4Sum.java)
- ✅ ⭐ [26. Remove Duplicates from Sorted Array](src/twopointers/Q0026_RemoveDuplicatesFromSortedArray.java)
- ✅ ⭐ [27. Remove Element](src/twopointers/Q0027_RemoveElement.java)
- ✅ ⭐ [31. Next Permutation](src/twopointers/Q0031_NextPermutation.java)
- ✅ ⭐ [42. Trapping Rain Water](src/twopointers/Q0042_TrappingRainWater.java)
- ✅ ⭐ [75. Sort Colors](src/twopointers/Q0075_SortColors.java)
- ✅ ⭐ [88. Merge Sorted Array](src/twopointers/Q0088_MergeSortedArray.java)
- ✅ ⭐ [125. Valid Palindrome](src/twopointers/Q0125_ValidPalindrome.java)
- ✅ ⭐ [151. Reverse Words in a String](src/twopointers/Q0151_ReverseWordsInAString.java)
- ✅ ⭐ [165. Compare Version Numbers](src/twopointers/Q0165_CompareVersionNumbers.java)
- ✅ ⭐ [167. Two Sum II - Input Array Is Sorted](src/twopointers/Q0167_TwoSumII.java)
- ✅ ⭐ [189. Rotate Array](src/twopointers/Q0189_RotateArray.java)
- ✅ ⭐ [283. Move Zeroes](src/twopointers/Q0283_MoveZeroes.java)
- ✅ ⭐ [344. Reverse String](src/twopointers/Q0344_ReverseString.java)
- ✅ [392. Is Subsequence](src/twopointers/Q0392_IsSubsequence.java)
- ✅ ⭐ [408. Valid Word Abbreviation](src/twopointers/Q0408_ValidWordAbbreviation.java)
- ✅ ⭐ [443. String Compression](src/twopointers/Q0443_StringCompression.java)
- ✅ ⭐ [611. Valid Triangle Number](src/twopointers/Q0611_ValidTriangleNumber.java)
- ✅ ⭐ [647. Palindromic Substrings](src/twopointers/Q0647_PalindromicSubstrings.java)
- ✅ ⭐ [680. Valid Palindrome II](src/twopointers/Q0680_ValidPalindromeII.java)
- ✅ ⭐ [977. Squares of a Sorted Array](src/twopointers/Q0977_SquaresOfASortedArray.java)
- ✅ ⭐ [1768. Merge Strings Alternately](src/twopointers/Q1768_MergeStringsAlternately.java)
- ✅ ⭐ [2970. Count the Number of Incremovable Subarrays I](src/twopointers/Q2970_CountTheNumberOfIncremovableSubarraysI.java)
- ✅ ⭐ [2972. Count the Number of Incremovable Subarrays II](src/twopointers/Q2972_CountTheNumberOfIncremovableSubarraysII.java)
- ✅ ⭐ [3649. Number of Perfect Pairs](src/twopointers/Q3649_NumberOfPerfectPairs.java)

## Sliding Window  (`slidingwindow`)

- ✅ ⭐ [3. Longest Substring Without Repeating Characters](src/slidingwindow/Q0003_LongestSubstringWithoutRepeatingCharacters.java)
- ✅ ⭐ [76. Minimum Window Substring](src/slidingwindow/Q0076_MinimumWindowSubstring.java)
- ✅ ⭐ [121. Best Time to Buy and Sell Stock](src/slidingwindow/Q0121_BestTimeToBuyAndSellStock.java)
- ✅ ⭐ [209. Minimum Size Subarray Sum](src/slidingwindow/Q0209_MinimumSizeSubarraySum.java)
- ✅ ⭐ [424. Longest Repeating Character Replacement](src/slidingwindow/Q0424_LongestRepeatingCharactersReplacement.java)
- ✅ ⭐ [438. Find All Anagrams in a String](src/slidingwindow/Q0438_FindAllAnagramsInAString.java)
- ✅ ⭐ [485. Max Consecutive Ones](src/slidingwindow/Q0485_MaxConsecutiveOnes.java)
- ✅ ⭐ [567. Permutation in String](src/slidingwindow/Q0567_PermutationInString.java)
- ✅ [643. Maximum Average Subarray1](src/slidingwindow/Q0643_MaximumAverageSubarray1.java)
- ✅ ⭐ [713. Subarray Product Less Than K](src/slidingwindow/Q0713_SubarrayProductLessThanK.java)
- ✅ ⭐ [904. Fruit Into Baskets](src/slidingwindow/Q0904_FruitIntoBaskets.java)
- ✅ ⭐ [1004. Max Consecutive Ones III](src/slidingwindow/Q1004_MaxConsecutiveOnesIII.java)
- ✅ [1343. Number Of Sub Arrays Of Size K And Average Greater Than Or Equal To Threshold](src/slidingwindow/Q1343_NumberOfSubArraysOfSizeKAndAverageGreaterThanOrEqualToThreshold.java)
- ✅ [1456. Maximum Number Of Vowels In A Substring Of Given Length](src/slidingwindow/Q1456_MaximumNumberOfVowelsInASubstringOfGivenLength.java)
- ✅ ⭐ [3413. Maximum Coins From K Consecutive Bags](src/slidingwindow/Q3413_MaximumCoinsFromKConsecutiveBags.java)

## Prefix Sum  (`prefixsum`)

- ✅ ⭐ [238. Product of Array Except Self](src/prefixsum/Q0238_ProductOfArrayExceptSelf.java)
- ✅ [303. Range Sum Query Immutable](src/prefixsum/Q0303_RangeSumQueryImmutable.java)
- ✅ ⭐ [523. Continuous Subarray Sum](src/prefixsum/Q0523_ContinuousSubarraySum.java)
- ✅ ⭐ [525. Contiguous Array](src/prefixsum/Q0525_ContiguousArray.java)
- ✅ ⭐ [560. Subarray Sum Equals K](src/prefixsum/Q0560_SubarraySumEqualsK.java)
- ✅ [974. Subarray Sums Divisible By K](src/prefixsum/Q0974_SubarraySumsDivisibleByK.java)
- ✅ ⭐ [1480. Running Sum of 1d Array](src/prefixsum/Q1480_RunningSumOf1dArray.java)

## Binary Search  (`binarysearch`)

- ✅ ⭐ [4. Median of Two Sorted Arrays](src/binarysearch/Q0004_MedianOfTwoSortedArrays.java)
- ✅ ⭐ [33. Search in Rotated Sorted Array](src/binarysearch/Q0033_SearchInRotatedSortedArray.java)
- ✅ ⭐ [34. Find First and Last Position of Element in Sorted Array](src/binarysearch/Q0034_FindFirstAndLastPositionOfElementInSortedArray.java)
- ✅ ⭐ [35. Search Insert Position](src/binarysearch/Q0035_SearchInsertPosition.java)
- ✅ ⭐ [69. Sqrt(x)](src/binarysearch/Q0069_Sqrt.java)
- ✅ ⭐ [74. Search a 2D Matrix](src/binarysearch/Q0074_SearchA2DMatrix.java)
- ✅ [153. Find Minimum In Rotated Sorted Array](src/binarysearch/Q0153_FindMinimumInRotatedSortedArray.java)
- ✅ ⭐ [162. Find Peak Element](src/binarysearch/Q0162_FindPeakElement.java)
- ✅ ⭐ [240. Search a 2D Matrix II](src/binarysearch/Q0240_SearchA2DMatrixII.java)
- ✅ [278. First Bad Version](src/binarysearch/Q0278_FirstBadVersion.java)
- ✅ ⭐ [410. Split Array Largest Sum](src/binarysearch/Q0410_SplitArrayLargestSum.java)
- ✅ ⭐ [528. Random Pick with Weight](src/binarysearch/Q0528_RandomPickWithWeight.java)
- ✅ ⭐ [540. Single Element in a Sorted Array](src/binarysearch/Q0540_SingleElementInASortedArray.java)
- ✅ ⭐ [658. Find K Closest Elements](src/binarysearch/Q0658_FindKClosestElements.java)
- ✅ ⭐ [704. Binary Search](src/binarysearch/Q0704_BinarySearch.java)
- ✅ ⭐ [875. Koko Eating Bananas](src/binarysearch/Q0875_KokoEatingBananas.java)
- ✅ ⭐ [981. Time Based Key-Value Store](src/binarysearch/Q0981_TimeBasedKeyValueStore.java)
- ✅ ⭐ [1011. Capacity To Ship Packages Within D Days](src/binarysearch/Q1011_CapacityToShipPackagesWithinDDays.java)
- ✅ ⭐ [1060. Missing Element in Sorted Array](src/binarysearch/Q1060_MissingElementInSortedArray.java)
- ✅ ⭐ [1274. Number of Ships in a Rectangle](src/binarysearch/Q1274_NumberOfShipsInARectangle.java)
- ✅ [1482. Minimum Days To Make M Bouqets](src/binarysearch/Q1482_MinimumDaysToMakeMBouqets.java)
- ✅ ⭐ [1539. Kth Missing Positive Number](src/binarysearch/Q1539_KthMissingPositiveNumber.java)

## Intervals  (`intervals`)

- ✅ ⭐ [56. Merge Intervals](src/intervals/Q0056_MergeIntervals.java)
- ✅ [57. Insert Interval](src/intervals/Q0057_InsertInterval.java)
- ✅ ⭐ [163. Missing Ranges](src/intervals/Q0163_MissingRanges.java)
- ✅ ⭐ [252. Meeting Rooms](src/intervals/Q0252_MeetingRooms.java)
- ✅ ⭐ [253. Meeting Rooms II](src/intervals/Q0253_MeetingRoomsII.java)
- ✅ [435. Non Overlapping Intervals](src/intervals/Q0435_NonOverlappingIntervals.java)
- ✅ [452. Minimum Number Of Arrows To Burst Balloons](src/intervals/Q0452_MinimumNumberOfArrowsToBurstBalloons.java)
- ✅ ⭐ [986. Interval List Intersections](src/intervals/Q0986_IntervalListIntersections.java)

## Cyclic Sort  (`cyclicsort`)

- ✅ ⭐ [41. First Missing Positive](src/cyclicsort/Q0041_FirstMissingPositive.java)
- ✅ ⭐ [287. Find the Duplicate Number](src/cyclicsort/Q0287_FindTheDuplicateNumber.java)
- ✅ ⭐ [448. Find All Numbers Disappeared in an Array](src/cyclicsort/Q0448_FindAllNumbersDisappearedInAnArray.java)
- ✅ ⭐ [565. Array Nesting](src/cyclicsort/Q0565_ArrayNesting.java)

## Stack  (`stack`)

- ✅ ⭐ [20. Valid Parentheses](src/stack/Q0020_ValidParentheses.java)
- ✅ ⭐ [32. Longest Valid Parentheses](src/stack/Q0032_LongestValidParentheses.java)
- ✅ ⭐ [71. Simplify Path](src/stack/Q0071_SimplifyPath.java)
- ✅ [150. Evaluate Reverse Polish Rotation](src/stack/Q0150_EvaluateReversePolishRotation.java)
- ✅ ⭐ [155. Min Stack](src/stack/Q0155_MinStack.java)
- ✅ ⭐ [224. Basic Calculator](src/stack/Q0224_BasicCalculator.java)
- ✅ ⭐ [227. Basic Calculator II](src/stack/Q0227_BasicCalculator2.java)
- ✅ ⭐ [232. Implement Queue using Stacks](src/stack/Q0232_ImplementQueueUsingStacks.java)
- ✅ ⭐ [394. Decode String](src/stack/Q0394_DecodeString.java)
- ✅ ⭐ [636. Exclusive Time of Functions](src/stack/Q0636_ExclusiveTimeOfFunctions.java)
- ✅ ⭐ [735. Asteroid Collision](src/stack/Q0735_AsteroidCollision.java)
- ✅ ⭐ [736. Parse Lisp Expression](src/stack/Q0736_ParseLispExpression.java)
- ✅ [853. Car Fleet](src/stack/Q0853_CarFleet.java)
- ✅ ⭐ [921. Minimum Add to Make Parentheses Valid](src/stack/Q0921_MinimumAddToMakeParenthesesValid.java)
- ✅ ⭐ [1047. Remove All Adjacent Duplicates In String](src/stack/Q1047_RemoveAllAdjacentDuplicatesInString.java)
- ✅ ⭐ [1209. Remove All Adjacent Duplicates in String II](src/stack/Q1209_RemoveAllAdjacentDuplicatesInStringII.java)
- ✅ ⭐ [1249. Minimum Remove to Make Valid Parentheses](src/stack/Q1249_MinimumRemoveToMakeValidParentheses.java)

## Monotonic Stack / Queue  (`monotonic`)

- ✅ ⭐ [84. Largest Rectangle in Histogram](src/monotonic/Q0084_LargestRectangleInHistogram.java)
- ✅ ⭐ [85. Maximal Rectangle](src/monotonic/Q0085_MaximalRectangle.java)
- ✅ ⭐ [239. Sliding Window Maximum](src/monotonic/Q0239_SlidingWindowMaximum.java)
- ✅ ⭐ [402. Remove K Digits](src/monotonic/Q0402_RemoveKDigits.java)
- ✅ ⭐ [496. Next Greater Element I](src/monotonic/Q0496_NextGreaterElement1.java)
- ✅ ⭐ [503. Next Greater Element II](src/monotonic/Q0503_NextGreaterElement2.java)
- ✅ ⭐ [739. Daily Temperatures](src/monotonic/Q0739_DailyTemperatures.java)
- ✅ [862. Shortest Subarray With Sum At Least K](src/monotonic/Q0862_ShortestSubarrayWithSumAtLeastK.java)
- ✅ [901. Online Stock Span](src/monotonic/Q0901_OnlineStockSpan.java)
- ✅ [1696. Jump Game V I](src/monotonic/Q1696_JumpGameVI.java)
- ✅ ⭐ [1762. Buildings With an Ocean View](src/monotonic/Q1762_BuildingsWithAnOceanView.java)
- ✅ ⭐ [1944. Number of Visible People in a Queue](src/monotonic/Q1944_NumberOfVisiblePeopleInAQueue.java)

## Linked List  (`linkedlist`)

- ✅ ⭐ [2. Add Two Numbers](src/linkedlist/Q0002_AddTwoNumbers.java)
- ✅ ⭐ [19. Remove Nth Node From End of List](src/linkedlist/Q0019_RemoveNthNodeFromEndOfList.java)
- ✅ ⭐ [21. Merge Two Sorted Lists](src/linkedlist/Q0021_MergeTwoSortedLists.java)
- ✅ ⭐ [25. Reverse Nodes in k-Group](src/linkedlist/Q0025_ReverseNodesInKGroup.java)
- ✅ ⭐ [61. Rotate List](src/linkedlist/Q0061_RotateList.java)
- ✅ ⭐ [138. Copy List with Random Pointer](src/linkedlist/Q0138_CopyListWithRandomPointer.java)
- ✅ ⭐ [143. Reorder List](src/linkedlist/Q0143_ReorderList.java)
- ✅ [148. Sort List](src/linkedlist/Q0148_SortList.java)
- ✅ [160. Intersection Of Two Linked Lists](src/linkedlist/Q0160_IntersectionOfTwoLinkedLists.java)
- ✅ ⭐ [206. Reverse Linked List](src/linkedlist/Q0206_ReverseLinkedList.java)
- ✅ ⭐ [234. Palindrome Linked List](src/linkedlist/Q0234_PalindromeLinkedList.java)
- ✅ ⭐ [237. Delete Node in a Linked List](src/linkedlist/Q0237_DeleteNodeInALinkedList.java)
- ✅ ⭐ [430. Flatten a Multilevel Doubly Linked List](src/linkedlist/Q0430_FlattenAMultilevelDoublyLinkedList.java)
- ✅ ⭐ [708. Insert into a Sorted Circular Linked List](src/linkedlist/Q0708_InsertIntoASortedCircularLinkedList.java)
- ✅ ⭐ [876. Middle of the Linked List](src/linkedlist/Q0876_MiddleOfTheLinkedList.java)

## Tree DFS  (`trees.dfs`)

- ✅ [94. Binary Tree In Order Traversal](src/trees/dfs/Q0094_BinaryTreeInOrderTraversal.java)
- ✅ [100. Same Tree](src/trees/dfs/Q0100_SameTree.java)
- ✅ ⭐ [101. Symmetric Tree](src/trees/dfs/Q0101_SymmetricTree.java)
- ✅ ⭐ [104. Maximum Depth of Binary Tree](src/trees/dfs/Q0104_MaximumDepthOfBinaryTree.java)
- ✅ [110. Balanced Binary Tree](src/trees/dfs/Q0110_BalancedBinaryTree.java)
- ✅ [112. Path Sum](src/trees/dfs/Q0112_PathSum.java)
- ✅ [113. Path Sum2](src/trees/dfs/Q0113_PathSum2.java)
- ✅ ⭐ [124. Binary Tree Maximum Path Sum](src/trees/dfs/Q0124_BinaryTreeMaximumPathSum.java)
- ✅ ⭐ [129. Sum Root to Leaf Numbers](src/trees/dfs/Q0129_SumRootToLeafNumbers.java)
- ✅ [144. Binary Tree Pre Order Traversal](src/trees/dfs/Q0144_BinaryTreePreOrderTraversal.java)
- ✅ [145. Binary Tree Post Order Traversal](src/trees/dfs/Q0145_BinaryTreePostOrderTraversal.java)
- ✅ [222. Count Complete Tree Nodes](src/trees/dfs/Q0222_CountCompleteTreeNodes.java)
- ✅ [226. Invert Binary Tree](src/trees/dfs/Q0226_InvertBinaryTree.java)
- ✅ ⭐ [257. Binary Tree Paths](src/trees/dfs/Q0257_BinaryTreePaths.java)
- ✅ [337. House Robber3](src/trees/dfs/Q0337_HouseRobber3.java)
- ✅ ⭐ [339. Nested List Weight Sum](src/trees/dfs/Q0339_NestedListWeightSum.java)
- ✅ ⭐ [543. Diameter of Binary Tree](src/trees/dfs/Q0543_DiameterOfBinaryTree.java)
- ✅ [572. Subtree Of Another Tree](src/trees/dfs/Q0572_SubtreeOfAnotherTree.java)
- ✅ ⭐ [2265. Count Nodes Equal to Average of Subtree](src/trees/dfs/Q2265_CountNodesEqualToAverageOfSubtree.java)

## Tree BFS  (`trees.bfs`)

- ✅ ⭐ [102. Binary Tree Level Order Traversal](src/trees/bfs/Q0102_BinaryTreeLevelOrderTraversal.java)
- ✅ ⭐ [103. Binary Tree Zigzag Level Order Traversal](src/trees/bfs/Q0103_BinaryTreeZigzagLevelOrderTraversal.java)
- ✅ [111. Minimum Depth Of Binary Tree](src/trees/bfs/Q0111_MinimumDepthOfBinaryTree.java)
- ✅ [116. Populating Next Right Pointers In Each Node](src/trees/bfs/Q0116_PopulatingNextRightPointersInEachNode.java)
- ✅ [117. Populating Next Right Pointers In Each Node2](src/trees/bfs/Q0117_PopulatingNextRightPointersInEachNode2.java)
- ✅ ⭐ [199. Binary Tree Right Side View](src/trees/bfs/Q0199_BinaryTreeRightSideView.java)
- ✅ ⭐ [314. Binary Tree Vertical Order Traversal](src/trees/bfs/Q0314_BinaryTreeVerticalOrderTraversal.java)
- ✅ [515. Find Largest Value In Each Tree Row](src/trees/bfs/Q0515_FindLargestValueInEachTreeRow.java)
- ✅ [662. Maximum Width Of Binary Tree](src/trees/bfs/Q0662_MaximumWidthOfBinaryTree.java)
- ✅ ⭐ [863. All Nodes Distance K in Binary Tree](src/trees/bfs/Q0863_AllNodesDistanceKInBinaryTree.java)
- ✅ ⭐ [958. Check Completeness of a Binary Tree](src/trees/bfs/Q0958_CheckCompletenessOfABinaryTree.java)
- ✅ ⭐ [987. Vertical Order Traversal of a Binary Tree](src/trees/bfs/Q0987_VerticalOrderTraversalOfABinaryTree.java)

## Binary Search Tree  (`trees.bst`)

- ✅ ⭐ [98. Validate Binary Search Tree](src/trees/bst/Q0098_ValidateBinarySearchTree.java)
- ✅ [108. Convert Sorted Array To Binary Search Tree](src/trees/bst/Q0108_ConvertSortedArrayToBinarySearchTree.java)
- ✅ ⭐ [173. Binary Search Tree Iterator](src/trees/bst/Q0173_BinarySearchTreeIterator.java)
- ✅ [230. Kth Smallest Element Ina B S T](src/trees/bst/Q0230_KthSmallestElementInaBST.java)
- ✅ ⭐ [270. Closest Binary Search Tree Value](src/trees/bst/Q0270_ClosestBinarySearchTreeValue.java)
- ✅ ⭐ [426. Convert Binary Search Tree to Sorted Doubly Linked List](src/trees/bst/Q0426_ConvertBinarySearchTreeToSortedDoublyLinkedList.java)
- ✅ [530. Minimum Absolute Difference In B S T](src/trees/bst/Q0530_MinimumAbsoluteDifferenceInBST.java)
- ✅ [669. Trim A Binary Search Tree](src/trees/bst/Q0669_TrimABinarySearchTree.java)
- ✅ [783. Minimum Distance Between B S T Nodes](src/trees/bst/Q0783_MinimumDistanceBetweenBSTNodes.java)
- ✅ ⭐ [938. Range Sum of BST](src/trees/bst/Q0938_RangeSumOfBST.java)

## Lowest Common Ancestor  (`trees.lca`)

- ✅ [235. Lowest Common Ancestor Of A Binary Search Tree](src/trees/lca/Q0235_LowestCommonAncestorOfABinarySearchTree.java)
- ✅ ⭐ [236. Lowest Common Ancestor of a Binary Tree](src/trees/lca/Q0236_LowestCommonAncestorOfABinaryTree.java)
- ✅ ⭐ [1644. Lowest Common Ancestor of a Binary Tree II](src/trees/lca/Q1644_LowestCommonAncestorOfABinaryTreeII.java)
- ✅ ⭐ [1650. Lowest Common Ancestor of a Binary Tree III](src/trees/lca/Q1650_LowestCommonAncestorOfABinaryTreeIII.java)

## Tree Construction / Serialization  (`trees.construction`)

- ✅ [105. Construct Binary Tree From Preorder And Inorder Traversal](src/trees/construction/Q0105_ConstructBinaryTreeFromPreorderAndInorderTraversal.java)
- ✅ [106. Construct Binary Tree From Inorder And Postorder Traversal](src/trees/construction/Q0106_ConstructBinaryTreeFromInorderAndPostorderTraversal.java)
- ✅ [109. Convert Sorted List To Binary Search Tree](src/trees/construction/Q0109_ConvertSortedListToBinarySearchTree.java)
- ✅ ⭐ [297. Serialize and Deserialize Binary Tree](src/trees/construction/Q0297_SerializeAndDeserializeBinaryTree.java)
- ✅ ⭐ [889. Construct Binary Tree from Preorder and Postorder Traversal](src/trees/construction/Q0889_ConstructBinaryTreeFromPreorderAndPostorderTraversal.java)

## Heap / Top-K  (`heap`)

- ✅ ⭐ [23. Merge k Sorted Lists](src/heap/Q0023_MergeKSortedLists.java)
- ✅ ⭐ [215. Kth Largest Element in an Array](src/heap/Q0215_KthLargestElementInAnArray.java)
- ✅ ⭐ [295. Find Median from Data Stream](src/heap/Q0295_FindMedianFromDataStream.java)
- ✅ ⭐ [347. Top K Frequent Elements](src/heap/Q0347_TopKFrequentElements.java)
- ✅ [373. Find K Pairs With Smallest Sums](src/heap/Q0373_FindKPairsWithSmallestSums.java)
- ✅ ⭐ [378. Kth Smallest Element in a Sorted Matrix](src/heap/Q0378_KthSmallestElementInASortedMatrix.java)
- ✅ ⭐ [480. Sliding Window Median](src/heap/Q0480_SlidingWindowMedian.java)
- ✅ ⭐ [621. Task Scheduler](src/heap/Q0621_TaskScheduler.java)
- ✅ [703. Kth Largest Element In A Stream](src/heap/Q0703_KthLargestElementInAStream.java)
- ✅ ⭐ [767. Reorganize String](src/heap/Q0767_ReorganizeString.java)
- ✅ ⭐ [857. Minimum Cost to Hire K Workers](src/heap/Q0857_MinimumCostToHireKWorkers.java)
- ✅ ⭐ [973. K Closest Points to Origin](src/heap/Q0973_KClosestPointsToOrigin.java)
- ✅ ⭐ [1606. Find Servers That Handled Most Number of Requests](src/heap/Q1606_FindServersThatHandledMostNumberOfRequests.java)
- ✅ [1642. Furthest Building You Can Reach](src/heap/Q1642_FurthestBuildingYouCanReach.java)
- ✅ ⭐ [2402. Meeting Rooms III](src/heap/Q2402_MeetingRoomsIII.java)

## Backtracking  (`backtracking`)

- ✅ ⭐ [17. Letter Combinations of a Phone Number](src/backtracking/Q0017_LetterCombinationsOfAPhoneNumber.java)
- ✅ ⭐ [22. Generate Parentheses](src/backtracking/Q0022_GenerateParentheses.java)
- ✅ ⭐ [39. Combination Sum](src/backtracking/Q0039_CombinationSum.java)
- ✅ [40. Combination Sum I I](src/backtracking/Q0040_CombinationSumII.java)
- ✅ ⭐ [46. Permutations](src/backtracking/Q0046_Permutations.java)
- ✅ [47. Permutations I I](src/backtracking/Q0047_PermutationsII.java)
- ✅ ⭐ [51. N-Queens](src/backtracking/Q0051_NQueens.java)
- ✅ [77. Combinations](src/backtracking/Q0077_Combinations.java)
- ✅ ⭐ [78. Subsets](src/backtracking/Q0078_Subsets.java)
- ✅ ⭐ [79. Word Search](src/backtracking/Q0079_WordSearch.java)
- ✅ [90. Subsets I I](src/backtracking/Q0090_SubsetsII.java)
- ✅ ⭐ [131. Palindrome Partitioning](src/backtracking/Q0131_PalindromePartitioning.java)
- ✅ ⭐ [140. Word Break II](src/backtracking/Q0140_WordBreakII.java)
- ✅ [216. Combination Sum I I I](src/backtracking/Q0216_CombinationSumIII.java)
- ✅ ⭐ [282. Expression Add Operators](src/backtracking/Q0282_ExpressionAddOperators.java)
- ✅ ⭐ [489. Robot Room Cleaner](src/backtracking/Q0489_RobotRoomCleaner.java)
- ✅ ⭐ [996. Number of Squareful Arrays](src/backtracking/Q0996_NumberOfSquarefulArrays.java)
- ✅ ⭐ [2397. Maximum Rows Covered by Columns](src/backtracking/Q2397_MaximumRowsCoveredByColumns.java)

## Graph DFS  (`graphs.dfs`)

- ✅ [130. Surrounded Regions](src/graphs/dfs/Q0130_SurroundedRegions.java)
- ✅ ⭐ [133. Clone Graph](src/graphs/dfs/Q0133_CloneGraph.java)
- ✅ ⭐ [200. Number of Islands](src/graphs/dfs/Q0200_NumberOfIslands.java)
- ✅ [323. Number Of Connected Components In An Undirected Graph](src/graphs/dfs/Q0323_NumberOfConnectedComponentsInAnUndirectedGraph.java)
- ✅ ⭐ [399. Evaluate Division](src/graphs/dfs/Q0399_EvaluateDivision.java)
- ✅ [417. Pacific Atlantic Water Flow](src/graphs/dfs/Q0417_PacificAtlanticWaterFlow.java)
- ✅ [695. Max Area Of Island](src/graphs/dfs/Q0695_MaxAreaOfIsland.java)
- ✅ ⭐ [733. Flood Fill](src/graphs/dfs/Q0733_FloodFill.java)
- ✅ ⭐ [797. All Paths From Source to Target](src/graphs/dfs/Q0797_AllPathsFromSourceToTarget.java)
- ✅ ⭐ [827. Making A Large Island](src/graphs/dfs/Q0827_MakingALargeIsland.java)
- ✅ ⭐ [1254. Number of Closed Islands](src/graphs/dfs/Q1254_NumberOfClosedIslands.java)

## Graph BFS  (`graphs.bfs`)

- ✅ ⭐ [127. Word Ladder](src/graphs/bfs/Q0127_WordLadder.java)
- ✅ [433. Minimum Genetic Mutation](src/graphs/bfs/Q0433_MinimumGeneticMutation.java)
- ✅ ⭐ [785. Is Graph Bipartite?](src/graphs/bfs/Q0785_IsGraphBipartite.java)
- ✅ ⭐ [994. Rotting Oranges](src/graphs/bfs/Q0994_RottingOranges.java)
- ✅ ⭐ [1091. Shortest Path in Binary Matrix](src/graphs/bfs/Q1091_ShortestPathInBinaryMatrix.java)

## Topological Sort  (`graphs.topologicalsort`)

- ✅ ⭐ [207. Course Schedule](src/graphs/topologicalsort/Q0207_CourseSchedule.java)
- ✅ ⭐ [210. Course Schedule II](src/graphs/topologicalsort/Q0210_CourseSchedule2.java)
- ✅ ⭐ [269. Alien Dictionary](src/graphs/topologicalsort/Q0269_AlienDictionary.java)
- ✅ [310. Minimum Height Trees](src/graphs/topologicalsort/Q0310_MinimumHeightTrees.java)
- ✅ [444. Sequence Reconstruction](src/graphs/topologicalsort/Q0444_SequenceReconstruction.java)
- ✅ [802. Find Eventual Safe States](src/graphs/topologicalsort/Q0802_FindEventualSafeStates.java)
- ✅ [1136. Parallel Courses](src/graphs/topologicalsort/Q1136_ParallelCourses.java)

## Union Find  (`graphs.unionfind`)

- ✅ [261. Graph Valid Tree](src/graphs/unionfind/Q0261_GraphValidTree.java)
- ✅ ⭐ [547. Number of Provinces](src/graphs/unionfind/Q0547_NumberOfProvinces.java)
- ✅ [684. Redundant Connection](src/graphs/unionfind/Q0684_RedundantConnection.java)
- ✅ [685. Redundant Connection I I](src/graphs/unionfind/Q0685_RedundantConnectionII.java)
- ✅ ⭐ [721. Accounts Merge](src/graphs/unionfind/Q0721_AccountsMerge.java)
- ✅ [765. Couples Holding Hands](src/graphs/unionfind/Q0765_CouplesHoldingHands.java)
- ✅ [839. Similar String Groups](src/graphs/unionfind/Q0839_SimilarStringGroups.java)
- ✅ [924. Minimize Malware Spread](src/graphs/unionfind/Q0924_MinimizeMalwareSpread.java)
- ✅ [990. Satisfiability Of Equality Equations](src/graphs/unionfind/Q0990_SatisfiabilityOfEqualityEquations.java)

## Shortest Path (Dijkstra / Bellman-Ford)  (`graphs.shortestpath`)

- ✅ [743. Network Delay Time](src/graphs/shortestpath/Q0743_NetworkDelayTime.java)
- ✅ ⭐ [778. Swim in Rising Water](src/graphs/shortestpath/Q0778_SwimInRisingWater.java)
- ✅ [787. Cheapest Flights Within K Stops](src/graphs/shortestpath/Q0787_CheapestFlightsWithinKStops.java)
- ✅ [1514. Path With Maximum Probability](src/graphs/shortestpath/Q1514_PathWithMaximumProbability.java)
- ✅ [1631. Path With Minimum Effort](src/graphs/shortestpath/Q1631_PathWithMinimumEffort.java)

## Minimum Spanning Tree  (`graphs.mst`)

- ✅ [1584. Min Cost To Connect All Points](src/graphs/mst/Q1584_MinCostToConnectAllPoints.java)

## Trie  (`trie`)

- ✅ ⭐ [208. Implement Trie (Prefix Tree)](src/trie/Q0208_ImplementTrie.java)
- ✅ [211. Design Add And Search Words](src/trie/Q0211_DesignAddAndSearchWords.java)
- ✅ [212. Word Search I I](src/trie/Q0212_WordSearchII.java)
- ✅ [648. Replace Words](src/trie/Q0648_ReplaceWords.java)
- ✅ [677. Map Sum Pairs](src/trie/Q0677_MapSumPairs.java)
- ✅ [1268. Search Suggestions System](src/trie/Q1268_SearchSuggestionsSystem.java)

## 1-D Dynamic Programming  (`dp.linear`)

- ✅ ⭐ [53. Maximum Subarray](src/dp/linear/Q0053_MaximumSubarray.java)
- ✅ ⭐ [70. Climbing Stairs](src/dp/linear/Q0070_ClimbingStairs.java)
- ✅ ⭐ [118. Pascal's Triangle](src/dp/linear/Q0118_PascalSTriangle.java)
- ✅ ⭐ [152. Maximum Product Subarray](src/dp/linear/Q0152_MaximumProductSubarray.java)
- ✅ ⭐ [198. House Robber](src/dp/linear/Q0198_HouseRobber.java)
- ✅ [213. House Robber I I](src/dp/linear/Q0213_HouseRobberII.java)
- ✅ ⭐ [509. Fibonacci Number](src/dp/linear/Q0509_FibonacciNumber.java)
- ✅ [746. Min Cost Climbing Stairs](src/dp/linear/Q0746_MinCostClimbingStairs.java)
- ✅ [918. Maximum Circular Subarray](src/dp/linear/Q0918_MaximumCircularSubarray.java)
- ✅ ⭐ [1387. Sort Integers by The Power Value](src/dp/linear/Q1387_SortIntegersByThePowerValue.java)

## Knapsack DP  (`dp.knapsack`)

- ✅ ⭐ [322. Coin Change](src/dp/knapsack/Q0322_CoinChange1.java)
- ✅ [416. Partition Equal Subset Sum](src/dp/knapsack/Q0416_PartitionEqualSubsetSum.java)
- ✅ [474. Ones And Zeroes](src/dp/knapsack/Q0474_OnesAndZeroes.java)
- ✅ [494. Target Sum](src/dp/knapsack/Q0494_TargetSum.java)
- ✅ [518. Coin Change2](src/dp/knapsack/Q0518_CoinChange2.java)
- ✅ ⭐ [1049. Last Stone Weight II](src/dp/knapsack/Q1049_LastStoneWeightII.java)

## Subsequence / String DP  (`dp.subsequence`)

- ✅ ⭐ [10. Regular Expression Matching](src/dp/subsequence/Q0010_RegularExpressionMatching.java)
- ✅ ⭐ [72. Edit Distance](src/dp/subsequence/Q0072_EditDistance.java)
- ✅ [115. Distinct Subsequences](src/dp/subsequence/Q0115_DistinctSubsequences.java)
- ✅ ⭐ [139. Word Break](src/dp/subsequence/Q0139_WordBreak.java)
- ✅ ⭐ [300. Longest Increasing Subsequence](src/dp/subsequence/Q0300_LongestIncreasingSubsequence.java)
- ✅ ⭐ [354. Russian Doll Envelopes](src/dp/subsequence/Q0354_RussianDollEnvelopes.java)
- ✅ [516. Longest Palindromic Subsequence](src/dp/subsequence/Q0516_LongestPalindromicSubsequence.java)
- ✅ [583. Delete Operation For Two Strings](src/dp/subsequence/Q0583_DeleteOperationForTwoStrings.java)
- ✅ [673. Number Of Longest Increasing Subsequence](src/dp/subsequence/Q0673_NumberOfLongestIncreasingSubsequence.java)
- ✅ ⭐ [1143. Longest Common Subsequence](src/dp/subsequence/Q1143_LongestCommonSubsequence.java)
- ✅ ⭐ [1216. Valid Palindrome III](src/dp/subsequence/Q1216_ValidPalindromeIII.java)

## Grid DP  (`dp.grid`)

- ✅ ⭐ [62. Unique Paths](src/dp/grid/Q0062_UniquePaths.java)
- ✅ [63. Unique Paths2](src/dp/grid/Q0063_UniquePaths2.java)
- ✅ [64. Minimum Path Sum](src/dp/grid/Q0064_MinimumPathSum.java)
- ✅ ⭐ [221. Maximal Square](src/dp/grid/Q0221_MaximalSquare.java)
- ✅ [329. Longest Increasing Path In A Matrix](src/dp/grid/Q0329_LongestIncreasingPathInAMatrix.java)
- ✅ [931. Minimum Falling Path Sum](src/dp/grid/Q0931_MinimumFallingPathSum.java)

## State Machine DP  (`dp.state`)

- ✅ [403. Frog Jump](src/dp/state/Q0403_FrogJump.java)
- ✅ ⭐ [714. Best Time to Buy and Sell Stock with Transaction Fee](src/dp/state/Q0714_BestTimeToBuyAndSellStockWithTransactionFee.java)

## Greedy  (`greedy`)

- ✅ ⭐ [45. Jump Game II](src/greedy/Q0045_JumpGame2.java)
- ✅ ⭐ [55. Jump Game](src/greedy/Q0055_JumpGame.java)
- ✅ ⭐ [122. Best Time to Buy and Sell Stock II](src/greedy/Q0122_BestTimeToBuyAndSellStockII.java)
- ✅ ⭐ [134. Gas Station](src/greedy/Q0134_GasStation.java)
- ✅ ⭐ [135. Candy](src/greedy/Q0135_Candy.java)
- ✅ ⭐ [670. Maximum Swap](src/greedy/Q0670_MaximumSwap.java)
- ✅ ⭐ [1029. Two City Scheduling](src/greedy/Q1029_TwoCityScheduling.java)
- ✅ ⭐ [3914. Minimum Operations to Make Array Non Decreasing](src/greedy/Q3914_MinimumOperationsToMakeArrayNonDecreasing.java)

## Data Structure Design  (`design`)

- ✅ ⭐ [146. LRU Cache](src/design/Q0146_LRUCache.java)
- ✅ ⭐ [284. Peeking Iterator](src/design/Q0284_PeekingIterator.java)
- ✅ ⭐ [341. Flatten Nested List Iterator](src/design/Q0341_FlattenNestedListIterator.java)
- ✅ ⭐ [346. Moving Average from Data Stream](src/design/Q0346_MovingAverageFromDataStream.java)
- ✅ ⭐ [348. Design Tic-Tac-Toe](src/design/Q0348_DesignTicTacToe.java)
- ✅ ⭐ [359. Logger Rate Limiter](src/design/Q0359_LoggerRateLimiter.java)
- ✅ ⭐ [362. Design Hit Counter](src/design/Q0362_DesignHitCounter.java)
- ✅ ⭐ [380. Insert Delete GetRandom O(1)](src/design/Q0380_InsertDeleteGetRandomO1.java)
- ✅ ⭐ [460. LFU Cache](src/design/Q0460_LFUCache.java)
- ✅ [535. Encode And Decode Tiny U R L](src/design/Q0535_EncodeAndDecodeTinyURL.java)
- ✅ ⭐ [622. Design Circular Queue](src/design/Q0622_DesignCircularQueue.java)
- ✅ ⭐ [706. Design HashMap](src/design/Q0706_DesignHashMap.java)
- ✅ [933. Number Of Recent Calls](src/design/Q0933_NumberOfRecentCalls.java)
- ✅ ⭐ [1146. Snapshot Array](src/design/Q1146_SnapshotArray.java)
- ✅ ⭐ [1396. Design Underground System](src/design/Q1396_DesignUndergroundSystem.java)
- ✅ [1472. Design Browser History](src/design/Q1472_DesignBrowserHistory.java)
- ✅ ⭐ [1570. Dot Product of Two Sparse Vectors](src/design/Q1570_DotProductOfTwoSparseVectors.java)
- ✅ ⭐ [1656. Design an Ordered Stream](src/design/Q1656_DesignAnOrderedStream.java)
- ✅ ⭐ [2502. Design Memory Allocator](src/design/Q2502_DesignMemoryAllocator.java)
- ✅ ⭐ [3408. Design Task Manager](src/design/Q3408_DesignTaskManager.java)

## Bit Manipulation  (`bit`)

- ✅ ⭐ [136. Single Number](src/bit/Q0136_SingleNumber.java)
- ✅ ⭐ [190. Reverse Bits](src/bit/Q0190_ReverseBits.java)
- ✅ ⭐ [191. Number of 1 Bits](src/bit/Q0191_NumberOf1Bits.java)
- ✅ ⭐ [231. Power of Two](src/bit/Q0231_PowerOfTwo.java)
- ✅ ⭐ [268. Missing Number](src/bit/Q0268_MissingNumber.java)
- ✅ [338. Counting Bits](src/bit/Q0338_CountingBits.java)
- ✅ ⭐ [477. Total Hamming Distance](src/bit/Q0477_TotalHammingDistance.java)

## Math & Geometry  (`math`)

- ✅ ⭐ [7. Reverse Integer](src/math/Q0007_ReverseInteger.java)
- ✅ ⭐ [9. Palindrome Number](src/math/Q0009_PalindromeNumber.java)
- ✅ ⭐ [50. Pow(x, n)](src/math/Q0050_PowXN.java)
- ✅ ⭐ [66. Plus One](src/math/Q0066_PlusOne.java)
- ✅ ⭐ [67. Add Binary](src/math/Q0067_AddBinary.java)
- ✅ ⭐ [149. Max Points on a Line](src/math/Q0149_MaxPointsOnALine.java)
- ✅ ⭐ [202. Happy Number](src/math/Q0202_HappyNumber.java)
- ✅ ⭐ [398. Random Pick Index](src/math/Q0398_RandomPickIndex.java)
- ✅ ⭐ [415. Add Strings](src/math/Q0415_AddStrings.java)
- ✅ ⭐ [2235. Add Two Integers](src/math/Q2235_AddTwoIntegers.java)
- ✅ ⭐ [3625. Count Number of Trapezoids II](src/math/Q3625_CountNumberOfTrapezoidsII.java)

## Matrix Simulation  (`matrix`)

- ✅ ⭐ [48. Rotate Image](src/matrix/Q0048_RotateImage.java)
- ✅ ⭐ [54. Spiral Matrix](src/matrix/Q0054_SpiralMatrix.java)
- ✅ ⭐ [73. Set Matrix Zeroes](src/matrix/Q0073_SetMatrixZeroes.java)
- ✅ [289. Game Of Life](src/matrix/Q0289_GameOfLife.java)
- ✅ ⭐ [498. Diagonal Traverse](src/matrix/Q0498_DiagonalTraverse.java)
- ✅ ⭐ [3030. Find the Grid of Region Average](src/matrix/Q3030_FindTheGridOfRegionAverage.java)

## String / Array Simulation  (`simulation`)

- ✅ ⭐ [6. Zigzag Conversion](src/simulation/Q0006_ZigzagConversion.java)
- ✅ ⭐ [8. String to Integer (atoi)](src/simulation/Q0008_StringToIntegerAtoi.java)
- ✅ ⭐ [12. Integer to Roman](src/simulation/Q0012_IntegerToRoman.java)
- ✅ ⭐ [13. Roman to Integer](src/simulation/Q0013_RomanToInteger.java)
- ✅ ⭐ [14. Longest Common Prefix](src/simulation/Q0014_LongestCommonPrefix.java)
- ✅ ⭐ [28. Find the Index of the First Occurrence in a String](src/simulation/Q0028_FindTheIndexOfTheFirstOccurrenceInAString.java)
- ✅ ⭐ [58. Length of Last Word](src/simulation/Q0058_LengthOfLastWord.java)
- ✅ ⭐ [65. Valid Number](src/simulation/Q0065_ValidNumber.java)
- ✅ ⭐ [273. Integer to English Words](src/simulation/Q0273_IntegerToEnglishWords.java)
- ✅ ⭐ [824. Goat Latin](src/simulation/Q0824_GoatLatin.java)
- ✅ [950. Reveal Cards In Increasing Order](src/simulation/Q0950_RevealCardsInIncreasingOrder.java)
- ✅ ⭐ [1752. Check if Array Is Sorted and Rotated](src/simulation/Q1752_CheckIfArrayIsSortedAndRotated.java)
- ✅ ⭐ [1929. Concatenation of Array](src/simulation/Q1929_ConcatenationOfArray.java)
- ✅ [2073. Time Needed To Buy Tickets](src/simulation/Q2073_TimeNeededToBuyTickets.java)
- ✅ ⭐ [3522. Calculate Score After Performing Instructions](src/simulation/Q3522_CalculateScoreAfterPerformingInstructions.java)

## Sorting  (`sorting`)

- ✅ ⭐ [912. Sort an Array](src/sorting/Q0912_SortAnArray.java)
