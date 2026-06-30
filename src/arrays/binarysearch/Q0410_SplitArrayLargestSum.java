package arrays.binarysearch;

public class Q0410_SplitArrayLargestSum {
    // 410. Split Array Largest Sum - Hard
    // https://leetcode.com/problems/split-array-largest-sum/
    /* ------------------------------------------------------------
       | PATTERN:     Binary Search (Find First True)           ✅|
       ------------------------------------------------------------
    /* ⭐ Binary Search on Answer
            Cevap ne olabilir?

            Minimum possible answer: max(nums)
            Çünkü herhangi bir parça en az en büyük elemanı içermek zorunda.

            Maximum possible answer: sum(nums)
            Çünkü tek parça yaparsak tüm toplam olur.

                left = max(nums)
                right = sum(nums)

            Predicate
            Şunu soruyoruz:
            Can we split nums into at most k subarrays such that each subarray sum <= X?
            Yani:
                canSplit(nums, k, maxAllowedSum)

            Monotonic yapı
            X küçük  → split etmek zor / mümkün değil
            X büyük  → mümkün

            Örneğin:
            X:        10  11  12  13  14  15  16  17  18  19
            can:       F   F   F   F   F   F   F   F   T   T
                                                  ^
                                          minimum valid X

            Yani yine: Find First True
     */
    /*  Complexity
        n = nums.length
        S = sum(nums)

        Time: O(n log S)
        Space: O(1)
    */
    public static int splitArray(int[] nums, int k) {
        int left = 0;
        int right = 0;

        for (int num : nums) {
            left = Math.max(left, num);
            right += num;
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canSplit(nums, k, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private static boolean canSplit(int[] nums, int k, int maxAllowedSum) {
        int subarrays = 1;
        int currentSum = 0;

        for (int num : nums) {
            if (currentSum + num > maxAllowedSum) {
                subarrays++;
                currentSum = 0;
            }

            currentSum += num;

            if (subarrays > k) {
                return false;
            }
        }
        return true;
    }

    /* 1011 ile Aynı mı?
        Evet, neredeyse birebir aynı.

        1011:
            weights’i days güne böl
            her günün toplamı capacity’yi geçmesin
            minimum capacity

        410:
            nums’ı k subarray’e böl
            her subarray toplamı maxAllowedSum’ı geçmesin
            minimum maxAllowedSum

        Şablon aynı:
            left = max(nums)
            right = sum(nums)

            if (can(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            return left;
    */
}
