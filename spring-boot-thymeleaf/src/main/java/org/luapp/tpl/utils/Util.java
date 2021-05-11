package org.luapp.tpl.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * @author: 86150
 * @create: 2021/05/01
 **/
public class Util {


    public static void printArray(int[] ret) {
        if (ret == null || ret.length <= 0) {
            System.out.println("");
        }

        System.out.println(StringUtils.join(ret, ','));
    }

    public static void printMatrix(int[][] matrix) {
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        for (int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];
            for (int j = 0; j < row.length; j++) {
                System.out.print(row[j] + "\t");
            }
            System.out.println();
        }
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
    }

    public static <T> void printNestList(List<List<T>> lists) {
        for (List<T> subList : lists) {
            for (Object i : subList) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }

    public static TreeNode buildFromArray(Integer[] nodes) {
        TreeNode root = cursiveBuildTree(nodes, 0);
        return root;
    }

    private static TreeNode cursiveBuildTree(Integer[] nodes, int startIdx) {
        if (startIdx >= nodes.length) {
            return null;
        }

        if (nodes[startIdx] == null) {
            return null;
        }

        TreeNode root = new TreeNode(nodes[startIdx]);
        root.left = cursiveBuildTree(nodes, startIdx * 2 + 1);
        root.right = cursiveBuildTree(nodes, startIdx * 2 + 2);

        return root;
    }

    public static ListNode makeListNode(int[] nums) {

        ListNode dummy = new ListNode(-1);
        ListNode node = dummy;
        for (int i = 0; i < nums.length; i++) {
            node.next = new ListNode(nums[i]);
            node = node.next;
        }
        return dummy.next;
    }

    public static void printListNode(ListNode head) {
        int count = 0;
        while (head != null && count < 100) {
            System.out.print(head.val + " \t");
            head = head.next;
            count++;
        }

        System.out.println();
    }

    public static void printIntList(List<Integer> list) {
        for (int i : list) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }
}
