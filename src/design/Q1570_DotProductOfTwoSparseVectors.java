package design;

import java.util.*;

public class Q1570_DotProductOfTwoSparseVectors {
    // Öncelik   : ⭐ Gerçek deneyim
    // Şirketler : Meta (#28)
    // Seviye    : Mid
    // Raporlar  : 1 (1 📍London)
    //             https://leetcode.com/discuss/post/5279925/Meta-(London)-or-E4-or-Reject/
    //
    // 1570. Dot Product of Two Sparse Vectors - Medium
    // https://leetcode.com/problems/dot-product-of-two-sparse-vectors/

    /* ------------------------------------------------------------
       | PATTERN: Design - Hash Map (sıfır olmayanlar)
       ------------------------------------------------------------
       Sadece sıfır olmayan (indeks, değer) çiftlerini map'te sakla. Çarpımda küçük map'i gez,
       diğer map'te aynı indeks varsa çarpıp topla. Takip (Meta): iki taraf da seyrekse indekse göre
       sıralı listelerde two pointer; biri yoğunsa küçük olanda binary search.
    */
    /*  Complexity
        Time  : O(min(n1, n2))
        Space : O(sıfır olmayan sayısı)
    */

    public class SparseVector {
        public Map<Integer, Integer> d = new HashMap<>(128);

        SparseVector(int[] nums) {
            for (int i = 0; i < nums.length; ++i) {
                if (nums[i] != 0) {
                    d.put(i, nums[i]);
                }
            }
        }

        // Return the dotProduct of two sparse vectors
        public int dotProduct(SparseVector vec) {
            var a = d;
            var b = vec.d;
            if (b.size() < a.size()) {
                var t = a;
                a = b;
                b = t;
            }
            int ans = 0;
            for (var e : a.entrySet()) {
                int i = e.getKey(), v = e.getValue();
                ans += v * b.getOrDefault(i, 0);
            }
            return ans;
        }
    }
}
