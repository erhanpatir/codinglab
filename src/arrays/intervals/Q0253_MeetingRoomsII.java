package arrays.intervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Q0253_MeetingRoomsII {
    // 253. Meeting Rooms II - Medium
    // https://leetcode.com/problems/meeting-rooms-ii/
    /* ---------------------------------------------------------
       | PATTERN: Min Heap (Priority Queue)                  ✅|
       ---------------------------------------------------------
    */
    /* Complexity Analysis
        Sorting: O(n log n)
        Her interval: heap add/remove -> O(log n)

        Toplam: O(n log n)
        Space: O(n)
    */
    public static int minMeetingRooms(int[][] intervals) {
        // sort meetings by start time
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        // a min heap containing the end times of all currently active meetings
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int[] interval : intervals) {
            if (!minHeap.isEmpty() && minHeap.peek() <= interval[0]) {
                minHeap.poll();
            }
            minHeap.offer(interval[1]);
        }

        return minHeap.size();
    }
}
