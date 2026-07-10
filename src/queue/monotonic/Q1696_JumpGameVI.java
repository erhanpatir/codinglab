package queue.monotonic;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q1696_JumpGameVI {
    // 1306. Jump Game VI - Medium
    // https://leetcode.com/problems/jump-game-vi/
    /* ------------------------------------------------------------
       | PATTERN:             Monotonic Queue                   ✅|
       ------------------------------------------------------------
    /* ⭐ Optimal pattern
            Burada sliding window şu:
                Her i için candidate previous indexes = [i-k, i-1]

            Bu pencere içinde en büyük dp[j] lazım.
            O yüzden monotonic deque kullanırız.
            Deque içinde index tutarız ve dp değerine göre decreasing tutulur:
                dp[deque[0]] >= dp[deque[1]] >= dp[deque[2]]

            Böylece:
                deque front = current window içindeki en iyi önceki index

            4. State / invariant
            Invariant:
                Deque, son k index içindeki dp adaylarını tutar.
                dp değerleri decreasing order’dadır.
                Front her zaman en yüksek dp değeridir.

            Her index i için: -------------------------------
            |    Window dışına çıkan index’leri önden sil.  |
            |    dp[i] = nums[i] + dp[deque.peekFirst()].   |
            |    Arkadan dp[i]’den küçük/eşit adayları sil. |
            |    i’yi deque’e ekle.                         |
            -------------------------------------------------
            Başlangıç:
                dp[0] = nums[0]
                deque = [0]
     */
    /*  Complexity
        Her index deque’e bir kere girer, en fazla bir kere çıkar.
            Time: O(n)
            Space: O(n)

        dp array kullanırsak O(n) space.
        İstersek nums üzerinde in-place DP yapabiliriz ama interview’da ayrı dp daha temiz anlatılır.
    */
    public static int maxResult(int[] nums, int k) {
        int n = nums.length;

        // ⭐ index i'ye gelindiğinde alınabilecek maksimum skor
        int[] dp = new int[n];
        dp[0] = nums[0];

        Deque<Integer> deque = new ArrayDeque<>(); // son k index içindeki dp adayi indexleri tutar
        deque.offerLast(0);

        for (int i = 1; i < n; i++) {
            // 1. Remove indexes outside the valid jump range
            while (!deque.isEmpty() && deque.peekFirst() < i - k) {
                deque.pollFirst();
            }

            // 2. Best previous dp is at the front
            dp[i] = nums[i] + dp[deque.peekFirst()];

            // 3. Maintain decreasing dp values
            while (!deque.isEmpty() && dp[deque.peekLast()] <= dp[i]) {
                deque.pollLast();
            }

            // 4. Add current index
            deque.offerLast(i);
        }

        return dp[n - 1];
    }
}
