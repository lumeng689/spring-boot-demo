package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2020/03/20
 **/
public class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        TreeNode nearP = root;

        while (true) {
            if (nearP.val > p.val && nearP.val > q.val) {
                nearP = nearP.left;
            } else if (nearP.val < p.val && nearP.val < q.val) {
                nearP = nearP.right;
            } else {
                break;
            }
        }

        return nearP;
    }


    public static boolean isUgly(int num) {

        while (num > 0 && num % 2 == 0) {
            num = num / 2;
        }

        while (num > 0 && num % 3 == 0) {
            num = num / 3;
        }

        while (num > 0 && num % 5 == 0) {
            num = num / 5;
        }

        return num == 1;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void deleteNode(ListNode node) {
        ListNode p = null;
        while (node.next != null) {
            p = node;
            node.val = node.next.val;
            node = node.next;
        }

        p.next = null;
    }

    public static int missingNumber(int[] nums) {

//        int a = nums.length;
//        for (int i =0;i< nums.length;i++) {
//            if (nums[i] != i) {
//                a = i;
//                break;
//            }
//        }
//
//        return a;

        int i = 0, j = nums.length - 1;

        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] == m) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }

        return i;
    }

    public static int search(int[] nums, int target) {

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                count++;
            } else if (nums[i] > target) {
                break;
            }
        }

        return count;
    }

    public static int numWays(int n) {
        if (n <= 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        long[] a = new long[n + 1];

        a[0] = 1;
        a[1] = 1;
        a[2] = 2;

        for (int i = 3; i <= n; i++) {
            a[i] = (a[i - 1] + a[i - 2]) % 1000000007;
        }

        return (int) a[n];
    }

    public static int[] sortArrayByParity(int[] a) {

        if (a == null || a.length < 1) {
            return a;
        }

        int i = 0, j = a.length - 1;

        while (i < j) {
            while (a[i] % 2 == 0 && i < j) {
                i++;
            }

            while (a[j] % 2 == 1 && j > i) {
                j--;
            }

            if (i == j) {
                break;
            }

            int t = a[i];
            a[i] = a[j];
            a[j] = t;
            i++;
            j--;
        }

        return a;
    }

    public static void test1(int[] b) {
        int[] a = sortArrayByParity(b);

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "  ");
        }

        System.out.println();
    }

    public static int sumRootToLeaf(TreeNode root) {
        return getChildVal(root, 0);
    }

    public static int getChildVal(TreeNode node, int parentVal) {

        if (node == null) {
            return 0;
        }

        if (node.left == null && node.right == null) {
            return parentVal * 2 + node.val;
        }

        int leftVal = getChildVal(node.left, parentVal * 2 + node.val);

        int rightVal = getChildVal(node.right, parentVal * 2 + node.val);

        return leftVal + rightVal;
    }

    public static void main(String[] args) {
//        System.out.println(isUgly(6));
//        System.out.println(isUgly(8));
//        System.out.println(isUgly(14));

//        System.out.println(missingNumber(new int[]{0}));
//        System.out.println(missingNumber(new int[]{0, 1, 3}));

//        System.out.println(search(new int[]{5, 7, 7, 8, 8, 10}, 8));
//        System.out.println(search(new int[]{5, 7, 7, 8, 8, 10}, 6));

//        System.out.println(numWays(2));
//        System.out.println(numWays(7));
//        System.out.println(numWays(46));
//        System.out.println(numWays(92));

//        test1(new int[]{3, 1, 2, 4});
//        test1(new int[]{2, 4});
//        test1(new int[]{3, 1});
//        test1(new int[]{2, 4, 3, 1});

        TreeNode root = new TreeNode(1);

        TreeNode n10 = new TreeNode(0);
        n10.left = new TreeNode(0);
        n10.right = new TreeNode(1);
        TreeNode n11 = new TreeNode(1);
        n11.left = new TreeNode(0);
        n11.right = new TreeNode(1);

        root.left = n10;
        root.right = n11;


        System.out.println(sumRootToLeaf(root));
    }
}
