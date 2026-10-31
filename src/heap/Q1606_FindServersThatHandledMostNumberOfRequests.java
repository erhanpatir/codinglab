package heap;

import java.util.*;

public class Q1606_FindServersThatHandledMostNumberOfRequests {
    // 1606. Find Servers That Handled Most Number of Requests - Hard
    // https://leetcode.com/problems/find-servers-that-handled-most-number-of-requests/

    /* ------------------------------------------------------------
       | PATTERN: Heap + TreeSet (boş sunucu arama)
       ------------------------------------------------------------
       busy: (bitiş zamanı, sunucu) min-heap; free: boş sunucuların TreeSet'i.
       Her istekte bitmiş sunucuları busy'den free'ye taşı. free'de i % k'dan büyük ya da eşit ilk sunucuyu ara
       (ceiling), yoksa en küçüğünü al (dairesel). En çok istek alan sunucuları döndür.
    */
    /*  Complexity
        Time  : O(n log k)
        Space : O(k)
    */

    public static List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int[] cnt = new int[k];
        PriorityQueue<int[]> busy = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        TreeSet<Integer> free = new TreeSet<>();
        for (int i = 0; i < k; ++i) {
            free.add(i);
        }
        for (int i = 0; i < arrival.length; ++i) {
            int start = arrival[i];
            int end = start + load[i];
            while (!busy.isEmpty() && busy.peek()[0] <= start) {
                free.add(busy.poll()[1]);
            }
            if (free.isEmpty()) {
                continue;
            }
            Integer server = free.ceiling(i % k);
            if (server == null) {
                server = free.first();
            }
            ++cnt[server];
            busy.offer(new int[] {end, server});
            free.remove(server);
        }
        int mx = 0;
        for (int v : cnt) {
            mx = Math.max(mx, v);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; ++i) {
            if (cnt[i] == mx) {
                ans.add(i);
            }
        }
        return ans;
    }
}
