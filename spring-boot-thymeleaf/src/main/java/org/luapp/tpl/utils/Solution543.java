package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/05/10
 **/
public class Solution543 {

    int ans;

    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        depth(root);
        return ans;
    }

    private int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int L = depth(node.left);
        int R = depth(node.right);

        ans = Math.max(ans, L + R);
        return Math.max(L, R) + 1;
    }

    public static void main(String[] args) {

    }
}
