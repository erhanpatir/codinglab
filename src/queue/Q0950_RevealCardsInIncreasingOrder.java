package queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Q0950_RevealCardsInIncreasingOrder {
    // 950. Reveal Cards In Increasing Order - Medium
    // https://leetcode.com/problems/reveal-cards-in-increasing-order/description/
    /* ------------------------------------------------------------
       | PATTERN:              Queue                            ✅|
       ------------------------------------------------------------
    /* ⭐ 3. Optimal pattern
            Reveal işlemi pozisyonlarla ilgilidir.
            Kart değerlerini önce sort ederiz:
                [2, 3, 5, 7, 11, 13, 17]

            Sonra şu soruyu sorarız:
                Reveal sırasında hangi index’ler açılıyor?

            Bunu queue ile simüle ederiz.
            Başta index queue:
                [0, 1, 2, 3, 4, 5, 6]

            Her sorted kart için:

                1. Queue’dan bir index çıkar.
                2. O index’e sıradaki küçük kartı koy.
                3. Sonraki index’i queue’dan çıkarıp sona at.

            4. State / invariant
            Queue içinde henüz kart yerleştirilmemiş index’ler tutulur.

            Invariant:
                queue = reveal process'e göre gelecekte açılacak boş pozisyonlar
            Sorted kartları küçükten büyüğe koyduğumuz için, reveal sırası otomatik olarak artan olur.
     */
    /*  Complexity
            Sort: O(n log n)
            Queue simulation: O(n)

            Total Time: O(n log n)
            Space: O(n)
    */
    public static int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);

        int n = deck.length;
        int[] result = new int[n];

        Queue<Integer> queue = new ArrayDeque<>(); // index queue

        for (int i = 0; i < n; i++) {
            queue.offer(i);
        }

        for (int card : deck) {
            int index = queue.poll();
            result[index] = card;

            if (!queue.isEmpty()) {
                queue.offer(queue.poll());
            }
        }

        return result;
    }
}
