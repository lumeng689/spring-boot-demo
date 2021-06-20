package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/06/17
 **/
public class Solution965 {

    public static boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (root.left != null && root.val != root.left.val || root.right != null && root.val != root.right.val) {
            return false;
        }

        return isUnivalTree(root.left) && isUnivalTree(root.right);
    }

    public static void main(String[] args) {
//        System.out.println(isUnivalTree());
    }
}
