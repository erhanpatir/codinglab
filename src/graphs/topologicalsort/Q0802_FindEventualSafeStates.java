package graphs.topologicalsort;

import java.util.*;

public class Q0802_FindEventualSafeStates {
    // 802. Find Eventual Safe States - Medium
    // https://leetcode.com/problems/find-eventual-safe-states/

    /*--------------------------------------------------------------------
    | PATTERN : reverse graph + outdegree
     --------------------------------------------------------------------*/

    // Time: O(V + E)
    // Space: O(V + E)

    /* Bir directed graph var.
        graph[i] = i node’undan gidebildiğin komşular.
        Problem “eventual safe node”ları istiyor;
        yani bir node’dan hangi yolu seçersen seç,
        sonunda mutlaka terminal bir node’a gidiyorsan o node safe sayılıyor.
        Terminal node da outgoing edge’i olmayan node.

        Türkçesi
        Bir node’dan başlıyorsun.
            Eğer bir cycle’a girme ihtimalin varsa, o node unsafe
            Eğer ne yaparsan yap sonunda çıkışsız bir node’a düşüyorsan, o node safe
        Yani soru aslında şunu soruyor:
            hangi node’lar cycle’a gitmez?

        Neden reverse graph?
            Orijinal graph’ta safe olmanın anlamı:
                bütün outgoing edge'lerin sonunda safe yerlere gitmesi
            Bunu Kahn tarzı düşünmek için şu dönüşümü yapıyoruz:
                reverse graph kur
                outdegree[i] = graph[i].size()

            Sonra:
                outdegree == 0 olanlar terminal, yani başlangıç safe node’lar
                bunları queue’ya koy
                bunların parent’larının outdegree’sini azalt
                bir parent’ın tüm çıkışları güvenli hale gelince outdegree == 0 olur
                o da safe olur

            Bu, reverse graph + outdegree ile yapılan topo benzeri bir çözüm.
    * */
    public static List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> reverseGraph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            reverseGraph.add(new ArrayList<>()); // set up
        }

        int[] outdegree = new int[n];

        for (int node = 0; node < n; node++) {
            outdegree[node] = graph[node].length;

            for (int next : graph[node]) {
                reverseGraph.get(next).add(node); // reverse graph  >> { next >> prev }
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int node = 0; node < n; node++) {
            if (outdegree[node] == 0) { // Bunlar kesin safe.
                queue.offer(node);
            }
        }

        List<Integer> safe = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            safe.add(node);

            for (int prev : reverseGraph.get(node)) {
                outdegree[prev]--; // Safe bir node işlenince, ona gelen parent’ları azalt

                if (outdegree[prev] == 0) { // Bunlar kesin safe.
                    queue.offer(prev);
                }
            }
        }
        Collections.sort(safe);
        return safe;
    }
}
