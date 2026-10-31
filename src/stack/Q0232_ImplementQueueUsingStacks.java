package stack;

import java.util.*;

public class Q0232_ImplementQueueUsingStacks {
    // Öncelik   : 🟡 Orta
    // Şirketler : Apple (#92)
    //
    // 232. Implement Queue using Stacks - Easy
    // https://leetcode.com/problems/implement-queue-using-stacks/

    /* ------------------------------------------------------------
       | PATTERN: Stack - iki stack ile queue
       ------------------------------------------------------------
       push hep stk1'e. pop/peek için stk2 boşsa stk1'deki her şeyi stk2'ye aktar (sıra tersine döner, FIFO olur).
       Her eleman en fazla bir kez aktarıldığı için işlemler amortize O(1).
    */
    /*  Complexity
        Time  : Amortize O(1)
        Space : O(n)
    */

    public class MyQueue {
        private Deque<Integer> stk1 = new ArrayDeque<>();
        private Deque<Integer> stk2 = new ArrayDeque<>();

        public MyQueue() {
        }

        public void push(int x) {
            stk1.push(x);
        }

        public int pop() {
            move();
            return stk2.pop();
        }

        public int peek() {
            move();
            return stk2.peek();
        }

        public boolean empty() {
            return stk1.isEmpty() && stk2.isEmpty();
        }

        private void move() {
            while (stk2.isEmpty()) {
                while (!stk1.isEmpty()) {
                    stk2.push(stk1.pop());
                }
            }
        }
    }
}
