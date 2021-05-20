package org.luapp.tpl.utils;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: 86150
 * @create: 2021/05/16
 **/
public class Offer006 {

    public int[] reversePrint(ListNode head) {

        if (head == null) {
            return new int[0];
        }

        Deque<ListNode> stack = new ArrayDeque<>();

        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        int[] ans = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            ans[i++] = stack.pop().val;
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
