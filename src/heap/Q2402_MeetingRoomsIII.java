package heap;

import java.util.*;

public class Q2402_MeetingRoomsIII {
    // 2402. Meeting Rooms III - Hard
    // https://leetcode.com/problems/meeting-rooms-iii/

    /* ------------------------------------------------------------
       | PATTERN: Heap - iki min-heap (boş / meşgul odalar)
       ------------------------------------------------------------
       Toplantıları başlangıca göre sırala. idle: boş odaların indeksleri, busy: (bitiş zamanı, oda).
       Her toplantıda bitmiş odaları busy'den idle'a taşı. Boş oda varsa en küçük indeksliyi kullan;
       yoksa en erken bitecek odayı al, toplantıyı süresi korunarak ertele. En çok kullanılan oda cevap.
    */
    /*  Complexity
        Time  : O(m log m + m log n)
        Space : O(n + m)
    */

    public static int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        PriorityQueue<long[]> busy = new PriorityQueue<>(
            (a, b) -> a[0] == b[0] ? Long.compare(a[1], b[1]) : Long.compare(a[0], b[0]));
        PriorityQueue<Integer> idle = new PriorityQueue<>();
        for (int i = 0; i < n; ++i) {
            idle.offer(i);
        }
        int[] cnt = new int[n];
        for (var v : meetings) {
            int s = v[0], e = v[1];
            while (!busy.isEmpty() && busy.peek()[0] <= s) {
                idle.offer((int) busy.poll()[1]);
            }
            int i = 0;
            if (!idle.isEmpty()) {
                i = idle.poll();
                busy.offer(new long[] {e, i});
            } else {
                var x = busy.poll();
                i = (int) x[1];
                busy.offer(new long[] {x[0] + e - s, i});
            }
            ++cnt[i];
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (cnt[ans] < cnt[i]) {
                ans = i;
            }
        }
        return ans;
    }
}
