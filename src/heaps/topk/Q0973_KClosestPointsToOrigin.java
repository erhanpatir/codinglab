package heaps.topk;

import java.util.PriorityQueue;

public class Q0973_KClosestPointsToOrigin {
    // 973. K Closest Points to Origin - Medium
    // https://leetcode.com/problems/k-closest-points-to-origin/
    // ------------------------------------------------------
    // | PATTERN: Max Heap of Size K                     ✅ |
    // ------------------------------------------------------
    /*
        En yakın k point’i tutmak istiyoruz.\
        Heap içinde sadece k point tutarız.
        Ama neden max heap?
        Çünkü elimizdeki k point içinde en uzak olanı hızlıca atmak isteriz.

        Mantık:
            Her point'i heap'e ekle
            Heap size > k olursa en uzak point'i çıkar
            Böylece heap’te daima en yakın k point kalır.

     */
    /*  ---------------------------------------------------------
        | Comparator Notu                                       |
        ---------------------------------------------------------
        Bu satır:
            (a, b) -> distance(b) - distance(a)

        max heap yapar. ✅

        Çünkü Java PriorityQueue DEFAULT olarak min heap’tir.✅
        Biz uzak olanın önce gelmesini istiyoruz.

        Daha güvenli yazım:
            (a, b) -> Integer.compare(distance(b), distance(a))

        Bu overflow riskini azaltır.
        ---------------------------------------------------------
    */
    /* Complexity
         Time: O(n log k)
         Space: O(k)
         Çünkü heap size en fazla k.
    */
    public static int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> maxHeap =
                new PriorityQueue<>(
                        (a, b) -> distance(b) - distance(a));
                     // (a, b) -> Integer.compare(distance(b), distance(a));

        for (int[] point : points) {
            maxHeap.offer(point);

            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] result = new int[k][2];

        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll();
        }

        return result;
        //  return maxHeap.toArray(new int[k][2]);
    }

    private static int distance(int[] point) {
        int x = point[0];
        int y = point[1];

        return x * x + y * y;
    }
    /* Max Heap Nasıl Yapılır?
       Comparator ters çevrilir.

      PriorityQueue<Integer> maxHeap =
          new PriorityQueue<>((a, b) -> b - a);

      veya daha güvenlisi:

      PriorityQueue<Integer> maxHeap =
          new PriorityQueue<>(Comparator.reverseOrder());
    */
}
