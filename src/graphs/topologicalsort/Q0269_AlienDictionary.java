package graphs.topologicalsort;

import java.util.*;

public class Q0269_AlienDictionary {
    // 269. Alien Dictionary - Hard
    // https://leetcode.com/problems/alien-dictionary/
    // PATTERN : directed graph + topological sort

    // Time : O(V + E)
    // Space : O(V + E)
    public static String alienOrder(String[] words) {

        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        // add all chars
        for (String w : words) {
            for (char c : w.toCharArray()) {
                graph.putIfAbsent(c, new HashSet<>());
                indegree.putIfAbsent(c, 0);
            }
        }

        // build graph
        for (int i = 0; i < words.length - 1; i++) {

            String w1 = words[i];
            String w2 = words[i + 1];

            int min = Math.min(w1.length(), w2.length());

            boolean found = false;

            for (int j = 0; j < min; j++) {

                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);

                if (c1 != c2) {

                    if (!graph.get(c1).contains(c2)) {
                        graph.get(c1).add(c2);
                        indegree.put(c2, indegree.get(c2) + 1);
                    }

                    found = true;
                    break;
                }
            }

            // invalid case
            if (!found && w1.length() > w2.length()) {
                return "";
            }
        }

        // topological sort
        Queue<Character> queue = new ArrayDeque<>();

        for (char c : indegree.keySet()) {
            if (indegree.get(c) == 0) {
                queue.offer(c);
            }
        }

        StringBuilder order = new StringBuilder();

        while (!queue.isEmpty()) {

            char c = queue.poll();
            order.append(c);

            for (char next : graph.get(c)) {

                indegree.put(next, indegree.get(next) - 1);

                if (indegree.get(next) == 0) {
                    queue.offer(next);
                }
            }
        }

        if (order.length() != indegree.size()) {
            return "";
        }

        return order.toString();
    }
}
