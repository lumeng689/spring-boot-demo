package org.luapp.tpl.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 86150
 * @create: 2021/05/24
 **/
public class Solution257 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        dfs(root, "", ans);
        return ans;
    }

    private void dfs(TreeNode node, String str, List<String> ans) {
        if (node == null) {

            return;
        }

        str += node.val;
        str += "->";

        if (node.left == null && node.right == null) {
            ans.add(str.substring(0, str.length() - 2));
        }

        if (node.left != null) {
            dfs(node.left, str, ans);
        }

        if (node.right != null) {
            dfs(node.right, str, ans);
        }
    }
}
