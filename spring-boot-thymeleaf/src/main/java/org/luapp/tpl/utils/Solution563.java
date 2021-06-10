package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/06/09
 **/
public class Solution563 {

    public int findTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = findTilt(root.left);
        int right = findTilt(root.right);
        int tilt = Math.abs(left - right);
        return tilt + findTilt(root.left) + findTilt(root.right);
    }

    public static void main(String[] args) {

    }
}
