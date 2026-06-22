package stack;

import java.util.Arrays;

public class Q0853_CarFleet {
    // 853. Car Fleet - Medium
    // https://leetcode.com/problems/car-fleet/
    /* ------------------------------------------------------------
       | PATTERN:  Sort by position + compare arrival times     ✅|
       ------------------------------------------------------------
    /*
        Arabaları position’a göre azalan sıralarız:
            hedefe en yakın -> en uzak

        Sonra arrival time hesaplarız.

        ⭐ Kural:
            Arkadan gelen arabanın time'ı <= öndeki fleet time ise,
            ona yetişir ve aynı fleet olur.

        Eğer daha büyükse:
            Yetişemez, yeni fleet olur.
    */

    /*  Complexity
        Sorting var: O(n log n)
        Tek pass: O(n)
        Toplam:
            Time: O(n log n)
            Space: O(n)

        Çünkü arabaları position-time pair olarak tutuyoruz.
    */
    public static int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] cars = new int[n][2];

        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        // pozisyon'a göre azalan siralama
        Arrays.sort(cars, (a, b) -> Integer.compare(b[0], a[0]));

        int fleets = 0;
        double slowestTimeAhead = 0.0;

        for (int[] car : cars) {
            int pos = car[0];
            int spd = car[1];

            // Her araba için hedefe varış süresini hesaplarız
            double currentTime = (double) (target - pos) / spd;

            /*
               currentTime slowestTimeAhead'den buyukse:
                    ondeki fleet'e yetisemez, yeni fleet olur.
               currentTime slowestTimeAhead'den kucukse:
                    ondkei fleet'e yetisir, yeni fleet olmaz.
               */
            if (currentTime > slowestTimeAhead) {
                fleets++;

                // slowestTimeAhead, şu ana kadar oluşmuş en arkadaki fleet'in hedefe varış süresidir.
                slowestTimeAhead = currentTime;
            }
        }
        return fleets;
    }
    /* Dry Run
        Input:
            target = 12
            position = [10,8,0,5,3]
            speed    = [2,4,1,1,3]

        Her araba için time:

        pos 10, speed 2 -> (12 - 10) / 2 = 1
        pos 8,  speed 4 -> (12 - 8)  / 4 = 1
        pos 5,  speed 1 -> (12 - 5)  / 1 = 7
        pos 3,  speed 3 -> (12 - 3)  / 3 = 3
        pos 0,  speed 1 -> (12 - 0)  / 1 = 12

        Position’a göre descending:

        pos 10 -> time 1
        pos 8  -> time 1
        pos 5  -> time 7
        pos 3  -> time 3
        pos 0  -> time 12

        Başlangıç:
            fleets = 0
            slowestTimeAhead = 0
        pos 10, time 1
        Önde fleet yok.

        Yeni fleet:
            fleets = 1
            slowestTimeAhead = 1

        pos 8, time 1
        Arkadan geliyor.
            time = 1
            slowestTimeAhead = 1
            1 <= 1

        Yetişir.

        Yeni fleet değil.
            fleets = 1
            slowestTimeAhead = 1

        pos 5, time 7
            7 > 1
        Öndeki fleet’e yetişemez.

        Yeni fleet:
            fleets = 2
            slowestTimeAhead = 7

        pos 3, time 3
        3 <= 7

        Bu araba normalde hedefe daha hızlı varırdı.
        Ama önündeki yavaş fleet’e yetişir ve onunla gider.

        Yeni fleet değil.

            fleets = 2
            slowestTimeAhead = 7
        pos 0, time 12
            12 > 7

        Öndeki fleet’e yetişemez.
        Yeni fleet:
            fleets = 3
            slowestTimeAhead = 12

        Final: 3
    */
}
