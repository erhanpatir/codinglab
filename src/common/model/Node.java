package common.model;

import java.util.ArrayList;
import java.util.List;

// LeetCode'daki farklı "Node" tanımlarını tek sınıfta toplar:
// tree (left/right/next/parent), linked list (next/prev/child/random), N-ary (children).
public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;
    public Node prev;
    public Node child;
    public Node random;
    public Node parent;
    public List<Node> children = new ArrayList<>();

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
