package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/05/07
 **/
public class Solution092 {

    public static ListNode reverseBetween(ListNode head, int left, int right) {

        if (head == null || head.next == null) {
            return head;
        }

        if (left == right) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode preLeft = dummy;
        ListNode leftNode = dummy;
        ListNode rightNode = dummy;
        ListNode afterRight = dummy;

        while (dummy != null) {
            if (left > 0) {
                preLeft = leftNode;
                leftNode = leftNode.next;
                left--;
            }

            if (right > 0) {
                rightNode = rightNode.next;
                right--;
            }

            if (right <= 0) {
                afterRight = rightNode.next;
                break;
            }
        }

        preLeft.next = null;
        rightNode.next = null;

        ListNode pre = null;
        ListNode cur = leftNode;

        while (cur != rightNode) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        leftNode.next = afterRight;

        return head;
    }

    public static void main(String[] args) {

        Util.printListNode(reverseBetween(Util.makeListNode(new int[]{1, 2, 3, 4, 5}), 2, 4));

    }
}
