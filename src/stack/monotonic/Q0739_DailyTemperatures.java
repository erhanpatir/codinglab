package stack.monotonic;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q0739_DailyTemperatures {
    // 739. Daily Temperatures - Medium
    // https://leetcode.com/problems/daily-temperatures/
    /* ------------------------------------------------------
       | PATTERN:         Monotonic Stack                 ✅|
       ------------------------------------------------------
    /*
        Stack içinde index tutacağız.
        Neden value değil index?
        Çünkü cevap için gün farkı lazım:
            i - previousIndex

        Stack’in tuttuğu şey:
            Henüz daha sıcak günü bulunmamış günlerin indexleri
        Stack sıcaklık olarak decreasing kalır.
        Yani stack’teki indexlerin sıcaklıkları şöyle görünür:

        75, 71, 69

        Yeni gelen sıcaklık daha yüksekse, stack’in tepesindeki günlerin cevabı bulunmuş olur.
    */
    /*  Complexity
            Time: O(n)
            Space: O(n)
    */
    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];

        Deque<Integer> stack = new ArrayDeque<>(); // index tutar

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty()
                    && temperatures[i] > temperatures[stack.peek()]) {

                int previousIndex = stack.pop();
                answer[previousIndex] = i - previousIndex;
            }

            stack.push(i);
        }

        return answer;
    }
}
