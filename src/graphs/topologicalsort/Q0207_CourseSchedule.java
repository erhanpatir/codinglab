package graphs.topologicalsort;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Q0207_CourseSchedule {
    // 207. Course Schedule - Medium
    // https://leetcode.com/problems/course-schedule/

    // Time:  O(V + E)
    // Space: O(V + E)

    // PATTERN: directed graph + cycle detection

    // Topological sort, yalnızca DAG’lerde vardır; graph’ta cycle varsa geçerli bir course order üretilemez.
    // Course Schedule problemi de tam olarak bunu soruyor: bütün course’lar bitirilebilir mi?

    /*  Asıl soru ne?

        Aslında soru şuna indirgeniyor:
            Bu directed graph'ta cycle var mı?

            cycle varsa → bazı course’lar birbirini bekler → bitiremezsin
            cycle yoksa → bir topological ordering vardır → bitirebilirsin
    */

    // Yöntem 1 — Kahn’s Algorithm (BFS / indegree)
    /* Fikir
        Graph kur
        Her node için indegree hesapla
        indegree == 0 olanları queue’ya koy
        Queue’dan çektikçe komşuların indegree’sini azalt
        En sonda işlenen node sayısı numCourses ise tamam

        Neden çalışıyor?
            indegree == 0 demek, o course’un beklediği prerequisite kalmamış
            Bunları sırayla “alınca”, bağımlı course’ların da indegree’si düşer
            Cycle varsa bazı node’ların indegree’si hiçbir zaman 0 olmaz
    */
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>(); // graph kur

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        for (int[] edge : prerequisites) {
            int course = edge[0];
            int prereq = edge[1];

            graph.get(prereq).add(course); // prereq -> course
            indegree[course]++;            // her node için indegree hesapla
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);      // indegree == 0 olanları queue’ya koy
            }
        }

        int taken = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            taken++;

            for(int next : graph.get(current)) {
                indegree[next]--;   // queue’dan çektikçe komşuların indegree’sini azalt

                if (indegree[next] == 0) {  // indegree == 0 demek, o course’un beklediği prerequisite kalmamış
                    queue.offer(next);
                }
            }
        }

        return taken == numCourses; // En sonda işlenen node sayısı numCourses ise tamam
    }

    // Yöntem 2 — DFS ile cycle detection
    /*
        Burada 3 state tutarız:

            0 = unvisited
            1 = visiting
            2 = visited

        Kural:
            DFS sırasında visiting node’a tekrar geliyorsan cycle vardır
            visited node güvenlidir, tekrar işlemene gerek yok
            Bu yöntem özellikle “directed graph cycle detection” mantığını iyi gösterir.
    */
    public static boolean canFinish_dfs(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : prerequisites) {
            int course = edge[0];
            int prereq = edge[1];
            graph.get(prereq).add(course);
        }

        int[] state = new int[numCourses]; // 0=unvisited, 1=visiting, 2=visited

        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0 && hasCycle(graph, state, i)) {
                return false;
            }
        }
        return true;
    }

    private static boolean hasCycle(List<List<Integer>> graph, int[] state, int node) {
        if (state[node] == 1) return true;  // back edge

        if (state[node] == 2) return false;

        state[node] = 1;

        for (int neighbor : graph.get(node)) {
            if (hasCycle(graph, state, neighbor)) {
                return true;
            }
        }

        state[node] = 2;
        return false;
    }
}
