package org.luapp.tpl.utils;

import org.yaml.snakeyaml.util.ArrayStack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: 86150
 * @create: 2021/05/18
 **/
public class Offer031 {

    public static boolean validateStackSequences(int[] pushed, int[] popped) {

        if (pushed == null || popped == null || pushed.length <= 0 || popped.length <= 0) {
            return false;
        }

        int i = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        for (int num : pushed) {
            stack.push(num);

            while (!stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}));
        System.out.println(validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2}));
    }
}
