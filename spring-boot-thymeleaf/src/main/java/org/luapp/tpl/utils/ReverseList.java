package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/04/18
 **/
public class ReverseList {

    public static class ListNode {
        int value;
        ListNode next;

        public ListNode(int value) {
            this.value = value;
        }
    }

    private static void printListNode(ListNode head) {
        if (head == null) {
            return;
        }

        System.out.print(head.value);

        while (head.next != null) {
            System.out.print("->");
            System.out.print(head.next.value);
            head = head.next;
        }

        System.out.println();
    }

    public static ListNode reverseListNode(ListNode head) {
//        ListNode nextNode = head.next;
//        // 这个地方一定要把next设置成null;
//        ListNode newHead = head;
//        newHead.next = null;
//
//        while (nextNode != null) {
//            ListNode tmp = nextNode.next;
//            nextNode.next = newHead;
//            newHead = nextNode;
//            nextNode = tmp;
//        }
//
//        return newHead;

        ListNode newHead = null;

        while (head != null) {
            ListNode second = newHead;
            newHead = new ListNode(head.value);
            newHead.next = second;
            head = head.next;
        }

        return newHead;
    }

    public static void main(String[] args) {
        ListNode header = new ListNode(0);
        ListNode current = header;
        for (int i = 1; i < 10; i++) {
            current.next = new ListNode(i);
            current = current.next;
        }

        printListNode(header);

        ListNode newHead = reverseListNode(header);
        printListNode(newHead);

        printListNode(header);
    }
}
