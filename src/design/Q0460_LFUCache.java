package design;

import java.util.*;

public class Q0460_LFUCache {
    // Öncelik   : 🔴 Yüksek  ·  🌍 Ortak soru
    // Şirketler : Amazon ✅ (#115), Apple ✅ (#79)
    //
    // 460. LFU Cache - Hard
    // https://leetcode.com/problems/lfu-cache/

    /* ------------------------------------------------------------
       | PATTERN: Design - Hash Map + frekans başına Doubly Linked List
       ------------------------------------------------------------
       key -> düğüm map'i ve frekans -> o frekanstaki düğümlerin çift yönlü listesi.
       get/put düğümün frekansını artırır: eski listeden çıkar, yeni frekansın listesinin başına ekle.
       minFreq'i takip et; kapasite dolunca minFreq listesinin sonundaki (en eski) düğümü sil.
    */
    /*  Complexity
        Time  : O(1) (get/put)
        Space : O(capacity)
    */

    public class LFUCache {
        private final Map<Integer, Node> map;
        private final Map<Integer, DoublyLinkedList> freqMap;
        private final int capacity;
        private int minFreq;

        public LFUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>(capacity, 1);
            freqMap = new HashMap<>();
        }

        public int get(int key) {
            if (capacity == 0) {
                return -1;
            }
            if (!map.containsKey(key)) {
                return -1;
            }
            Node node = map.get(key);
            incrFreq(node);
            return node.value;
        }

        public void put(int key, int value) {
            if (capacity == 0) {
                return;
            }
            if (map.containsKey(key)) {
                Node node = map.get(key);
                node.value = value;
                incrFreq(node);
                return;
            }
            if (map.size() == capacity) {
                DoublyLinkedList list = freqMap.get(minFreq);
                map.remove(list.removeLast().key);
            }
            Node node = new Node(key, value);
            addNode(node);
            map.put(key, node);
            minFreq = 1;
        }

        private void incrFreq(Node node) {
            int freq = node.freq;
            DoublyLinkedList list = freqMap.get(freq);
            list.remove(node);
            if (list.isEmpty()) {
                freqMap.remove(freq);
                if (freq == minFreq) {
                    minFreq++;
                }
            }
            node.freq++;
            addNode(node);
        }

        private void addNode(Node node) {
            int freq = node.freq;
            DoublyLinkedList list = freqMap.getOrDefault(freq, new DoublyLinkedList());
            list.addFirst(node);
            freqMap.put(freq, list);
        }

        private static class Node {
            int key;
            int value;
            int freq;
            Node prev;
            Node next;

            Node(int key, int value) {
                this.key = key;
                this.value = value;
                this.freq = 1;
            }
        }

        private static class DoublyLinkedList {

            private final Node head;
            private final Node tail;

            public DoublyLinkedList() {
                head = new Node(-1, -1);
                tail = new Node(-1, -1);
                head.next = tail;
                tail.prev = head;
            }

            public void addFirst(Node node) {
                node.prev = head;
                node.next = head.next;
                head.next.prev = node;
                head.next = node;
            }

            public Node remove(Node node) {
                node.next.prev = node.prev;
                node.prev.next = node.next;
                node.next = null;
                node.prev = null;
                return node;
            }

            public Node removeLast() {
                return remove(tail.prev);
            }

            public boolean isEmpty() {
                return head.next == tail;
            }
        }
    }
}
