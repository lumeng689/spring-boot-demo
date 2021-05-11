package org.luapp.tpl.utils;

import java.sql.SQLOutput;

/**
 * @author: 86150
 * @create: 2021/05/09
 **/
public class Solution203 {

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            if(cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }

            cur = cur.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
//        Util.printListNode(removeElements(Util.makeListNode(new int[]{1, 2, 3, 4, 5, 6}), 3));
        Util.printListNode(removeElements(Util.makeListNode(new int[]{1, 2, 6,3, 4, 5, 6}), 6));
//        Util.printListNode(removeElements(Util.makeListNode(new int[]{7,7,7,7}), 7));
    }
}
