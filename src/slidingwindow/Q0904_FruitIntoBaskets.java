package slidingwindow;

import java.util.*;

public class Q0904_FruitIntoBaskets {
    // 904. Fruit Into Baskets - Medium
    // https://leetcode.com/problems/fruit-into-baskets/

    /* ------------------------------------------------------------
       | PATTERN: Sliding Window (en fazla 2 farklı tür)
       ------------------------------------------------------------
       Penceredeki türlerin sayısını map'te tut. Sağ ucu genişlet; map'te 2'den fazla tür olunca soldan daralt,
       sayısı 0'a düşen türü map'ten sil. En büyük pencere boyutu cevap.
    */
    /*  Complexity
        Time  : O(n)
        Space : O(1)
    */

    public static int totalFruit(int[] fruits) {
        Map<Integer, Integer> cnt = new HashMap<>();
        int ans = 0;
        for (int i = 0, j = 0; i < fruits.length; ++i) {
            int x = fruits[i];
            cnt.merge(x, 1, Integer::sum);
            while (cnt.size() > 2) {
                int y = fruits[j++];
                if (cnt.merge(y, -1, Integer::sum) == 0) {
                    cnt.remove(y);
                }
            }
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }
}
