package dp.linear;

import java.util.*;

public class Q0118_PascalSTriangle {
    // 118. Pascal's Triangle - Easy
    // https://leetcode.com/problems/pascals-triangle/

    /* ------------------------------------------------------------
       | PATTERN: 1-D DP (önceki satırdan türetme)
       ------------------------------------------------------------
       Her satır 1 ile başlar ve biter. Aradaki her eleman = önceki satırda üstündeki iki elemanın toplamı.
       row[i][j] = row[i-1][j-1] + row[i-1][j].
    */
    /*  Complexity
        Time  : O(numRows^2)
        Space : O(1) (çıktı hariç)
    */

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> f = new ArrayList<>();
        f.add(List.of(1));
        for (int i = 0; i < numRows - 1; ++i) {
            List<Integer> g = new ArrayList<>();
            g.add(1);
            for (int j = 1; j < f.get(i).size(); ++j) {
                g.add(f.get(i).get(j - 1) + f.get(i).get(j));
            }
            g.add(1);
            f.add(g);
        }
        return f;
    }
}
