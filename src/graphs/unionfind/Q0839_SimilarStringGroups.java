package graphs.unionfind;

import java.util.*;

public class Q0839_SimilarStringGroups {
    // 839. Similar String Groups - Hard
    // https://leetcode.com/problems/similar-string-groups/description/

    /* ------------------------------------------------------------
       | PATTERN: Union Find (benzer string grupları)
       ------------------------------------------------------------
       Her string çifti için farklı karakter sayısı 0 ya da 2 ise (anagram oldukları garanti) benzerdir; birleştir.
       Her başarılı birleştirme grup sayısını bir azaltır.
    */
    /*  Complexity
        Time  : O(n^2 * m)
        Space : O(n)
    */

    public static int numSimilarGroups(String[] strs) {
        int n = strs.length, m = strs[0].length();
        UnionFind uf = new UnionFind(n);
        int cnt = n;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                int diff = 0;
                for (int k = 0; k < m; ++k) {
                    if (strs[i].charAt(k) != strs[j].charAt(k)) {
                        ++diff;
                    }
                }
                if (diff <= 2 && uf.union(i, j)) {
                    --cnt;
                }
            }
        }
        return cnt;
    }

    static class UnionFind {
        private final int[] p;
        private final int[] size;

        public UnionFind(int n) {
            p = new int[n];
            size = new int[n];
            for (int i = 0; i < n; ++i) {
                p[i] = i;
                size[i] = 1;
            }
        }

        public int find(int x) {
            if (p[x] != x) {
                p[x] = find(p[x]);
            }
            return p[x];
        }

        public boolean union(int a, int b) {
            int pa = find(a), pb = find(b);
            if (pa == pb) {
                return false;
            }
            if (size[pa] > size[pb]) {
                p[pb] = pa;
                size[pa] += size[pb];
            } else {
                p[pa] = pb;
                size[pb] += size[pa];
            }
            return true;
        }
    }
}
