package arrays.binarysearch;

import java.util.Random;

public class Q0528_RandomPickWithWeight {
    // 528. Random Pick with Weight - Medium
    // https://leetcode.com/problems/random-pick-with-weight/
    /* ------------------------------------------------------------
       | PATTERN:      Binary Search + Prefix Sum               ✅|
       ------------------------------------------------------------
    /* ⭐ Asıl Fikir
            Array'i büyütmeye gerek yok.
            Onun yerine Prefix Sum tut.

            Prefix Sum
            w = [1,3,2,4]

            Prefix:
                1
                4
                6
                10

            Yani:
                index0 : 1
                index1 : 2 3 4
                index2 : 5 6
                index3 : 7 8 9 10

            Artık: Random 1..10 üretmek yeterli.

            Mapping
            Diyelim random: r = 5

            Prefix:
                1
                4
                6
                10

            Hangi index?
            İlk kez: prefix >= 5 olan yer.
                1
                4
                6
                ^
            Index: 2 Diyelim:

            r = 3

            İlk:
            prefix >= 3
                1
                4
                ^
            Index: 1

            Fark ettin mi?
            Bu tam olarak:
            35 Search Insert Position Sorusu.

            Aradığımız: first prefix >= random
     */
    /*  Complexity
        Constructor: O(n)
        Her pickIndex():
            Binary Search: O(log n)
            Space: O(n)
    */
    class Solution {
        private int[] prefix;
        private int total;
        private Random random;

        public Solution(int[] w) {
            prefix = new int[w.length];
            random = new Random();

            prefix[0] = w[0];

            // build prefix sum array
            for (int i = 1; i < w.length; i++) {
                prefix[i] = prefix[i - 1] + w[i]; // [1...total]
            }

            total = prefix[prefix.length - 1];
        }

        public int pickIndex() {
            // generate a random integer between 1 and total
            int target = random.nextInt(total) + 1;

            int left = 0;
            int right = prefix.length - 1;
            // lower bound binary search
            while (left < right) {

                int mid = left + (right - left) / 2;

                if (prefix[mid] >= target) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            return left;
        }
    }
    /**
     * Your Solution object will be instantiated and called as such:
     * Solution obj = new Solution(w);
     * int param_1 = obj.pickIndex();
     */
    /*
        1. Brute force: "Her index'i weight kadar tekrar eden bir array oluşturabilirim ama bu bellek açısından verimsiz."
        2. Optimizasyon: "Bunun yerine prefix sum ile aynı dağılımı aralıklar olarak temsil edebilirim."
        3. Son adım: "Random sayı üretince artık problem first prefix >= target oluyor; bu da lower bound binary search."
     */
}
