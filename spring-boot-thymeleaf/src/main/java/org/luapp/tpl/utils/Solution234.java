package org.luapp.tpl.utils;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: 86150
 * @create: 2021/05/08
 **/
public class Solution234 {

    public boolean isPalindrome(ListNode head) {
        Deque<ListNode> stack = new ArrayDeque<>();

        ListNode tmp = head;

        while(tmp != null) {
            stack.push(tmp);
            tmp = tmp.next;
        }

        while(head != null && !stack.isEmpty()) {
            ListNode node1 = stack.pop();
            if (head.val != node1.val) {
                return false;
            }

            head = head.next;
        }

        return true;
    }




    public static void main(String[] args) {

    }
}
