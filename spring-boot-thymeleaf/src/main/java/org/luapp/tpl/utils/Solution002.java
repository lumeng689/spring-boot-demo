package org.luapp.tpl.utils;

import java.util.ArrayList;

/**
 * @author: 86150
 * @create: 2021/04/28
 **/
public class Solution002 {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode head = new ListNode(-1);
        ListNode res = head;

        int carry = 0;

        while (l1 != null && l2 != null) {
            int val = l1.val + l2.val + carry;

            if (val >= 10) {
                carry = val / 10;
                val = val % 10;
            }else {
                carry = 0;
            }

            l1 = l1.next;
            l2 = l2.next;

            res.next = new ListNode(val);
            res = res.next;
        }

        while (l1 != null) {
            int val = l1.val + carry;
            if (val >= 10) {
                carry = val / 10;
                val = val % 10;
            }else {
                carry = 0;
            }
            l1 = l1.next;
            res.next = new ListNode(val);
            res = res.next;
        }

        while (l2 != null) {
            int val = l2.val + carry;
            if (val >= 10) {
                carry = val / 10;
                val = val % 10;
            } else {
                carry = 0;
            }
            l2 = l2.next;
            res.next = new ListNode(val);
            res = res.next;
        }

        if (carry ==1) {
            res.next = new ListNode(carry);
        }

        return head.next;
    }

    public static void print(ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            node = node.next;
        }
        System.out.println();
    }

    public static void test1() {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(8);

        print(addTwoNumbers(l1, l2));
    }

    public static void test2() {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(9);
        l1.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next.next = new ListNode(9);

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);

        print(addTwoNumbers(l1, l2));
    }

    public static void main(String[] args) {
//        test1();
        test2();
    }
}
