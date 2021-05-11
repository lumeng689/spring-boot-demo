package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/05/10
 **/
public class Solution226 {

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            invertTree(root);
        }

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;
        return root;
    }

    public static void dfs(TreeNode node) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            return;
        }

        dfs(node.left);
        dfs(node.right);
        TreeNode tmp = node.left;
        node.right = node.left;
        node.left = tmp;
    }

    public static void main(String[] args) {

    }
}
