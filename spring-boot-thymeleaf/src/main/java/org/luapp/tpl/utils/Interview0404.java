package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/05/24
 **/
public class Interview0404 {
    public boolean isBalanced(TreeNode root) {

        if (root == null) {
            return true;
        } else {
            return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(height(root.left), height(root.right)) + 1;
        }
    }
}
