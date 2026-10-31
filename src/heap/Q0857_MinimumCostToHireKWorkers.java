package heap;

import java.util.*;

public class Q0857_MinimumCostToHireKWorkers {
    // Öncelik   : ⭐ Gerçek deneyim
    // Şirketler : Apple ✅ (#24)
    // Raporlar  : 1
    //             https://www.vervecopilot.com/blog/apple-leetcode-interview-questions
    //
    // 857. Minimum Cost to Hire K Workers - Hard
    // https://leetcode.com/problems/minimum-cost-to-hire-k-workers/

    /* ------------------------------------------------------------
       | PATTERN: Heap + Greedy (oran sırası)
       ------------------------------------------------------------
       Bir grupta herkese ödenen oran, gruptaki en yüksek wage/quality oranıdır; maliyet = oran * toplam kalite.
       İşçileri orana göre artan sırala. Gezerken mevcut işçi oranı belirler; toplam kaliteyi küçük tutmak için
       max-heap ile en düşük k kaliteyi tut. Heap k elemana ulaşınca maliyeti hesapla.
    */
    /*  Complexity
        Time  : O(n log n)
        Space : O(n)
    */

    public static double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        Integer[] order = new Integer[n];
        for (int i = 0; i < n; i++) order[i] = i;
        // ücret/kalite oranına (wage/quality) göre artan sırala
        Arrays.sort(order, (a, b) -> Double.compare((double) wage[a] / quality[a], (double) wage[b] / quality[b]));
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int qualitySum = 0;
        double best = Double.MAX_VALUE;
        for (int i : order) {
            maxHeap.offer(quality[i]);
            qualitySum += quality[i];
            if (maxHeap.size() > k) qualitySum -= maxHeap.poll();
            if (maxHeap.size() == k) best = Math.min(best, qualitySum * ((double) wage[i] / quality[i]));
        }
        return best;
    }
}
