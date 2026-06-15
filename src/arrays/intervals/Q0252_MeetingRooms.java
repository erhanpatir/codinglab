package arrays.intervals;

import java.util.Arrays;
import java.util.Comparator;

public class Q0252_MeetingRooms {
    // 252. Meeting Rooms - Easy
    // https://leetcode.com/problems/meeting-rooms/
    /* ------------------------------------------
       | PATTERN: Sort + Interval Overlap     ✅|
       ------------------------------------------
       Sort by start time
        Meetingleri başlangıç zamanına göre sırala.
        Sonra sadece komşu meetingleri kontrol et.

        Neden?
            Çünkü start time’a göre sorted ise
            bir meeting en çok kendisinden hemen sonraki meeting ile problem çıkarabilir.
            previous.end > current.start ise overlap vardır.

        3. State / Invariant
        State:
            previous interval
            current interval

        Invariant:
            Intervals start time’a göre sıralı olduğu için, current meeting sadece önceki meeting’in end time’ı ile kontrol edilmelidir.

        Overlap condition:
            previousEnd > currentStart

        Dikkat:
            previousEnd == currentStart overlap değildir.
            Çünkü biri biter bitmez diğeri başlayabilir.
    */
    /* Complexity Analysis
        Time: O(nlogn)
        Space: O(1)
    */
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        for (int i = 1; i < intervals.length; i++) {
            int previousEnd = intervals[i - 1][1]; // the end of prev
            int currentStart = intervals[i][0];    // the start of curr

            if (previousEnd > currentStart) {
                return false;
            }
        }

        return true;
    }
}
