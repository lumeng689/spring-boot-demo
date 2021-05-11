package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/05/10
 **/
public class Interview0205 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int z = 0;
        while (l1 != null && l2 != null) {
            int v = l1.val + l2.val + z;

            z = v / 10;
            ListNode next = new ListNode(v % 10);
            cur.next = next;

            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int v = l1.val  + z;

            z = v / 10;
            ListNode next = new ListNode(v % 10);
            cur.next = next;

            cur = cur.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            int v = l2.val  + z;

            z = v / 10;
            ListNode next = new ListNode(v % 10);
            cur.next = next;

            cur = cur.next;
            l2 = l2.next;
        }

        if (z > 0) {
            cur.next = new ListNode(z);
        }

        return dummy.next;
    }

    public static void main(String[] args) {

    }
}
