package binarysearch;

import common.model.Sea;
import java.util.*;

public class Q1274_NumberOfShipsInARectangle {
    // Öncelik   : 🔴 Yüksek
    // Şirketler : Bloomberg ✅ (#43)
    //
    // 1274. Number of Ships in a Rectangle - Hard
    // https://leetcode.com/problems/number-of-ships-in-a-rectangle/

    /* ------------------------------------------------------------
       | PATTERN: Divide & Conquer (dörde bölme)
       ------------------------------------------------------------
       Dikdörtgende gemi yoksa 0, tek hücreyse 1. Değilse orta noktalardan dört parçaya böl ve
       her parçada recursive say. hasShips her çağrıda boş bölgeleri hızla eler.
    */
    /*  Complexity
        Time  : O(C * log max(m, n))
        Space : O(log max(m, n))
    */

    public static int countShips(Sea sea, int[] topRight, int[] bottomLeft) {
        int x1 = bottomLeft[0], y1 = bottomLeft[1];
        int x2 = topRight[0], y2 = topRight[1];
        if (x1 > x2 || y1 > y2) {
            return 0;
        }
        if (!sea.hasShips(topRight, bottomLeft)) {
            return 0;
        }
        if (x1 == x2 && y1 == y2) {
            return 1;
        }
        int midx = (x1 + x2) >> 1;
        int midy = (y1 + y2) >> 1;
        int a = countShips(sea, topRight, new int[] {midx + 1, midy + 1});
        int b = countShips(sea, new int[] {midx, y2}, new int[] {x1, midy + 1});
        int c = countShips(sea, new int[] {midx, midy}, bottomLeft);
        int d = countShips(sea, new int[] {x2, midy}, new int[] {midx + 1, y1});
        return a + b + c + d;
    }
}
