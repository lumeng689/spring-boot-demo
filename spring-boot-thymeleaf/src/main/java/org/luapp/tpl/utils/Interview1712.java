package org.luapp.tpl.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 86150
 * @create: 2021/06/10
 **/
public class Interview1712 {
    public TreeNode convertBiNode(TreeNode root) {

        if (root == null) {
            return root;
        }

        List<TreeNode> nodes = new ArrayList<>();
        inorder(root, nodes);
        root = nodes.get(0);
        TreeNode pre = root;
        for (int i = 1; i < nodes.size(); i++) {
            pre.left = null;
            pre.right = nodes.get(i);
            pre = pre.right;
        }

        return root;
    }

    private void inorder(TreeNode root, List<TreeNode> nodes) {
        if (root == null) {
            return;
        }
        inorder(root.left, nodes);
        nodes.add(root);
        inorder(root.right, nodes);
    }

    public static void main(String[] args) {

    }
}
