package heap;

import java.util.*;

public class Q0621_TaskScheduler {
    // Öncelik   : ⭐ Gerçek deneyim
    // Şirketler : Amazon ✅ (#53), Apple ✅ (#80)
    // Seviye    : Mid
    // Raporlar  : 1
    //             https://medium.com/@saiteja.dasari123/interview-experience-sde-2-at-amazon-accepted-offer-57655fab76b8
    //
    // 621. Task Scheduler - Medium
    // https://leetcode.com/problems/task-scheduler/description/

    /* ------------------------------------------------------------
       | PATTERN: Greedy / Math (en sık görev formülü)
       ------------------------------------------------------------
       En sık görev x kez geçiyorsa, (x - 1) blok oluşur, her blok n + 1 uzunlukta,
       son bloğa en sık frekansa sahip s görev girer: (x - 1) * (n + 1) + s.
       Boşluklar diğer görevlerle doldurulabiliyorsa cevap görev sayısıdır: max(tasks.length, formül).
       Heap ile simülasyon da mümkündür ama formül O(n).
    */
    /*  Complexity
        Time  : O(n)
        Space : O(1) (26 harf)
    */

    public static int leastInterval(char[] tasks, int n) {
        int[] cnt = new int[26];
        int x = 0;
        for (char c : tasks) {
            c -= 'A';
            ++cnt[c];
            x = Math.max(x, cnt[c]);
        }
        int s = 0;
        for (int v : cnt) {
            if (v == x) {
                ++s;
            }
        }
        return Math.max(tasks.length, (x - 1) * (n + 1) + s);
    }
}
