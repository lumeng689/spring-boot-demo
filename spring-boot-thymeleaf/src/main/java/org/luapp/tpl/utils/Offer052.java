package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/05/06
 **/
public class Offer052 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = len(headA);
        int lenB = len(headB);

        if (lenA > lenB) {
            int step = lenA - lenB;

            while (step > 0) {
                headA = headA.next;
                step--;
            }
        } else {
            int step = lenB - lenA;

            while (step > 0) {
                headB = headB.next;
                step--;
            }
        }

        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            } else {
                headA = headA.next;
                headB = headB.next;
            }
        }

        return null;
    }

    public int len(ListNode head) {
        int len = 0;

        while (head != null) {
            len++;
            head = head.next;
        }

        return len;
    }

    public static void main(String[] args) {

    }
}
