package org.luapp.tpl.utils;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: 86150
 * @create: 2021/05/16
 **/
public class Offer030 {
    private static class MinStack {

        private Deque<Integer> stack;
        private Deque<Integer> min;

        public MinStack() {
            stack = new ArrayDeque<>();
            min = new ArrayDeque<>();
        }

        public void push(int x) {
            stack.push(x);
            if (min.isEmpty()) {
                min.push(x);
            } else {
                min.push(Math.min(x, min.peek()));
            }
        }

        public void pop() {
            stack.pop();
            min.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int min() {
            return min.peek();
        }
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.min();
        minStack.pop();
        minStack.top();
        minStack.min();

    }
}
