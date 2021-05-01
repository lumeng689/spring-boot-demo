package org.luapp.tpl.utils;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: 86150
 * @create: 2021/05/01
 **/
public class Solution739 {

    public static int[] dailyTemperatures(int[] T) {
        Deque<Integer> stack = new ArrayDeque<>();

        int[] res = new int[T.length];

        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[stack.peek()] < T[i]) {
                int idx = stack.pop();
                res[idx] = i - idx;
            }
            stack.push(i);
        }

        return res;
    }

    public static void main(String[] args) {
        Util.printArray(dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73}));
    }
}
