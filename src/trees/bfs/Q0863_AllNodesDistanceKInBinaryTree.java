package trees.bfs;

import common.model.TreeNode;
import java.util.*;

public class Q0863_AllNodesDistanceKInBinaryTree {
    // Öncelik   : ⭐ Gerçek deneyim  ·  🌍 Ortak soru
    // Şirketler : Meta ✅ (#56), Amazon ✅ (#103)
    // Seviye    : Mid
    // Raporlar  : 1 (1 📍London)
    //             https://leetcode.com/discuss/post/6485719/meta-e4-software-engineer-interview-expe-osx7/
    //
    // 863. All Nodes Distance K in Binary Tree - Medium
    // https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/

    /* ------------------------------------------------------------
       | PATTERN: Tree -> Graph + BFS
       ------------------------------------------------------------
       Ağaçta yukarı çıkabilmek için her düğümün parent'ını DFS ile map'e kaydet; ağaç yönsüz grafa dönüşür.
       target'tan başlayarak k seviye BFS yap (sol, sağ, parent komşuları); ziyaret edilenleri set'te tut.
       k. seviyedeki kuyrukta kalanlar cevaptır.
    */
    /*  Complexity
        Time  : O(n)
        Space : O(n)
    */

    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // 1) Her düğümün parent'ını kaydet: ağacı yönsüz bir grafa çevirmiş oluruz.
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        buildParents(root, null, parent);
        // 2) target'tan başlayarak k seviye BFS yap.
        Deque<TreeNode> queue = new ArrayDeque<>();
        Set<TreeNode> seen = new HashSet<>();
        queue.offer(target);
        seen.add(target);
        for (int dist = 0; dist < k && !queue.isEmpty(); dist++) {
            for (int size = queue.size(); size > 0; size--) {
                TreeNode node = queue.poll();
                for (TreeNode next : new TreeNode[]{node.left, node.right, parent.get(node)}) {
                    if (next != null && seen.add(next)) queue.offer(next);
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for (TreeNode node : queue) result.add(node.val);
        return result;
    }

    private static void buildParents(TreeNode node, TreeNode par, Map<TreeNode, TreeNode> parent) {
        if (node == null) return;
        parent.put(node, par);
        buildParents(node.left, node, parent);
        buildParents(node.right, node, parent);
    }
}
