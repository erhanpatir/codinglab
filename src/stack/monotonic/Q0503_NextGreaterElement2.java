package stack.monotonic;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Q0503_NextGreaterElement2 {
    // 503. Next Greater Element II - Medium
    // https://leetcode.com/problems/next-greater-element-ii/
    /* ------------------------------------------------------------
       | PATTERN:     Monotonic stack + 2n loop + i % n         ✅|
       ------------------------------------------------------------
    /*
        Bu yine:
            Next Greater Element
        Ama circular.

        Çözüm fikri:
            ⭐ Array'i iki kere geziyormuş gibi davran.
        Yani:
            0, 1, 2, ..., n-1, 0, 1, 2, ..., n-1
        Bunu gerçekten array kopyalayarak yapmayız.
        Index için: i % n kullanırız.
    */
    /*  Complexity
        Time
            Loop 2n çalışır.
            Her index stack’e bir kere girer, bir kere çıkar.
                O(n)
        Space
            Stack ve answer: O(n)
    */
    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        Arrays.fill(answer, -1);

        Deque<Integer> stack = new ArrayDeque<>(); // index tutacagiz

        for (int i = 0; i < 2 * n; i++) { // Circular array oldugu icin 2n kez geziyoruz
            int index = i % n;

            while (!stack.isEmpty() && nums[index] > nums[stack.peek()]) {
                int previousIndex = stack.pop();
                answer[previousIndex] = nums[index];
            }

            if (i < n)  { // İkinci tur için push yok, ilk tur icin push var
                stack.push(index);
            }
        }
        return answer;
    }
}
