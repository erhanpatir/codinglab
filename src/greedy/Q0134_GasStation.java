package greedy;

import java.util.*;

public class Q0134_GasStation {
    // Öncelik   : 🔴 Yüksek
    // Şirketler : Bloomberg ✅ (#110)
    //
    // 134. Gas Station - Medium
    // https://leetcode.com/problems/gas-station/

    /* ------------------------------------------------------------
       | PATTERN: Greedy (tek geçiş)
       ------------------------------------------------------------
       Toplam benzin toplam maliyetten azsa çözüm yoktur (-1).
       Aksi halde tek geçişte tank tut; tank negatife düştüğünde, start'tan i'ye kadar hiçbir istasyon
       başlangıç olamaz, start = i + 1 yapıp tankı sıfırla. Kalan start cevaptır.
    */
    /*  Complexity
        Time  : O(n)
        Space : O(1)
    */

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0, tank = 0, start = 0;
        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            total += diff;
            tank += diff;
            if (tank < 0) {   // start..i arasından hiçbir istasyon başlangıç olamaz
                start = i + 1;
                tank = 0;
            }
        }
        return total < 0 ? -1 : start;
    }
}
