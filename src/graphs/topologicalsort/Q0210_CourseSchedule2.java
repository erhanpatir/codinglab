package graphs.topologicalsort;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Q0210_CourseSchedule2 {
    // 210. Course Schedule II - Medium
    // https://leetcode.com/problems/course-schedule-ii/
    // PATTERN : directed graph + topological sort

    // Time : O(V + E)
    // Space : O(V + E)
    // Kahn’s Algorithm
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        for (int[] edge : prerequisites) {
            int course = edge[0];
            int prereq = edge[1];

            graph.get(prereq).add(course);
            indegree[course]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] res = new int[numCourses];
        int taken = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            taken++;
            res[taken] = current;
            for (int neighbor : graph.get(current)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return taken == numCourses ? res : new int[0];
    }
}
