package graphs.shortestpath.stategraph;

import java.util.*;

public class Q0787_CheapestFlightsWithinKStops {
    // 787. Cheapest Flights Within K Stops - Medium
    // https://leetcode.com/problems/cheapest-flights-within-k-stops/
    /*--------------------------------------------------------------------
    | PATTERN : directed graph + constrained shortest path + state graph
     --------------------------------------------------------------------*/
    /*-----------------------------------------------------
      |  shortest path?
      |    ├─ unweighted
      |    │    → BFS
      |    │
      |    ├─ weighted, no extra constraint
      |    │    → Dijkstra
      |    │
      |    └─ weighted + extra constraint
      |         → state graph / Bellman-Ford style DP
     -----------------------------------------------------*/

    // Time: O((V * K + E * K) log (V * K))
    // Space: O(V)

    // |----------------------------------------------|
    // | Dijkstra’s Algorithm                         |
    // |----------------------------------------------|
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] flight : flights) {
            int from  = flight[0];
            int to    = flight[1];
            int price = flight[2];
            graph.get(from).add(new int[]{to, price}); // source -->> {destination, price}
        }

        // PQ’daki eleman, node değil state’tir.   {best value + state identity}
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0])); // ordered by cost
        pq.offer(new int[]{0, src, k + 1}); // {cost, city, remainingEdges}

        /* bu city’ye daha önce EN FAZLA kaç remainingEdges ile geldim ?
        Örnek:
            1️⃣ önce bu geldi
                (city = B, remaining = 3, cost = 120)
            2️⃣ sonra bu geldi
                (city = B, remaining = 1, cost = 110)

            Şimdi soru:
            ikinciyi explore etmeli miyiz?

            Cevap:
            👉 Genelde HAYIR

            Çünkü:
                daha az move hakkın var
                gelecekte daha az seçenek

            Yani:
                remaining fazla olan state daha güçlü
            ⚠️ Ama cost daha ucuz değil mi?
                Evet ama dikkat:
                    future expansion için flexibility önemli
                Remaining düşükse:
                    ileride dst’ye ulaşamayabilirsin

            az remaining olan path daha ucuz bitebilir, biz bunu erken eliyoruz
            bu riskli değil mi?
            Bu %100 doğru bir endişe.

            💡 Cevap: biz cost’u ASLA göz ardı etmiyoruz
            Şu çok kritik:
                priority queue → her zaman en düşük cost state’i önce işler
            Yani:
                ucuz path'ler zaten önce explore edilir.
        */
        int[] bestRemaining = new int[n];
        Arrays.fill(bestRemaining, -1);

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int cost = current[0];
            int city = current[1];
            int remainingEdges = current[2];

            if (city == dst) {
                return cost;
            }

            /* ben bu city’ye daha önce daha fazla veya eşit hareket hakkıyla gelmişim
               o zaman şu anki state daha kötü → at*/
            if (bestRemaining[city] >= remainingEdges) {
                continue;
            }
            bestRemaining[city] = remainingEdges;

            if (remainingEdges == 0) {
                continue;
            }

            for (int[] neighbor : graph.get(city)) {
                int nextCity = neighbor[0];
                int price = neighbor[1];
                pq.offer(new int[]{cost + price, nextCity, remainingEdges - 1});
            }
        }

        return -1;
    }
}
