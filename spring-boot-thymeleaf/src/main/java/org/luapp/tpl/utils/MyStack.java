package org.luapp.tpl.utils;

import java.util.LinkedList;
import java.util.Queue;
/**
 * @author: 86150
 * @create: 2020/07/24
 **/
class MyStack {

    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        q1.offer(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {

        if (!q2.isEmpty()) {
            return q2.poll();
        }

        if (q1.isEmpty()) {
            return -1;
        }

        for (int i = 0;i < q1.size();i++) {
            q2.offer(q1.poll());
        }

        return q2.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {

        if (!q2.isEmpty()) {
            return q2.peek();
        }

        if (q1.isEmpty()) {
            return -1;
        }

        for (int i = 0;i < q1.size();i++) {
            q2.offer(q1.poll());
        }

        return 0;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */