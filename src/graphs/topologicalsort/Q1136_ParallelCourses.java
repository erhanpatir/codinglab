package graphs.topologicalsort;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Q1136_ParallelCourses {
    // 1136. Parallel Courses - Medium
    // https://leetcode.com/problems/parallel-courses/
    /*--------------------------------------------------------------------
    | PATTERN : directed graph + topological sort
     --------------------------------------------------------------------*/

    // Course Schedule + level counting

    // Time: O(V + E)
    // Space: O(V + E)
    public static int minimumSemesters(int n, int[][] relations) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[n + 1];

        for (int[] relation : relations) {
            int prev = relation[0];
            int next = relation[1];

            graph.get(prev).add(next);
            indegree[next]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();

        for (int course = 1; course <= n; course++) {
            if (indegree[course] == 0) {
                queue.offer(course);
            }
        }

        int semesters = 0;
        int takenCourses = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            semesters++; // queue'da şu anda bulunan derslerin hepsi aynı semester'da alınır

            for (int i = 0; i < size; i++) {
                int course = queue.poll();
                takenCourses++;

                for (int next : graph.get(course)) {
                    indegree[next]--;
                    if (indegree[next] == 0) {
                        queue.offer(next);
                    }
                }
            }
        }
        return takenCourses == n ? semesters : -1;
    }


}
