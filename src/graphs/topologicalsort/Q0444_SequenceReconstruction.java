package graphs.topologicalsort;

import java.util.*;

public class Q0444_SequenceReconstruction {
    // 444. Sequence Reconstruction - Medium
    // https://leetcode.com/problems/sequence-reconstruction/

    // PATTERN : topological sort + uniqueness check

    /*
        This is a topological sort problem, but we also need uniqueness.
        In Kahn’s algorithm, uniqueness is guaranteed only
        if there is exactly one node with indegree zero at every step.
    */

    // Time:  O(V + E)
    // Space: O(V + E)

    //org  = [1,2,3]
    //seqs = [[1,2],[1,3],[2,3]]
    public static boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();

        for (List<Integer> seq : seqs) {
            for (int num : seq) {
                graph.putIfAbsent(num, new HashSet<>()); // set up -- { 1 >> [],
                                                         //             2 >> [],
                                                         //             3 >> [] }
                indegree.putIfAbsent(num, 0);            // set up -- { 1 >> 0,
                                                         //             2 >> 0,
                                                         //             3 >> 0 }
            }
        }

        if (graph.size() != org.length) {
            return false;
        }

        for (List<Integer> seq : seqs) {
            for (int i = 1; i < seq.size(); i++) {
                int prev = seq.get(i - 1);
                int next = seq.get(i);

                if (!graph.containsKey(prev) || !graph.containsKey(next)) {
                    return false;
                }

                if (graph.get(prev).add(next)) {  // { 1 >> [2, 3],
                                                  //   2 >> [3],
                                                  //   3 >> [] }
                    indegree.put(next, indegree.get(next) + 1); // { 1 >> 0,
                                                                //   2 >> 1,
                                                                //   3 >> 2  }
                }
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int node : indegree.keySet()) {
            if (indegree.get(node) == 0) {
                queue.offer(node); // prereq'i olmayanlari queue'a koy
            }
        }

        int idx = 0; // org array'inde şu anda hangi index'teyim?

        while (!queue.isEmpty()) {
            if (queue.size() > 1) {
                return false; // birden fazla geçerli seçim var → unique order yok
            }

            int current = queue.poll();

            // topo sort ile çıkan sırayı,
            // org array ile adım adım karşılaştırıyor
            if (idx == org.length || org[idx] != current) {
                return false;
            }

            idx++;

            for (int next : graph.get(current)) {
                indegree.put(next, indegree.get(next) - 1); // indegree yi 1 azalt
                if (indegree.get(next) == 0) {
                    queue.offer(next);
                }
            }
        }
        return idx == org.length;
    }
}
