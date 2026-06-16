package arrays.greedy;

import java.util.PriorityQueue;

public class Q1642_FurthestBuildingYouCanReach {
    // 1642. Furthest Building You Can Reach - Medium
    // https://leetcode.com/problems/furthest-building-you-can-reach/description/
    // ------------------------------------------------------
    // | PATTERN:        Min Heap + Greedy               ✅ |
    // ------------------------------------------------------
    /*
        Ana fikir:
            Ladder’ları en büyük yükselişlere sakla.
            Bricks’i küçük yükselişlerde kullan.

        Bunu online şekilde yapmak için min heap kullanırız.

        Her pozitif climb’ı heap’e koyarız.
            heap = ladder ile karşılamayı düşündüğümüz climb'lar

        Eğer heap size ladder sayısını geçerse:
            en küçük climb'ı heap'ten çıkar
            onu brick ile öde

        Böylece heap içinde her zaman en büyük climb’lar kalır.
     */
    /* Complexity
         Time: O(n log L)
         Space: O(L)
         Burada L = ladders.
         Çünkü heap size en fazla ladders + 1 olur.
    */
    public static int furthestBuilding(int[] heights, int bricks, int ladders) {
        // Heap içinde şu ana kadar ladder ile karşılanacak climb’lar tutulur.
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < heights.length; i++) {
            int diff = heights[i + 1] - heights[i];

            if (diff <= 0) continue; // free

            minHeap.offer(diff);

            if (minHeap.size() > ladders) {
                bricks -= minHeap.poll(); // use bricks for small climbs
            }

            if (bricks < 0) {
                return i;
            }
        }
        return heights.length - 1;
    }
}
