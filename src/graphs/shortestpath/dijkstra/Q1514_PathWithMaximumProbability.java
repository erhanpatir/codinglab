package graphs.shortestpath.dijkstra;

import java.util.*;

public class Q1514_PathWithMaximumProbability {
    // 1514. Path With Maximum Probability - Medium
    // https://leetcode.com/problems/path-with-maximum-probability/
    /*--------------------------------------------------------------------
      PATTERN : directed graph + maximum product path + dijkstra
     --------------------------------------------------------------------*/

      /*-----------------------------------------------------
      |  shortest path?
      |    ├─ unweighted → BFS
      |     ├─ weighted min → Dijkstra
      |     ├─ weighted max → Dijkstra (max-heap)
      |     └─ constraint → state graph / DP
     -----------------------------------------------------*/

    /*🧩 Algorithm
            Graph kur
            max-heap kullan
            (probability, node) tut
            en yüksek probability’yi önce explore et
            relax:
                newProb = currProb * edgeProb
    */

    /*
        Time: O((V + E) log V)
        Space: O(V + E)
    */

    // This is a maximum probability path problem,
    // but it can be solved using Dijkstra by changing the relaxation
    // from sum to product and using a max-heap.
    public static double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<double[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int from = edge[0];
            int to = edge[1];

            graph.get(from).add(new double[] {to, succProb[i]}); // source      -->> {destination, prob}
            graph.get(to).add(new double[] {from, succProb[i]}); // destination -->> {source, prob}
        }

        double[] prob = new double[n];
        prob[start_node] = 1.0;

        PriorityQueue<double[]> pq =
                new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0])); // max heap
        pq.offer(new double[] {1.0, start_node}); // {prob, node}

        while (!pq.isEmpty()) {
            double[] curr = pq.poll();
            double currProb = curr[0];
            int node = (int) curr[1];

            if (node == end_node) {
                return currProb; // maximum product of probabilities
            }

            if (currProb < prob[node]) { // stale entry check
                continue;
            }

            prob[node] = currProb;

            for (double[] neighbor : graph.get(node)) {
                int nextNode = (int) neighbor[0];
                double nextProb = neighbor[1];

                double newProb = currProb * nextProb;

                if (newProb > prob[nextNode]) {
                    prob[nextNode] = newProb;
                    pq.offer(new double[] {newProb, nextNode});
                }
            }
        }

        return 0.0;
    }
}
