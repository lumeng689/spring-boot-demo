package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/06/15
 **/
public class Offer0552 {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isBalanced(root.left) && isBalanced(root.right) && Math.abs(height(root.left) - height(root.right)) <= 1;
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return Math.max(height(node.left), height(node.right)) + 1;
    }

    public static void main(String[] args) {

    }
}
