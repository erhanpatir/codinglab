package design;

import java.util.*;

public class Q1146_SnapshotArray {
    // 1146. Snapshot Array - Medium
    // https://leetcode.com/problems/snapshot-array/

    /* ------------------------------------------------------------
       | PATTERN: Design - Binary Search (değişiklik geçmişi)
       ------------------------------------------------------------
       Her indeks için (snap_id, değer) değişiklik listesi tut; set sadece listeye ekler.
       snap() sayacı artırır. get(index, snap_id): o indeksin listesinde snap_id'den küçük ya da eşit
       son kaydı binary search ile bul. Her snap'te tüm diziyi kopyalamaktan kaçınılmış olur.
    */
    /*  Complexity
        Time  : set/snap O(1), get O(log n)
        Space : O(set çağrısı sayısı)
    */

    public class SnapshotArray {
        private List<int[]>[] arr;
        private int idx;

        public SnapshotArray(int length) {
            arr = new List[length];
            Arrays.setAll(arr, k -> new ArrayList<>());
        }

        public void set(int index, int val) {
            arr[index].add(new int[] {idx, val});
        }

        public int snap() {
            return idx++;
        }

        public int get(int index, int snap_id) {
            int l = 0, r = arr[index].size();
            while (l < r) {
                int mid = (l + r) >> 1;
                if (arr[index].get(mid)[0] > snap_id) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            --l;
            return l < 0 ? 0 : arr[index].get(l)[1];
        }
    }
}
