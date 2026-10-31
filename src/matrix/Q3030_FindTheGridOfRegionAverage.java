package matrix;

import java.util.*;

public class Q3030_FindTheGridOfRegionAverage {
    // Öncelik   : 🟡 Orta
    // Şirketler : Apple (#86)
    //
    // 3030. Find the Grid of Region Average - Medium
    // https://leetcode.com/problems/find-the-grid-of-region-average/

    /* ------------------------------------------------------------
       | PATTERN: Matrix - 3x3 bölge kontrolü
       ------------------------------------------------------------
       Her 3x3 pencere için içindeki komşu hücre farklarının threshold'u aşmadığını kontrol et; geçerliyse bölgenin ortalamasını
       bölgedeki her hücreye ekle ve sayacını artır. Sonunda her hücrenin değeri: ait olduğu bölgelerin ortalama değerlerinin ortalaması
       (hiç bölgesi yoksa orijinal değer).
    */
    /*  Complexity
        Time  : O(m * n)
        Space : O(m * n)
    */

    public static int[][] resultGrid(int[][] image, int threshold) {
        int n = image.length;
        int m = image[0].length;
        int[][] ans = new int[n][m];
        int[][] ct = new int[n][m];
        for (int i = 0; i + 2 < n; ++i) {
            for (int j = 0; j + 2 < m; ++j) {
                boolean region = true;
                for (int k = 0; k < 3; ++k) {
                    for (int l = 0; l < 2; ++l) {
                        region
                            &= Math.abs(image[i + k][j + l] - image[i + k][j + l + 1]) <= threshold;
                    }
                }
                for (int k = 0; k < 2; ++k) {
                    for (int l = 0; l < 3; ++l) {
                        region
                            &= Math.abs(image[i + k][j + l] - image[i + k + 1][j + l]) <= threshold;
                    }
                }
                if (region) {
                    int tot = 0;
                    for (int k = 0; k < 3; ++k) {
                        for (int l = 0; l < 3; ++l) {
                            tot += image[i + k][j + l];
                        }
                    }
                    for (int k = 0; k < 3; ++k) {
                        for (int l = 0; l < 3; ++l) {
                            ct[i + k][j + l]++;
                            ans[i + k][j + l] += tot / 9;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (ct[i][j] == 0) {
                    ans[i][j] = image[i][j];
                } else {
                    ans[i][j] /= ct[i][j];
                }
            }
        }
        return ans;
    }
}
