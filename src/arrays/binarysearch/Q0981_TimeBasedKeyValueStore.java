package arrays.binarysearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q0981_TimeBasedKeyValueStore {
    // 981. Time Based Key-Value Store - Medium
    // https://leetcode.com/problems/time-based-key-value-store/
    /* ------------------------------------------------------------
       | PATTERN:      Binary Search (Find Last True)           ✅|
       ------------------------------------------------------------
    /* ⭐ Optimal Pattern
            Her key için timestamp sırasına göre list tut:
                foo:
                (1, "bar"), (4, "bar2")

            get("foo", 3):
                timestamp <= 3 olan son kayıt

            Yani:
                last timestamp <= target
            Bu da binary search.
        ------------------------------------------------------
        State
            Map<String, List<Pair>>
        Her key için liste:
            (timestamp, value)
        LeetCode bu soruda set timestamp’lerinin increasing geldiğini garanti eder.
        Bu yüzden listeye direkt append yapabiliriz.

        Binary Search Mantığı
        Aradığımız:
            last timestamp <= target
        Örnek:
            timestamps = [1, 4, 8, 10]
            target = 6

        Cevap:
            index = 1
            timestamp = 4

        Bu last true problemidir:

        timestamp <= target
            1   4   8   10
            T   T   F   F
                ^
             "last true"
     */
    /*  Complexity
        Let:
            n = number of values for a key

            set: O(1)
            get: O(log n)
            space: O(total number of set calls)
    */
}

class TimeMap {

    private Map<String, List<Entry>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>())
                .add(new Entry(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }

        List<Entry> entries = map.get(key);

        int left = 0;
        int right = entries.size() - 1;
        String result = "";

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (entries.get(mid).timestamp <= timestamp) {
                result = entries.get(mid).value;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    private static class Entry {
        int timestamp;
        String value;

        Entry(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
