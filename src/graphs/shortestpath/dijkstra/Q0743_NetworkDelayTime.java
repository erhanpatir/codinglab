package graphs.shortestpath.dijkstra;

import java.util.*;

public class Q0743_NetworkDelayTime {
    // 743. Network Delay Time - Medium
    // https://leetcode.com/problems/network-delay-time/

    /* PATTERN: weighted graph + single source shortest path

                    unweighted shortest path        -> BFS
                    weighted positive shortest path -> Dijkstra
                    weighted negative shortest path -> Bellman-Ford
     ----------------------------------------------------------------------*/

    /*  OZET:
        times[i] = [u, v, w] directed edge demek; sinyal k node’undan çıkıyor,
        tüm node’lara ulaşma süresi isteniyor. Eğer bazı node’lara hiç ulaşılamıyorsa cevap -1.

        SORU: k node'undan tüm node'lara shortest path bul
              en geç ulaşan node'un distance'ını dön
              Çünkü sinyalin tüm ağa yayılması için, en yavaş ulaşan node kadar beklemek gerekir.
     ----------------------------------------------------------------------*/

    // Time: O((V + E) log V)
    // Space: O(V + E)
    // This is a single-source shortest path problem on a directed weighted graph with positive edge weights,
    // so Dijkstra’s algorithm is the right choice.
    // |----------------------------------------------|
    // | Dijkstra’s Algorithm                         |
    // |----------------------------------------------|
    public static int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : times) {
            int u = edge[0]; // source
            int v = edge[1]; // target
            int w = edge[2]; // distance

            graph.get(u).add(new int[] {v, w}); // source -->> [target, distance]
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;  // {max, max, 0, max, max}

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0])); //min-heap
        pq.offer(new int[] {0, k}); // {distance, node}

        while (!pq.isEmpty()) {
            int[] current   = pq.poll();
            int currentDist = current[0];
            int node        = current[1];

            if (currentDist > dist[node]) {
                /* Neden var?
                    Bu çok önemli.
                    Priority queue’ya aynı node birden fazla kez girebilir.
                  Örnek:
                    önce node 5 için distance 10 ile queue’ya girdin
                    sonra daha iyi bir yol bulup 7 ile tekrar girdin
                    Heap’ten önce 10 çıkarsa artık eski bilgi olur.
*/
                continue;
            }

            for (int[] neighbor : graph.get(node)) {
                int nextNode = neighbor[0];         // target
                int weight   = neighbor[1];         // distance
                int newDist  = currentDist + weight;

                if (newDist < dist[nextNode]) {
                    dist[nextNode] = newDist;
                    pq.offer(new int[] {newDist, nextNode});
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }
            answer = Math.max(answer, dist[i]); // dist teki max olan cevaptir.
        }

        return answer;
    }
}
