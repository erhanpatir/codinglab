package heaps;

import java.util.*;

public class Q0347_TopKFrequentElements {
    // 347. Top K Frequent Elements - Medium
    // https://leetcode.com/problems/top-k-frequent-elements/

    // ------------------------------------------------------
    // | PATTERN: Frequency Map + Bucket Sort             ✅|
    // ------------------------------------------------------
    /* Frekans sayıyoruz:

        number -> frequency
        Sonra şunu fark ediyoruz:
            Bir sayının frekansı en fazla n olabilir.
            Yani bucket array kurabiliriz:
            bucket[frequency] = bu frekanstaki sayılar

        Örnek:
            nums = [1,1,1,2,2,3]

        Frequency map:
            1 -> 3
            2 -> 2
            3 -> 1

        Bucket:
            bucket[1] = [3]
            bucket[2] = [2]
            bucket[3] = [1]

        Sonra bucket’ı sondan başa gezeriz.
            frequency 3 -> [1]
            frequency 2 -> [2]
        k eleman tamam.
    */
    /*
        Time: O(n * k log k)
        Space: O(n * k)
    */
    public static int[] topKFrequent_bucketsort(int[] nums, int k) {
        Map<Integer, Integer> frequency = new HashMap<>();
        // frequency leri hesaplıyoruz.
        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }

        // bucket sort için buckets array'ini oluşturuyoruz.
        List<Integer>[] buckets = new List[nums.length + 1];

        // frequency leri buckets array'ine yerleştiriyoruz.
        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();

            if (buckets[count] == null) {
                buckets[count] = new ArrayList<>();
            }

            buckets[count].add(num);
        }

        int[] result = new int[k];
        int index = 0;

        for (int freq = buckets.length - 1; freq >= 0; freq--) {
            if (buckets[freq] == null) continue;

            for (int num : buckets[freq]) {
                result[index++] = num;

                if (index == k) {
                    return result;
                }
            }
        }
        return result;
    }

    /*
        Time: O(n log k)
        Space: O(n)
    */
    // Eğer “top K” duyarsan önce heap düşün
    public static int[] topKFrequent_priorityQueue(int[] nums, int k) {
        Map<Integer, Integer> frequency = new HashMap<>();

        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> minHeap =
                new PriorityQueue<>((a, b) -> frequency.get(a) - frequency.get(b));

        for (int num : frequency.keySet()) {
            minHeap.offer(num);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll();
        }
        return result;
    }
}
