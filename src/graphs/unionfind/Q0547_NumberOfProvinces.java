package graphs.unionfind;

import java.util.*;

public class Q0547_NumberOfProvinces {
    // 547. Number of Provinces - Medium
    // https://leetcode.com/problems/number-of-provinces/description/

    /* ------------------------------------------------------------
       | PATTERN: Union Find
       ------------------------------------------------------------
       Her şehir başta kendi bileşeninde, il sayısı n. isConnected[i][j] == 1 olan her çift için root'ları bul;
       farklıysa birleştir ve il sayısını bir azalt. Path compression ile find neredeyse O(1).
    */
    /*  Complexity
        Time  : O(n^2 * α(n))
        Space : O(n)
    */

    public static int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        int provinces = n;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    int a = find(parent, i), b = find(parent, j);
                    if (a != b) {
                        parent[a] = b;
                        provinces--; // iki ayrı bileşen birleşti
                    }
                }
            }
        }
        return provinces;
    }

    private static int find(int[] parent, int x) {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]]; // path compression
            x = parent[x];
        }
        return x;
    }
}
