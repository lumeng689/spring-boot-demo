package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/05/16
 **/
public class Offer022 {

    public static ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (k > 0 && fast != null) {
            k--;
            fast = fast.next;
        }

        if (k > 0) {
            return null;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        Util.printListNode(getKthFromEnd(Util.makeListNode(new int[]{1, 2, 3, 4, 5}), 2));
    }
}
