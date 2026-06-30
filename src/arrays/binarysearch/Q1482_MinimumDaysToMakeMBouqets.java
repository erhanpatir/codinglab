package arrays.binarysearch;

public class Q1482_MinimumDaysToMakeMBouqets {
    // 1482. Minimum Days To Make M Bouquets - Medium
    // https://leetcode.com/problems/minimum-days-to-make-m-bouquets/
    /* ------------------------------------------------------------
       | PATTERN:     Binary Search  (Find First True)          ✅|
       ------------------------------------------------------------
    /* ⭐ Binary Search on Answer
            Gün arttıkça daha fazla çiçek açar.

            day küçük → bouquet yapılamaz
            day büyük → bouquet yapılabilir

            Yani:
                day:   1   2   3   4   5 ... 10
                can:   F   F   T   T   T ... T
                             ^
                       minimum valid day

            Yine: Find First True

            Search Space
                Minimum gün: min(bloomDay)
                Maximum gün: max(bloomDay)
                left = minBloomDay;
                right = maxBloomDay;

            Predicate
            Şunu soruyoruz:
                Can we make at least m bouquets by given day?

            Yani: canMake(bloomDay, m, k, day)
            Adjacent Mantığı
            Bu sorunun tek farkı burada.

            Bir çiçek açmışsa: bloomDay[i] <= day available.
            Adjacent k tane available çiçek görünce 1 bouquet yaparız.
            Sonra counter sıfırlanır.
     */
    /*  Complexity
        n = bloomDay.length
        D = max(bloomDay) - min(bloomDay)

        Time: O(n log D)
        Space: O(1)
    */
    public static int minDays(int[] bloomDay, int m, int k) {
        long neededFlowers = (long) m * k;

        if (neededFlowers > bloomDay.length) { // yeterli çiçek yoksa -1 dondurur.
            return -1;
        }

        int left  = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;

        for (int day : bloomDay) {
            left = Math.min(left, day);   // min val: en kucuk gun
            right = Math.max(right, day); // max val: en buyuk gun
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canMake(bloomDay, m, k, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static boolean canMake(int[] bloomDay, int m, int k, int day) {
        int bouquets = 0;
        int adjacentFlowers = 0;

        for (int bloom : bloomDay) {
            if (bloom <= day) { // artik çiçek açmış
                adjacentFlowers++;

                if (adjacentFlowers == k) { // yeterli adjacent cicek var ise artik buket yapabiliriz demektir.
                    bouquets++;
                    adjacentFlowers = 0;

                    if (bouquets >= m) { // yeterli bouquets varsa true dondurur.
                        return true;
                    }
                }
            } else {  // adjacent degil ise
                adjacentFlowers = 0;
            }
        }

        return false;
    }

    /*
        DRY RUN
        bloomDay = [1,10,3,10,2]
        m = 3
        k = 1

        Search space:
            left = 1
            right = 10

        day = 5
            [1,10,3,10,2]
             T F T F T

            Bouquets:
            k = 1 olduğu için her T bir bouquet
            count = 3
            true
            Daha küçük gün olabilir.

        day = 2
            [1,10,3,10,2]
             T F F F T

            Bouquets:
            count = 2
            false
            Daha büyük gün lazım.

        day = 3
            [1,10,3,10,2]
             T F T F T

            Bouquets:
            count = 3
            true
            Cevap 3.
    */
}
