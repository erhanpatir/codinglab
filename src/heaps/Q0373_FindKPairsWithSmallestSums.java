package heaps;

import java.util.*;

public class Q0373_FindKPairsWithSmallestSums {
    // 373. Find K Pairs with Smallest Sums - Medium
    // https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
    // ------------------------------------------------------
    // | PATTERN: Min Heap + Sorted Arrays                ✅|
    // ------------------------------------------------------
    /*
        Array’ler sorted olduğu için her nums1[i] için en küçük pair şudur:
            (nums1[i], nums2[0])

        Yani başlangıçta heap’e şunları koyabiliriz:
            [nums1[0], nums2[0]]
            [nums1[1], nums2[0]]
            [nums1[2], nums2[0]]
            ...

        Ama en fazla k tane koymak yeterli.
        Heap her zaman en küçük sum’lı pair’i çıkarır.

        Bir pair çıkınca: (i, j)

        sonraki aday: (i, j + 1) olur.

        Küçük Görsel
            nums1 = [1,7,11]
            nums2 = [2,4,6]

        Matrix gibi düşün:

                  nums2
                  2    4    6
        nums1 1   3    5    7
              7   9   11   13
             11  13   15   17

        Her hücre: nums1[i] + nums2[j]

        İstenen: en küçük k hücre

        Sorted olduğu için her satır soldan sağa artıyor.
    */
    /*
        Time: O(n log k)
        Space: O(k)
    */
    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return result;
        }

        // pair leri toplamına göre siralayan min heap oluştur
        PriorityQueue<int[]> minHeap =
                new PriorityQueue<>(
                        Comparator.comparingInt(
                                a -> nums1[a[0]] + nums2[a[1]])
                        );

        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            minHeap.offer(new int[] {i, 0}); // heap sadece index leri tutuyor
        }

        while (k > 0 && !minHeap.isEmpty()) {
            int[] current = minHeap.poll(); // pop the smallest pair

            int i = current[0];
            int j = current[1];

            result.add(Arrays.asList(nums1[i], nums2[j]));

            if (j + 1 < nums2.length) {
                minHeap.offer(new int[] {i, j + 1}); // add the next pair from the same row
            }
            k--;
        }

        return result;
    }
}
