package stack;

import java.util.*;

public class Q0636_ExclusiveTimeOfFunctions {
    // 636. Exclusive Time of Functions - Medium
    // https://leetcode.com/problems/exclusive-time-of-functions/

    /* ------------------------------------------------------------
       | PATTERN: Stack (fonksiyon çağrı yığını)
       ------------------------------------------------------------
       Stack'in tepesi o an çalışan fonksiyon. pre = önceki olayın zamanı.
       start: tepedeki fonksiyona cur - pre ekle, yeni fonksiyonu push et, pre = cur.
       end: tepedeki fonksiyona cur - pre + 1 ekle, pop et, pre = cur + 1.
    */
    /*  Complexity
        Time  : O(n)
        Space : O(n)
    */

    public static int[] exclusiveTime(int n, List<String> logs) {
        int[] ans = new int[n];
        Deque<Integer> stk = new ArrayDeque<>();
        int pre = 0;
        for (var log : logs) {
            var parts = log.split(":");
            int i = Integer.parseInt(parts[0]);
            int cur = Integer.parseInt(parts[2]);
            if (parts[1].charAt(0) == 's') {
                if (!stk.isEmpty()) {
                    ans[stk.peek()] += cur - pre;
                }
                stk.push(i);
                pre = cur;
            } else {
                ans[stk.pop()] += cur - pre + 1;
                pre = cur + 1;
            }
        }
        return ans;
    }
}
