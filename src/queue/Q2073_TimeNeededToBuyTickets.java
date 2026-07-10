package queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class Q2073_TimeNeededToBuyTickets {
    // 2073. Time Needed to Buy Tickets - Easy
    // https://leetcode.com/problems/number-of-recent-calls/description/
    /* ------------------------------------------------------------
       | PATTERN:              Queue                            ✅|
       ------------------------------------------------------------
    /* ⭐ Optimal pattern
            Bu soruda aslında herkesin kaç kere sıraya gireceğini hesaplayabiliriz.
            k kişisinin ihtiyacı:
                target = tickets[k]

            Şu mantık var:
            k’den önceki veya k dahil kişiler, en fazla target kez bilet alabilir.
            k’den sonraki kişiler, k işi bitmeden önce en fazla target - 1 kez bilet alabilir.
            Çünkü k son turunda biletini alır ve işlem orada biter.
            Ondan sonraki kişilere o tur sıra gelmez.

            4. State / invariant
            Toplam süreyi şu şekilde sayarız:
            for each person i:
                if i <= k:
                    contribution = min(tickets[i], tickets[k])
                if i > k:
                    contribution = min(tickets[i], tickets[k] - 1)
            Invariant:
                Her kişinin contribution'ı, k bitene kadar kaç saniye işlem yapabildiğidir.
     */
    /*  Complexity
            Optimal çözüm:
                Time: O(n)
                Space: O(1)

            Queue simülasyonu:
                Time: O(total tickets)
                Space: O(n)
    */
    public static int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Integer> queue = new ArrayDeque<>(); // index queue

        for (int i = 0; i < tickets.length; i++) {
            queue.offer(i);
        }

        int time = 0;

        while (!queue.isEmpty()) {
            int person = queue.poll();

            tickets[person]--;
            time++;

            if (person == k && tickets[person] == 0) {
                return time;
            }

            if (tickets[person] > 0) {
                queue.offer(person);
            }
        }

        return time;
    }

    public static int timeRequiredToBuy_array(int[] tickets, int k) {
        int target = tickets[k];
        int time = 0;

        for (int i = 0; i < tickets.length; i++) {
            if (i <= k) {
                time += Math.min(tickets[i], target);
            } else {
                time += Math.min(tickets[i], target - 1);
            }
        }

        return time;
    }
}
