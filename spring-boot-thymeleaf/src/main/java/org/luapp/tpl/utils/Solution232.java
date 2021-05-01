package org.luapp.tpl.utils;

import java.util.Stack;

/**
 * @author: 86150
 * @create: 2021/05/01
 **/
public class Solution232 {
    private static class MyQueue {

        private Stack<Integer> in, out;

        /** Initialize your data structure here. */
        public MyQueue() {
            this.in = new Stack<>();
            this.out = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            in.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if (!out.isEmpty()) {
                return out.pop();
            } else {
                while(!in.isEmpty()) {
                    out.push(in.pop());
                }

                return out.pop();
            }
        }

        /** Get the front element. */
        public int peek() {
            if (!out.isEmpty()) {
                return out.peek();
            } else {
                while(!in.isEmpty()) {
                    out.push(in.pop());
                }

                return out.peek();
            }
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return this.in.isEmpty() && this.out.isEmpty();
        }
    }
}
