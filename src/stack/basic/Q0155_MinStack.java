package stack.basic;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q0155_MinStack {
    // 155. Min Stack - Medium
    // https://leetcode.com/problems/min-stack/
    /* ------------------------------------------------------
       | PATTERN: Two Stacks                              ✅|
       ------------------------------------------------------
    /* Bir stack gerçek değerleri tutar: stack
       Diğer stack minimumları tutar: minStack

       Her push yaptığımızda, o ana kadarki minimumu da minStack içine koyarız.
       Yani minStack.peek() her zaman mevcut minimumdur.
    */
    /*
        Complexity
        Time:
            Her işlem:
                push   -> O(1)
                pop    -> O(1)
                top    -> O(1)
                getMin -> O(1)

        Space: O(n)
    */
    private final Deque<Integer> stack;
    private final Deque<Integer> minStack;
    private Integer min;

    public Q0155_MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }

    public void push(int value) {
        stack.push(value);

        if (minStack.isEmpty()) {
            minStack.push(value);
        } else {
            minStack.push(Math.min(value, minStack.peek()));
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

