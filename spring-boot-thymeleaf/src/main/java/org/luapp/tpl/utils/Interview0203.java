package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/06/21
 **/
public class Interview0203 {

    public void deleteNode1(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public void deleteNode2(ListNode node) {

        while (node.next.next != null) {
            node.val = node.next.val;
            node = node.next;
        }

        node.next = null;
    }

    public static void main(String[] args) {

    }
}
