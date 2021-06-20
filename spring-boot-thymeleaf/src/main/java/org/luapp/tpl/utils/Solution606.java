package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/06/18
 **/
public class Solution606 {

    public static String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return sb.toString();
    }

    private static void dfs(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        sb.append(root.val);

        if (root.left == null && root.right == null) {
            return;
        }

        sb.append("(");
        if (root.left != null) {
            dfs(root.left, sb);
        }
        sb.append(")");
        if (root.right != null) {
            sb.append("(");
            dfs(root.right, sb);
            sb.append(")");
        }
    }

    public static void main(String[] args) {

        TreeNode root = Util.buildFromArray(new Integer[]{1, 2, 3, null, 4});

        //  result:  1(2()(4))(3)
        System.out.println(tree2str(root));
    }
}
