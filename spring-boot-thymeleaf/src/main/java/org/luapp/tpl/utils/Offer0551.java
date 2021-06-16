package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/06/16
 **/
public class Offer0551 {

    public static int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {

    }
}
