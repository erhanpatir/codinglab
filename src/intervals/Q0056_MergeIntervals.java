package intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Q0056_MergeIntervals {
    // Öncelik   : ⭐ Gerçek deneyim  ·  🌍 Ortak soru
    // Şirketler : Meta ✅ (#17), Google ✅ (#23), Amazon ✅ (#13), Apple ✅ (#3), Bloomberg ✅ (#2)
    // Seviye    : Mid, Senior
    // Raporlar  : 6 (3 📍London)
    //             https://leetcode.com/discuss/post/5501360/MetaorLondonorOnsite/
    //
    // 56. Merge Intervals - Medium
    // https://leetcode.com/problems/merge-intervals/
    /* ---------------------------------------------------------
       | PATTERN: Sort by start + merge current interval     ✅|
       ---------------------------------------------------------
       Önce başlangıca göre sırala.
        Sonra soldan sağa git.
        Elimizde son merge edilmiş interval var:
        last = result sonundaki interval

        Yeni interval:
            current
        Eğer overlap varsa:
        last.end = max(last.end, current.end)

        Overlap yoksa:
            current result'a eklenir

        3. State / Invariant
        Invariant:
            result her zaman şu ana kadar merge edilmiş, overlap etmeyen interval’ları içerir.

        Overlap condition:
            current.start <= last.end

        Overlap yoksa:
            current.start > last.end
    */
    /* Complexity Analysis
        Time: O(n logn)
        Space: O(1)
    */
    public static int[][] merge(int[][] intervals) {
        // sort the intervals by start time
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> merged = new ArrayList<>();

        for (int[] current : intervals) {
            if (merged.isEmpty()) {
                merged.add(current);
                continue;
            }
            // Java'da array'ler primitive degil, reference type.
            // Bu yuzden, last set edildiginde, merged listesi de degisiyor.
            int[] last = merged.get(merged.size() - 1);

            // current in start'i, last in end'ten kucuk ise,
            if (current[0] <= last[1]) {
                last[1] = Math.max(last[1], current[1]); // overlap
            } else {
                merged.add(current); // overlap yok
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}
