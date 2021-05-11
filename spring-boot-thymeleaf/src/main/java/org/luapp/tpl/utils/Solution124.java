package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/05/11
 **/
public class Solution124 {

    static int ans = Integer.MIN_VALUE;

    public static int maxPathSum(TreeNode root) {
        maxGain(root);
        return ans;
    }

    public static int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = Math.max(maxGain(node.left), 0);
        int right = Math.max(maxGain(node.right), 0);

        ans = Math.max(left + right + node.val, ans);

        return node.val + Math.max(left, right);
    }

    public static void main(String[] args) {

    }
}
