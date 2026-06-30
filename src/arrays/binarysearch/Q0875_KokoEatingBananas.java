package arrays.binarysearch;

public class Q0875_KokoEatingBananas {
    // 875. Koko Eating Bananas - Medium
    // https://leetcode.com/problems/koko-eating-bananas/
    /* ------------------------------------------------------------
       | PATTERN:     Binary Search  (Find First True)          ✅|
       ------------------------------------------------------------
    /* ⭐ Kritik Gözlem
            Hız arttıkça gereken saat azalır.
                k küçük  → yetişemez
                k büyük  → yetişir

            Yani şöyle bir yapı var:
            k:       1   2   3   4   5   6   ...
            canEat:  F   F   F   T   T   T
                                ^
                          minimum valid k
             ------------------------------------------------
             ⭐ Bu tam olarak: "Find First True" problemidir.
             ------------------------------------------------
            Search Space
                Minimum hız: 1
                Maximum hız: max(piles)

            Neden?
            Çünkü en büyük pile’ı 1 saatte bitirebilen hızdan fazlasına gerek yok.
                left = 1;
                right = maxPile;
     */
    /*  Complexity
            n = piles.length
            m = max(piles)

            Time: O(n log m)
            Space: O(1)
    */
    public static int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0; // en büyük pile’ı 1 saatte bitirebilen hızdan fazlasına gerek yok.

        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canFinish(piles, h, mid)) {
                right = mid - 1;  // Bu hız yeterli ama daha küçüğü olabilir.
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private static boolean canFinish(int[] piles, int h, int speed) {
        long hours = 0;

        for (int pile : piles) {
            hours += (pile + speed - 1) / speed;
            /*
                Bir pile için gereken saat: ceil(pile / k)
                Java’da double kullanmadan:
                    (pile + k - 1) / k
            */

            if (hours > h) {
                return false;
            }
        }

        return hours <= h;
    }

    /* Dry Run
        piles = [3,6,7,11]
        h = 8

        Search space:
            left = 1
            right = 11

        1. adım
            mid = 6

            Saat hesabı:
                3  → 1
                6  → 1
                7  → 2
                11 → 2

            total = 6
            6 <= 8 → true

            Bu hız yeterli ama daha küçüğü olabilir.
            right = mid - 1;

        2. adım
            left = 1
            right = 5
            mid = 3

            Saat:
                3  → 1
                6  → 2
                7  → 3
                11 → 4

            total = 10
            10 > 8 → false

            Hız yetmedi, daha hızlı yemeli.
            left = mid + 1;

        3. adım
            left = 4
            right = 5
            mid = 4

            Saat:
                3  → 1
                6  → 2
                7  → 2
                11 → 3

            total = 8
            true

            Daha küçüğü olabilir.
            right = mid - 1;

        Loop biter:

        left = 4
        right = 3

        Cevap: return left;
    */
}

