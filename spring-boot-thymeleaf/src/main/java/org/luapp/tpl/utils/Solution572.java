package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/05/25
 **/
public class Solution572 {

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return dfs(root, subRoot);
    }

    private static boolean dfs(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }

        return check(s, t) || dfs(s.left, t) || dfs(s.right, t);
    }

    private static boolean check(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }

        if (s == null || t == null || s.val != t.val) {
            return false;
        }

        return check(s.left, t.left) && check(s.right, t.right);
    }


    public static void main(String[] args) {

    }
}
