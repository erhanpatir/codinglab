package design;

import java.util.*;

public class Q0622_DesignCircularQueue {
    // Öncelik   : 🟡 Orta
    // Şirketler : Apple (#37)
    //
    // 622. Design Circular Queue - Medium
    // https://leetcode.com/problems/design-circular-queue/

    /* ------------------------------------------------------------
       | PATTERN: Design - Circular Queue (dizi + front + size)
       ------------------------------------------------------------
       front ve size tut. Ekleme indeksi (front + size) % k, son eleman (front + size - 1) % k.
       deQueue front'u bir ilerletir. Boş ve dolu kontrolü size ile yapılır.
    */
    /*  Complexity
        Time  : O(1) her işlem
        Space : O(k)
    */

    public class MyCircularQueue {
        private int[] q;
        private int front;
        private int size;
        private int capacity;

        public MyCircularQueue(int k) {
            q = new int[k];
            capacity = k;
        }

        public boolean enQueue(int value) {
            if (isFull()) {
                return false;
            }
            int idx = (front + size) % capacity;
            q[idx] = value;
            ++size;
            return true;
        }

        public boolean deQueue() {
            if (isEmpty()) {
                return false;
            }
            front = (front + 1) % capacity;
            --size;
            return true;
        }

        public int Front() {
            if (isEmpty()) {
                return -1;
            }
            return q[front];
        }

        public int Rear() {
            if (isEmpty()) {
                return -1;
            }
            int idx = (front + size - 1) % capacity;
            return q[idx];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == capacity;
        }
    }
}
