package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/06/01
 **/
public class Solution707 {

    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    private static class MyLinkedList {

        int size = 0;
        ListNode head = null;

        /**
         * Initialize your data structure here.
         */
        public MyLinkedList() {
            this.size = 0;
            this.head = new ListNode(0);
        }

        /**
         * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
         */
        public int get(int index) {
            if (index >= this.size || index < 0) {
                return -1;
            }

            ListNode curr = this.head;

            for (int i = 0; i < index + 1; ++i) {
                curr = curr.next;
            }
            return curr.val;
        }

        /**
         * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
         */
        public void addAtHead(int val) {
            addAtIndex(0, val);
        }

        /**
         * Append a node of value val to the last element of the linked list.
         */
        public void addAtTail(int val) {
            addAtIndex(this.size, val);
        }

        /**
         * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
         */
        public void addAtIndex(int index, int val) {
            if (index > this.size) {
                return;
            }

            if (index < 0) {
                index = 0;
            }

            ListNode pred = this.head;

            for (int i = 0; i < index; ++i) {
                pred = pred.next;
            }

            ListNode node = new ListNode(val);
            node.next = pred.next;
            pred.next = node;

            this.size++;
        }

        /**
         * Delete the index-th node in the linked list, if the index is valid.
         */
        public void deleteAtIndex(int index) {
            if (index >= this.size || index < 0) {
                return;
            }

            ListNode pred = this.head;

            for (int i = 0; i < index; ++i) {
                pred = pred.next;
            }
            pred.next = pred.next.next;
            this.size--;
        }
    }
}
