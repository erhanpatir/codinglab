package arrays.intervals;

import java.util.ArrayList;
import java.util.List;

public class Q0057_InsertInterval {
    // 57. Insert Interval - Medium
    // https://leetcode.com/problems/insert-interval/
    /* ---------------------------------------------------------
       | PATTERN: Sort by start + merge current interval     ✅|
       ---------------------------------------------------------
       Interval'ları 3 parçaya ayır.
        Bölüm 1
        Yeni interval'den tamamen solda olanlar.
            interval.end < newInterval.start
        Örnek:
            [1,2]    [4,8]

        Bunlar asla merge olmaz.
        Direkt sonuca ekle.

        Bölüm 2
        Yeni interval ile overlap edenler.
        Kural:
            interval.start <= newInterval.end
        olduğu sürece merge et.

        newInterval.start =
            Math.min(newInterval.start, interval.start);
        newInterval.end =
            Math.max(newInterval.end, interval.end);

        Bölüm 3
        Yeni interval'in tamamen sağında kalanlar.
            interval.start > newInterval.end

        Bunlar da direkt eklenir.
    */
    /* Complexity Analysis
        Time:  O(n)
        Space: O(n)
    */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();

        int i = 0;

        // left side (interval.end < newInterval.start)
        while (i < intervals.length
                && intervals[i][1] < newInterval[0]) {

            result.add(intervals[i]);
            i++;
        }

        // merge  (interval.start <= newInterval.end)
        while (i < intervals.length
                && intervals[i][0] <= newInterval[1]) {

            newInterval[0] =
                    Math.min(newInterval[0], intervals[i][0]);

            newInterval[1] =
                    Math.max(newInterval[1], intervals[i][1]);

            i++;
        }

        result.add(newInterval);

        // right side (interval.start > newInterval.end)
        while (i < intervals.length) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }
}
