package queue.monotonic;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q0862_ShortestSubarrayWithSumAtLeastK {
    // 862. Shortest Subarray with Sum at Least K - Hard
    // https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/description/
    /* ------------------------------------------------------------
       | PATTERN:      Monotonic Queue + Prefix Sum             ✅|
       ------------------------------------------------------------
    /* ⭐Optimal pattern

        Burada prefix sum kullanırız.
            prefix[i] = nums[0] + nums[1] + ... + nums[i - 1]

        Yani:
            sum(j..i-1) = prefix[i] - prefix[j]

        İstediğimiz şey:
            prefix[i] - prefix[j] >= k

        Yani:
            prefix[j] <= prefix[i] - k

        Her i için, daha önceki prefix’ler arasından uygun j bulmak istiyoruz.
        Ama aynı zamanda subarray kısa olsun istiyoruz:

            length = i - j

        Bu yüzden j ne kadar büyükse, subarray o kadar kısa olur.
        Deque içinde candidate prefix index’leri tutarız.

        4. State / invariant
        Deque içinde prefix index’leri tutulur.
        İki invariant var:

        Invariant 1
        Deque index olarak artan sıradadır.
            j1 < j2 < j3

        Invariant 2
        Prefix değerleri artan sıradadır.
            prefix[j1] < prefix[j2] < prefix[j3]

        Neden prefix increasing?
        Çünkü eğer elimizde iki index varsa:
            j1 < j2
            prefix[j2] <= prefix[j1]

        O zaman j1 gereksizdir.

        Çünkü j2:
            daha yeni index  -> daha kısa subarray verir
            daha küçük/eşit prefix -> sum yapmayı daha kolaylaştırır

        Yani j2, j1’i dominate eder.
     */
    /*  Complexity
            Her prefix index deque’e bir kere girer, en fazla bir kere çıkar.
            Time: O(n)
            Space: O(n)
            Prefix sum için long kullanmak daha güvenlidir.
    */
    public static int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] prefixSum = new long[n + 1];

        prefixSum[0] = nums[0];

        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        int answer = Integer.MAX_VALUE;
        Deque<Integer> deque = new ArrayDeque<>(); // increasing deque (prefix degeri kucuk, index degeri buyuk olan)

        for (int i = 0; i <= n; i++) {
            // 1. Check if current prefix can form valid subarray
            /*-------------------------------------------------------------
                Bu şu demek:
                 - Bu başlangıç index’iyle geçerli bir subarray buldum.
                 - Cevabı güncelle.
                - Sonra bu başlangıcı at, çünkü gelecekte daha uzun olur.
            -------------------------------------------------------------*/
            while (!deque.isEmpty() && prefixSum[i] - prefixSum[deque.peekFirst()] >= k) {
                answer = Math.min(answer, i - deque.peekFirst());
                deque.pollFirst();
            }

            // 2. Maintain increasing prefix sums
            /*-------------------------------------------------------------
                Bu şu demek:
                 - Current prefix daha küçük/eşit ve daha yeni.
                 - Kucuk olmasinin sebebi prefix ne kadar küçükse,
                 - aynı bitiş noktası için subarray toplamı o kadar büyük olur.
                 - O yüzden arkadaki eski prefix artık kötü aday.
            -------------------------------------------------------------*/
            while (!deque.isEmpty() && prefixSum[deque.peekLast()] >= prefixSum[i]) {
                deque.pollLast();
            }

            // 3. Add current prefix index
            deque.offerLast(i);
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}
