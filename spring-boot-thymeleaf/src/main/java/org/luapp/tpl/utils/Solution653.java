package org.luapp.tpl.utils;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: 86150
 * @create: 2021/06/17
 **/
public class Solution653 {

    public boolean findTarget(TreeNode root, int k) {

        Set<Integer> nodes = new HashSet<>();

        dfs(root, nodes);


        for (int v : nodes) {
            if (v != k -v && nodes.contains(k -v)) {
                return true;
            }
        }

        return false;
    }

    private void dfs(TreeNode root, Set<Integer> nodes) {
        if (root == null) {
            return;
        }

        nodes.add(root.val);
        dfs(root.left, nodes);
        dfs(root.right, nodes);
    }

    public static void main(String[] args) {

    }
}
