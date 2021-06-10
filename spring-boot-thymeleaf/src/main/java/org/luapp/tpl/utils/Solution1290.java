package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/06/10
 **/
public class Solution1290 {

    public static int getDecimalValue(ListNode head) {
        int ans = 0;

        while (head != null) {
            ans <<= 1;
            ans += head.val;
            head = head.next;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(getDecimalValue(Util.makeListNode(new int[]{1, 0, 1})));
        System.out.println(getDecimalValue(Util.makeListNode(new int[]{0})));
        System.out.println(getDecimalValue(Util.makeListNode(new int[]{1})));
        System.out.println(getDecimalValue(Util.makeListNode(new int[]{1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0})));
        System.out.println(getDecimalValue(Util.makeListNode(new int[]{0})));
    }
}
