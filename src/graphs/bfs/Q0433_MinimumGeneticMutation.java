package graphs.bfs;

import java.util.*;

public class Q0433_MinimumGeneticMutation {
    // 433. Minimum Genetic Mutation - Medium
    // https://leetcode.com/problems/minimum-genetic-mutation/

    /* ------------------------------------------------------------
       | PATTERN: Graph BFS (gen dizileri)
       ------------------------------------------------------------
       Her gen bir düğüm, bank'taki tek karakter farklı genler komşu.
       start'tan seviye seviye BFS; end'e ulaşılan seviye mutasyon sayısıdır. Ziyaret edilenleri set'te tut.
    */
    /*  Complexity
        Time  : O(C * n * m)
        Space : O(n * m)
    */

    public static int minMutation(String startGene, String endGene, String[] bank) {
        Deque<String> q = new ArrayDeque<>();
        q.offer(startGene);
        Set<String> vis = new HashSet<>();
        vis.add(startGene);
        int depth = 0;
        while (!q.isEmpty()) {
            for (int m = q.size(); m > 0; --m) {
                String gene = q.poll();
                if (gene.equals(endGene)) {
                    return depth;
                }
                for (String next : bank) {
                    int c = 2;
                    for (int k = 0; k < 8 && c > 0; ++k) {
                        if (gene.charAt(k) != next.charAt(k)) {
                            --c;
                        }
                    }
                    if (c > 0 && !vis.contains(next)) {
                        q.offer(next);
                        vis.add(next);
                    }
                }
            }
            ++depth;
        }
        return -1;
    }
}
