package monotonic;

import java.util.stream.*;
import java.util.*;

public class Q1762_BuildingsWithAnOceanView {
    // 1762. Buildings With an Ocean View - Medium
    // https://leetcode.com/problems/buildings-with-an-ocean-view/

    /* ------------------------------------------------------------
       | PATTERN: Monotonic (sağdan maksimum)
       ------------------------------------------------------------
       Sağdan sola gez ve sağdaki en yüksek binayı tut. Bina bundan yüksekse okyanus manzarası vardır.
       İndeksler ters sırada toplandığı için sonunda ters çevrilir.
       Alternatif: soldan gezerken monotonic azalan stack.
    */
    /*  Complexity
        Time  : O(n)
        Space : O(1) (çıktı hariç)
    */

    public static int[] findBuildings(int[] heights) {
        int n = heights.length;
        List<Integer> ans = new ArrayList<>();
        int mx = 0;
        for (int i = heights.length - 1; i >= 0; --i) {
            if (heights[i] > mx) {
                ans.add(i);
                mx = heights[i];
            }
        }
        Collections.reverse(ans);
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
