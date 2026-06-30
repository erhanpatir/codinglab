package arrays.binarysearch;

public class Q1011_CapacityToShipPackagesWithinDDays {
    // 1011. Capacity To Ship Packages Within D Days - Medium
    // https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
    /* ----------------------------------------------------------------------
       | PATTERN:      Binary Search on Answer (Find First True)          ✅|
       ----------------------------------------------------------------------
    /* ⭐ Binary Search on Answer
            Capacity arttıkça gereken gün sayısı azalır.

                capacity küçük → yetişmez
                capacity büyük → yetişir

            Yani:
                capacity:  10  11  12  13  14  15  16 ...
                canShip:   F   F   F   F   F   T   T
                                            ^
                                     minimum valid capacity

            Bu yine: Find First True
        ----------------------------------------------------------------------
          Search Space
            Minimum capacity: max(weights)
            Çünkü gemi en ağır paketi bile taşıyabilmeli.

            Maximum capacity: sum(weights)
            Çünkü tüm paketleri tek günde gönderebiliriz.

            left = maxWeight;
            right = totalWeight;
     */
    /*  Complexity
            n = weights.length
            S = sum(weights)

            Time: O(n log S)
            Space: O(1)
    */
    public static int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;

        for (int weight : weights) {
            left = Math.max(left, weight); // min capacity: en ağır paket
            right += weight;               // max capacity: toplam
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canShip(weights, days, mid)) {
                right = mid - 1;    // true ise, daha az gunde tasima ihtimali var
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private static boolean canShip(int[] weights, int days, int capacity) {
        int neededDays = 1;
        int currentLoad = 0;

        for (int weight : weights) {
            if (currentLoad + weight > capacity) {
                neededDays++;
                currentLoad = 0;
            }

            currentLoad += weight;

            if (neededDays > days) {
                return false;
            }
        }

        return true;
    }
    /* Dry Run
        weights = [1,2,3,4,5,6,7,8,9,10]
        days = 5

        Search space:
            left = 10
            right = 55
            mid = 32

        Capacity 32 ile:

        Day 1: 1 2 3 4 5 6 7 = 28
        Day 2: 8 9 10 = 27
        2 days <= 5 → true

        Daha küçük capacity olabilir.

        right = mid - 1;

        mid = 20
            Day 1: 1 2 3 4 5 = 15
            Day 2: 6 7 = 13
            Day 3: 8 9 = 17
            Day 4: 10
            4 days <= 5 → true

            Daha küçük olabilir.

        mid = 14
            Day 1: 1 2 3 4 = 10
            Day 2: 5 6 = 11
            Day 3: 7
            Day 4: 8
            Day 5: 9
            Day 6: 10
            6 days > 5 → false

            Capacity yetmedi.

        mid = 17
            Day 1: 1 2 3 4 5 = 15
            Day 2: 6 7 = 13
            Day 3: 8 9 = 17
            Day 4: 10
            4 days <= 5 → true

        mid = 15
            Day 1: 1 2 3 4 5 = 15
            Day 2: 6 7 = 13
            Day 3: 8
            Day 4: 9
            Day 5: 10
            5 days <= 5 → true

        Loop sonunda cevap: 15
     */
}
