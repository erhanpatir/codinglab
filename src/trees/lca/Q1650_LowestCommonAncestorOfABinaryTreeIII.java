package trees.lca;

import common.model.Node;
import java.util.*;

public class Q1650_LowestCommonAncestorOfABinaryTreeIII {
    // 1650. Lowest Common Ancestor of a Binary Tree III - Medium
    // https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-iii/

    /* ------------------------------------------------------------
       | PATTERN: LCA - Two Pointers (parent zinciri kesişimi)
       ------------------------------------------------------------
       Parent pointer'lar ile p ve q'dan köke giden yollar iki linked list gibi düşünülür.
       "Intersection of Two Linked Lists" tekniği: a ve b yukarı çıkar, null'a ulaşınca diğer düğümün başına geçer.
       İki pointer aynı uzunlukta yol yürüdüğü için kesişim noktasında buluşur. O(1) ekstra bellek.
    */
    /*  Complexity
        Time  : O(h)
        Space : O(1)
    */

    public static Node lowestCommonAncestor(Node p, Node q) {
        // İki "linked list"in (parent zinciri) kesişimini bulma tekniği.
        Node a = p, b = q;
        while (a != b) {
            a = (a == null) ? q : a.parent;
            b = (b == null) ? p : b.parent;
        }
        return a;
    }
}
