package org.luapp.tpl.utils;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: 86150
 * @create: 2021/05/20
 **/
public class Offer033 {

    public static boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length <= 0) {
            return true;
        }

        Deque<Integer> stack = new ArrayDeque<>();
        int root = Integer.MAX_VALUE;
        for (int i = postorder.length - 1; i >= 0; i--) {
            if (postorder[i] > root) {
                return false;
            }

            while (!stack.isEmpty() && stack.peek() > postorder[i]) {
                root = stack.pop();
            }

            stack.push(postorder[i]);
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(verifyPostorder(new int[]{1, 6, 3, 2, 5}));
        System.out.println(verifyPostorder(new int[]{1, 3, 2, 6, 5}));
    }
}
