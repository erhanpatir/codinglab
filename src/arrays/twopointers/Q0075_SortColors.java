package arrays.twopointers;

import java.util.Arrays;

public class Q0075_SortColors {
    // 75. Sort Colors - Medium
    // https://leetcode.com/problems/sort-colors/

    // -------------------------------------------------------------
    // |PATTERN: Dutch National Flag.                            ✅|
    // -------------------------------------------------------------
    /*
        Üç pointer kullanırız:
            low
            mid
            high

        Amaç:
            [0 ... low-1]     -> 0'lar
            [low ... mid-1]   -> 1'ler
            [mid ... high]    -> unknown
            [high+1 ... end]  -> 2'ler
        mid unknown bölgeyi tarar.

        3. State / Invariant
        Invariant çok önemli:

            0 ... low-1       => all 0
            low ... mid-1     => all 1
            mid ... high      => unknown
            high+1 ... n-1    => all 2

        Kurallar:

        nums[mid] == 0
        0 solda olmalı.

            swap(nums, low, mid);
            low++;
            mid++;

        nums[mid] == 1
        1 zaten ortada olmalı.

            mid++;

        nums[mid] == 2
        2 sağda olmalı.

            swap(nums, mid, high);
            high--;

        Dikkat:
            nums[mid] == 2 durumunda mid++ yapmıyoruz.
            Çünkü sağdan gelen yeni değeri henüz kontrol etmedik.
    */
    /*
        Time: O(n)
        Space: O(1)
    */
    public static void sortColors(int[] nums) {

        /* Interview Explanation
            “Since the array contains only three values, I use the Dutch National Flag algorithm.
            I maintain three regions: zeros on the left, twos on the right, and unknown elements in the middle.
            The mid pointer scans the unknown region.
            When I see a 0, I swap it to the left.
            When I see a 2, I swap it to the right.
            When I see a 1, I just move forward.”
        */
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, low);
                high--;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
