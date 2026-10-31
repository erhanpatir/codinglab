package graphs.dfs;

import java.util.*;

public class Q0797_AllPathsFromSourceToTarget {
    // 797. All Paths From Source to Target - Medium
    // https://leetcode.com/problems/all-paths-from-source-to-target/

    /* ------------------------------------------------------------
       | PATTERN: Graph DFS + Backtracking (tüm yollar)
       ------------------------------------------------------------
       Graf DAG olduğu için visited gerekmez. 0'dan DFS; path'e düğümü ekle, hedefe gelince path'in kopyasını sonuca ekle,
       dönüşte son düğümü çıkar.
    */
    /*  Complexity
        Time  : O(2^n * n)
        Space : O(n) (çıktı hariç)
    */

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(graph, 0, path, result);
        return result;
    }

    private static void dfs(int[][] graph, int node, List<Integer> path, List<List<Integer>> result) {
        if (node == graph.length - 1) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int next : graph[node]) {
            path.add(next);
            dfs(graph, next, path, result);
            path.remove(path.size() - 1); // backtrack
        }
    }
}
