package greedy;

import java.util.*;

public class Q0135_Candy {
    // Öncelik   : 🔴 Yüksek  ·  🌍 Ortak soru
    // Şirketler : Google ✅ (#116), Bloomberg ✅ (#105)
    //
    // 135. Candy - Hard
    // https://leetcode.com/problems/candy/

    /* ------------------------------------------------------------
       | PATTERN: Greedy - iki yönlü geçiş
       ------------------------------------------------------------
       left[i]: sadece sol komşu kuralına göre gereken şeker (soldan sağa geçiş).
       right[i]: sadece sağ komşu kuralına göre gereken şeker (sağdan sola geçiş).
       Her çocuk için max(left[i], right[i]) iki kuralı birlikte sağlar; toplamları cevap.
    */
    /*  Complexity
        Time  : O(n)
        Space : O(n)
    */

    public static int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        for (int i = 1; i < n; ++i) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
        }
        for (int i = n - 2; i >= 0; --i) {
            if (ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans += Math.max(left[i], right[i]);
        }
        return ans;
    }
}
