package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/05/18
 **/
public class Solution671 {

    long ans = Long.MAX_VALUE;

    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        long miniVal = root.val;
        dfs(root, miniVal);
        if (ans == Long.MAX_VALUE) {
            return -1;
        }
        return (int)ans;
    }

    private void dfs(TreeNode root, long miniVal) {
        if (root == null) {
            return;
        }
        if (root.val > miniVal && root.val < ans) {
            ans = root.val;
        }
        dfs(root.left, miniVal);
        dfs(root.right, miniVal);
    }

    public static void main(String[] args) {

    }
}
