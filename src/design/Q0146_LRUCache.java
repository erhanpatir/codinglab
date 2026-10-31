package design;

import java.util.*;

public class Q0146_LRUCache {
    // 146. LRU Cache - Medium
    // https://leetcode.com/problems/lru-cache/

    /* ------------------------------------------------------------
       | PATTERN: Hash Map + Doubly Linked List
       ------------------------------------------------------------
       Map: key -> düğüm (O(1) erişim). Çift yönlü liste: en son kullanılan başta, en eski sonda.
       get: düğümü bul, başa taşı. put: varsa güncelle ve başa taşı; yoksa başa ekle,
       kapasite aşılırsa sondaki düğümü listeden ve map'ten sil. Head/tail sentinel düğümleri kenar durumları kolaylaştırır.
    */
    /*  Complexity
        Time  : O(1) (get/put)
        Space : O(capacity)
    */

    public class LRUCache {
        private int size;
        private int capacity;
        private Node head = new Node();
        private Node tail = new Node();
        private Map<Integer, Node> cache = new HashMap<>();

        public LRUCache(int capacity) {
            this.capacity = capacity;
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            if (!cache.containsKey(key)) {
                return -1;
            }
            Node node = cache.get(key);
            removeNode(node);
            addToHead(node);
            return node.val;
        }

        public void put(int key, int value) {
            if (cache.containsKey(key)) {
                Node node = cache.get(key);
                removeNode(node);
                node.val = value;
                addToHead(node);
            } else {
                Node node = new Node(key, value);
                cache.put(key, node);
                addToHead(node);
                if (++size > capacity) {
                    node = tail.prev;
                    cache.remove(node.key);
                    removeNode(node);
                    --size;
                }
            }
        }

        private void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private void addToHead(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next = node;
            node.next.prev = node;
        }
    }

    static class Node {
        int key, val;
        Node prev, next;

        Node() {
        }

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
