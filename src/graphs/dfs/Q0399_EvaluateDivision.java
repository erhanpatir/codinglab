package graphs.dfs;

import java.util.*;

public class Q0399_EvaluateDivision {
    // 399. Evaluate Division - Medium
    // https://leetcode.com/problems/evaluate-division/

    /* ------------------------------------------------------------
       | PATTERN: Graph DFS (ağırlıklı yönlü graf)
       ------------------------------------------------------------
       a / b = v ise a -> b kenarının ağırlığı v, b -> a kenarının ağırlığı 1/v.
       Her sorgu için src'den dst'ye DFS; yol boyunca ağırlıkları çarp.
       Değişkenlerden biri grafta yoksa ya da yol bulunamazsa -1.0.
    */
    /*  Complexity
        Time  : O(Q * (V + E))
        Space : O(V + E)
    */

    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // a / b = v  =>  a -> b (v) ve b -> a (1/v) ağırlıklı kenarlar
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0), b = equations.get(i).get(1);
            graph.computeIfAbsent(a, x -> new HashMap<>()).put(b, values[i]);
            graph.computeIfAbsent(b, x -> new HashMap<>()).put(a, 1.0 / values[i]);
        }
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String src = queries.get(i).get(0), dst = queries.get(i).get(1);
            result[i] = (!graph.containsKey(src) || !graph.containsKey(dst))
                    ? -1.0
                    : dfs(graph, src, dst, new HashSet<>());
        }
        return result;
    }

    private static double dfs(Map<String, Map<String, Double>> graph, String cur, String dst, Set<String> seen) {
        if (cur.equals(dst)) return 1.0;
        seen.add(cur);
        for (Map.Entry<String, Double> edge : graph.get(cur).entrySet()) {
            if (seen.contains(edge.getKey())) continue;
            double rest = dfs(graph, edge.getKey(), dst, seen);
            if (rest != -1.0) return rest * edge.getValue();   // yol boyunca çarpımlar
        }
        return -1.0;
    }
}
