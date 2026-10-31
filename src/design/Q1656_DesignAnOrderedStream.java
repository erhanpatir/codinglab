package design;

import java.util.*;

public class Q1656_DesignAnOrderedStream {
    // 1656. Design an Ordered Stream - Easy
    // https://leetcode.com/problems/design-an-ordered-stream/

    /* ------------------------------------------------------------
       | PATTERN: Design - Dizi + pointer
       ------------------------------------------------------------
       Değerleri id'ye göre diziye yerleştir. ptr, henüz döndürülmemiş en küçük id.
       insert'ten sonra ptr'den başlayarak dolu ardışık hücreleri döndür ve ptr'yi ilerlet.
    */
    /*  Complexity
        Time  : Toplamda O(n)
        Space : O(n)
    */

    public class OrderedStream {
        private int ptr = 1;
        private String[] data;

        public OrderedStream(int n) {
            data = new String[n + 1];
        }

        public List<String> insert(int idKey, String value) {
            data[idKey] = value;
            List<String> ans = new ArrayList<>();
            while (ptr < data.length && data[ptr] != null) {
                ans.add(data[ptr++]);
            }
            return ans;
        }
    }
}
