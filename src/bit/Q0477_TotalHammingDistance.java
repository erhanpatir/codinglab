package bit;

import java.util.*;

public class Q0477_TotalHammingDistance {
    // 477. Total Hamming Distance - Medium
    // https://leetcode.com/problems/total-hamming-distance/

    /* ------------------------------------------------------------
       | PATTERN: Bit Manipulation (bit bit sayma)
       ------------------------------------------------------------
       Her bit pozisyonu için kaç sayıda 1 (a), kaç sayıda 0 (b) olduğunu say.
       O bit pozisyonunun toplam mesafeye katkısı a * b'dir. 32 bitin katkıları toplanır.
    */
    /*  Complexity
        Time  : O(32 * n)
        Space : O(1)
    */

    public static int totalHammingDistance(int[] nums) {
        int ans = 0, n = nums.length;
        for (int i = 0; i < 32; ++i) {
            int a = 0;
            for (int x : nums) {
                a += (x >> i & 1);
            }
            int b = n - a;
            ans += a * b;
        }
        return ans;
    }
}
