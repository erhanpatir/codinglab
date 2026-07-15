package hashing;

import java.util.HashMap;
import java.util.Map;

public class Q0219_ContainsDuplicateII {
    // 219. Contains Duplicate II - Easy
    // https://leetcode.com/problems/contains-duplicate-ii/
    /* ------------------------------------------------------------
       | PATTERN:             Last Seen Index                   ✅|
       ------------------------------------------------------------
    /* ⭐Last Seen Index ⭐ (Yeni)
        HashMap içinde her sayının en son görüldüğü index’i tutarız:
            value -> lastSeenIndex

        Yeni bir nums[i] gördüğümüzde:
            - Daha önce görüldüyse önceki index’i al.
            - Aradaki mesafeyi hesapla.
            - Mesafe k veya daha küçükse true dön.
            - Son görülen index’i güncelle.
        -----------------------------------------------------------
        if (lastSeen.containsKey(nums[i])) {
            int previousIndex = lastSeen.get(nums[i]);

            if (i - previousIndex <= k) {
                return true;
            }
        }

        lastSeen.put(nums[i], i);
        -----------------------------------------------------------

        Neden sadece son index yeterli?
            Bir sayı daha önce birden fazla kez görülmüş olabilir:
                nums = [1, ..., 1, ..., 1]

        Mevcut index’e en yakın olan tekrar, en son görülen tekrardır.

        Örneğin:
            previous indexes = 0, 4, 8
            current index    = 10

        Mesafeler:
            10 - 0 = 10
            10 - 4 = 6
            10 - 8 = 2

        En küçük mesafe her zaman son index ile oluşur.
        Bu yüzden tüm index’leri saklamaya gerek yoktur.
     */
    /*  Complexity
            Time: O(n)
            Space: O(n)

            HashMap işlemleri ortalama O(1)’dir.
            En kötü durumda tüm sayılar farklıysa map n eleman tutar.
    */
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        // Map<Value, LastSeenIndex>
        Map<Integer, Integer> lastSeen = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];

            if (lastSeen.containsKey(value)) {
                int previousIndex = lastSeen.get(value);

                if (Math.abs(i - previousIndex) <= k) return true;
            }

            lastSeen.put(value, i);
        }

        return false;
    }
    /* Başarılı örnek
        nums = [1, 0, 1, 1]
        k = 1

        i	nums[i]	Önceki index	Mesafe	  Sonuç
        0	   1	   yok	          —	     map {1=0}
        1	   0	   yok	          —	     map {1=0, 0=1}
        2	   1	   0	          2	     2 > 1, güncelle 1 -> 2
        3	   1	   2	          1	     1 <= 1, true

        Kritik nokta:
            i = 2'de 1'in index'ini 0'dan 2'ye güncelledik.

        Güncellemeseydik son adımda:
            3 - 0 = 3

        hesaplardık ve doğru pair’i kaçırırdık.
        Doğru yakın pair:  index 2 ve index 3
     */
}
