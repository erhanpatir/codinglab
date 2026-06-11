package arrays.slidingwindow;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q0239_SlidingWindowMaximum {
    // 239. Sliding Window Maximum - Hard
    // https://leetcode.com/problems/sliding-window-maximum/
    /* ------------------------------------------
       | PATTERN: Monotonic Deque              ✅|
       -------------------------------------------
       Deque içinde index tutarız.
        Ama özel kural var:
            Deque içindeki değerler büyükten küçüğe sıralı kalır.
            Yani deque’in başı her zaman current window’un maksimumudur.

        3. State / Invariant
        State:
        Deque<Integer> deque
            Deque index tutar.

        Invariant:
            nums[deque[0]] >= nums[deque[1]] >= nums[deque[2]] ...

        Yani:
            Deque’in başındaki index, current window’un maksimum elemanıdır. ✅

        Her right için 3 şey yaparız:
        1. Window dışına çıkan index’i sil
            if (!deque.isEmpty() && deque.peekFirst() <= right - k) {
                deque.pollFirst();
            }
        2. Yeni elemandan küçük olanları arkadan sil
        Çünkü yeni eleman daha büyükse, eski küçük elemanlar artık hiçbir future window’da maksimum olamaz.
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[right]) {
                deque.pollLast();
            }
        3. Yeni index’i ekle
            deque.offerLast(right);

        Window oluştuysa answer yaz:
            if (right >= k - 1) {
                result[right - k + 1] = nums[deque.peekFirst()];
            }
    */
    /* Complexity
        Time: O(n)
        Space: O(k)
        Her index deque’e en fazla bir kere girer, en fazla bir kere çıkar.
    */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];

        // Deque index tutar.
        // Deque içindeki değerler büyükten küçüğe sıralı kalır.
        // Yani deque’in başı her zaman current window’un maksimumudur.
        Deque<Integer> deque = new ArrayDeque<>();

        for (int right = 0; right < n; right++) {
            // Window dışına çıkan index’i sil
            while (!deque.isEmpty() && deque.peekFirst() <= right - k) {
                deque.pollFirst();
            }
            // Yeni elemandan küçük olanları arkadan sil
            while (!deque.isEmpty() && deque.peekLast() < nums[right]) {
                deque.pollLast();
            }
            // Yeni index’i ekle
            deque.offerLast(right);

            // Window oluştuysa answer yaz
            if (right >= k - 1) {
                result[right - k + 1] = nums[deque.peekFirst()];
            }
        }

        return result;
    }
}
