package graphs.traversal.dfs;

import common.ds.Node;

import java.util.*;

public class Q0133_CloneGraph {
    // 133. Clone Graph - Medium
    // https://leetcode.com/problems/clone-graph/

    private static final Map<Node, Node> clones = new HashMap<>();

    // Time: O(V + E)
    // Space: O(V)
    public static Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        if (clones.containsKey(node)) {
            return clones.get(node); // İşte cycle bu şekilde kırılıyor.
        }

        Node copy = new Node(node.val, new ArrayList<>());
        /*
            Bunu neighbor’lara gitmeden önce yapmalısın.

            Neden?
                Çünkü graph cycle içeriyorsa, neighbor tekrar aynı node’a dönebilir.
                Map’e önceden koyduysan recursion orada durur.
                Koymadıysan sonsuz döngüye girersin.
        */
        clones.put(node, copy);

        for (Node neighbor : node.neighbors) {
            copy.neighbors.add(cloneGraph(neighbor));
        }

        return copy;
    }

    public static Node cloneGraph_bfs(Node node) {
        if (node == null) return null;

        Map<Node, Node> clones = new HashMap<>();
        Queue<Node> queue = new ArrayDeque<>();

        Node root = new Node(node.val, new ArrayList<>()); // create
        clones.put(node, root); // map
        queue.offer(node);      // enqueue

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            for (Node neighbor : current.neighbors) {
                if (!clones.containsKey(neighbor)) {
                    Node clone = new Node(neighbor.val, new ArrayList<>());
                    clones.put(neighbor, clone);

                    queue.offer(neighbor); // enqueue
                }

                // add neighbor
                clones.get(current).neighbors.add(clones.get(neighbor));
            }
        }

        return clones.get(node);
    }
}
