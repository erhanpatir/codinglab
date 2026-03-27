package graphs.topologicalsort;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Q0310_MinimumHeightTrees {
    // 310. Minimum Height Trees - Medium
    // https://leetcode.com/problems/minimum-height-trees/

    // undirected tree + leaf peeling

    // Time: O(n)
    // Space: O(n)

    /*  The roots of minimum height trees are the centroids of the tree.
        We can find them by repeatedly removing all current leaves layer
        by layer until only one or two nodes remain.
    */

    // input: n = 4, edges = [[1,0],[1,2],[1,3]]
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return List.of(0);
        }

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        int[] degree = new int[n];

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);

            degree[u]++;
            degree[v]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                queue.offer(i);
            }
        }

        int remainingNodes = n;

        // Çünkü bir tree’nin center sayısı: 1 veya 2 olabilir.
        // O yüzden 2 veya daha az node kalınca dururuz.
        while (remainingNodes > 2) {
            int size = queue.size();
            remainingNodes -= size;

            for (int i = 0; i < size; i++) {
                int leaf = queue.poll();

                for (int neighbor : graph.get(leaf)) {
                    degree[neighbor]--;

                    if (degree[neighbor] == 1) {
                        queue.offer(neighbor);
                    }
                }
            }
        }

        return new ArrayList<>(queue);
    }
}
